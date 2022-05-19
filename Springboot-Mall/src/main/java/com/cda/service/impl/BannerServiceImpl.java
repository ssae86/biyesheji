package com.cda.service.impl;

import com.cda.dao.BannerDao;
import com.cda.entity.Banner;
import com.cda.service.BannerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description 商品轮播图业务逻辑
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Banner selectById(Integer bannerId) {
        return bannerDao.selectById(bannerId);
    }

    @Override
    public List<Banner> selectAll() {
        List<Banner> banners = null;
        try {
            //String结构缓存轮播图信息
            String BannersStr = stringRedisTemplate.opsForValue().get("banners");
            if (BannersStr != null) {
                //从redis中获取到了轮播图信息
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Banner.class);
                banners = objectMapper.readValue(BannersStr, javaType);
            } else {
                //从redis中没有获取到轮播图信息，则查询数据库
                banners = bannerDao.selectAll();
                //写到redis数据库
                stringRedisTemplate.boundValueOps("banners").set(objectMapper.writeValueAsString(banners));
                //设置过期时间1天
                stringRedisTemplate.boundValueOps("banners").expire(1,TimeUnit.DAYS);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        System.out.println(banners);
        return banners;
    }
//@Override
//public List<Banner> selectAll() {
//    System.out.println(bannerDao.selectAll());
//    return bannerDao.selectAll();
//}

    @Override
    public Boolean insertData(Banner banner) {
        return bannerDao.insertData(banner);
    }

    @Override
    public Boolean updateById(Banner banner) {
        return bannerDao.updateById(banner);
    }

    @Override
    public Boolean deleteById(Integer bannerId) {
        return bannerDao.deleteById(bannerId);
    }
}
