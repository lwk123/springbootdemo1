package cn.com.gei.kmp4.kaoqinmgr.service;

import cn.com.domain.City;
import cn.com.service.CityService;

/**
 * Created by admin on 2018/1/23.
 */
public class CityServiceImpl implements CityService{
    @Override
    public City findCityByName(String s) {
        City city = new City();
        city.setId(Long.parseLong("123"));
        city.setCityName("武汉");
        return city;
    }
}
