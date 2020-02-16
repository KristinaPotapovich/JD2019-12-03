package by.it.kuzmichalex.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private int listSize = 0;
    private int containIndex;
    private T[] listValue = (T[]) new Object[]{};

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("[");
        for (int i = 0; i < listSize; i++) {
            returnString.append(listValue[i]);
            if (i < (listSize) - 1) returnString.append(", ");
        }
        returnString.append("]");
        return returnString.toString();
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < listSize; i++) {
                if (listValue[i] == null) {
                    containIndex = i;
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < listSize; i++) {
            if (listValue[i] != null) {
                if (listValue[i].equals((T) o)) {
                    containIndex = i;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return toArray(listValue);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(T newElement) {
        if (this.contains(newElement)) return false;
        if (listSize >= listValue.length) {
            listValue = Arrays.copyOf(listValue, ((listValue.length * 3) / 2) + 1);
        }
        listValue[listSize++] = newElement;
        return true;
    }

    //@Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            this.add((T) arr[i]);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (!this.contains(arr[i])) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean bDeleted = false;
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (this.remove(arr[i])) bDeleted = true;
        }
        return bDeleted;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) return false;
        System.arraycopy(listValue, containIndex + 1, listValue, containIndex, listValue.length - containIndex - 1);
        listValue[--listSize] = null;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < listSize; i++) {
            listValue[i] = null;
        }
        listSize = 0;
    }

    /////////////////////////////////////////////////////////
    //// STUBS
    /////////////////////////////////////////////////////////

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
