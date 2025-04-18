package ru.sb.hw1;

import java.util.*;

/**
 * Класс для проверки работоспособности структур данных
 * @author Belyakov Sergey
 */
public class Homework1 {
    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        Random random = new Random();
        Integer a = 111;

        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(1000);
            myArrayList.add(value);
            myLinkedList.add(value);
            arrayList.add(value);
            linkedList.add(value);
        }

        System.out.println("\nДобавили 5 элементов в каждый из списков");
        System.out.println("============================================\n");

        System.out.println("My ArrayList : " + myArrayList);
        System.out.println("My LinkedList : " + myLinkedList);
        System.out.println("Arraylist: " + arrayList);
        System.out.println("Linkedlist: " + linkedList);



        myArrayList.add(a);
        myLinkedList.add(a);
        arrayList.add(a);
        linkedList.add(a);

        System.out.println("\nДобавили элемент 111 в каждый из списков");
        System.out.println("============================================\n");

        System.out.println("My ArrayList : " + myArrayList);
        System.out.println("My LinkedList : " + myLinkedList);
        System.out.println("Arraylist: " + arrayList);
        System.out.println("Linkedlist: " + linkedList);

        myArrayList.sort(Comparator.naturalOrder());
        myLinkedList.sort(Comparator.naturalOrder());
        arrayList.sort(Comparator.naturalOrder());
        linkedList.sort(Comparator.naturalOrder());

        System.out.println("\nОтсортировали элементы по возрастанию в списках");
        System.out.println("============================================\n");

        System.out.println("My ArrayList : " + myArrayList);
        System.out.println("My LinkedList : " + myLinkedList);
        System.out.println("Arraylist: " + arrayList);
        System.out.println("Linkedlist: " + linkedList);

        myArrayList.remove(a);
        myLinkedList.remove(a);
        arrayList.remove(a);
        linkedList.remove(a);

        System.out.println("\nУдалили элемент 111 в каждом списке");
        System.out.println("============================================\n");

        System.out.println("My ArrayList : " + myArrayList);
        System.out.println("My LinkedList : " + myLinkedList);
        System.out.println("Arraylist: " + arrayList);
        System.out.println("Linkedlist: " + linkedList);

        myArrayList.clear();
        myLinkedList.clear();
        arrayList.clear();
        linkedList.clear();

        System.out.println("\nОчислили все списки");
        System.out.println("============================================\n");

        System.out.println("My ArrayList : " + myArrayList);
        System.out.println("My LinkedList : " + myLinkedList);
        System.out.println("Arraylist: " + arrayList);
        System.out.println("Linkedlist: " + linkedList);


    }
}
