package ru.sb.hw1;

import java.util.Comparator;

/**
 * Интерфейс, описывающий основные методы List.
 * @param <T>
 */
//public interface MyList <T extends Comparable<T>> extends Iterable<T>  {
public interface MyList <T> {
    /**
     * Метод добавление элемента в список.
     * @param value - значение элемента.
     */
    void add(T value);

    /**
     * Метод добавление элемента по индексу.
     * @param index - значение индекса.
     * @param value - значение элемента.
     */
    void add(int index, T value);

    /**
     * Метод получения элемента по индексу.
     * @param index - значение индекса.
     * @return
     */
    T get(int index);

    /**
     * Метод удаления элемента из списка.
     * @param value - значение элемента на удаление.
     */
    void remove(T value);

    /**
     * Метод удаления всех элементов в списке.
     */
    void clear();

    /**
     * Метод компоратора
     * @param comparator - компоратор.
     */
    void sort(Comparator<T> comparator);

}
