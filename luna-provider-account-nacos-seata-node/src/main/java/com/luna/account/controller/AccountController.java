package com.luna.account.controller;

import com.github.pagehelper.PageInfo;
import com.luna.account.entity.Account;
import com.luna.account.service.AccountService;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.dto.constant.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 13:53:04
 */
@Api(tags = "(Account)")
@RestController
@RequestMapping("/account/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "根据id查询")
    @GetMapping("/get/{id}")
    public ResultDTO<Account> getById(@PathVariable(value = "Long id") Long id) {
        Account account = accountService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, account);
    }

    @ApiOperation(value = "查询全部")
    @GetMapping("/get")
    public ResultDTO<Account> getByEntity(Account account) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, accountService.getByEntity(account));
    }

    @ApiOperation(value = "条件查询")
    @GetMapping("/list")
    public ResultDTO<List<Account>> list(Account account) {
        List<Account> accountList = accountService.listByEntity(account);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, accountList);
    }

    @ApiOperation(value = "分页条件查询")
    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Account account) {
        PageInfo pageInfo = accountService.listPageByEntity(page, size, account);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = accountService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insert")
    public ResultDTO<Account> insert(@RequestBody Account account) {
        accountService.insert(account);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, account);
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatch")
    public ResultDTO<List<Account>> insert(@RequestBody List<Account> list) {
        accountService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @ApiOperation(value = "更新")
    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Account account) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, accountService.update(account) == 1);
    }

    @ApiOperation(value = "批量更新")
    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Account> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            accountService.updateBatch(list) == list.size());
    }

    @ApiOperation(value = "主键删除")
    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable(value = "Long id") Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, accountService.deleteById(id) == 1);
    }

    @ApiOperation(value = "条件删除")
    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Account account) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            accountService.deleteByEntity(account) == 1);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = accountService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @ApiOperation(value = "记录个数")
    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, accountService.countAll());
    }

    @ApiOperation(value = "条件记录个数")
    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Account account) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            accountService.countByEntity(account));
    }
}
