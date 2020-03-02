package by.it.borodachev.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    private int indexOf(Object o) {
        if (o==null) {
            for (int i = 0; i < size; i++) {
                if (elements[i]==null) return i;
            }
            return -1;
        }
        for (int i = 0; i < size; i++) {
             if (elements[i]!=null) {
                 if (o.equals(elements[i])) {
                     return i;
                 }
             }
        }
        return -1;
    }
    private T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return element;
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
        return (size==0);
    }

    @Override
    public boolean contains(Object o) {
        return (this.indexOf(o)>=0);
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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T element) {
        if (this.contains(element)) return false;
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, (elements.length * 3 / 2) + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i=indexOf(o);
        if (i>0) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!this.contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[]{};
        size=0;
    }
}
