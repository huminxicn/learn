package com.huminxi.service;

import com.huminxi.model.Order;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/09 16:00
 */
public interface OrderService {
    Order createOrder(String username, String product);

    Order queryOrder(String username);

}
