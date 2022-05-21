package com.huminxi.junit5;

import java.util.ArrayList;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/05/21 22:46
 */
public class CountList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CountList() {
        System.out.println("CountList #" + id);
    }

    public int getId() {
        return id;
    }
}
