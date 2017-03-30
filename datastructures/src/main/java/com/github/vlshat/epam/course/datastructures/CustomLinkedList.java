package com.github.vlshat.epam.course.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by vladislav on 28.03.17.
 */
public class CustomLinkedList<T> implements List<T> {

    private Node<T> head = new Node<>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    @Override
    public boolean contains(Object o) {
        Node<T> iterator = head;

        while (iterator.hasNext()) {
            iterator = iterator.next;
            if (iterator.value == null) {
                if (o == null) {
                    return true;
                }
            } else if (iterator.value.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> iterator = head;

        while (iterator.hasNext()) {
            iterator = iterator.next;
        }

        iterator.next = new Node<>(t);
        size++;

        return false;
    }

    @Override
    public boolean remove(Object o) {

        Node<T> previousNode = head;
        Node<T> node = head.next;

        while (node.hasNext()) {
            if (node.value == null) {
                if (o == null) {
                    previousNode.next = node.next;
                    return true;
                }
            } else if (node.value.equals(o)) {
                previousNode.next = node.next;
                return true;
            }

            previousNode = node;
            node = node.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = null;
    }

    @Override
    public T get(int index) {

        indexValidator(index);

        Node<T> node = head.next;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        indexValidator(index);

        Node<T> previousNode = head;
        Node<T> node = head.next;

        for (int i = 0; i < index; i++) {
            previousNode = node;
            node = node.next;
        }

        Node<T> newNode = new Node<>(element);
        previousNode.next = newNode;
        newNode.next = node;
        size += 1;
    }

    @Override
    public T remove(int index) {

        indexValidator(index);

        Node<T> node = head.next;

        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }

        Node<T> deletedNode = node.next;

        node.next = deletedNode.next;
        size -= 1;

        return deletedNode.value;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void indexValidator(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }


    private class Node<T> {

        private Node<T> next;
        private T value;

        Node(T value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
