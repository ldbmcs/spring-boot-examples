package com.ldbmcs.secKill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldbmcs.secKill.common.web.JsonResult;
import com.ldbmcs.secKill.entity.SecKill;
import com.ldbmcs.secKill.entity.SecKillRecord;
import com.ldbmcs.secKill.mapper.SecKillMapper;
import com.ldbmcs.secKill.mapper.SecKillRecordMapper;
import com.ldbmcs.secKill.service.ISecKillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("secKillService")
public class SecKillService extends ServiceImpl<SecKillMapper, SecKill> implements ISecKillService {

    @Resource
    SecKillRecordMapper secKillRecordMapper;

    @Override
    @Transactional
    public void deleteSecKill(Integer secKillId) {
        secKillRecordMapper.delete(new QueryWrapper<SecKillRecord>().lambda().eq(SecKillRecord::getSecKillId, secKillId));
        SecKill secKill = baseMapper.selectById(secKillId);
        secKill.setNumber(100);
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
        if (number == 0){
            return JsonResult.error();
        }
        // 扣库存
        baseMapper.updateNumber(secKillId);
        // 创建订单
        SecKillRecord secKillRecord = new SecKillRecord();
        secKillRecord.setSecKillId(secKillId);
        secKillRecord.setUserId(userId);
        secKillRecord.setState(0);
        return JsonResult.ok();
    }
}
