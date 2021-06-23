package com.example.demo.service.impl;

import com.example.demo.entities.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMapper3;
import com.example.demo.service.UserService;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(Long id) {


        User u=userMapper.getUser(id);  //传统方式通过mybatis配置文件操作数据库

        userMapper.selectByPrimaryKey(100); //slect * from user where id = 100;//根据maper自动方法操作数据库(无太多条件)
        userMapper.insert(u);
        userMapper.updateByPrimaryKey(u);
        //多条件操作数据据库
        Example example =new Example(User.class);
        //Condition condition=new Condition(User.class);Conditions是Example子类也可以
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("id","1");
        criteria.andEqualTo("name","zmn");
        userMapper.selectByExample(criteria);

        //;
        return u;
    }
    /**
     * @Description:
     * @Date: 2021/6/21 16:56
     * Jpa
     *
     **/
    @Resource
    JPAQueryFactory jpaQueryFactory;
    @Autowired

    UserMapper3 userMapper3;
    @Autowired
    private EntityManager entityManager;
    @Override
    public User findUser(String name,Integer age){
        QUser user = QUser.user;

//        jpaQueryFactory.selectFrom(user)
        Predicate predicate=null;
        userMapper3.findAll(predicate);

       // jpaQueryFactory=new JPAQueryFactory(entityManager);
        jpaQueryFactory.selectFrom(user).where(predicate);
        return jpaQueryFactory.selectFrom(user).where(user.name.eq(name),user.age.eq(age)).fetchOne();
    }
    @Test
    public void test2(){
        findUser2("zmn",12);


    }
    public List<User> findUser2(String name,Integer age){
        List<User> userList=null;
        QUser user = QUser.user;
        BooleanExpression predicate = null;//
        predicate = user.name.eq(name).and(user.age.eq(age));
        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        System.out.println(sort);
        System.out.println("-----------------");
        if (predicate!=null){
            userList=Lists.newArrayList(userMapper3.findAll(predicate,sort));
        }else {
            userList=Lists.newArrayList(userMapper3.findAll(sort));
        }

//        jpaQueryFactory.selectFrom(user).where()
        System.out.println(userList);
        return userList;
    }


    @Test
    public void  test(){
        User user=new User();
        User user1=new User();
        //        String userJson="";
        user1.setId(1L);
        user1.setName("zmn");
        User user2=new User();
        //        String userJson="";
        user2.setId(2L);
        user2.setName("zs");
        User user3=new User();
        //        String userJson="";
        user3.setId(3L);
        user3.setName("zs");
        List<User> userList=Lists.newLinkedList();
//        userList.add(user);   //null
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.addAll(Lists.newArrayList());//
        List<Long> ids=userList.stream().map(User::getId).distinct().collect(Collectors.toList());
        System.out.println(ids);  //[1,2,3]
        Map<Long,User> map=userList.stream().collect(Collectors.toMap(User::getId,x->x));
        System.out.println(map);  //{1=User(id=1, projectId=null, name=zmn, age=null), 2=User(id=2, projectId=null, name=zs, age=null), 3=User(id=3, projectId=null, name=zs, age=null)}
        System.out.println("*****************");
        userList.forEach(ul->{
            if (map.containsKey(ul.getId())){
                User user4 =map.get(ul.getId());
                System.out.println(user4);
                if (!Objects.equals(ul.getName(),user4.getName())){
                    System.out.println("相等");
                }
            }
        });


//        JSON.parseObject(userJson, Test.class);
//        User user1=new User();
//        BeanUtils.copyProperties(user,user1);
//        Condition condition = new Condition(User.class);
//        Example.Criteria criteria=condition.createCriteria();
//        criteria.andEqualTo("id",user1.getId());
//        criteria.andEqualTo("name","zmn");
//        List<User> list = Lists.newLinkedList();
//        Integer pageNumer=2;
//        Integer pageSize=2;
//        PageHelper.startPage(pageNumer,pageSize);
//        userMapper.getAll();





    }
}
