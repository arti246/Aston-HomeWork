package HomeWork2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyHashSet<T> implements Iterable<T> {
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentBucket = 0;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                // Пропускаем пустые корзины
                while (currentBucket < buckets.length) {
                    if (currentIndex < buckets[currentBucket].getSize()) {
                        return true;
                    }
                    currentBucket++;
                    currentIndex = 0;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return buckets[currentBucket].myGet(currentIndex++);
            }
        };
    }

    public Stream<T> stream() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        iterator(),
                        Spliterator.DISTINCT // Уникальные
                ),
                false // не параллельный поток
        );
    }
}
