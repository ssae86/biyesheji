package com.cda.service.impl;

import com.cda.dao.OrderDao;
import com.cda.entity.Order;
import com.cda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 订单业务逻辑
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order selectById(Integer orderId) {
        return orderDao.selectById(orderId);
    }

    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }

    @Override
    public List<Map<String, Object>> selectAllOrder(String userAccount) {
        return orderDao.selectAllOrder(userAccount);
    }

    @Override
    public Map<String, Object> selectOrder(String orderNo) {
        return orderDao.selectOrder(orderNo);
    }

    @Override
    public Integer selectCount() {
        return orderDao.selectCount();
    }

    @Override
    public Order selectByKey(String orderNo) {
        return orderDao.selectByKey(orderNo);
    }

    @Override
    public Integer selectIdByKey(String orderNo) {
        return orderDao.selectIdByKey(orderNo);
    }

    @Override
    public Boolean insertData(Order order) {
        order.setOrderTime(new Date());
        return orderDao.insertData(order);
    }

    @Override
    public Boolean updateById(Order order) {
        return orderDao.updateById(order);
    }

    @Override
    public Boolean deleteById(Integer orderId) {
        return orderDao.deleteById(orderId);
    }

    @Override
    public Map<String, Object> orderOverview() {
        return orderDao.orderOverview();
    }

    @Override
    public List<Map<String, Object>> selectChartDate(String startTime, String endTime) {
        return orderDao.selectChartDate(startTime, endTime);
    }

    @Override
    public List<Map<String, Object>> selectProductTypeChart(String startTime, String endTime) {
        return orderDao.selectProductTypeChart(startTime, endTime);
    }

    @Override
    public Map<String, Object> selectCountAndAmount(String startTime, String endTime) {
        return orderDao.selectCountAndAmount(startTime, endTime);
    }
}
