package helper;

import java.util.HashMap;

public class UnorderedMultiset<T> {
    public HashMap<T, Integer> map;
    public int size = 0;

    public UnorderedMultiset() {
        map = new HashMap<>();
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
        if (val == 1) {
            map.remove(a);
        } else {
            map.put(a, val - 1);
        }
    }

    void removeAll(int a) {
        if (map.containsKey(a)) {
            size -= map.get(a);
            map.remove(a);
        }
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

}
