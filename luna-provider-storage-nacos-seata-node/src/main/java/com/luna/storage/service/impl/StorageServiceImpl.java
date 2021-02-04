package com.luna.storage.service.impl;

import com.luna.storage.mapper.StorageMapper;
import com.luna.storage.service.StorageService;
import com.luna.storage.entity.Storage;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 01:40:07
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource(type = StorageMapper.class)
    private StorageMapper storageMapper;

    @Override
    public Storage getById(Long id) {
        return storageMapper.getById(id);
    }

    @Override
    public Storage getByEntity(Storage storage) {
        return storageMapper.getByEntity(storage);
    }

    @Override
    public List<Storage> listByEntity(Storage storage) {
        return storageMapper.listByEntity(storage);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Storage storage) {
        PageHelper.startPage(page, pageSize);
        List<Storage> list = storageMapper.listByEntity(storage);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Storage> list = storageMapper.listByEntity(new Storage());
        return new PageInfo(list);
    }

    @Override
    public List<Storage> listByIds(List<Long> ids) {
        return storageMapper.listByIds(ids);
    }

    @Override
    public int insert(Storage storage) {
        return storageMapper.insert(storage);
    }

    @Override
    public int insertBatch(List<Storage> list) {
        return storageMapper.insertBatch(list);
    }

    @Override
    public int update(Storage storage) {
        return storageMapper.update(storage);
    }

    @Override
    public int updateBatch(List<Storage> list) {
        return storageMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return storageMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Storage storage) {
        return storageMapper.deleteByEntity(storage);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return storageMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return storageMapper.countAll();
    }

    @Override
    public int countByEntity(Storage storage) {
        return storageMapper.countByEntity(storage);
    }

}
