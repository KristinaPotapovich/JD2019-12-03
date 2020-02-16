package by.it.busel.jd01_11;

import java.util.*;

/*
TaskB
 */
public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index <= size - 1) {
            T elementToBeRemoved = elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[size--] = null;
            return elementToBeRemoved;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index <= size - 1) {
            return elements[index];
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        if (index <= size - 1) {
            T elementToBeReplaced = elements[index];
            elements[index] = element;
            return elementToBeReplaced;
        }
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index <= size - 1) {
            System.arraycopy(elements, index, elements, index + 1, size++ - index);
            elements[index] = element;
            return;
        } else if (index == size) {
            if (index >= elements.length) {
                elements = Arrays.copyOf(elements, elements.length / 2 * 3 + 1);
            }
            elements[size++] = element;
            return;
        }
        System.out.printf("The addition of element \"%s\" to position \"%d\" is impossible", element, index);
        System.out.println("Please, re-enter new index of element, which is to be added");
        System.out.printf("The current size of this container is %d", size);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        Iterator<? extends T> iterator = c.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            add(next);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder textVisualRepresentationOfElements = new StringBuilder();
        String separator = "";
        textVisualRepresentationOfElements.append("[");
        for (int i = 0; i < size; i++) {
            textVisualRepresentationOfElements.append(separator).append(elements[i]);
            separator = ", ";
        }
        textVisualRepresentationOfElements.append("]");
        return textVisualRepresentationOfElements.toString();
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
