package com.example.demo.mapper;

import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    public User getUser(Long id);
    public List<User> getAll();
}
