package com.company;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Main {

    /**
     * 钢条分段售卖问题
     *  n = 8
     *  0 1 2 3 4 5  6  7  8
     *  0 1 5 8 9 10 17 17 20
     * @param args
     */
    static int [] m = {0,1,3,8,9,10,17,25,18};//价格表
    int p;

    /**
     *  直接递归的方法 时间复杂度非常高 非常多的子问题被重新遍历
     *  推荐采用带备忘的自顶向下的递归（动态规划之一）
     * @param len
     * @return
     */
    public int cut_rod(int len){
        if (len == 0){
            return 0;
        }
        p = 0;
        for (int i = 1 ; i <= len ;i++){
            p = Math.max(p,m[i]+cut_rod(len-i));
        }
        return p;
    }

    /**
     * 采用备忘的递归方法 又称自顶向下的动态规划方法
     */
    int z = 0;
    static int [] k = new int[m.length];//切割方案记录
    static int [] r = new int[m.length];//记录子问题的解
    public int memoized_cut_rod(int len){
        if (r[len]>-10){
            return r[len];
        }
        if (len == 0 ){
            return 0;
        }
        int q = 0;
        for (int i = 1 ; i <= len ; i++){
            q = Math.max(q,m[i]+memoized_cut_rod(len-i));
            
        }
        r[len] = q;
        return q;
    }
    static int [] r1 = new int [m.length];
//    static int [] c = new int [m.length];
    static int i ,j;
    static int CUT = 2;//切割成本
    public static int botton_up_cut_rod(int len){
        for (i = 1 ; i <= len ;i++){
            int p = 0;
            for (j = 1 ; j <= i ; j++){
                if (j == i){
                    p = Math.max(p,m[j] + r1[i - j]);
                }else{
                    p = Math.max(p,m[j] + r1[i - j]- CUT);
                }
            }
            r1[i] = p;
        }
        return r1[i-1];
    }
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0 ; i < main.m.length ; i++){
            r[i] = -10;
            k[i] = -10;
        }
        r1[0] = 0;
//        c[0] = 0;
        System.out.println(main.botton_up_cut_rod(8));
    }
}
