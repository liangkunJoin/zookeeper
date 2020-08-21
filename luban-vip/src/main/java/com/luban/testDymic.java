package com.luban;

public class testDymic {


    public static void main(String[] args) {
        int[] w = { 3, 4, 1 };// 物品的重量
        int[] value = { 3000, 4000, 2000 }; // 物品的价格
        int m = 5; // 总容量
        int n = value.length; // 物品的个数
        // 使用一个二维数组用于存放搭配方案
        int[][] path = new int[n + 1][m + 1];
        // 使用二维数组表示 表格
        int[][] v = new int[n + 1][m + 1];
        // 对数组进行初始化
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        // 对表格进行处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < v[i - 1][j - w[i - 1]] + value[i - 1]) {
                        v[i][j] = v[i - 1][j - w[i - 1]] + value[i - 1];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        //从后往前进行遍历
        int i = path.length-1;
        int j = path[0].length-1;
        while(i>0&&j>0) {
            if (path[i][j]==1) {
                System.out.printf("第%d个物品放入背包\n",i);
                j-=w[i-1];
            }
            i--;
        }
    }
}
