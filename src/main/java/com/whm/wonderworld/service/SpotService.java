package com.whm.wonderworld.service;

import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.domain.vo.SimpleSpot;

import java.util.List;

public interface SpotService {
    List<Spot> getSpotByLocation(Double Longitude, Double Latitude);

    boolean addSpot(Spot spot);

    List<SimpleSpot> getSpots();

    Spot getSpotByName(String name);
}
