package com.luna.order.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.dto.constant.ResultCode;
import com.luna.commons.entities.Account;
import com.luna.commons.entities.Storage;
import com.luna.order.entity.Order;
import com.luna.order.feign.AccountService;
import com.luna.order.feign.StorageService;
import com.luna.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:11:51
 */
@Api(tags = "订单(Order)")
@RestController
@RequestMapping("/order/api")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService        orderService;

    @Autowired
    private StorageService      storageService;

    @Autowired
    private AccountService      accountService;

    @ApiOperation(value = "根据id查询订单")
    @GetMapping("/get/{id}")
    public ResultDTO<Order> getById(@PathVariable(value = "id") Long id) {
        Order order = orderService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, order);
    }

    @ApiOperation(value = "查询全部订单")
    @GetMapping("/get")
    public ResultDTO<Order> getByEntity(Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.getByEntity(order));
    }

    @ApiOperation(value = "条件查询订单")
    @GetMapping("/list")
    public ResultDTO<List<Order>> list(Order order) {
        List<Order> orderList = orderService.listByEntity(order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderList);
    }

    @ApiOperation(value = "分页条件查询订单")
    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Order order) {
        PageInfo pageInfo = orderService.listPageByEntity(page, size, order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "分页查询订单")
    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = orderService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "新增订单")
    @PostMapping("/insert")
    public ResultDTO<Order> insert(@RequestBody Order order) {
        log.info("-----------------------创建订单-----------------------");
        orderService.insert(order);
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
        orderService.update(order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, order);
    }

    @ApiOperation(value = "批量新增订单")
    @PostMapping("/insertBatch")
    public ResultDTO<List<Order>> insert(@RequestBody List<Order> list) {
        orderService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @ApiOperation(value = "更新订单")
    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.update(order) == 1);
    }

    @ApiOperation(value = "批量更新订单")
    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Order> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.updateBatch(list) == list.size());
    }

    @ApiOperation(value = "主键删除订单")
    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable(value = "id") Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.deleteById(id) == 1);
    }

    @ApiOperation(value = "条件删除订单")
    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.deleteByEntity(order) == 1);
    }

    @ApiOperation(value = "批量删除订单")
    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = orderService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @ApiOperation(value = "记录订单个数")
    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.countAll());
    }

    @ApiOperation(value = "条件记录订单个数")
    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.countByEntity(order));
    }
}
