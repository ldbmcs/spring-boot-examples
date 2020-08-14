package com.ldbmcs.secKill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ldbmcs.secKill.common.web.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 秒杀信息表
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sec_kill")
@Data
public class SecKill extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer number;
    private Integer startTime;
    private Integer endTime;
    private String version;
}
