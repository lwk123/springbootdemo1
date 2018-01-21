package cn.com.service.impl;

import cn.com.dao.CityDao;
import cn.com.domain.City;
import cn.com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by lc on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        City city = new City();
        city.setId(Long.valueOf("111"));
        city.setCityName("武汉");
        return city;
    }

}
