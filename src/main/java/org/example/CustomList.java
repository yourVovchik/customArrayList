package org.example;

import java.util.Comparator;

/**
 * Custom collection interface with typing
 * @autor Uladzimir Zhelakovich
 * @version 1.0
 */
public interface CustomList <E> {
    /**
     * Function to add an element {@link E} to the end of the array
     * @param element - Value
     */

    void add(E element);

    /**
     * Function to add element {@link E} by index {@link Integer}
     * @param element - Value
     * @param index - Index
     */
    void add(E element, int index);

    /**
     * Function to get element by index
     * @param index - Index
     * @return {@link E} - Value by index
     */
    E get(int index);

    /**
     * Function delete by index
     * @param index - Index
     */
    void delete(int index);

    /**
     * Function to replace element by index
     * @param element - Value
     * @param index - Index
     */
    void set(E element, int index);

    /**
     * Function to get collection size
     */
    int size();

    /**
     * Collection cleanup function
     */
    void clear();

    /**
     * Collection sorting function using comparator {@link Comparator}
     * @param comparator - Comparator
     */
    void sort(Comparator<E> comparator);
}
