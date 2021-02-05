package com.luna.account.service;

import com.luna.account.mapper.AccountMapper;
import com.luna.account.entity.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 13:53:04
 */
public interface AccountService {

    /**
     * 通过主键查询数据
     *
     * @param id 主键
     * @return 对象
     */
    Account getById(Long id);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个
     *
     * @param account 条件
     * @return 对象
     */
    Account getByEntity(Account account);

    /**
     * 通过实体不为空的属性作为筛选条件查询列表
     *
     * @param account 条件
     * @return 对象列表
     */
    List<Account> listByEntity(Account account);

    /**
     * 条件分页查询
     *
     * @param account 查询条件
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo listPageByEntity(int page, int pageSize, Account account);

    /**
     * 条件分页查询
     *
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo listPage(int page, int pageSize);

    /**
     * Id列表查询对象列表
     *
     * @param ids Id列表
     * @return 对象列表
     */
    List<Account> listByIds(List<Long> ids);

    /**
     * 插入
     *
     * @param account 对象
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 列表插入
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int insertBatch(List<Account> list);

    /**
     * 更新
     *
     * @param account 对象
     * @return 影响行数
     */
    int update(Account account);

    /**
     * 列表更新
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int updateBatch(List<Account> list);

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 条件删除
     *
     * @param account 对象
     * @return 影响行数
     */
    int deleteByEntity(Account account);

    /**
     * 主键列表删除
     *
     * @param list 主键列表
     * @return 影响行数
     */
    int deleteByIds(List<Long> list);

    /**
     * 数据条目
     *
     * @return 影响行数
     */
    int countAll();

    /**
     * 条件查询数目
     *
     * @param account 对象
     * @return 影响行数
     */
    int countByEntity(Account account);
}
