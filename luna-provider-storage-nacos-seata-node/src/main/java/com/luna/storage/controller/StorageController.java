package com.luna.storage.controller;

import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.dto.constant.ResultCode;
import com.luna.storage.entity.Storage;
import com.luna.storage.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-04 22:24:23
 */
@Api(tags = "(Storage)")
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @ApiOperation(value = "根据id查询 ")
    @GetMapping("/get/{id}")
    public ResultDTO<Storage> getById(@PathVariable Long id) {
        Storage storage = storageService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storage);
    }

    @ApiOperation(value = "查询全部 ")
    @GetMapping("/get")
    public ResultDTO<Storage> getByEntity(Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.getByEntity(storage));
    }

    @ApiOperation(value = "条件查询 ")
    @GetMapping("/list")
    public ResultDTO<List<Storage>> list(Storage storage) {
        List<Storage> storageList = storageService.listByEntity(storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageList);
    }

    @ApiOperation(value = "分页条件查询 ")
    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Storage storage) {
        PageInfo pageInfo = storageService.listPageByEntity(page, size, storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "分页查询 ")
    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = storageService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "插入 ")
    @PostMapping("/insert")
    public ResultDTO<Storage> insert(@RequestBody Storage storage) {
        storageService.insert(storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storage);
    }

    @ApiOperation(value = "批量插入 ")
    @PostMapping("/insertBatch")
    public ResultDTO<List<Storage>> insert(@RequestBody List<Storage> list) {
        storageService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @ApiOperation(value = "更新 ")
    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.update(storage) == 1);
    }

    @ApiOperation(value = "批量更新 ")
    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Storage> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.updateBatch(list) == list.size());
    }

    @ApiOperation(value = "主键删除 ")
    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.deleteById(id) == 1);
    }

    @ApiOperation(value = "条件删除 ")
    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.deleteByEntity(storage) == 1);
    }

    @ApiOperation(value = "批量删除 ")
    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = storageService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @ApiOperation(value = "记录个数 ")
    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.countAll());
    }

    @ApiOperation(value = "条件记录个数 ")
    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.countByEntity(storage));
    }
}
