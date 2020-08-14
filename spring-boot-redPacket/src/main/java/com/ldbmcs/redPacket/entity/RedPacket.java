package com.ldbmcs.redPacket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ldbmcs.redPacket.common.web.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 红包信息表
 */
@EqualsAndHashCode(callSuper = true)
@TableName("red_packet")
@Data
public class RedPacket extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer totalAmount;//红包总金额，单位分
    private Integer totalPacket;//红包总个数
    private String version;
}
