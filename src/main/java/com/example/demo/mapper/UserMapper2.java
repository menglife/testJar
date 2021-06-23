package com.example.demo.mapper;

import com.example.demo.base.BaseMapper;
import com.example.demo.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 extends BaseMapper<User> {
}
