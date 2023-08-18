package org.example;

import java.util.Comparator;

/**
 * Сlass with ready-made methods for working with CustomList {@link CustomList}
 * @autor Uladzimir Zhelakovich
 * @version 1.0
 */
public class CustomArraysUtils {

    /**
     * Constructor - private to close object initialization
     * @see CustomArraysUtils
     */
    private CustomArraysUtils(){}


    /**
     * Quick sort function for CustomList {@link CustomList} with use Comparator {@link Comparator}
     * @param list - CustomList
     * @param begin - Sort begin index
     * @param end - Sort end index
     * @param comparator - Comparator
     */
    public static <E> void quickSort(CustomList<E> list, int begin, int end, Comparator<E> comparator){
        if(begin < end){
            int partitionIndex = partition(list, begin, end, comparator);
            quickSort(list, begin, partitionIndex - 1, comparator);
            quickSort(list, partitionIndex, end, comparator);
        }

    }


    /**
     * Quick sort function for CustomList {@link CustomList} for implementers Comparable {@link Comparable}
     * @param list - CustomList
     * @param begin - Sort begin index
     * @param end - Sort end index
     */
    public static <E extends Comparable> void quickSort(CustomList<E> list, int begin, int end){
        if(begin < end){
            int partitionIndex = partition(list, begin, end);
            quickSort(list, begin, partitionIndex - 1);
            quickSort(list, partitionIndex, end);
        }

    }

    /**
     * Collection splitting and element iteration function {@link CustomList} for implementers Comparable {@link Comparable}
     * @param list - CustomList
     * @param begin - Sort begin index
     * @param end - Sort end index
     */
    private static <E extends Comparable> int partition(CustomList<E> list, int begin, int end) {
        int rightIndex = end;
        int leftIndex = begin;

        E pivot = list.get(begin + (end - begin) / 2);
        while (leftIndex <= rightIndex) {

            while (list.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (list.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swapElement(list,rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;

    }

    /**
     * Collection splitting and element iteration function {@link CustomList} with use Comparator {@link Comparator}
     * @param list - CustomList
     * @param begin - Sort begin index
     * @param end - Sort end index
     * @param comparator - Comparator
     */
    private static <E> int partition(CustomList<E> list, int begin, int end,  Comparator<E> comparator) {
        int rightIndex = end;
        int leftIndex = begin;

        E pivot = list.get(begin + (end - begin) / 2);
        while (leftIndex <= rightIndex) {

            while (comparator.compare(list.get(leftIndex),(pivot)) < 0) {
                leftIndex++;
            }

            while (comparator.compare(list.get(rightIndex),(pivot)) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swapElement(list,rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    /**
     * Collection element replacement function {@link CustomList}
     * @param list - CustomList
     * @param rightIndex - Right element index
     * @param leftIndex - Left element index
     */
    private static <E> void swapElement(CustomList<E> list, int rightIndex,int leftIndex){
        E element = list.get(rightIndex);
        list.set(list.get(leftIndex), rightIndex);
        list.set(element, leftIndex);
    }






}
