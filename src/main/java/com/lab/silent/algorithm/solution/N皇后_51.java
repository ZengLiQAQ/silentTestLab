package com.lab.silent.algorithm.solution;

import java.util.ArrayList;
import java.util.List;

public class N皇后_51 {
    /* 回溯算法：n 皇后 */
   public void backtrack(int row, int n, List<String> state, List<List<String>> res,
                   boolean[] cols, boolean[] diags1, boolean[] diags2) {
        // 当放置完所有行时，记录解
        if (row == n) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有列
        for (int col = 0; col < n; col++) {
            // 计算该格子对应的主对角线和次对角线
            int diag1 = row - col + n - 1;
            int diag2 = row + col;
            // 剪枝：不允许该格子所在列、主对角线、次对角线上存在皇后
            if (!cols[col] && !diags1[diag1] && !diags2[diag2]) {
                // 尝试：将皇后放置在该格子
                char[] rowArr = state.get(row).toCharArray();
                //将对应列位置的字符串替换为Q
                rowArr[col] = 'Q';
                //重置当前行的字符串
                state.set(row,new String(rowArr));
                cols[col] = diags1[diag1] = diags2[diag2] = true;
                // 放置下一行
                backtrack(row + 1, n, state, res, cols, diags1, diags2);
                // 回退：将该格子恢复为空位
                // 尝试：将皇后放置在该格子
                char[] rowBackArr = state.get(row).toCharArray();
                //将对应列位置的字符串替换为Q
                rowBackArr[col] = '.';
                //重置当前行的字符串
                state.set(row,new String(rowBackArr));
                cols[col] = diags1[diag1] = diags2[diag2] = false;
            }
        }
    }

    /* 求解 n 皇后 */
    public   List<List<String>> solveNQueens(int n) {
        // 初始化 n*n 大小的棋盘，其中 'Q' 代表皇后，'#' 代表空位
        List<String> state = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            state.add(row.toString());
        }
        boolean[] cols = new boolean[n]; // 记录列是否有皇后
        boolean[] diags1 = new boolean[2 * n - 1]; // 记录主对角线上是否有皇后
        boolean[] diags2 = new boolean[2 * n - 1]; // 记录次对角线上是否有皇后
        List<List<String>> res = new ArrayList<>();

        backtrack(0, n, state, res, cols, diags1, diags2);

        return res;
    }
}
