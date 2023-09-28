package com.whm.wonderworld.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.mapper.SpotMapper;
import com.whm.wonderworld.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {
    private final SpotMapper spotMapper;

    @Override
    public Spot getSpotByLocation(Double Longitude, Double Latitude) {
        LambdaQueryWrapper<Spot> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Spot::getLongitude, Longitude)
                .eq(Spot::getLatitude, Latitude);
        return spotMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean addSpot(Spot spot) {
        return spotMapper.insert(spot) > 0;
    }
}
