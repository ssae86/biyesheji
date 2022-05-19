package com.cda.service.impl;

import com.cda.dao.ReturnGoodsDao;
import com.cda.entity.ReturnGoods;
import com.cda.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 商品退货业务逻辑
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReturnGoodsServiceImpl implements ReturnGoodsService {
    @Autowired
    private ReturnGoodsDao returnGoodsDao;

    @Override
    public ReturnGoods selectById(Integer returnId) {
        return returnGoodsDao.selectById(returnId);
    }

    @Override
    public List<ReturnGoods> selectAll() {
        return returnGoodsDao.selectAll();
    }

    @Override
    public Integer selectCount() {
        return returnGoodsDao.selectCount();
    }

    @Override
    public Boolean insertData(ReturnGoods returnGoods) {
        returnGoods.setApplyTime(new Date());
        return returnGoodsDao.insertData(returnGoods);
    }

    @Override
    public Boolean updateById(ReturnGoods returnGoods) {
        return returnGoodsDao.updateById(returnGoods);
    }

    @Override
    public Boolean deleteById(Integer returnId) {
        return returnGoodsDao.deleteById(returnId);
    }

    @Override
    public List<Map<String, Object>> selectAllOrder(String userAccount) {
        return returnGoodsDao.selectAllOrder(userAccount);
    }

    @Override
    public Map<String, Object> returnGoodsOverview() {
        return returnGoodsDao.returnGoodsOverview();
    }

    @Override
    public Map<String, Object> selectOrderNo(String orderNo) {
        return returnGoodsDao.selectOrderNo(orderNo);
    }
}
