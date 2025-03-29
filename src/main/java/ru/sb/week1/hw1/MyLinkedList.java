package ru.sb.week1.hw1;

import java.util.Comparator;
import java.util.Iterator;


/**
 * Класс MyLinkedList является самописной структурой данных в формате двусвязного списка.
 * Где хранятся данные и указатели на следующий и предшествующий узлы.
 * @param <T> - тип элемента, который хранится в узле
 */
    public class MyLinkedList<T> implements MyList<T> {

    /**
     * Первый узел в списке.
     * Хранит null на предшествующий узел.
     * Хранит значение элемента.
     * Хранит ссылку на следующий узел, если таковой имеется.
     */
    private MyNode<T> first;

    /**
     * Последний узел в списке.
     * Хранит ссылку на предшествующий узел.
     * Хранит значение элемента.
     * Хранит null на следующий узел.
     */
    private MyNode<T> last;

    /**
     * Количество узлов в списке.
     */
    private int size;

    /**
     * Конструктор LinkedList.
     * Хранящий в себе 0 элементов.
     * Первый и последний узлы равны null
     */
    public MyLinkedList() {
        this.size = 0;
        first = null;
        last = null;
    }

    /**
     * Добавление элемента в список.
     * @param value - значение элемента, который добавляем.
     */
    @Override
    public void add(T value) {
        addLast(value);
    }

    /**
     * Добавление элемента в список по индексу.
     * @param index - индекс добавляемого элемента.
     * @param value - значение элемента.
     */
    @Override
    public void add(int index, T value) {
        if(index == size-1) addLast(value);
        if(index == 0) addFirst(value);
        MyNode<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        MyNode<T> newNode = new MyNode<T>(current, value, current.prev);
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    /**
     * Добавление элемента в начало списка.
     * @param value - значение добавляемого элемента.
     */
    public void addFirst(T value) {
        MyNode<T> first = this.first;
        MyNode<T> newNode = new MyNode<T>(first, value, null);
        newNode.next = first;
        this.first = newNode;
        if(first == null) last = newNode;
        else first.prev = newNode;
        size++;
    }

    /**
     * Добавление элемента в конец списка.
     * @param value - значение элемента.
     */
    public void addLast(T value) {
        MyNode<T> last = this.last;
        MyNode<T> newNode = new MyNode<T>(null,value, last);
        this.last = newNode;
        if(last == null) first = newNode;
        else last.next = newNode;
        size++;
    }

    /**
     * Метод возвращающий элемент по индексу
     * @param index - индекс поискового элемента
     * @return - возвращает элемент по индексу
     */
    @Override
    public T get(int index) {
        if(index >= 0 && index < size) {
            MyNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } return null;
    }

    /**
     * Метод удаления элемента из списка по значению.
     * @param value - значение элемента, который нужно удалить из списка.
     */
    @Override
    public void remove(T value) {

        MyNode<T> current = first;

         while (current.next != null) {
            if(current.value.equals(value)) {
                if(current.prev != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    break;
                } else {
                    first = current.next;
                    first.prev = null;
                    size--;
                    break;
                }
            }
            current = current.next;
        }
    }

    /**
     * Метод очистки LinkedList от всех элементов
     */
    @Override
    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * Метод сортировки в порядке возрастания
     * @param comparator -
     */
    @Override
    public void sort(Comparator<T> comparator) {
        if (size > 1) {
            MyNode<T> current = first.next;
             while (current != null) {
                 MyNode<T> inner = first;
                 while (inner != current) {
                     if (comparator.compare(inner.value, current.value) > 0) {
                         T temp = current.value;
                         current.value = inner.value;
                         inner.value = temp;
                     }
                     inner = inner.next;
                 }
                 current = current.next;
             }
        }
    }

    public int size() {
        return size;
    }

    /**
     * Метод возвращающий строку с элементами LinkedList
     * @return - возвращаемая строка.
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        MyNode<T> current = first;
        if(first == null) return "[]";
        for (int i = 0; i < size; i++) {
            strBuilder.append(current.value).append(", ");
            current = current.next;
        }
        if (strBuilder.length() > 2) strBuilder.delete(strBuilder.length() - 2, strBuilder.length());
        strBuilder.append("]");
        return strBuilder.toString();
    }
}
