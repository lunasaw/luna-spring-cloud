package com.luna.order.feign;

import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:13:26
 */
@FeignClient("luna-provider-account")
@Component
public interface AccountService {
    String PROVIDER_URL = "/provider-account/account/api";

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get/{id}")
    ResultDTO<Account> getById(@PathVariable Long id);

    /**
     * 查询全部
     *
     * @param account
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/get")
    ResultDTO<Account> getByEntity(Account account);

    /**
     * 条件查询全部
     *
     * @param account
     * @return 对象列表
     */
    @GetMapping(PROVIDER_URL + "/list")
    ResultDTO<List<Account>> list(Account account);

    /**
     * 分页分页条件查询
     *
     * @param account
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageListByEntity/{page}/{size}")
    ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size,
        Account account);

    /**
     * 分页查询全部
     * 
     * @param page
     * @param size
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/pageList/{page}/{size}")
    ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size);

    /**
     * 插入新增
     *
     * @param account
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insert")
    ResultDTO<Account> insert(@RequestBody Account account);

    /**
     * 批量插入新增
     *
     * @param list 列表
     * @return 对象
     */
    @PostMapping(PROVIDER_URL + "/insertBatch")
    ResultDTO<List<Account>> insert(@RequestBody List<Account> list);

    /**
     * 更新
     *
     * @param account
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/update")
    ResultDTO<Boolean> update(@RequestBody Account account);

    /**
     * 批量更新
     *
     * @param list 列表
     * @return 对象
     */
    @PutMapping(PROVIDER_URL + "/updateBatch")
    ResultDTO<Boolean> update(@RequestBody List<Account> list);

    /**
     * 根据id删除
     *
     * @param id 主键
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete/{id}")
    ResultDTO<Boolean> deleteOne(@PathVariable Long id);

    /**
     * 条件删除
     *
     * @param account
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/deleteByEntity")
    ResultDTO<Boolean> deleteOne(@RequestBody Account account);

    /**
     * 批量删除
     *
     * @param ids
     * @return 对象
     */
    @DeleteMapping(PROVIDER_URL + "/delete")
    ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids);

    /**
     * 查询记录个数
     *
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/account")
    ResultDTO<Integer> getAccount();

    /**
     * 条件查询记录个数
     *
     * @param account
     * @return 对象
     */
    @GetMapping(PROVIDER_URL + "/accountByEntity")
    ResultDTO<Integer> getAccountByEntity(Account account);
}
