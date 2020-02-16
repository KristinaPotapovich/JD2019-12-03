package by.it.plugatar.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<E> implements Set<E> {

    private int size = 0;
    private E[] elements = (E[]) new Object[0];

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String det = "";
        for (int i = 0; i < size; i++) {
            sb.append(det).append(this.elements[i]);
            det = ", ";
        }
        sb.append("]");
        return sb.toString();
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
        if (!this.isEmpty()) {
            if (o == null) {
                for (int i = 0; i < size; i++)
                    if (elements[i] == null) return true;
            } else
                for (int i = 0; i < size; i++)
                    if (o.equals(elements[i])) return true;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = e;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean res = false;
        if (!c.isEmpty()) {
            Object[] objects = c.toArray();
            for (Object object : objects) {
                if (!this.contains(object)) if (this.add((E) object)) res = true;
            }
        }
        return res;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    if (elements.length - i - 1 > 0)
                        System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
                    elements[size--] = null;
                    return true;
                }
            }
        } else
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    if (elements.length - i - 1 > 0)
                        System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
                    elements[size--] = null;
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (Object object : objects) {
            if (!this.contains(object)) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (Object object : objects) {
            this.remove(object);
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}