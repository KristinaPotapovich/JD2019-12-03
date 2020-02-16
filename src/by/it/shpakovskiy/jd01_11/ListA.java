package by.it.shpakovskiy.jd01_11;

import java.util.*;

class ListA<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            text.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        text.append("]");
        return text.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int i, T element) {
        if (i <= size) {
            T oldElement = elements[i];
            elements[i] = element;
            return oldElement;
        }
        return null;
    }

    @Override
    public void add(int i, T t) {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
