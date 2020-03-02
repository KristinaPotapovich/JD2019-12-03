package by.it.samuseva.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private int size = 0;
    private T[] elements = (T[]) new Object[]{};
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
    public boolean contains(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] != null){
                    if (o.equals(elements[i])) return true;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
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
        if (size==0) return true;
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
       for (T coll : collection) {
            add(coll);
       }
       return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        int count = 0;
        for (Object o : collection) {
            if (contains(o)) count++;
        }
        if (count==collection.size()) return true;

        return false;
    }
    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object o : collection) {
            if (contains(o)) remove(o);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter= ", ";
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    //-----------------------------------------------------------------------------------------------------

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
}
