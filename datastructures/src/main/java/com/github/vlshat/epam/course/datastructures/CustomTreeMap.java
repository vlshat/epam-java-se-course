package com.github.vlshat.epam.course.datastructures;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vladislav Shatilenko
 */
public class CustomTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node<K, V> root;
    private int size = 0;

    public static void main(String[] args) {
        System.out.println("Glaube".hashCode() % 16);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);

        if (root == null)
            return false;

        return find(root, (K) key) != null;
    }

    private Node<K, V> find(Node<K, V> node, K key) {
        if (node == null)
            return null;

        if (node.key.equals(key)){
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    @Override
    public boolean containsValue(Object value) {

        return find(root, (V) value) != null;
    }

    private Node<K, V> find(Node<K, V> node, V value) {
        Node<K, V> result;

        if (node == null)
            return null;

        if (node.value.equals(value)) {
            return node;
        }

        result = find(node.right, value);

        if (result == null)
            result = find(node.left, value);

        return result;

    }

    @Override
    public V get(Object key) {

        Node<K, V> result = find(root, (K) key);
        return result == null ? null : result.value;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(root, key, value);
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size += 1;
            return new Node<>(key, value);
        }

        if (node.key.equals(key)) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }

        return node;

    }

    private class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
