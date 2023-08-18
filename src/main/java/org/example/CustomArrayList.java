package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Custom collection class containing <b>values</b> and <b>size</b>.
 * @autor Uladzimir Zhelakovich
 * @version 1.0
 */
public class CustomArrayList<E> implements CustomList<E>{

    /** Default size of the original array */
    private final static int DEFAULT_CAPACITY = 10;

    /** Array to store data */
    private E[] values;

    /** Array size */
    private int size;

    /**
     * Constructor - creating a new collection with a default value
     */
    public CustomArrayList() {
        this.values = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor - creating a new collection with an array added
     *  @param values - Array
     */
    public CustomArrayList(E[] values) {
        this.values = values;
        size = values.length;
    }

    /**
     * Function to add an element {@link E} to the end of the array
     * @param element - Value
     */
    @Override
    public void add(E element) {
        if(checkRangeCapacity(size))
            expand();
        values[size] = element;
        size++;
    }

    /**
     * Function to add element {@link E} by index {@link Integer}
     * @param element - Value
     * @param index - Index
     */
    @Override
    public void add(E element, int index) {
        if(checkRangeCapacity(size))
            expand();
        E[] newArray = (E[]) new Object[values.length];
        System.arraycopy(values,0,newArray,0,size - index);
        newArray[index] = element;
        System.arraycopy(values,index ,newArray,index + 1 ,size - index);
        this.values = newArray;
        size++;
    }

    /**
     * Function to get element by index
     * @param index - Index
     * @return {@link E} - Value by index
     */
    @Override
    public E get(int index) {
        checkSizeCapacity(index);
        return values[index];
    }

    /**
     * Function delete by index
     * @param index - Index
     */
    @Override
    public void delete(int index) {
        checkSizeCapacity(index);
        E[] newArray = (E[]) new Object[values.length - 1];
        System.arraycopy(values, 0, newArray, 0, index);
        System.arraycopy(values, index + 1, newArray, index, values.length - index - 1);
        this.values = newArray;
        size--;
    }

    /**
     * Function to replace element by index
     * @param element - Value
     * @param index - Index
     */
    @Override
    public void set(E element, int index) {
        checkSizeCapacity(index);
        values[index] = element;
    }

    /**
     * Function to get collection size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Collection cleanup function
     */
    @Override
    public void clear() {
        values = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Collection sorting function using comparator {@link Comparator} with use {@link Arrays}
     * @param comparator - Comparator
     * @see Arrays#sort(Object[], Comparator))
     */
    @Override
    public void sort(Comparator<E> comparator) {
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(values,0,newArray,0,size);
        Arrays.sort(newArray,comparator);
        values = newArray;
    }


    /**
     * Array size checking function
     */
    private boolean checkRangeCapacity(int index){
        return index >= values.length || index < 0;
    }

    /**
     * The function of throwing an exception in cases of out of bounds of the array  {@link IndexOutOfBoundsException}
     * @param index - Index
     * @throws IndexOutOfBoundsException - Array out-of-bounds exceptions
     */
    private void checkSizeCapacity(int index){
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException(index);
    }

    /**
     * Function to double size the array
     */
    private void expand(){
        E[] newArray = (E[]) new Object[values.length * 2];
        System.arraycopy(values,0,newArray,0,values.length);
        values = newArray;
    }
}
