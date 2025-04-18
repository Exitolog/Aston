package ru.sb.hw1;

/**
 * Класс узел двусвязного списка
 * @param <T> - тип элемента, который хранится в узле
 */
public class MyNode<T> {

    /**
     * Указатель на следующий элемент в списке
     */
    MyNode<T> next;

    /**
     * Значение элемента в узле
     */
    T value;

    /**
     * Указатель на предыдущий элемент в списке
     */
    MyNode<T> prev;

    /**
     * Конструктор узла
     * @param next - указатель на следующий элемент в списке
     * @param value - значение элемента в узле
     * @param prev - указатель на предыдущий элемент в списке
     */
    public MyNode(MyNode<T> next, T value, MyNode<T> prev) {
        this.next = next;
        this.value = value;
        this.prev = prev;
    }
}
