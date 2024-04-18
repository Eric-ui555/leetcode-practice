package org.leetcode.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/4/18 9:23
 */

public class IteratorDemo {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        /**
         * 迭代器遍历
         */
        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()){
        //     Integer next = iterator.next();
        //     // System.out.println(next);
        //     if(next == 3){
        //         iterator.remove();
        //     }
        // }
        // System.out.println(list);

        /**
         * Stream流遍历
         */
        list.stream().forEach(ele->{
            if(ele != 3){
                System.out.println(ele);
            }
        });
    }



}
