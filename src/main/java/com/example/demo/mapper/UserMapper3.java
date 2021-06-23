package com.example.demo.mapper;



import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface UserMapper3 extends JpaRepository<User, String>, QuerydslPredicateExecutor<User>{
}
