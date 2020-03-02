package by.it.plugatar.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private E[] elements = (E[]) new Object[0];
    private int size;

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
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null) return i;

        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    public void trimToSize(){
        if (size < elements.length) elements = Arrays.copyOf(elements, size);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i >= 0) {
            remove(i);
            return true;
        } else
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        for (Object object : objects) {
            add((E) object);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E res = elements[index];
        elements[index] = element;
        return res;
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(this.elements, this.elements.length * 3 / 2 + 1);
        }
        size++;
        System.arraycopy(elements, index, elements, index + 1, elements.length - index - 1);
        elements[index] = element;
    }

    private void checkRange(int index){
        if (index>=size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index){
        return "Index: " + index + " Size: " + size;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        E rem = elements[index];
        if (elements.length-index-1>0)
            System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
        elements[size--] = null;
        return rem;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}