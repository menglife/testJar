package com.example.demo;




import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Test
    public void test1(){
        Integer [] arr ={1,2,3,4,5,6,7,8,9,10,11,12,13};
        for (Integer i:arr){
            System.out.println("a" + StringUtils.leftPad(i + "", 5, "0"));//a+五位数字最后一位递增

        }

    }

}
