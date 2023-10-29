package com.whm.wonderworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whm.wonderworld.domain.entity.Spot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SpotMapper extends BaseMapper<Spot> {
    @Update("truncate table landscape")
    void truncate();
}
