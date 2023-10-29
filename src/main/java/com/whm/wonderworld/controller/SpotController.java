package com.whm.wonderworld.controller;

import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.domain.vo.Response;
import com.whm.wonderworld.domain.vo.SimpleSpot;
import com.whm.wonderworld.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author whm
 * @date 2023/9/28 17:32
 */
@RestController
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @RequestMapping("/spot/addSpot")
    public Response<Spot> addSpot(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("photo") String photo,
                                  @RequestParam("longitude") Double longitude, @RequestParam("latitude") Double latitude) {
        Spot spot = Spot.builder()
                .name(name)
                .description(description)
                .photo(photo)
                .longitude(longitude)
                .latitude(latitude)
                .build();
        boolean res = spotService.addSpot(spot);
        if (res) {
            return Response.success(200, "新增景点成功");
        } else {
            return Response.failed();
        }
    }

    @RequestMapping("/spot/getAll")
    public Response<List<SimpleSpot>> getSpots() {
        List<SimpleSpot> spots = spotService.getSpots();
        if (spots != null) return Response.success(200, "获取所有景点成功", spots);
        else return Response.failed();
    }

    @RequestMapping("/spot/queryByName")
    public Response<Spot> queryByName(@RequestParam("name") String name) {
        Spot spot = spotService.getSpotByName(name);
        if (spot != null) return Response.success(200, "查询景点成功", spot);
        else return Response.failed(999, "查询失败，景点不存在");
    }
}
