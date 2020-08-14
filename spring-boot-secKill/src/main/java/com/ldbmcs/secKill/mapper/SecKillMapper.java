package com.ldbmcs.secKill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldbmcs.secKill.entity.SecKill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecKillMapper extends BaseMapper<SecKill> {
    void updateNumber(Integer secKillId);
}
