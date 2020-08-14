package com.ldbmcs.redPacket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldbmcs.redPacket.common.uitls.RedisUtil;
import com.ldbmcs.redPacket.common.uitls.RedisLockUtil;
import com.ldbmcs.redPacket.entity.RedPacket;
import com.ldbmcs.redPacket.entity.RedPacketRecord;
import com.ldbmcs.redPacket.mapper.RedPacketMapper;
import com.ldbmcs.redPacket.mapper.RedPacketRecordMapper;
import com.ldbmcs.redPacket.service.IRedPacketService;
import com.ldbmcs.redPacket.service.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service("redPacketService")
public class RedPacketService extends ServiceImpl<RedPacketMapper, RedPacket> implements IRedPacketService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedissonService redissonService;

    @Autowired
    private RedPacketRecordMapper redPacketRecordMapper;

    @Override
    public RedPacket get(long redPacketId) {
        return null;
    }

    @Override
    @Transactional
    public Integer startSecKill(Integer redPacketId, int userId) {
        int money = 0;
        boolean res = false;
        try {
            // 获取锁
            res = redissonService.tryLock(redPacketId + "", TimeUnit.SECONDS, 3, 10);
            if (res) {
                long restPeople = redisUtil.decr(redPacketId + "-restPeople", 1);
                //  如果是最后一人
                if (restPeople == 0) {
                    money = Integer.parseInt(redisUtil.getValue(redPacketId + "-money").toString());
                } else {
                    int restMoney = Integer.parseInt(redisUtil.getValue(redPacketId + "-money").toString());
                    Random random = new Random();
                    //随机范围：[1,剩余人均金额的两倍]
                    money = random.nextInt((int) (restMoney / (restPeople + 1) * 2 - 1)) + 1;
                }
                redisUtil.decr(redPacketId + "-money", money);
                // 入库
                RedPacketRecord record = new RedPacketRecord();
                record.setRedPacketAmount(money);
                record.setRedPacketId(redPacketId);
                record.setUserId(userId);
                saveRecord(record);
            } else {
                // 获取锁失败相当于抢红包失败，红包个数加一
                redisUtil.incr(redPacketId + "-num", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res) {//释放锁
                redissonService.unlock(redPacketId + "");
            }
        }
        return money;
    }

    @Async
    void saveRecord(RedPacketRecord record){
        redPacketRecordMapper.insert(record);
    }
}
