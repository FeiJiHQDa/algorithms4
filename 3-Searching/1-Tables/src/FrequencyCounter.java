

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 文本 频率计数器
 *
 * 符号表， 基于顺序查看 顺序搜索
 * 2017、4/22 23:12
 *
 * 2 ../algs4-data/tinyTale.txt
 *
 * 0 ../algs4-data/tale.txt
 */

public class FrequencyCounter {
    private FrequencyCounter() {

    }

    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        In arr = new In(args[1]);

        ST<String, Integer> st = new ST<String, Integer>();

        Stopwatch timer = new Stopwatch();

        while (!arr.isEmpty()) {
            String key = arr.readString();
            if (key.length() < minlen) {
                continue;
            }
            words++;                // 单词总数
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;         // 去重复后的单词数
            }
        }

        double time = timer.elapsedTime();
        StdOut.print(time);

        String max = "";
        st.put(max, 0);     // 设置默认值

        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

//        for (String kes : st) {
//            StdOut.println(kes);
//        }
        StdOut.println("------------------");

//        for (String kess: st.keys()) {
//            StdOut.println(kess);
//        }


        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println(st.min());
    }
}
