package ap.structures;


public class HashTable {

    public class ListNode {
        String key;
        int value;
        ListNode next;
    }

    ListNode[] table;

    public HashTable() {
        table = new ListNode[64];
    }

    public int hashedIndex(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    public void put(String key, int value) {
        if (key == null) {
            return;
        }

        int index = hashedIndex(key);
        ListNode list = table[index];
        ListNode prev = null;

        if (list == null) {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            list = newNode;
            table[index] = list;
            return;
        }

        while (list != null) {
            if (list.key.equals(key)) {
                list.value = value;
                return;
            }
            prev = list;
            list = list.next;
        }

        ListNode newNode = new ListNode();
        newNode.key = key;
        newNode.value = value;
        prev.next = newNode;
    }

    public int get(String key) {
        int index = hashedIndex(key);
        ListNode list = table[index];
        while (list != null) {
            if (list.key.equals(key)) {
                return list.value;
            }
            list = list.next;
        }
        return -1;
    }

    public void remove(String key) {
        int index = hashedIndex(key);
        ListNode list = table[index];
        ListNode head = list;
        ListNode prev = null;
        while (list != null) {
            if (list.key.equals(key)) {
                if (list == head) {
                    list = list.next;
                    table[index] = list;
                    return;
                } else {
                    prev.next = list.next;
                }
            }
            prev = list;
            list = list.next;
        }
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            //System.out.println(i);
            ListNode list = table[i];
            while (list != null) {
                System.out.println(list.key);
                list = list.next;
            }
        }
    }



}
