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
 * @CreateTime: 2021-02-05 12:04:27
 */
@Api(tags = "库存(Storage)")
@RestController
@RequestMapping("/storage/api")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @ApiOperation(value = "根据id查询库存")
    @GetMapping("/get/{id}")
    public ResultDTO<Storage> getById(@PathVariable Long id) {
        Storage storage = storageService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storage);
    }

    @ApiOperation(value = "查询全部库存")
    @GetMapping("/get")
    public ResultDTO<Storage> getByEntity(Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.getByEntity(storage));
    }

    @ApiOperation(value = "条件查询库存")
    @GetMapping("/list")
    public ResultDTO<List<Storage>> list(Storage storage) {
        List<Storage> storageList = storageService.listByEntity(storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageList);
    }

    @ApiOperation(value = "分页条件查询库存")
    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Storage storage) {
        PageInfo pageInfo = storageService.listPageByEntity(page, size, storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "分页查询库存")
    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = storageService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "插入库存")
    @PostMapping("/insert")
    public ResultDTO<Storage> insert(@RequestBody Storage storage) {
        storageService.insert(storage);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storage);
    }

    @ApiOperation(value = "批量插入库存")
    @PostMapping("/insertBatch")
    public ResultDTO<List<Storage>> insert(@RequestBody List<Storage> list) {
        storageService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @ApiOperation(value = "更新库存")
    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.update(storage) == 1);
    }

    @ApiOperation(value = "批量更新库存")
    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Storage> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.updateBatch(list) == list.size());
    }

    @ApiOperation(value = "主键删除库存")
    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.deleteById(id) == 1);
    }

    @ApiOperation(value = "条件删除库存")
    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.deleteByEntity(storage) == 1);
    }

    @ApiOperation(value = "批量删除库存")
    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = storageService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @ApiOperation(value = "记录库存个数")
    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, storageService.countAll());
    }

    @ApiOperation(value = "条件记录库存个数")
    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Storage storage) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            storageService.countByEntity(storage));
    }
}
