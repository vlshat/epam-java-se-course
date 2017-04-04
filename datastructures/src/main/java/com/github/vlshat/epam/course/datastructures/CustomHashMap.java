package com.github.vlshat.epam.course.datastructures;


import java.util.*;

/**
 * Created by vladislav on 27.03.17.
 */
public class CustomHashMap<K, V> implements Map<K, V>{
    private static final int DEFAULT_CAPACITY = 16;

    private CustomEntry<K, V>[] buckets = new CustomEntry[DEFAULT_CAPACITY];
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
        if (key == null)
            throw new NullPointerException();

        K castedKey = (K) key;

        int bucketIndex = castedKey.hashCode() % buckets.length;

        CustomEntry<K, V> bucket = buckets[bucketIndex];

        if(bucket != null){

            while (bucket != null) {
                if (bucket.key.equals(castedKey)) {
                    return true;
                }
                bucket = bucket.next();
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                CustomEntry<K, V> entry = buckets[i];
                while (entry != null) {
                    if (entry.value == null) {
                        if (value == null) {
                            return true;
                        }
                    } else if (entry.value.equals(value)){
                        return true;
                    }
                    entry = entry.next();
                }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);

        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;

        if (buckets[bucketIndex] == null) {
            return null;
        } else {
            CustomEntry<K, V> entry = buckets[bucketIndex];

            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new CustomEntry<>(key, value);
            size += 1;
        } else {
            CustomEntry<K, V> entry = buckets[bucketIndex];
            CustomEntry<K, V> previousEntry = null;
            while (entry != null) {
                if (entry.key.equals(key)) {
                    V previousValue = entry.value;
                    entry.value = value;
                    return previousValue;
                }
                previousEntry = entry;
                entry = entry.next();
            }

            previousEntry.next = new CustomEntry<>(key, value);
            size += 1;

        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }

        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;

        if (buckets[bucketIndex] != null) {
            CustomEntry<K, V> entry = buckets[bucketIndex];
            CustomEntry<K, V> previousEntry = null;
            while (entry != null) {
                if (entry.key.equals(key)) {
                    V deletedValue = entry.value;
                    if (previousEntry != null) {
                        previousEntry.next = entry.next;
                    } else {
                        buckets[bucketIndex] = entry.next;
                    }
                    size -= 1;
                    return deletedValue;
                }
                previousEntry = entry;
                entry = entry.next();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new CustomEntry[DEFAULT_CAPACITY];
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

    private class CustomEntry<K, V> implements Iterator<CustomEntry<K, V>>, Entry<K, V> {

        private final K key;
        private V value;
        private CustomEntry<K, V> next = null;

        CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public CustomEntry<K, V> next() {
            return this.next;
        }

        void setNext(CustomEntry<K, V> next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V previousValue = value;
            this.value = value;
            return previousValue;
        }
    }
}
