package com.whm.wonderworld;

import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.mapper.SpotMapper;
import com.whm.wonderworld.service.ReadCsvService;
import com.whm.wonderworld.service.SpotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WonderWorldApplicationTests {
    @Autowired
    private SpotService spotService;

    @Autowired
    private ReadCsvService readCsvService;

    @Autowired
    private SpotMapper spotMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testAddSpot() {
        Spot spot = Spot.builder().build();
        spot.setName("test");
        spot.setDescription("test");
        spot.setLatitude(0.0);
        spot.setLongitude(0.0);
        assertEquals(true, spotService.addSpot(spot));
    }

    @Test
    void testSelect() {
        Spot spot = spotService.getSpotByLocation(0.0, 0.0);
        System.out.println(spot.getName());
        assertEquals("test", spot.getName());
    }

    @Test
    void testReadCsv() {
//        spotMapper.truncate();
        String filePath = "C:\\Users\\Lenovo\\Desktop\\scenery_spot.csv";
        readCsvService.writeDataFromCsv(filePath);
    }

}
