package com.ldbmcs.secKill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ldbmcs.secKill.common.web.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 秒杀记录表
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sec_kill_record")
@Data
public class SecKillRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer secKillId;
    private Integer userId;
    private Integer state;
}
