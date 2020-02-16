package by.it.lozouski.jd01_11;

import java.util.*;

class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T addElement) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = addElement;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> addCollectionName) {
        for (T elements : addCollectionName) {
            this.add(elements);
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T removeElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removeElement;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T newElement) {
        T replaceElement = elements[index];
        elements[index] = newElement;
        return replaceElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj)>=0;
    }

    @Override
    public String toString() {
        StringBuilder printObj = new StringBuilder("[");
        String joiner = "";
        for (int i = 0; i < size; i++) {
            printObj.append(joiner).append(elements[i]);
            joiner = ", ";
        }
        printObj.append("]");
        return printObj.toString();
    }

    //////////////////---------Stabs---------//////////////////

    @Override
    public boolean isEmpty() {
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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
