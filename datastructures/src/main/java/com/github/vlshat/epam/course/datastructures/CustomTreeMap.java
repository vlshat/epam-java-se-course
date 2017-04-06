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

    @Override
    public boolean containsValue(Object value) {

        return find(root, (V) value) != null;
    }

    @Override
    public V get(Object key) {

        Node<K, V> result = find(root, (K) key);
        return result == null ? null : result.value;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        V[] previousValue = (V[]) new Object[1];
        root = put(root, key, value, previousValue);
        return previousValue[0];
    }

    @Override
    public V remove(Object key) {
        Node<K, V>[] nodes = findNodeWithParent((K) key);
        Node<K, V> parent = nodes[0];
        Node<K, V> node = nodes[1];

        if (node == null) {
            return null;
        }

        if (node.right == null) {
            if (parent == null) {
                root = node.left;
            } else {
                if (node.key.compareTo(parent.key) > 0) {
                    parent.right = node.left;
                } else {
                    parent.left = node.left;
                }
            }
        } else {

                if (node.right.left == null) {
                    node.right.left = node.left;

                   if (parent == null) {
                       root = node.right;
                   } else {
                       if (node.key.compareTo(parent.key) > 0) {
                           parent.right = node.right;
                       } else {
                           parent.left = node.right;
                       }
                   }

                } else {

                    Node<K, V> leastRight = node.right.left;
                    Node<K, V> previous = node.right;

                    while (true) {
                        if (leastRight.left == null)
                            break;

                        previous = leastRight;
                        leastRight = leastRight.left;
                    }

                    previous.left = leastRight.right;
                    leastRight.right = node.right;
                    leastRight.left = node.left;

                    if (parent == null) {
                        root = leastRight;
                    } else {
                        if (node.key.compareTo(parent.key) > 0) {
                            parent.right = leastRight;
                        } else {
                            parent.left = leastRight;
                        }
                    }
                }
            }

        size -= 1;

        return node.value;
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

    private Node<K, V> put(Node<K, V> node, K key, V value, V[] previousValue) {
        if (node == null) {
            size += 1;
            return new Node<>(key, value);
        }

        if (node.key.equals(key)) {
            previousValue[0] = node.value;
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = put(node.left, key, value, previousValue);
        } else {
            node.right = put(node.right, key, value, previousValue);
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

    private Node<K, V> find(Node<K, V> node, K key) {
        if (node == null)
            return null;

        if (node.key.equals(key)) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    private Node<K, V>[] findNodeWithParent(K key) {
        Node<K, V> parent = null;
        Node<K, V> current = root;


        while (current != null) {
            if (current.key.compareTo(key) > 0) {
                parent = current;
                current = current.left;
            } else if (current.key.compareTo(key) < 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        Node<K, V>[] result = new Node[2];
        result[0] = parent;
        result[1] = current;

        return result;

    }
}
