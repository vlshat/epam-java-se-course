package com.github.vlshat.epam.course.datastructures;

import java.util.*;

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

        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator<>();
    }

    @Override
    public Object[] toArray() {

        Object[] objects = new Object[size];
        Iterator<T> iterator = iterator();

        for (int i = 0; i < size; i++) {
            objects[i] = iterator.next();
        }

        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {

        if (a == null)
            throw new NullPointerException();

        Iterator<T> iterator = iterator();

        if (a.length < size) {

            T1[] result = (T1[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);

            for (int i = 0; i < size; i++) {
                result[i] = (T1) iterator.next();
            }

            return (T1[]) result;
        }

        for (int i = 0; i < size; i++) {
            a[i] = (T1) iterator.next();
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
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

        while (previousNode.hasNext()) {
            if (node.value == null) {
                if (o == null) {
                    previousNode.next = node.next;
                    size -= 1;
                    return true;
                }
            } else if (node.value.equals(o)) {
                previousNode.next = node.next;
                size -= 1;
                return true;
            }

            previousNode = node;
            node = node.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        Object[] elements = c.toArray();

        for (Object element : elements) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] elements = c.toArray();

        for (Object element : elements) {
            add((T) element);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] elements = c.toArray();

        for (int i = elements.length - 1; i >= 0; i--) {
            add(index, (T) elements[i]);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] elements = c.toArray();

        for (Object element : elements) {
            remove((T) element);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        List<T> elementsToSave = new CustomArrayList<T>();
        Object[] elements = c.toArray();

        for (Object element : elements) {
            if (contains(element)) {
                elementsToSave.add((T) element);
            }
        }

        clear();
        addAll(elementsToSave);

        return true;
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
        indexValidator(index);

        Node<T> previousNode = head;
        Node<T> node = head.next;

        for (int i = 0; i < index; i++) {
            previousNode = node;
            node = node.next;
        }

        Node<T> newNode = new Node<>(element);
        previousNode.next = newNode;
        newNode.next = node.next;

        return element;
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

        Node<T> node = head.next;

        for (int i = 0; i < size; i++) {
            if (node.value == null) {
                if (o == null) {
                    return i;
                }
            } else if (node.value.equals(o)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = -1;

        Node<T> node = head.next;

        for (int i = 0; i < size; i++) {
            if (node.value == null) {
                if (o == null) {
                    index = i;
                }
            } else if (node.value.equals(o)) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {

            int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (currentIndex + 1 == size)
                    throw new NoSuchElementException();
                return (T) CustomLinkedList.this.getNodeByIndex(++currentIndex).value;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (currentIndex == 0) {
                    throw new NoSuchElementException();
                }
                return (T) CustomLinkedList.this.getNodeByIndex(--currentIndex).value;
            }

            @Override
            public int nextIndex() {
                return currentIndex < size ? currentIndex + 1 : -1;
            }

            @Override
            public int previousIndex() {
                return currentIndex > 0 ? currentIndex - 1 : -1;
            }

            @Override
            public void remove() {
                CustomLinkedList.this.remove(currentIndex);
            }

            @Override
            public void set(T t) {
                CustomLinkedList.this.set(currentIndex, t);
            }

            @Override
            public void add(T t) {
                CustomLinkedList.this.add(currentIndex + 1, t);
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        indexValidator(index);
        return new ListIterator<T>() {

            int currentIndex = index;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (currentIndex + 1 == size)
                    throw new NoSuchElementException();
                return (T) CustomLinkedList.this.getNodeByIndex(++currentIndex).value;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (currentIndex == 0) {
                    throw new NoSuchElementException();
                }
                return (T) CustomLinkedList.this.getNodeByIndex(--currentIndex).value;
            }

            @Override
            public int nextIndex() {
                return currentIndex < size ? currentIndex + 1 : -1;
            }

            @Override
            public int previousIndex() {
                return currentIndex > 0 ? currentIndex - 1 : -1;
            }

            @Override
            public void remove() {
                CustomLinkedList.this.remove(currentIndex);
            }

            @Override
            public void set(T t) {
                CustomLinkedList.this.set(currentIndex, t);
            }

            @Override
            public void add(T t) {
                CustomLinkedList.this.add(currentIndex + 1, t);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        indexValidator(fromIndex);
        indexValidator(toIndex);

        List<T> result = new CustomArrayList<T>();

        Node<T> node = getNodeByIndex(fromIndex - 1);

        for (int i = fromIndex; i < toIndex; i++) {
            node = node.next;
            result.add(node.value);
        }


        return result;
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

    private class CustomLinkedListIterator<T> implements Iterator<T> {

        private Node<T> node = (Node<T>) head;

        @Override
        public boolean hasNext() {
            return node.hasNext();
        }

        @Override
        public T next() {
            if (node.hasNext()) {
                T value = node.next.value;
                node = node.next;
                return (T) value;
            }

            throw new NoSuchElementException();
        }
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> node = head;

        for (int i = 0; i <= index; i++) {
            node = node.next;
        }

        return node;
    }
}
