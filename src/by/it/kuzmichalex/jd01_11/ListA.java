package by.it.kuzmichalex.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {

    private int listSize = 0;
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
    public boolean add(T newElement) {
        if (listSize >= listValue.length) {
            listValue = Arrays.copyOf(listValue, ((listValue.length * 3) / 2) + 1);
        }
        listValue[listSize++] = newElement;
        return true;
    }

    @Override
    public T remove(int index) {
        T retValue;
        if (index < 0) return null;
        if (index >= listSize) return null;
        retValue = listValue[index];
        System.arraycopy(listValue, index + 1, listValue, index, listValue.length - index - 1);
        listValue[--listSize] = null;
        return retValue;
    }

    @Override
    public T get(int index) {
        if (index < 0) return null;
        if (index >=listSize) return null;
        return listValue[index];
    }
    //-----Stub's

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
