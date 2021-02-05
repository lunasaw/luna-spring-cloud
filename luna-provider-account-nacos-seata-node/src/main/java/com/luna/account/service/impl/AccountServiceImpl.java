package com.luna.account.service.impl;

import com.luna.account.mapper.AccountMapper;
import com.luna.account.service.AccountService;
import com.luna.account.entity.Account;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 13:53:04
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource(type = AccountMapper.class)
    private AccountMapper accountMapper;

    @Override
    public Account getById(Long id) {
        return accountMapper.getById(id);
    }

    @Override
    public Account getByEntity(Account account) {
        return accountMapper.getByEntity(account);
    }

    @Override
    public List<Account> listByEntity(Account account) {
        return accountMapper.listByEntity(account);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Account account) {
        PageHelper.startPage(page, pageSize);
        List<Account> list = accountMapper.listByEntity(account);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Account> list = accountMapper.listByEntity(new Account());
        return new PageInfo(list);
    }

    @Override
    public List<Account> listByIds(List<Long> ids) {
        return accountMapper.listByIds(ids);
    }

    @Override
    public int insert(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int insertBatch(List<Account> list) {
        return accountMapper.insertBatch(list);
    }

    @Override
    public int update(Account account) {
        // try {
        // TimeUnit.SECONDS.sleep(20);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        return accountMapper.update(account);
    }

    @Override
    public int updateBatch(List<Account> list) {
        return accountMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return accountMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Account account) {
        return accountMapper.deleteByEntity(account);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return accountMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return accountMapper.countAll();
    }

    @Override
    public int countByEntity(Account account) {
        return accountMapper.countByEntity(account);
    }

}
