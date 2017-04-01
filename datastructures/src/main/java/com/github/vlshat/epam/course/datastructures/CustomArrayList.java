package com.github.vlshat.epam.course.datastructures;

import java.util.*;

/**
 * @author Vladislav Shatilenko
 */
public class CustomArrayList<T> implements List<T> {

    public static final int DEFAULT_CAPACITY = 16;

    private Object[] data = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator<>();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {

        if (a == null)
            throw new NullPointerException();

        if (a.length < size){
            return (T1[]) Arrays.copyOf(data, size, a.getClass());
        }

        System.arraycopy(data, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {

        ensureCapacity();

        data[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    remove(i);
                    return true;
                }
            } else if (data[i].equals(o)) {
                remove(i);
                return true;
            }
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
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {

        indexValidator(index);

        return (T) data[index];
    }

    @Override
    public T set(int index, T element) {

        indexValidator(index);

        data[index] = element;

        return element;
    }

    @Override
    public void add(int index, T element) {
        indexValidator(index);
        ensureCapacity();

        System.arraycopy(data, index, data, index + 1, data.length - index - 1);
        data[index] = element;
        size += 1;

    }

    @Override
    public T remove(int index) {

        indexValidator(index);

        T value = (T) data[index];

        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        size -= 1;

        return value;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    return i;
                }
            } else if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = -1;

        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    index = i;
                }
            } else if (data[i].equals(o)) {
                index = i;
            }
        }

        return index;
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

    private void ensureCapacity() {
        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
    }

    private void indexValidator(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class CustomListIterator<T> implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) data[index++];
            }

            throw new NoSuchElementException();
        }
    }
}