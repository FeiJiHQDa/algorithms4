import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import javax.print.DocFlavor;

/**
 * 高位优先 从 左往 右
 */

public class MSD {

    private static final int CUTOFF = 15;   // 数据分类的辅助数组
    private static int R = 256;             // 基数

    private static void sort(String[] a) {
        int      n   = a.length;
        String[] aux = new String[n];
        sort(a, 0, n - 1, 0, aux);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

        // 以第 d 个字符为键 将 a[lo] 至 a[hi] 排序
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int[] count = new int[R+2];     // 计算频率
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;   // 获取 index 偏移 2 位。
        }


        for (int r = 0; r < R+1; r++) {     // 将频率 转换为索引
            count[r+1] += count[r];
        }

//        for ()
    }

    // 插入 排序
    private static void insertion(String[] a, int lo, int hi, int d) {

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--) {
                exch(a, j, j-1);
            }
        }
    }

    // 交换 数值
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 比较 两个 字符串的大小
    private static boolean less(String v, String w, int d) {

        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return false;
            if (v.charAt(i) > w.charAt(i)) return true;
        }

        return v.length() < w.length();
    }

    /**
     *  返回 字符， 如果 范围大于 长度 ，return -1
     * @param s
     * @param d
     * @return
     */
    private static int charAt(String s, int d) {
        assert d <= s.length() && d >= 0;
        if (d == s.length())
            return  -1;
        return s.charAt(d);
    }

    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
//        int      n = a.length;
//
//        sort(a);
//
//        for (int i = 0; i < n; i++) {
//            StdOut.println(a[i]);
//        }

//        StdOut.print(charAt("abcd", 0));
    }
}
