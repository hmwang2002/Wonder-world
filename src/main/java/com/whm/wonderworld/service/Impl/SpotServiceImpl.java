package com.whm.wonderworld.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.domain.vo.SimpleSpot;
import com.whm.wonderworld.mapper.SpotMapper;
import com.whm.wonderworld.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {
    private final SpotMapper spotMapper;

    @Override
    public List<Spot> getSpotByLocation(Double Longitude, Double Latitude) {
        LambdaQueryWrapper<Spot> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(Spot::getLatitude, Latitude - 0.1, Latitude + 0.1)
                .between(Spot::getLongitude, Longitude - 0.1, Longitude + 0.1);
        return spotMapper.selectList(queryWrapper);
    }

    @Override
    public boolean addSpot(Spot spot) {
        return spotMapper.insert(spot) > 0;
    }

    @Override
    public List<SimpleSpot> getSpots() {
        return spotMapper.findAll();
    }

    @Override
    public Spot getSpotByName(String name) {
        LambdaQueryWrapper<Spot> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Spot::getName, name);
        return spotMapper.selectOne(queryWrapper);
    }
}
