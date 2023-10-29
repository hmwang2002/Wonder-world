package com.whm.wonderworld.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csvreader.CsvReader;
import com.whm.wonderworld.domain.entity.Spot;
import com.whm.wonderworld.mapper.SpotMapper;
import com.whm.wonderworld.service.ReadCsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author whm
 * @date 2023/10/29 10:32
 */
@Service
@RequiredArgsConstructor
public class ReadCsvServiceImpl implements ReadCsvService {
    private final SpotMapper spotMapper;

    @Override
    public void writeDataFromCsv(String filePath) {
        Spot spot;

        try {
            // 创建Csv Reader对象，参数说明（写入的文件路径，分隔符，编码格式)
            CsvReader csvReader = new CsvReader(filePath, ',', java.nio.charset.StandardCharsets.UTF_8);
            // 跳过表头
            csvReader.readHeaders();

            // 读取表头以外的内容
            while (csvReader.readRecord()) {
                spot = Spot.builder()
                        .name(csvReader.get("dest_name"))
                        .photo(csvReader.get("photos").split(";")[0])
                        .description(csvReader.get("summary_description"))
                        .latitude(Double.parseDouble(csvReader.get("lat")))
                        .longitude(Double.parseDouble(csvReader.get("lng")))
                        .build();
                // 防止插入重复景点
                LambdaQueryWrapper<Spot> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(Spot::getName, csvReader.get("dest_name"));
                Spot spot_ = spotMapper.selectOne(queryWrapper);
                if (spot_ == null) spotMapper.insert(spot);
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
