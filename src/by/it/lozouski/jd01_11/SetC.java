package by.it.lozouski.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {
    private HashMap<T, Object> map = new HashMap<>();
    private static final Object OBJ = new Object();

    @Override
    public boolean add(T elem) {
        return map.put(elem, OBJ) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==OBJ;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T addElement : c) {
            add(addElement);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!map.containsKey(elem))return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object elem : c) {
            if (map.containsKey(elem)){
                remove(elem);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public String toString() {
        Object[] values = map.keySet().toArray(new Object[0]);
        StringBuilder printObj = new StringBuilder("[");
        String joiner = "";
        for (int i = 0; i < values.length; i++) {
            printObj.append(joiner).append(values[i]);
            joiner = ", ";
        }
        printObj.append("]");
        return printObj.toString();
    }
    ////////////////////////------------STABS----------/////////////////////

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
