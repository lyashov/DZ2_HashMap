package HashMap;

import java.util.*;

public class MyHashMap<T1, T2> implements Map<T1, T2> {
    float loadFactor = 0.75f;
    static int arraySize = 16;

    public MyHashMap() {

    }

    public MyHashMap(int arraySize) {
        this.arraySize = arraySize;
    }

    public MyHashMap(int loadFactor, int arraySize) {
        this.loadFactor = loadFactor;
        this.arraySize = arraySize;
    }

    static class Pair<T1, T2> {
        private final T1 key;
        private final T2 value;
        private int hashCode;
        Pair<T1, T2> next;

        public Pair(T1 key, T2 value) {
            this.key = key;
            this.value = value;
            this.hashCode = keyHashCode(key.hashCode());
        }

        public static int keyHashCode(int hashCode) {
            return Math.abs(hashCode) % (MyHashMap.arraySize - 1);
            //hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
            //return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
        }

        public T1 getKey() {
            return key;
        }

        public T2 getValue() {
            return value;
        }
    }

    private Pair<T1, T2>[] arr = new Pair[arraySize];

    public T2 put(T1 key, T2 value) {
        return putKeyValue(key, value);
    }

    private T2 putKeyValue(T1 key, T2 value) {
        if (arr.length != 0) {
            float persent = (float) size() / (float) arr.length;
            arraySize = arr.length * 2;
            if (persent >= loadFactor) resize(arr.length * 2);
        }
        Pair<T1, T2> pair = new Pair(key, value);
        int index = Pair.keyHashCode(key.hashCode());
        if (arr[index] == null) arr[index] = pair;
        else if (!pair.getKey().equals(arr[index].getKey())) {
            //if collision
            pair.next = arr[index];
            arr[index] = pair;
        }
        //update element
        else arr[index] = pair;
        return pair.getValue();
    }

    private void resize(int newCapacity) {
        Pair[] newTable = new Pair[newCapacity];
        Pair[] tmpTable = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmpTable[i] = arr[i];
        }
        arr = newTable;
        for (Pair pair : tmpTable) {
            if (pair == null) continue;
            putKeyValue((T1) pair.getKey(), (T2) pair.getValue());
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object key) {
        int hashCodeKey = Pair.keyHashCode(key.hashCode());
        Pair<T1, T2> pair = arr[hashCodeKey];
        return pair != null ? true : false;
    }

    private Pair<T1, T2> getParent(Pair<T1, T2> pair) {
        return pair.next;
    }

    public T2 get(Object key) {
        int hashCodeKey = Pair.keyHashCode(key.hashCode());
        if (arr[hashCodeKey] == null) return null;
        Pair<T1, T2> pair = arr[hashCodeKey];
        if (key.equals(pair.getKey()))
            return pair != null ? pair.getValue() : null;
        else {
            //if collision
            Pair<T1, T2> parent;
            while ((parent = getParent(pair)) != null) {
                if (key.equals(pair.getKey()))
                    return pair != null ? pair.getValue() : null;
            }
            return null;
        }
    }

    public T2 remove(Object key) {
        int hashCodeKey = Pair.keyHashCode(key.hashCode());
        Pair<T1, T2> pair = arr[hashCodeKey];
        if (pair != null){
            arr[hashCodeKey] = null;
            return pair.getValue();
        }
        throw new NullPointerException();
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null) size++;
        }
        return size;
    }

    @Override
    public Set<Entry<T1, T2>> entrySet() {
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void putAll(Map<? extends T1, ? extends T2> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<T1> keySet() {
        return null;
    }

    @Override
    public Collection<T2> values() {
        return null;
    }
}
