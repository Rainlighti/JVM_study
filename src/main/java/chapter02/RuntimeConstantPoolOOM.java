package chapter02;


import java.util.HashSet;

/**
 * VM Args:-Xmx6m  JDK7以后字符串常量池被移至Java堆中，所以用此参数限制最大堆
 */
public class RuntimeConstantPoolOOM {
    public void demo1() {
        // 使用Set保持着常量池的引用，避免Full GC回收常量池行为
        HashSet<String> set = new HashSet<>();
        short  i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
    public void demo2() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
    public static void main(String[] args) {
        RuntimeConstantPoolOOM r = new RuntimeConstantPoolOOM();
//        r.demo1();
        r.demo2();
    }
}
