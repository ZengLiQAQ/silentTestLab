package com.lab.silent.algorithm.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 用数组表示二叉树,关键需要知道,各节点之间在数组中的idx的映射公式:
 * 若某节点的索引为 𝑖 ， 则该节点的左子节点索引为 2𝑖 + 1 ，右子节点索引为 2𝑖 + 2,其父节点的索引为: (i-1)/2
 */
public class 用数组表示完全二叉树 {
    private List<Integer> tree;

    /* 构造方法 */
    public 用数组表示完全二叉树(List<Integer> arr) {
        tree = new ArrayList<>(arr);
    }

    /* 列表容量 */
    public int size() {
        return tree.size();
    }

    /* 获取索引为 i 节点的值 */
    public Integer val(int i) {
        // 若索引越界，则返回 null ，代表空位
        if (i < 0 || i >= size()) return null;
        return tree.get(i);
    }

    /* 获取索引为 i 节点的左子节点的索引 */
    public Integer left(int i) {
        return 2 * i + 1;
    }

    /* 获取索引为 i 节点的右子节点的索引 */
    public Integer right(int i) {
        return 2 * i + 2;
    }

    /* 获取索引为 i 节点的父节点的索引 */
    public Integer parent(int i) {
        return (i - 1) / 2;
    }

    /* 层序遍历 */
    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>(); // 直接遍历数组
        for (int i = 0; i < size(); i++) {
            if (val(i) != null) res.add(val(i));
        }
        return res;
    }

    /* 深度优先遍历 */
    private void dfs(Integer i, String order, List<Integer> res) {
        // 若为空位，则返回
        if (val(i) == null) return;
        // 前序遍历
        if ("pre".equals(order)) {
            res.add(val(i));
        }
        dfs(left(i), order, res); // 中序遍历
        if ("in".equals(order)) {
            res.add(val(i));
        }
        dfs(right(i), order, res); // 后序遍历
        if ("post".equals(order)) {
            res.add(val(i));
        }
    }

    /* 前序遍历 */
    public List<Integer> preOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    /* 中序遍历 */
    public List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    /* 后序遍历 */
    public List<Integer> postOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }

}
