package by.it.busel.jd01_12;

class C1Entry<K, V> {
    private K key;
    private V value;

    C1Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    C1Entry() {
    }

    K getKey() {
        return key;
    }

    void setKey(K key) {
        this.key = key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }

    void set(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
