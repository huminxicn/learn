package com.huminxi.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.google.common.base.Verify.*;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/05/21 22:48
 */
public class CountListTest {
    private CountList list;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> start countListTest");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> finish countListTest");
    }

    @BeforeEach
    public void init() {
        list = new CountList();
        System.out.println("set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }
    }

    @AfterEach
    public void clean() {
        System.out.println("clean up " + list.getId());
    }

    @Test
    public void insert() {
        System.out.println("running insert test");
        assertEquals(list.size(), 3);
        list.add(1, "Insert");
        assertEquals(list.size(), 4);
        assertEquals(list.get(1), "Insert");
    }

    @Test
    public void replace() {
        System.out.println("running replace test");
        assertEquals(list.size(), 3);
        list.add(1, "Replace");
        assertEquals(list.size(), 4);
        assertEquals(list.get(1), "Replace");
        verify(2+2==4);
    }
}
