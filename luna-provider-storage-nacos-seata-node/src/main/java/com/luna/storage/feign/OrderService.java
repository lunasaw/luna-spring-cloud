package com.luna.storage.feign;

import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.entities.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:11:51
 */
@FeignClient("provider-xxxxx-order")
@Component
public interface OrderService {
    String PROVIDER_URL = "/provider-order/api";

    /**
     * 根据id查询订单
     *
     * @param id 主键
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get/{id}")
    ResultDTO<Order> getById(@PathVariable Long id);

    /**
     * 查询全部订单
     *
     * @param order 订单
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get")
    ResultDTO<Order> getByEntity(Order order);

    /**
     * 条件查询全部订单
     *
     * @param order 订单
     * @return 对象列表
     */
    @GetMapping(PROVIDER_URL + "/list")
    ResultDTO<List<Order>> list(Order order);

    /**
     * 分页分页条件查询订单
     *
     * @param order 订单
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageListByEntity/{page}/{size}")
    ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size,
        Order order);

    /**
     * 分页查询全部订单
     * 
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageList/{page}/{size}")
    ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size);

    /**
     * 插入新增订单
     *
     * @param order 订单
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insert")
    ResultDTO<Order> insert(@RequestBody Order order);

    /**
     * 批量插入新增订单
     *
     * @param list 订单列表
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insertBatch")
    ResultDTO<List<Order>> insert(@RequestBody List<Order> list);

    /**
     * 更新订单
     *
     * @param order 订单
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/update")
    ResultDTO<Boolean> update(@RequestBody Order order);

    /**
     * 批量更新订单
     *
     * @param list 订单列表
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/updateBatch")
    ResultDTO<Boolean> update(@RequestBody List<Order> list);

    /**
     * 根据id删除订单
     *
     * @param id 主键
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete/{id}")
    ResultDTO<Boolean> deleteOne(@PathVariable Long id);

    /**
     * 条件删除订单
     *
     * @param order 订单
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/deleteByEntity")
    ResultDTO<Boolean> deleteOne(@RequestBody Order order);

    /**
     * 批量删除订单
     *
     * @param ids
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete")
    ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids);

    /**
     * 查询记录订单个数
     *
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/account")
    ResultDTO<Integer> getAccount();

    /**
     * 条件查询记录订单个数
     *
     * @param order 订单
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/accountByEntity")
    ResultDTO<Integer> getAccountByEntity(Order order);
}
