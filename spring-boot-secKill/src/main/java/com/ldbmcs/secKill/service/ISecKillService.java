package com.ldbmcs.secKill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldbmcs.secKill.common.web.JsonResult;
import com.ldbmcs.secKill.entity.SecKill;

public interface ISecKillService extends IService<SecKill> {
    void deleteSecKill(Integer secKillId);

    Integer getSecKillCount(Integer secKillId);

    JsonResult start1(Integer secKillId, int userId);

    JsonResult start2(Integer secKillId, int userId);

    JsonResult start3(Integer secKillId, int userId);

    JsonResult start4(Integer secKillId, int userId);

    JsonResult start5(Integer secKillId, int userId);

    JsonResult start6(Integer secKillId, int userId);

    JsonResult start7(Integer secKillId, int userId);

    JsonResult start8(Integer secKillId, int userId);
}
