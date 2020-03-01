package by.it.filipovich.jd01_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

    public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            String separator = "";
            for (int i = 0; i < size; i++) {
                sb.append(separator).append(elements[i]);
                separator = ", ";
            }
            sb.append("]");
            return sb.toString();
        }

        @Override
    public boolean add(T t) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if(o.equals(element))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public int size() {
            int count = 0;
            if(size == 0) {
                return 0;
            }
        for (T element : elements) {
            if (element != null) {
                count++;
            }
        }
            return count;
    }

    @Override
    public boolean isEmpty() {
        for (T element : elements) {
            if(element == null)
                return true;
        }
        return false;
    }

    // The rest of methods are default

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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
