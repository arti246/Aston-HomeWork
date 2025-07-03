package HomeWork2;

public class MyHashSet<T> {
    private MyArrayList<T>[] buckets;
    private int size;

    public MyHashSet(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        buckets = new MyArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new MyArrayList<>();
        }
        size = 0;
    }

    public boolean myAdd(T element) {
        int index = getBucketIndex(element);
        MyArrayList<T> bucket = buckets[index];
        if (!bucket.myContains(element)) {
            bucket.myAdd(element);
            size++;
            return true;
        }
        return false;
    }

    public boolean myRemove(T element) {
        int index = getBucketIndex(element);
        MyArrayList<T> bucket = buckets[index];
        boolean removed = bucket.myRemove(element);
        if (removed) {
            size--;
        }

        return removed;
    }

    private int getBucketIndex(T element) {
        if (element == null) return 0;
        return Math.abs(element.hashCode() % buckets.length);
    }
}
