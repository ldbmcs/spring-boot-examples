package com.ldbmcs.secKill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldbmcs.secKill.entity.SecKill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SecKillMapper extends BaseMapper<SecKill> {
    void updateNumber(@Param("secKillId") Integer secKillId);

    Integer getSecKillCountByLock(@Param("secKillId") Integer secKillId);

    Integer updateNumberByLock(@Param("secKillId") Integer secKillId);
}
