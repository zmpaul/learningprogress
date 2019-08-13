package com.paul.common.guava;

import java.util.Iterator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class MultiCollection {

    public static Multiset<String> buildSet() {
        Multiset<String> multi = HashMultiset.create();
        multi.add("1");
        multi.add("1");
        return multi;
    }
    
    public static Multimap<String,String> buildMap() {
        Multimap<String, String> multi = HashMultimap.create();
        multi.put("1", "1");
        multi.put("1", "1");
        return multi;
    }

    public static void main(String[] args) {
        Multiset<String> multSet = buildSet();
        Iterator<String> iterator = multSet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }
        Multimap<String, String> multMap = buildMap();
        Iterator<String> _iterator = multSet.iterator();
        while (_iterator.hasNext()) {
            String key = _iterator.next();
            System.out.println(key);
        }
    }
}
