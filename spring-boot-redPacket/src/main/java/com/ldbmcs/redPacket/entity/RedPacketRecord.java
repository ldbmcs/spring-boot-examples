package com.ldbmcs.redPacket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ldbmcs.redPacket.common.web.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 抢红包记录表
 */
@EqualsAndHashCode(callSuper = true)
@TableName("red_packet_record")
@Data
public class RedPacketRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer redPacketId;
    private Integer redPacketAmount;
    private Integer userId;
}
