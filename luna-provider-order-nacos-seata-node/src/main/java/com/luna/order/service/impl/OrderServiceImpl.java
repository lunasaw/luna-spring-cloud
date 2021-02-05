package com.luna.order.service.impl;

import cn.hutool.json.JSONUtil;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.entities.Account;
import com.luna.commons.entities.Storage;
import com.luna.order.controller.OrderController;
import com.luna.order.feign.AccountService;
import com.luna.order.feign.StorageService;
import com.luna.order.mapper.OrderMapper;
import com.luna.order.service.OrderService;
import com.luna.order.entity.Order;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:11:51
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource(type = OrderMapper.class)
    private OrderMapper orderMapper;

    @Autowired
    private StorageService      storageService;

    @Autowired
    private AccountService      accountService;

    @Override
    public Order getById(Long id) {
        return orderMapper.getById(id);
    }

    @Override
    public Order getByEntity(Order order) {
        return orderMapper.getByEntity(order);
    }

    @Override
    public List<Order> listByEntity(Order order) {
        return orderMapper.listByEntity(order);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Order order) {
        PageHelper.startPage(page, pageSize);
        List<Order> list = orderMapper.listByEntity(order);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Order> list = orderMapper.listByEntity(new Order());
        return new PageInfo(list);
    }

    @Override
    public List<Order> listByIds(List<Long> ids) {
        return orderMapper.listByIds(ids);
    }

    @Override
    public int insert(Order order) {
        log.info("-----------------------创建订单-----------------------");
        orderMapper.insert(order);
        log.info("-----------订单微服务开始调用库存，总量做扣减------------------");
        Storage storage = new Storage();
        storage.setProductId(order.getProductId());
        Storage data = storageService.getByEntity(storage).getData();
        data.setTotal(data.getTotal() - order.getCount());
        log.info("----------订单微服务开始调用库存，使用量做增加 data={}", JSONUtil.toJsonStr(data));
        data.setUsed(data.getUsed() + order.getCount());
        ResultDTO<Boolean> update = storageService.update(data);
        log.info("----------根据状态更新金额 状态={}", update.getData());
        Account account = new Account();
        account.setUserId(order.getUserId());
        Account userAccount = accountService.getByEntity(account).getData();
        userAccount.setTotal(userAccount.getTotal() - order.getMoney());
        userAccount.setUsed(userAccount.getUsed() + order.getMoney());
        userAccount.setResidue(userAccount.getTotal() - userAccount.getUsed());
        ResultDTO<Boolean> updateuUserAccount = accountService.update(userAccount);
        log.info("-----------更新金额后，修改订单状态-状态={}", updateuUserAccount.getData());
        order.setStatus(1);
        return orderMapper.update(order);
    }

    @Override
    public int insertBatch(List<Order> list) {
        return orderMapper.insertBatch(list);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public int updateBatch(List<Order> list) {
        return orderMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Order order) {
        return orderMapper.deleteByEntity(order);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return orderMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return orderMapper.countAll();
    }

    @Override
    public int countByEntity(Order order) {
        return orderMapper.countByEntity(order);
    }

}
