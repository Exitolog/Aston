package ru.sb.week1.hw1;

import org.junit.Test;
import ru.sb.hw1.MyLinkedList;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    @Test
    public void testAdd() {
        myLinkedList.add(10);
        myLinkedList.add(5);
        myLinkedList.add(104);

        assertEquals(104, myLinkedList.get(2).intValue());
        assertTrue(3 == myLinkedList.size());
    }

    @Test
    public void testAddWithIndex() {
        myLinkedList.add(10);
        myLinkedList.add(33);
        myLinkedList.add(49);
        myLinkedList.add(1, 100);

        assertEquals(100, myLinkedList.get(1).intValue());
    }

    @Test
    public void addFirst() {
        myLinkedList.add(10);
        myLinkedList.add(33);
        myLinkedList.add(4);
        myLinkedList.addFirst(100);

        assertEquals(100, myLinkedList.get(0).intValue());
    }

    @Test
    public void addLast() {
        myLinkedList.add(10);
        myLinkedList.add(33);
        myLinkedList.add(4);
        myLinkedList.addLast(100);

        assertEquals(100, myLinkedList.get(myLinkedList.size()-1).intValue());
    }

    @Test
    public void testGet() {
        myLinkedList.add(10);
        myLinkedList.add(33);
        myLinkedList.add(4);

        assertEquals(33, myLinkedList.get(1).intValue());
        assertEquals(4, myLinkedList.get(2).intValue());
    }

    @Test
    public void remove() {
        myLinkedList.add(10);
        myLinkedList.add(33);
        myLinkedList.add(4);
        myLinkedList.remove(33);

        assertEquals(2, myLinkedList.size());
        assertEquals(4, myLinkedList.get(1).intValue());
    }

    @Test
    public void clear() {
        myLinkedList.add(10);
        myLinkedList.add(5);
        myLinkedList.add(77);
        myLinkedList.clear();

        assertEquals(0, myLinkedList.size());
        assertNull(myLinkedList.get(0));
    }

    @Test
    public void sort() {
        myLinkedList.add(10);
        myLinkedList.add(7);
        myLinkedList.add(75);
        myLinkedList.add(4);
        myLinkedList.sort(Comparator.naturalOrder());

        assertEquals(4, myLinkedList.get(0).intValue());
        assertEquals(7, myLinkedList.get(1).intValue());
        assertEquals(10, myLinkedList.get(2).intValue());
        assertEquals(75, myLinkedList.get(3).intValue());
    }
}