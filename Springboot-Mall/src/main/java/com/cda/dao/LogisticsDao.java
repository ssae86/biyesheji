package com.cda.dao;

import com.cda.entity.Logistics;

/**
 * @description 物流表
 */
public interface LogisticsDao extends BaseDao<Logistics> {
    /**
     * 根据订单编号查询
     * @param orderNo 订单编号
     * @return 物流信息
     */
    Logistics selectOrderNo(String orderNo);
}
