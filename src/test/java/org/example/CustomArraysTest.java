package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArraysTest {

    CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

    @Test
    public void testSort(){
        customArrayList.add(4);
        customArrayList.add(3);
        customArrayList.add(2);
        customArrayList.add(1);
        CustomArrays.quickSort(customArrayList,0,customArrayList.size() - 1 );
        assertAll(
                () -> assertEquals(customArrayList.get(0), 1),
                () -> assertEquals(customArrayList.get(1), 2),
                () -> assertEquals(customArrayList.get(2), 3),
                () -> assertEquals(customArrayList.get(3), 4)
        );
    }

    @Test
    public void testComparatorSort(){
        customArrayList.add(4);
        customArrayList.add(3);
        customArrayList.add(2);
        customArrayList.add(1);
        CustomArrays.quickSort(customArrayList,0,customArrayList.size() - 1, Integer::compareTo);
        assertAll(
                () -> assertEquals(customArrayList.get(0), 1),
                () -> assertEquals(customArrayList.get(1), 2),
                () -> assertEquals(customArrayList.get(2), 3),
                () -> assertEquals(customArrayList.get(3), 4)
        );
    }


}
