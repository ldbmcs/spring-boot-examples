package com.ldbmcs.secKill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldbmcs.secKill.entity.SecKillRecord;

public interface ISecKillRecordService extends IService<SecKillRecord> {

    void insert(Integer secKillId, int userId);
}
