package com.ldbmcs.secKill.common.web;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.Instant;

/**
 * 基础实体类
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
@Data
public class BaseEntity {

    /**
     * 状态
     */
    public static final Integer STATUS_VALID = 1;
    public static final Integer STATUS_DELETE = 2;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Long createTime = Instant.now().getEpochSecond();

    private Long updateTime = 0L;

    @TableLogic
    private Integer deleteStatus = 1;

    private Long deleteTime = 0L;
}
