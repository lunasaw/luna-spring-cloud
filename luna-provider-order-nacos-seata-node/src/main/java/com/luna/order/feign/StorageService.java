package com.luna.order.feign;

import java.util.List;

import com.luna.commons.entities.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:04:27
 */
@FeignClient("luna-provider-storage")
@Component
public interface StorageService {
    String PROVIDER_URL = "/provider-storage/storage/api";

    /**
     * 根据id查询库存
     *
     * @param id 主键
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get/{id}")
    ResultDTO<Storage> getById(@PathVariable Long id);

    /**
     * 查询全部库存
     *
     * @param storage 库存
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get")
    ResultDTO<Storage> getByEntity(Storage storage);

    /**
     * 条件查询全部库存
     *
     * @param storage 库存
     * @return 对象列表
     */
    @GetMapping(PROVIDER_URL + "/list")
    ResultDTO<List<Storage>> list(Storage storage);

    /**
     * 分页分页条件查询库存
     *
     * @param storage 库存
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageListByEntity/{page}/{size}")
    ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size,
        Storage storage);

    /**
     * 分页查询全部库存
     * 
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageList/{page}/{size}")
    ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size);

    /**
     * 插入新增库存
     *
     * @param storage 库存
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insert")
    ResultDTO<Storage> insert(@RequestBody Storage storage);

    /**
     * 批量插入新增库存
     *
     * @param list 库存列表
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insertBatch")
    ResultDTO<List<Storage>> insert(@RequestBody List<Storage> list);

    /**
     * 更新库存
     *
     * @param storage 库存
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/update")
    ResultDTO<Boolean> update(@RequestBody Storage storage);

    /**
     * 批量更新库存
     *
     * @param list 库存列表
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/updateBatch")
    ResultDTO<Boolean> update(@RequestBody List<Storage> list);

    /**
     * 根据id删除库存
     *
     * @param id 主键
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete/{id}")
    ResultDTO<Boolean> deleteOne(@PathVariable Long id);

    /**
     * 条件删除库存
     *
     * @param storage 库存
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/deleteByEntity")
    ResultDTO<Boolean> deleteOne(@RequestBody Storage storage);

    /**
     * 批量删除库存
     *
     * @param ids
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete")
    ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids);

    /**
     * 查询记录库存个数
     *
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/account")
    ResultDTO<Integer> getAccount();

    /**
     * 条件查询记录库存个数
     *
     * @param storage 库存
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/accountByEntity")
    ResultDTO<Integer> getAccountByEntity(Storage storage);
}
