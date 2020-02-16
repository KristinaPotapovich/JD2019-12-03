package by.it.borodachev.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, (elements.length * 3 / 2) + 1);
        }
        elements[size++] = element;
        return false;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return element;
    }

    @Override
    public T get(int index) {
        return elements[index];
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
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
           add(t);
        }
        return true;
    }
    @Override
    public T set(int index, T element) {
        T retValue;
        if ((index <0) ||(index >=size))
            return null;
        retValue =elements[index];
        elements[index] = element;
        return retValue;
    }

    @Override
    public void add(int index, T element) {
        if ((index <0) ||(index >size))
            return ;
        if (index == size) {
            add(element);
        }
        else {
            if (size >= elements.length) {
                elements = Arrays.copyOf(elements, (elements.length * 3 / 2) + 1);
            }
           System.arraycopy(elements, index , elements, index+1, size - index - 1);
           size++;
           elements[index] = element;
        }

    }
    @Override
    public boolean contains(Object o) {
        return (indexOf(o)>=0);
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
    public int indexOf(Object o) {
        if (o==null) {
            for (int i = 0; i < size; i++) {
                if (elements[i]!=null) return 0;
            }
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
            return -1;
    }
    ///----------- stubs -------------------------------


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


