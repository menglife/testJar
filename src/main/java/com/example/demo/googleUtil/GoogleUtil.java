package com.example.demo.googleUtil;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

public class GoogleUtil {
    @Test
    public void test1(){
        //集合的创建
        List<String> list= Lists.newArrayList();
        Set<String> set= Sets.newHashSet();
        Map<String,String> map= Maps.newHashMap();

// 不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");
    //需求一需要一个Map，key为String,而值是一个集合传统赋值是先给集合赋值再put进map，根据map的Key取到value
        Map<String,List<Integer>> map1=new HashMap<String,List<Integer>>();
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        map1.put("a",list1);
        System.out.println(map1.get("a"));
        //谷歌工具类的使用
        Multimap<String,Integer> multimap=ArrayListMultimap.create();
        multimap.put("a",1);
        multimap.put("a",2);
        System.out.println(multimap.get("a"));
    //需求二无序可以重复
        Multiset<String> multiset=HashMultiset.create();
        //双向map key和value都不可以重复
        BiMap<String,String> biMap=HashBiMap.create();

    }
    @Test
    public void test2(){
        //将集合转成特定规则的字符串
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Joiner.on("-").join(list));
        //将map转化成特定规则字符串
        Map<String,String> map=Maps.newHashMap();
        map.put("name","zmn");
        map.put("address","无锡");
        System.out.println(map);
        System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));
        //将字符串转换为特定集合
        List<String> list1=new ArrayList<String >();
        String a="1-2-3-4";
        String[] strs=a.split("-");
        for (String i:strs){
            list1.add(i);
        }
        System.out.println(list1);
        String b="a-b-c-d";
        List<String> list2 = Splitter.on("-").splitToList(b);
        System.out.println(list2);
        //去空格
        String c="a-b-c-  d ";
        List<String> list3=Splitter.on("-").omitEmptyStrings().trimResults().splitToList(c);
        System.out.println(list3);
    }
    @Test
    public void test3(){
        //将字符串转成map
        String  str="name=zmn,address=无锡";
        Map<String,String > map=Splitter.on(",").withKeyValueSeparator("=").split(str);
        System.out.println(map);
        //多个字符切割
        String input = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input);
        System.out.println(result);
        //set交集，差集，并集
        HashSet hashSetA=Sets.newHashSet(1,2,3,4,5);
        HashSet hashSetB=Sets.newHashSet(4,5,6,7,8);
        Sets.SetView union=Sets.union(hashSetA,hashSetB);//求并集
        System.out.println(union);
        Sets.SetView differenceA=Sets.difference(hashSetA,hashSetB);
        Sets.SetView differenceB=Sets.difference(hashSetB,hashSetA);
        System.out.println(differenceA);//求差集
        System.out.println(differenceB);//求差集
        Sets.SetView intersection=Sets.intersection(hashSetA,hashSetB);
        System.out.println(intersection);//求交集
        //Map的求交集并集差集
    }
    @Test
    public void test4(){
        //非null和有数据的判定
        String str="123";
        if (str!=null&&str.length()>0){};
        if (!Strings.isNullOrEmpty(str)){}//



    }

}
