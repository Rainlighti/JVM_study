package chapter03;

/**
 *  testGC() 方法执行以后， objA 和  objB是否会被回收
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     *  这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有被回收过
     */
    private byte[] bigSize = new byte[2 *  _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC， ojbAhe objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
