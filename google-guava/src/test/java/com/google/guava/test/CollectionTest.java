package com.google.guava.test;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author zhuzhenke
 * @date 2018/8/5
 */
public class CollectionTest {

    @Test
    public void testCollectionImplement() {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        List<Integer> unmodifiableList = Collections.unmodifiableList(intList);
        System.out.println("unmodifiableList.size:" + unmodifiableList.size());


        intList.add(5);
        System.out.println("unmodifiableList.size:" + unmodifiableList.size());

        //UnmodifiableCollection can not add element
//        unmodifiableList.add(6);
    }


    @Test
    public void testGuavaCollectionImplement() {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        ImmutableList<Integer> immutableList = ImmutableList.copyOf(intList);
        System.out.println("immutableList.size:" + immutableList.size());


        intList.add(5);
        System.out.println("immutableList.size:" + immutableList.size());

        //ImmutableList can not add element
//        immutableList.add(6);
    }


    @Test
    public void testHashMultiSet() {
        Multiset<Integer> multiset = HashMultiset.create();
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(2);
        intList.add(2);
        intList.add(3);
        multiset.addAll(intList);

        System.out.println("---------------");
        for (Integer key : multiset.elementSet()) {
            System.out.println(key + "'s count is :" + multiset.count(key));
        }
        multiset.add(4, 4);
        System.out.println("---------------");
        for (Integer key : multiset.elementSet()) {
            System.out.println(key + "'s count is :" + multiset.count(key));
        }
    }

    @Test
    public void testTreeMultiSet() {
        Multiset<Integer> multiset = TreeMultiset.create();
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(2);
        intList.add(4);
        intList.add(4);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        multiset.addAll(intList);

        System.out.println("---------------");
        for (Integer key : multiset.elementSet()) {
            System.out.println(key + "'s count is :" + multiset.count(key));
        }
        multiset.add(-1, 1);
        System.out.println("---------------");
        for (Integer key : multiset.elementSet()) {
            System.out.println(key + "'s count is :" + multiset.count(key));
        }
    }


    @Test
    public void testHashMultimap() {
        HashMultimap<String, String> multimap = HashMultimap.create();
        multimap.put("a", "a");
        multimap.put("a", "aa");
        multimap.put("a", "aa");
        multimap.put("a", "aa");
        multimap.put("a", "aaa");
        multimap.put("a", "aaaa");
        multimap.put("b", "b");
        multimap.put("b", "bb");
        multimap.put("c", "cccc");
        multimap.put("c", "ccc");

        Set<String> set = multimap.get("a");
        for (String string : set) {
            System.out.println(string);
        }
    }


    @Test
    public void testHashBiMap(){
        HashBiMap<String,Integer> biMap = HashBiMap.create();
        biMap.put("aa",11);
        biMap.put("a",1);
        biMap.put("aaa",111);
        System.out.println(biMap.inverse().get(1));

    }
}
