package by.it.busel.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[0];
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        String separator = "";
        text.append("[");
        for (int i = 0; i < size; i++) {
            text.append(separator).append(elements[i]);
            separator = ", ";
        }
        text.append("]");
        return text.toString();
    }

    @Override
    public boolean add(T element) {
        if (!contains(element)) {
            if (size >= elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = element;
            return true;
        } else {
            return false;
        }
    }

    /*
    template
     */
    private boolean coincidenceFinder(T element) {
        if (element != null) {
            //        boolean containsElement = false;
            for (int i = 0; i < size; i++) {
                if (elements[i] != null) {
                    if (elements[i].equals(element)) {
//                System.out.printf("The current \"%s\"\ncontains \"%s\"\n",
//                        this.getClass().getName(), element.getClass().getName());
//                System.out.println("Please, enter another element");
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    private T remove(int index) {
        if (index <= size - 1) {
            if (size != 1) {
                T elementToBeRemoved = elements[index];
                System.arraycopy(elements, index + 1, elements, index, size - index - 1);
                elements[size--] = null;
                return elementToBeRemoved;
            } else {
                T elementToBeRemoved = elements[--size];
                elements = (T[]) new Object[0];
                return elementToBeRemoved;
            }
        }
        return null;
    }


    public int indexOf(Object obj) {
        if (obj != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(obj)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] != null) {
                    if (elements[i].equals(element)) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (T next : c) {
            add(next);
        }
        return true;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsElement = true;
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
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
        elements = (T[]) new Object[0];
        size = 0;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
