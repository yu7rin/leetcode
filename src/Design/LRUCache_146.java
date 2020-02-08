package Design;

import java.util.HashMap;

/**
 * Created by yu7rin on 10/31/2018.
 */
//本题目利用HashMap和DoubleLinkedList使得put与get操作均达到了O（1）的标准，在LRU中需要两个node指针来拼接list同时注意put有key重复的时候，所以要进行判断才可以
//同时要注意容量问题 当熔料已经满了的时候删除最久的也就是head指针位置的node,同时在设计get和put时要注意node的位置有可能是head或者是tail（用pre == null 和 node == tail）判断，
    //如果node的位置是head注意head的移动。要考虑当capacity为1或者整个list里面只有一个node时head也许是空指针所以在进行head给head.pre值时注意null的判断
class LRUCache_146 {
    HashMap<Integer , Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        //node的判断
        if(node == tail) return node.val;
        if(node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = head.next;
        }
        //

        node.next.pre = node.pre;
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            map.put(key , node);
            if(node == tail) return;
            if(node.pre != null) {
                node.pre.next = node.next;
            } else {
                head = head.next;
            }
            node.next.pre = node.pre;
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        } else {
            Node node = new Node(key , value);
            map.put(key , node);
            if(head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                if(capacity == 0) {
                    map.remove(head.key);
                    head = head.next;
                    //head的判断
                    if(head != null) head.pre = null;
                    capacity++;
                }
                map.put(key , node);
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;

            }
            capacity--;
        }
    }
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key ,int val) {
            this.key = key;
            this.val = val;
        }
}




}