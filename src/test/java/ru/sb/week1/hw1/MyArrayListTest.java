package ru.sb.week1.hw1;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Comparator;
import java.util.Optional;

import static org.junit.Assert.*;

public class MyArrayListTest {

    MyArrayList<Integer> myArrayList = new MyArrayList<>();


    @Test
    public void testAdd() {
        myArrayList.add(5);
        myArrayList.add(124);
        myArrayList.add(121);

        assertEquals(124, (int) myArrayList.get(1));
        assertTrue(5 == myArrayList.get(0));
    }

    @Test
    public void testAddWithIndex() {
        myArrayList.add(5);
        myArrayList.add(124);
        myArrayList.add(121);
        myArrayList.add(1, 100);
        assertEquals(100, myArrayList.get(1).intValue());
    }

    @Test
    public void testGet() {
        myArrayList.add(5);
        myArrayList.add(124);
        myArrayList.add(121);
        assertEquals(124, myArrayList.get(1).intValue());
    }

    @Test
    public void testRemove() {
        myArrayList.add(5);
        myArrayList.add(124);
        myArrayList.add(121);
        myArrayList.remove(124);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testClear() {
        myArrayList.add(10);
        myArrayList.add(5);
        myArrayList.add(24);
        myArrayList.clear();
        assertTrue(myArrayList.size() == 0);
    }

    @Test
    public void testSort() {
        myArrayList.add(3);
        myArrayList.add(100);
        myArrayList.add(12);
        myArrayList.add(1);
        myArrayList.sort(Comparator.naturalOrder());

        assertEquals(1, myArrayList.get(0).intValue());
        assertEquals(3, myArrayList.get(1).intValue());
        assertEquals(12, myArrayList.get(2).intValue());
        assertEquals(100, myArrayList.get(3).intValue());
        }
    }
