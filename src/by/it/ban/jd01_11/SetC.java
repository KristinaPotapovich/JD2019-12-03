package by.it.ban.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

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
    public boolean add(T element) {
        if (!this.contains(element)) {
            if (size >= elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (size > 0) {
            if (o != null) {
                for (int i = 0; i < size; i++) {
                    if (elements[i] != null) {
                        if (elements[i].equals(o)) {
                            System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                            elements[--size] = null;
                        }
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null) {
                        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                        elements[--size] = null;
                    }
                }
            }

        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] != null) {
                    if (elements[i].equals(o)) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {

        for (Object o : collection) {
            if(!contains(o)) return false;
        }
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object o : collection) {
            remove(o);
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size=0;
    }
}
