package com.example.demo.service.impl;

import com.example.demo.entities.User;
import com.example.demo.mapper.UserMapper2;
import com.example.demo.service.BaseService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.junit.Test;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import com.google.common.collect.Lists;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
@Service
public class UserServiceImpl2  extends BaseService<User> {
    @Resource
    private UserMapper2 userMapper2;


    @Override
    public Integer save(User model) {
        Condition condition=new Condition(User.class);
        Example.Criteria criteria=condition.createCriteria();
        criteria.andEqualTo("name","zmn");
        criteria.andEqualTo("id","1");
        List<User> userList=userMapper2.selectByCondition(criteria);

        return userMapper2.insert(model);
    }
    @Test
    public void test(){
        //java 8 比较
        User u1=new User();
        u1.setId(1l);
        u1.setName("zmn1");
        User u2=new User();
        u2.setId(4l);
        u2.setName("zmn4");
        User u3=new User();
        u3.setId(3l);
        u3.setName("zmn3");

        List<User> userList1=Lists.newLinkedList();
        userList1.add(u1);
        userList1.add(u2);
        userList1.add(u3);
        System.out.println(userList1);
        userList1.sort(Comparator.comparing(User::getId));
        System.out.println(userList1);
    }

    @Override
    public Integer save(List<User> models) {
        List<User> list = Lists.newLinkedList();

        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        return null;
    }

    @Override
    public Integer deleteByIds(String ids) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findBy(String fieldName, Object value) throws TooManyResultsException {
        return null;
    }

    @Override
    public List<User> findByIds(String ids) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findValidAll() {
        return null;
    }
}
