package com.ldbmcs.secKill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldbmcs.secKill.common.web.JsonResult;
import com.ldbmcs.secKill.entity.SecKill;

public interface ISecKillService extends IService<SecKill> {
    void deleteSecKill(Integer secKillId);
    Integer getSecKillCount(Integer secKillId);

    JsonResult start1(Integer secKillId, int userId);
}