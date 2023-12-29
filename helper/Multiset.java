package helper;

import java.util.TreeMap;

public  class Multiset<T> {
    public TreeMap<T, Integer> map;
    public int size = 0;

    public Multiset() {
        map = new TreeMap<>();
    }

    public Multiset(T[] a) {
        map = new TreeMap<>();
        size = a.length;
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
    }

    void add(T a) {
        size++;
        map.put(a, map.getOrDefault(a, 0) + 1);
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    void remove(T a) {
        size--;
        int val = map.get(a);
        map.put(a, val - 1);
        if (val == 1)
            map.remove(a);
    }

    void removeAll(int a) {
        if (map.containsKey(a)) {
            size -= map.get(a);
            map.remove(a);
        }
    }

    T ceiling(T a) {
        return map.ceilingKey(a);
    }

    T floor(T a) {
        return map.floorKey(a);
    }

    T lower(T a) {
        return map.lowerKey(a);
    }

    T higher(T a) {
        return map.higherKey(a);
    }

    T first() {
        return map.firstKey();
    }

    T last() {
        return map.lastKey();
    }

    boolean contains(T a) {
        return map.containsKey(a);
    }

    int size() {
        return size;
    }

    void clear() {
        map.clear();
    }

    T poll() {
        if (map.size() == 0) {
            return null;
        }
        size--;
        T first = map.firstKey();
        if (map.get(first) == 1) {
            map.pollFirstEntry();
        } else
            map.put(first, map.get(first) - 1);
        return first;
    }

    T polllast() {
        if (map.size() == 0) {
            return null;
        }
        size--;
        T last = map.lastKey();
        if (map.get(last) == 1) {
            map.pollLastEntry();
        } else
            map.put(last, map.get(last) - 1);
        return last;
    }
}



