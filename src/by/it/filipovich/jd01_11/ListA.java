package by.it.filipovich.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {
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
    public boolean add(T o) {
        if(size>=elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = o;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if(size>=elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index > -1)
            remove(index);
        return index > -1;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        size--;
        return element;
    }

    @Override
    public T get(int index) {
        return elements[index];
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
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object set(int index, Object element) {
        return null;
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
