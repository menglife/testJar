package com.example.demo.service;

import com.example.demo.base.BaseMapper;
import com.example.demo.service.impl.BaseCDUF;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public abstract class BaseService<T> implements BaseCDUF<T> {
    @Autowired
    protected BaseMapper baseMapper;

    @Override
    public Integer save(T model) {
        return baseMapper.insert( model);
    }

    @Override
    public Integer save(List<T> models) {
        return baseMapper.insertList( models);
    }

    @Override
    public Integer deleteById(Long id) {
        return baseMapper.delete( id);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return baseMapper.deleteByIds(ids);
    }

    @Override
    public Integer update(T model) {
        return baseMapper.updateByPrimaryKey( model);
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        return null;
    }

    @Override
    public List<T> findByIds(String ids) {
        return null;
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findValidAll() {
        return null;
    }
    //     //第二种方式通过继承ConditionMapper来满足条件
//    @Override
//    public Integer update(T model) {
//
//
//        return baseMapper.selectCountByCondition(model);
//    }
//
//    @Override
//    public List<T> findByCondition(Condition condition) {
//        return baseMapper.selectByCondition(condition);
//    }
}
