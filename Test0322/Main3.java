package Test0322;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main3 {
    private int capacity;
    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();
    private class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            if (size() > capacity) {
                return true;
            } else {
                return false;
            }
        }
    }
    public Main3(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer value = lruLinkedHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruLinkedHashMap.remove(key);
        lruLinkedHashMap.put(key, value);
        return value;
    }
    public void put(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
        }
        lruLinkedHashMap.put(key, value);
    }
}