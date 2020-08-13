package com.ldbmcs.redPacket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldbmcs.redPacket.common.web.JsonResult;
import com.ldbmcs.redPacket.entity.RedPacket;

public interface IRedPacketService extends IService<RedPacket> {
    /**
     * 获取红包
     *
     * @param redPacketId 红包id
     * @return
     */
    RedPacket get(long redPacketId);

    /**
     * 抢红包
     *
     * @param redPacketId 红包id
     * @return
     */
    JsonResult startSecKill(Integer redPacketId, int userId);

}
