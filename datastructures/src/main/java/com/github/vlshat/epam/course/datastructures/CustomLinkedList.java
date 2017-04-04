package com.github.vlshat.epam.course.datastructures;

import java.util.*;

/**
 * Created by vladislav on 28.03.17.
 */
public class CustomLinkedList<T> implements List<T> {

    private Node<T> head = new Node<>(null);
    private int size = 0;

    /**
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if this list contains elements
     */
    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    /**
     * @param o element
     * @return <tt>true</tt> if this element in list
     */
    @Override
    public boolean contains(Object o) {

        return indexOf(o) != -1;
    }

    /**
     * @return iterator elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator<>();
    }

    /**
     * @return array containing elements of list in proper sequence
     */
    @Override
    public Object[] toArray() {

        Object[] objects = new Object[size];
        Iterator<T> iterator = iterator();

        for (int i = 0; i < size; i++) {
            objects[i] = iterator.next();
        }

        return objects;
    }

    /**
     * @param a
     * @return array containing elements of list in proper sequence
     * @throws NullPointerException if a is null
     */
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

    /**
     * @param t element to add to list
     * @return true
     */
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

    /**
     * @param o element to remove
     * @return true if list contained this element
     */
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

    /**
     * @param c collection to be checked
     * @return true if this list contains all elements if specified collection
     */
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

    /**
     * @param c collection containing elements to be added to this list
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] elements = c.toArray();

        for (Object element : elements) {
            add((T) element);
        }

        return true;
    }

    /**
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] elements = c.toArray();

        for (int i = elements.length - 1; i >= 0; i--) {
            add(index, (T) elements[i]);
        }

        return true;
    }

    /**
     * @param c collection containing elements to be removed from this list
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] elements = c.toArray();

        for (Object element : elements) {
            remove((T) element);
        }

        return true;
    }

    /**
     * @param c collection containing elements to be retained in this list
     * @return
     */
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

    /**
     * Removes all elements from list
     */
    @Override
    public void clear() {
        size = 0;
        head.next = null;
    }

    /**
     * Returns element by index.
     * @param index of the element
     * @return element
     * @throws IndexOutOfBoundsException if index less than 0 or more then size()
     */
    @Override
    public T get(int index) {

        indexValidator(index);

        Node<T> node = head.next;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    /**
     * Replaces element at the specified position
     * @param index position of the element
     * @param element
     * @return previous element at this position
     */
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

    /**
     * @param index destination
     * @param element element to add to list
     * @return true
     */
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

    /**
     * Removes element from specified position.
     * @param index position of element in list
     * @return removed value
     */
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

    /**
     * @param o element to find
     * @return first position of element
     */
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

    /**
     * @param o element to find
     * @return last position of element
     */
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

    /**
     * @return list iterator over list elements
     */
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

    /**
     * @param index starting position
     * @return list iterator over list elements
     */
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

    /**
     * @param fromIndex starting position (inclusive)
     * @param toIndex last position (exclusive)
     * @return CustomArrayList with elements on positions from fromIndex to toIndex(exclusive)
     */
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
