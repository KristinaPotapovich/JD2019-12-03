package by.it.shpakovskiy.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {
    private HashMap<T, Object> map = new HashMap<>();
    private static final Object valueMap = new Object();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return map.keySet().toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        return map.put(t, valueMap) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == valueMap;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean isAddAll = false;
        for (Object element : collection) {
            isAddAll = contains(element);
        }
        return isAddAll;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isAddAll = false;
        for (T element : collection) {
            isAddAll = add(element);
        }
        return isAddAll;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return map.keySet().retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isRemoveAll = false;
        for (Object o : collection) {
            remove(o);
            isRemoveAll = true;
        }
        return isRemoveAll;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator<T> iterator = this.iterator();
        int count=0;
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (count<size()){
                stringBuilder.append(", ");
            }
            count++;
        }
        return stringBuilder.append("]").toString();
    }
}
