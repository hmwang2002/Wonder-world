package com.whm.wonderworld.service;

import com.whm.wonderworld.domain.entity.Spot;

public interface SpotService {
    Spot getSpotByLocation(Double Longitude, Double Latitude);

    boolean addSpot(Spot spot);
}
