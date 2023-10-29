package com.whm.wonderworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.domain.vo.SimpleSpot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SpotMapper extends BaseMapper<Spot> {
    @Update("truncate table landscape")
    void truncate();

    @Select("select name, latitude, longitude from landscape")
    List<SimpleSpot> findAll();
}
