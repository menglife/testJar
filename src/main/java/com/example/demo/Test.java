package com.example.demo;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
/**
 * Test<T>泛型 Test<String>泛型实例
 **/
public class Test<T> {
    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public Test() {
        ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass=(Class<T>) pt.getActualTypeArguments()[0];
    }
    public void testFiled(){
//        isExistFieldName("filed",modelClass);
    }
    //判断某个类是否拥有某个属性
    public static Boolean isExistFieldName(String fieldName, Class clazz) throws NoSuchFieldException {
        if (clazz == null || StringUtils.isEmpty(fieldName)) {
            return false;
        }
        // 获取这个类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        boolean flag = false;
        // 循环遍历所有的fields
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(fieldName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
