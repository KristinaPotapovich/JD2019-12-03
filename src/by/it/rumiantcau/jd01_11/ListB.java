package by.it.rumiantcau.jd01_11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
Свой ListB. Напишите класс ListB<T>, который реализует toString() и 6 методов
 add(int index, T e),
интерфейса List<T> (реализация остальных – фиктивная).
* */
public class ListB<T> implements List<T> {
    // private T[] elements = (T[]) new Object[]{};

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public T set(int index, T element) {
        T change = elements[index];
        elements[index] = element;
        return change;
    }
    //return zamenennyj simvol
    @Override
    public void add(int index, T element) {
        size++;
        T zamena = null;
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        for (int i = size-1; i > index; i--){
            elements[i] = elements[i -1];
        }
        elements[index] = element;
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
    // Проводим проверку, если количество мест, выделенных под объекты больше фактического выделенного места под
    // массив, то мы расширяем его по формуле старая_длинна*1,5 +1
    public boolean add(T element) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {
        //Определяем переданную коллекцию для добавления как массив Обджектов
        Object[] mas = c.toArray();
        int masLenght = mas.length;
        elements = Arrays.copyOf(elements, mas.length + elements.length);

        System.arraycopy(mas, 0, elements, size, masLenght);
        //увеличиваем величину массива на кол-во добавленных элементов
        size += masLenght;
        //если кол-во добавленных элеметов 0 - то ничего не добавили и возвр фолс
        return masLenght != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] mas = c.toArray(); //
        int masLenght = mas.length;
        int insertIndex = index + masLenght - 2; // индекс первого элемента, куда будут перемещаться эл массива, на место
        // которых будет произведена вставка
        elements = Arrays.copyOf(elements, mas.length + elements.length);
        for (int i = index, j = 0; i < index + masLenght; i++, j++) {
            elements[insertIndex++] = elements[i];
            elements[i] = (T) mas[j];
        }
        size += masLenght;
     return masLenght != 0;
    }




    @Override
    public int size() {
        return size;
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

    /*---------------------------------*/



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
    public void forEach(Consumer<? super T> action) {

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
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

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

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }
}
