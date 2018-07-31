package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;

        Entry(int key, int value, Entry prev, Entry next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return this.key + "=>" + this.value + "; prev: " + this.prev.key + "; next: "
                    + this.next.key + "\n";
        }
    }

    private Map<Integer, Entry> map = new HashMap<>();
    private int capacity = 32; // default capacity
    private int length;

    private Entry head;
    private Entry tail;

    public LRUCache() {
        this.length = 0;
        this.head = new Entry(-1, -1, null, null);
        this.tail = new Entry(-2, -1, null, null);
        this.head.next = this.tail;
    }

    public LRUCache(int capacity) {
        this();

        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        Entry entry = map.get(key);
        moveEntryToHead(entry);

        return entry.value;
    }

    public void set(int key, int value) {
        if (map.get(key) == null) {
            if (this.length >= this.capacity) {
                this.lru();
            }

            Entry entry = new Entry(key, value, this.head, this.head.next);
            this.head.next.prev = entry;
            this.head.next = entry;

            this.length++;
            map.put(key, entry);
        } else {
            Entry entry = map.get(key);

            entry.value = value;
            this.moveEntryToHead(entry);
        }
    }

    public String toString() {
        return map.toString();
    }

    private void moveEntryToHead(Entry entry) {

        // 删除链表中的entry节点
        entry.next.prev = entry.prev;
        entry.prev.next = entry.next;

        // 将entry节点移动到链表头部
        entry.prev = this.head;
        entry.next = this.head.next;
        this.head.next.prev = entry;
        this.head.next = entry;
    }

    private void lru() {
        Entry entry = this.tail.prev;
        this.tail.prev = entry.prev;
        entry.prev.next = this.tail;
        map.remove(this.tail.key);
        this.length--;
    }
}
