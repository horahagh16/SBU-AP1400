import java.util.HashSet;
import java.util.Set;

class Entry<K, V> {
    // TODO
    K k;
    V v;
    Entry<K, V> next;
    boolean isLastOne = true;

    Entry() {
    }

    public void setKey(K key) {
        this.k = key;
        isLastOne = false;
    }

    @Override
    public String toString() {
        return v.toString() + ":" + k.toString();
    }
}

public class GenericLinkedHashMap<K, V> {

    Entry<K, V> start = new Entry<>();
    Entry<K, V> here = start;

    public V put(K key, V value) {
        // TODO
        if (key == null) {
            throw new NullPointerException();
        }
        Entry<K, V> node = start;
        V former = null;
        boolean exist = false;
        while (!node.isLastOne) {
            if (key.equals(node.k)) {
                former = node.v;
                node.v = value;
                exist = true;
            }
            node = node.next;
        }
        if (!exist) {
            here.setKey(key);
            here.v = value;
            here.next = new Entry<>();
            here = here.next;
        }
        return former;
    }

    public boolean containsKey(Object key) {
        // TODO
        if (key == null) {
            throw new NullPointerException();
        }
        boolean contain = false;
        Entry<K, V> node = start;
        while (!node.isLastOne) {
            if (key.equals(node.k)) {
                contain = true;
                break;
            }
            node = node.next;
        }
        return contain;
    }

    public V get(Object key) {
        // TODO
        if (key == null) {
            throw new NullPointerException();
        }
        Entry<K, V> node = start;
        while (!node.isLastOne) {
            if (key.equals(node.k))
                return node.v;
            node = node.next;
        }
        return null;
    }

    public V remove(Object key) {
        // TODO
        if (key == null) {
            throw new NullPointerException();
        }
        Entry<K, V> node = start;
        Entry<K, V> former = null;
        boolean check = false;
        while (!node.isLastOne) {
            if (key.equals(node.k))
                check = true;
            node = node.next;
        }
        node = start;
        if (!check)
            return null;
        else {
            V carefree = null;
            while (!node.isLastOne) {
                if (key.equals(node.k)) {
                    carefree = node.v;
                    if (former == null)
                        start = start.next;
                    else
                        former.next = node.next;
                }
                former = node;
                node = node.next;
            }
            return carefree;
        }
    }

    public int size() {
        // TODO
        Entry<K, V> node = start;
        int size = 0;
        while (!node.isLastOne) {
            size++;
            node = node.next;
        }
        return size;
    }

    public boolean isEmpty() {
        // TODO
        return start.isLastOne;
    }

    public void clear() {
        // TODO
        start = new Entry<>();
    }

    public Set<K> keySet() {
        // TODO
        Set<K> set = new HashSet<>();
        Entry<K, V> node = start;
        while (!node.isLastOne) {
            set.add(node.k);
            node = node.next;
        }
        return set;
    }

    public Set<Entry<K, V>> entrySet() {
        // TODO
        Set<Entry<K, V>> set = new HashSet<>();
        Entry<K, V> node = start;
        while (!node.isLastOne) {
            set.add(node);
            node = node.next;
        }
        return set;
    }

    public static void main(String[] args) {
        GenericLinkedHashMap<Integer, String> map = new GenericLinkedHashMap<>();
        System.out.println(map.size()); // 0
        map.put(98245832, "Hassan");
        System.out.println(map.put(123456, "sara"));//null
        System.out.println(map.put(98245832, "hora"));//Hassan
        try {
            map.put(null, "hi");
            System.out.println("failed");
        } catch (Exception e) {
            System.out.println("exception handled");
        }//exception handled
        System.out.println(map.size()); // 2
        System.out.println(map.remove(98245542)); // null
        System.out.println(map.get(98245832));//hora
        System.out.println(map.get(982458));// null
        System.out.println(map.containsKey(98245542)); // false
        System.out.println(map.containsKey(98245832)); // true
        System.out.println(map.isEmpty()); // false
        System.out.println(map.entrySet());//[sara:123456, hora:98245832]
        System.out.println(map.keySet());//[123456, 98245832]
        map.remove(98245832);
        System.out.println(map.containsKey(98245832)); // false
        System.out.println(map.containsKey(123456));//true
        System.out.println(map.isEmpty()); // false
        System.out.println(map.entrySet());//[sara:123456]
        System.out.println(map.keySet());//[123456]
        map.put(98245542, "Ali");
        map.clear();
        System.out.println(map.isEmpty()); // true
    }
}