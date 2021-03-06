package com.zhang.chapter2.section25;

import com.zhang.chapter2.section24.MaxPQ;
import com.zhang.chapter2.section24.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * 排序算法应用
 * 1.稳定的排序算法：插入排序和归并排序
 * 2.快速排序是最快的通用排序算法
 * 3.Java选择对原始数据类型使用三向切分的快速排序，对引用类型使用归并排序
 */
public class AnswerList {
    /**
     * 2.5.1
     * Solution:
     *          少了循环里面对字符串长度的判断
     */
    /**
     * 2.5.2
     * 组合词
     */
    public void compoundWord() {
        CompoundWord compoundWord = new CompoundWord(100);
        String s;
        while (true) {
            s = StdIn.readString();
            if (s.equals("exit;")) break;
            compoundWord.add(s);
        }
        compoundWord.printCompound();
    }

    public class CompoundWord {
        int N;
        String[] strings;
        public CompoundWord(int maxN) {
            N = 0;
            strings = new String[maxN];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void add(String s) {
            strings[N++] = s;
        }

        public void printCompound() {
            Arrays.sort(strings,0,N - 1);
            for (int i = 1; i < N; i++) {
                String compound = strings[i];
                String subs = "";
                for (int j = i - 1; j >= 0; j--) {
                    int index = compound.indexOf(strings[j]);
                    if (index == 0 ) {
                        subs = compound.substring(strings[j].length());
                        if (findStr(subs, i + 1, N - 1) || findStr(subs, 0, j - 1)){
                            StdOut.println(compound);
                            break;
                        }
                    } else if (index > 0 ) {
                        subs = compound.substring(0, index - 1);
                        if (findStr(subs, 0, j - 1)){
                            StdOut.println(compound);
                            break;
                        }
                    }
                }
            }
        }

        public boolean findStr(String key, int lo, int hi) {
            while (lo <= hi) {
                if (key.equals(strings[lo])) return true;
                lo++;
            }
            return false;
        }
    }

    /**
     * 2.5.3
     * 比较器
     * Solution:
     *          0.005 = 0.008  0.008 = 0.011   0.005 != 0.011
     *  if (this.amount > that.amount) return 1;
     *  if (this.amount < that.amount) return -1;
     *  retrn 0;
     *  (参考github大神)
     */
    /**
     * 2.5.4
     * 字符串数组去重
     */
    public void test04() {
        String[] a = {"a", "a", "b", "c", "c"};
        a = dedup(a);
        for (int i = 0; i < a.length && a[i] != null; i++) {
            StdOut.print(a[i]);
        }
    }

    public String[] dedup(String[] a) {
        Arrays.sort(a);
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[j]) != 0) {
                exch(a, ++j, i);
            }
        }
        ++j;
        for (; j < a.length; j++) {
            a[j] = null;
        }
        return a;
    }

    public void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 2.5.5
     * 选择排序怎么不稳定
     * Solution：
     *          在依次将两个相等元素移到后边的时候，可能原来在前边的元素，被移到后边了
     *          比如：8a 8b 4 3  移动之后为  3  4  8b  8a
     *               注：8a/8b都为整数8
     */
    /**
     * 2.5.6
     * 递归实现查找k大数
     */
    public void test06() {
        Integer[] a = {2, 3, 5, 9, 4, 1};
        int k = 1;
        //非递归
        StdOut.println(FindKth.select(a, k - 1));
        //递归
        //StdOut.println(FindKth.select(a, k - 1, 0, a.length - 1));
    }
    /**
     * 2.5.7
     * select()找最小值需多少次比较
     * Solution：
     *          (N^2 / 2 + N) / 2
     */
    /**
     * 2.5.8
     * Frequency
     */

    public void frequency() {
        Node[] nodes = new Node[100];
        int n = 0;
        while (true) {
            String s = StdIn.readString();
            if (s.equals("exit;")) break;
            int k = findStr(nodes, s, n);
            if (k < n && nodes[k].word.equals(s)) {
                nodes[k].count++;
            } else {
                for (int i = n++; i >= k; i--) {
                    nodes[i + 1] = nodes[i];
                }
                nodes[k] = new Node(s, 0);
            }
        }
        Arrays.sort(nodes, 0, n, new StringSort());
        for (int i = 0; i < n; i++) {
            StdOut.print(nodes[i].word + ":" + (nodes[i].count + 1) + ",");
        }
    }

    public class StringSort implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            if (node2.count == node1.count) return 0;
            return node1.count < node2.count ? 1 : -1;
        }
    }

    public int findStr(Node[] a, String s, int n) {
        int k = 0;
        int lo = 0, hi = n - 1;
        int mid = lo;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid].word.compareTo(s) < 0) lo = mid + 1;
            else if (a[mid].word.compareTo(s) < 0) hi = mid - 1;
            else break;
        }
        return mid;
    }

    class Node {
        String word;
        int count;
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    /**
     * 2.5.9
     * 设计数据类型
     *
     */
    class Trade{
        Date date;
        int amount;
    }

    /**
     * 2.5.10
     * 定义版本号的数据结构
     *
     */
    class Version implements Comparable<Version>{
        String version;
        public Version(String version) {
            this.version = version;
        }


        @Override
        public int compareTo(Version o) {
            String[] s = this.version.split(".");
            String[] s1 = o.version.split(".");
            if (Integer.parseInt(s[0]) != Integer.parseInt(s1[0])) return Integer.parseInt(s[0]) - Integer.parseInt(s1[0]);
            if (Integer.parseInt(s[1]) != Integer.parseInt(s1[1])) return Integer.parseInt(s[1]) - Integer.parseInt(s1[1]);
            if (Integer.parseInt(s[2]) != Integer.parseInt(s1[2])) return Integer.parseInt(s[2]) - Integer.parseInt(s1[2]);
            return 0;
        }
    }
    /**
     * 2.5.11
     * 描述排序算法对有7个相同元素的数组排序后数字位置变化结果
     * Solution：
     *      插入排序：p[0] p[1] p[2] p[3] p[4] p[5] p[6]
     *      选择排序：p[0] p[1] p[2] p[3] p[4] p[5] p[6]
     *      希尔排序：p[0] p[1] p[2] p[3] p[4] p[5] p[6]
     *      归并排序：p[0] p[1] p[2] p[3] p[4] p[5] p[6]
     *      快速排序：p[5] p[4] p[6] p[0] p[1] p[3] p[2]
     *      堆排序：p[1] p[2] p[3] p[4] p[5] p[6] p[0]
     *
     */
    /**
     * 2.5.12
     * 调度
     * Solution:
     *      任务按最时间排序
     */

    public void spt() {
        MinPQ<Task> pq = new MinPQ<>(100);
        StdOut.print("请输入要输入的任务数：");
        int n = StdIn.readInt();
        while (n-- > 0) {
            String name = StdIn.readString();
            int time = StdIn.readInt();
            pq.insert(new Task(name, time));
        }

        while (!pq.isEmpty()) {
            Task task = pq.delMin();
            StdOut.println(task.name);
        }
    }

    //任务类
    class Task implements Comparable<Task>{

        String name;
        int time;
        public Task(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Task o) {
            return this.time - o.time;
        }
    }

    /**
     * 2.5.13
     * 负载均衡
     * Solution：
     *      任务按倒序排列，最小优先队列（任务时间和），依次添加元素到优先级最低的队列元素
     */
    public void lpt() {
        StdOut.print("请输入处理器个数：");
        int m = StdIn.readInt();
        MaxPQ<Task> maxPQ = new MaxPQ<>(100);//任务
        MinPQ<Task> pq = new MinPQ<>(m);//处理器
        StdOut.print("请输入要输入的任务数：");
        int n = StdIn.readInt();
        while (n-- > 0) {
            String name = StdIn.readString();
            int time = StdIn.readInt();
            maxPQ.insert(new Task(name, time));
        }

        while (m-- > 0 && !maxPQ.isEmpty()) {
            pq.insert(maxPQ.delMax());
        }

        while (!maxPQ.isEmpty()) {
            Task task = pq.delMin();
            Task max = maxPQ.delMax();
            task.name += max.name;
            task.time += task.time;
            pq.insert(task);
        }

        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin().name);
        }
    }

    /**
     * 2.5.14
     * 逆域名排序
     *
     */
    public class Domain implements Comparable<Domain>{
        String domain;
        String reverseDomain;

        public Domain(String domain) throws Exception {
            this.domain = domain;
            String[] domainArray = domain.split("\\.");
            if (domainArray.length != 3) throw new Exception("域名有误");
            this.reverseDomain = domainArray[2] + "." + domainArray[1] + "." + domainArray[0];
        }
        @Override
        public int compareTo(Domain o) {
            return this.reverseDomain.compareTo(o.reverseDomain);
        }
    }
    /**
     * 2.5.15
     * 垃圾邮件大战
     * Solution:
     *          将邮件地址排序，将邮件地址@符号前后的字符串作为1，2排序条件，然后总是用出现的第一个域名一样的向其他的发送邮件
     */
    /**
     * 2.5.16
     * 公正的选举
     */
    public class California implements Comparable<California> {
        String alphabets = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
        int[] alphabetOrder = new int[150];
        {
            for (int i = 0; i < alphabets.length(); i++) {
                alphabetOrder[alphabets.charAt(i)] = i;
            }
        }

        String name;

        @Override
        public int compareTo(California o) {
            if (o.name.isEmpty() && this.name.isEmpty()) return 0;
            int i = 0;
            while (true) {
                if (this.name.length() <= i) break;
                if (o.name.length() <= i) break;
                if (alphabetOrder[this.name.charAt(i)] != alphabetOrder[o.name.charAt(i)]) {
                    return alphabetOrder[this.name.charAt(i)] < alphabetOrder[o.name.charAt(i)] ? -1 : 1;
                }
                i++;
            }
            if (this.name.length() == o.name.length()) {
                return 0;
            } else {
                return this.name.length() < o.name.length() ? -1 : 1;
            }
        }
    }
    /**
     * 2.5.17
     * 检测稳定性
     * Solution:
     *          写一个包装类，类里面有应该排序数组对应的值和本来的下标，从而排序
     *          最后检测排序后相同的的相对位置有没有变化
     */
    /**
     * 2.5.18
     * 强制稳定
     * Solution:
     *          依照上边的思路，相对位置有变化，则交换
     */
    /**
     * 2.5.19
     * Kendall tau距离
     *Solution:
     *          看了答案。
     *          找出数组b相对于a的相对位置，从而找相对数组的逆序数
     *          ainv存的是a数组元素下标，bnew取ainv[b[i]], 表示b中元素在a中的下标
     *          从而求bnew的逆序数
     */
    /**
     * 2.5.20
     * 空闲时间
     */
    public class ComputerTask implements Comparable<ComputerTask>{
        Date start;
        Date end;


        @Override
        public int compareTo(ComputerTask o) {
            return this.start.compareTo(o.start);
        }
    }

    public void freeTime(ComputerTask[] ct) {
        Arrays.sort(ct);
        ComputerTask startTask, endTask;
        long freeTime = 0, workTime = 0;
        if (ct.length == 0) return;
        startTask = ct[0];
        endTask = ct[0];
        for (int i = 1; i <= ct.length; i++) {
            if (ct[i].end.compareTo(startTask.end) <= 0) continue;
            if (ct[i].start.compareTo(startTask.end) <=0 && ct[i].end.compareTo(startTask.end) > 0) {
                endTask = ct[i];
            }
            if (i == ct.length || ct[i].start.compareTo(startTask.end) > 0) {
                long freeTemp = ct[i].start.getTime() - endTask.end.getTime();
                long workTemp = endTask.end.getTime() - startTask.start.getTime();
                if (freeTemp > freeTime) freeTime = freeTemp;
                if (workTemp > workTime) workTime = workTemp;
                startTask = ct[i];
                endTask = ct[i];
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.compoundWord();
        //al.test04();
        //al.test06();
        //al.frequency();
        //al.spt();
        //al.lpt();
        StdOut.println((int)'z');
    }
}
