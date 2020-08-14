package com.ldbmcs.secKill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldbmcs.secKill.entity.SecKillRecord;
import com.ldbmcs.secKill.mapper.SecKillRecordMapper;
import com.ldbmcs.secKill.service.ISecKillRecordService;
import org.springframework.stereotype.Service;

@Service("secKillRecordService")
public class SecKillRecordService extends ServiceImpl<SecKillRecordMapper, SecKillRecord> implements ISecKillRecordService {
    @Override
    public void insert(Integer secKillId, int userId) {
        SecKillRecord secKillRecord = new SecKillRecord();
        secKillRecord.setSecKillId(secKillId);
        secKillRecord.setUserId(userId);
        secKillRecord.setState(0);
        baseMapper.insert(secKillRecord);
    }
}
