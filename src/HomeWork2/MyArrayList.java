package HomeWork2;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyArrayList<T> implements Iterable<T> {
    private T[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.array = (T[]) new Object[initialCapacity];
    }

    public boolean myAdd(T value) {
        if (size == array.length) {
            myResize();
        }
        array[size] = value;
        size++;

        return true;
    }

    public boolean myAddAll(Collection<? extends T> c) {
        if (c == null) return false;
        int requiredCapacity = c.size() + size;
        if (array.length < requiredCapacity)
            myResize(Math.max(array.length * 2, requiredCapacity));

        for (T element: c) {
            array[size] = element;
            size++;
        }

        return true;
    }

    private void myResize() {
        myResize(array.length * 2);
    }

    private void myResize(int newCapacity) {
        T[] newArr = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArr, 0, size);
        array = newArr;
    }

    public boolean myRemove(int index) {
        checkBounds(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        return true;
    }

    public boolean myRemove (T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? array[i] == null : element.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }
    
    public T myGet(int index) {
        checkBounds(index);
        return array[index];
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public String toString() {
        if (size == 0) return "[ ]";
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            str.append(array[i]).append((i == size - 1)? " ]": ", ");
        }
        return  str.toString();
    }

    public boolean myContains(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? array[i] == null : element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public void clearArray() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[currentIndex++];
            }
        };
    }

    public Stream<T> stream() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        iterator(),
                        Spliterator.ORDERED
                ),
                false // не параллельный поток
        );
    }

    public int getSize() {
        return size;
    }
}