package ru.sb.hw1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс MyArrayList является самописной структурой данных
 * работабщий по принципу динамического массива, если количество элементов
 * превышает вместимость, то вместимость увеличивается на 50%.
 *
 * @param <T> - тип элемента, который хранится в листе.
 */

public class MyArrayList<T> implements MyList<T> {

    /**
     * Индекс - номер, по которому хранятся значения в массиве.
     */
    private int index;

    /**
     * Вместимость данного массива.
     */
    private int capacity;

    /**
     * Размер данного массива.
     */
    private int size;

    /**
     * Массив, в котором хранятся значения.
     */
    private T[] values;

    /**
     * Конкруктор класса, по умолчанию установлена вместимость в 10 элементов.
     */
    public MyArrayList() {
        this.index = 0;
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (T[]) new Comparable[capacity];
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Метод добавления элемента в массивю.
     *
     * @param value - значение элемента.
     */
    @Override
    public void add(T value) {
        if (size == capacity) addCapacity();
        values[size++] = value;
    }

    /**
     * Метод добавление элемента в массив по индексу.
     *
     * @param index - значение индекса.
     * @param value - значение элемента.
     */
    @Override
    public void add(int index, T value) {
        if (size == capacity) addCapacity();
        values[index] = value;
        size++;
    }

    /**
     * Метод с получением элемента по индексу.
     *
     * @param index - значение индекса.
     * @return - возвращает элемент по индексу.
     */
    @Override
    public T get(int index) {
        return values[index];
    }

    /**
     * Метод удаления элемента из массива.
     *
     * @param value - значение элемента на удаление.
     */
    @Override
    public void remove(T value) {
        T[] temp = (T[]) new Comparable[values.length-1];
        for (int i = 0; i < size; i++) {
            if(values[i].equals(value)) {
                System.arraycopy(values, 0, temp, 0, i);
                int amountElementsAfterIndex = temp.length - i - 1;
                System.out.println(amountElementsAfterIndex);
                System.arraycopy(values, i + 1, temp, i, amountElementsAfterIndex);
                values = temp;
                size--;
                break;
            }
        }
    }

    /**
     * Метод очистки массива от всех элементов.
     */
    @Override
    public void clear() {
        for (int i = 0; i <= size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    /**
     * Метод сортировки массива.
     *
     * @param comparator - компаратор сортировки.
     */
    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort(values, Comparator.nullsLast(comparator));
    }

    /**
     * Приватный метод увеличения вместимости массива.
     */
    private void addCapacity() {
        try {
            T[] temp = (T[]) new Comparable[capacity + capacity / 2];
            System.arraycopy(values, 0, temp, 0, values.length);
            values = temp;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public int size() {
        return size;
    }


    /**
     * Метод возвращающий строку с элементами ArrayList.
     *
     * @return - возвращаемая строка.
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        for (T value : values) {
            if (value != null) strBuilder.append(value).append(", ");
        }
        if (strBuilder.length() > 2) strBuilder.delete(strBuilder.length() - 2, strBuilder.length());
        strBuilder.append("]");
        return strBuilder.toString();
    }
}
