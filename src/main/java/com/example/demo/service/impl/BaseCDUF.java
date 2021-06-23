package com.example.demo.service.impl;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface BaseCDUF <T>{
    Integer save(T model);
    Integer save(List<T> models);
    Integer deleteById(Long id);
    Integer deleteByIds(String ids);
    Integer update(T model);
    T findById(Long id);
    T findBy(String fieldName, Object value) throws TooManyResultsException;
    List<T> findByIds(String ids);
    List<T> findByCondition(Condition condition);
    List<T> findAll();
    List<T> findValidAll();
}
