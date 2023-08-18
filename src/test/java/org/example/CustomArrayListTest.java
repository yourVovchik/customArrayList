package org.example;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    CustomArrayList<Integer> customArrayList = new CustomArrayList<>();


    @Test
    public void testAdd(){
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        assertAll(
                () -> assertEquals(customArrayList.get(0), 1),
                () -> assertEquals(customArrayList.get(1), 2),
                () -> assertEquals(customArrayList.get(2), 3),
                () -> assertEquals(customArrayList.get(3), 4)
        );
    }

    @Test
    public void testAddByIndex(){
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3,0);
        customArrayList.add(4);
        assertEquals(customArrayList.get(0), 3);

    }

    @Test
    public void testSet(){
        customArrayList.add(1);
        customArrayList.set(5,0);
        assertEquals(customArrayList.get(0), 5);

    }

    @Test
    public void testGet(){
        customArrayList.add(100);
        assertEquals(customArrayList.get(0), 100);
    }

    @Test
    public void testDelete(){
        customArrayList.add(100);
        customArrayList.delete(0);
        assertEquals(customArrayList.size(), 0);
    }

    @Test
    public void testSize(){
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        assertEquals(customArrayList.size(), 4);
    }

    @Test
    public void testClear(){
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.clear();
        assertEquals(customArrayList.size(), 0);
    }

    @Test
    public void testSort(){
        customArrayList.add(4);
        customArrayList.add(3);
        customArrayList.add(2);
        customArrayList.add(1);
        customArrayList.sort(Integer::compareTo);
        assertAll(
                () -> assertEquals(customArrayList.get(0), 1),
                () -> assertEquals(customArrayList.get(1), 2),
                () -> assertEquals(customArrayList.get(2), 3),
                () -> assertEquals(customArrayList.get(3), 4)
        );
    }

}
