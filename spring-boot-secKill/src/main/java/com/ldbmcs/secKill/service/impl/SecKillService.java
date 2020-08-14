package com.ldbmcs.secKill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldbmcs.secKill.common.annotation.ServiceLock;
import com.ldbmcs.secKill.common.exception.BusinessException;
import com.ldbmcs.secKill.common.web.JsonResult;
import com.ldbmcs.secKill.entity.SecKill;
import com.ldbmcs.secKill.entity.SecKillRecord;
import com.ldbmcs.secKill.mapper.SecKillMapper;
import com.ldbmcs.secKill.mapper.SecKillRecordMapper;
import com.ldbmcs.secKill.service.ISecKillRecordService;
import com.ldbmcs.secKill.service.ISecKillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service("secKillService")
public class SecKillService extends ServiceImpl<SecKillMapper, SecKill> implements ISecKillService {

    @Resource
    SecKillRecordMapper secKillRecordMapper;

    @Resource
    SecKillMapper secKillMapper;

    @Resource
    ISecKillRecordService secKillRecordService;

    // 互斥锁 参数默认false，不公平锁
    private final Lock lock = new ReentrantLock(true);

    @Override
    @Transactional
    public void deleteSecKill(Integer secKillId) {
        secKillRecordMapper.delete(new QueryWrapper<SecKillRecord>().lambda().eq(SecKillRecord::getSecKillId, secKillId));
        SecKill secKill = baseMapper.selectById(secKillId);
        secKill.setNumber(10);
        baseMapper.updateById(secKill);
    }

    @Override
    public Integer getSecKillCount(Integer secKillId) {
        return baseMapper.selectById(secKillId).getNumber();
    }

    @Override
    public JsonResult start1(Integer secKillId, int userId) {
        // 查询库存
        Integer number = getSecKillCount(secKillId);
        if (number == 0) {
            return JsonResult.error();
        }
        // 扣库存
        secKillMapper.updateNumber(secKillId);
        // 创建订单
        secKillRecordService.insert(secKillId, userId);
        return JsonResult.ok();
    }

    @Override
    public JsonResult start2(Integer secKillId, int userId) {
        try {
            lock.lock();
            // 查询库存
            Integer number = getSecKillCount(secKillId);
            if (number == 0) {
                return JsonResult.error();
            }
            // 扣库存
            secKillMapper.updateNumber(secKillId);
            // 创建订单
            secKillRecordService.insert(secKillId, userId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        } finally {
            lock.unlock();
        }
        return JsonResult.ok();
    }

    @Override
    @ServiceLock
    public JsonResult start3(Integer secKillId, int userId) {
        // 查询库存
        Integer number = getSecKillCount(secKillId);
        if (number == 0) {
            return JsonResult.error();
        }
        // 扣库存
        secKillMapper.updateNumber(secKillId);
        // 创建订单
        secKillRecordService.insert(secKillId, userId);
        return JsonResult.ok();
    }

    @Override
    public JsonResult start4(Integer secKillId, int userId) {
        // 查询库存
        Integer number = secKillMapper.getSecKillCountByLock(secKillId);
        if (number == 0) {
            return JsonResult.error();
        }
        // 扣库存
        secKillMapper.updateNumber(secKillId);
        // 创建订单
        secKillRecordService.insert(secKillId, userId);
        return JsonResult.ok();
    }

    @Override
    public JsonResult start5(Integer secKillId, int userId) {
        // 查询库存
        Integer result = secKillMapper.updateNumberByLock(secKillId);
        if (result > 0) {
            // 创建订单
            secKillRecordService.insert(secKillId, userId);
            return JsonResult.ok();
        }
        return JsonResult.error();
    }
}
