package com.lab.silent.algorithm.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gouqi
 * @version 1.0
 * @description: LRU
 * @date 2023/9/26 10:01
 */

public class LRUCache {
    class DLinkedNode{
        int key;
        int val;

        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "DLinkedNode{" +
                    "key=" + key +
                    ", val=" + val +
                    ", prev.key=" + (prev == null ? null:prev.key) +
                    ", next.key=" + (next == null ? null:next.key) +
                    '}';
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        //伪头尾节点
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(null == node){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key,int val){
        DLinkedNode node = cache.get(key);
        if(null == node){
            //不存在,创建新节点
            DLinkedNode newNode = new DLinkedNode(key,val);
            //加入map缓存
            cache.put(key,newNode);
            //移动到头节点
            moveToHead(newNode);
        }else{
            node.val = val;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
