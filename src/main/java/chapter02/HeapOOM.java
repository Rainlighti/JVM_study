package chapter02;

import java.util.ArrayList;

/**
 *  VM Args: -Xms20m -Xmx20m -XX: +HeapDumpOnOutOfMemoryError : 出现异常时 Dump 出当前的内存堆转储快照便于事后分析
 *  -Xms20m -Xmx20m : 将堆的最小值-Xms参数与最大值-Xmx参数设置为一样可避免堆自动扩展
 *  -XX:HeapDumpPath=JVM_analysis: 表示堆转储快照文件的保存路径和文件名
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();

        while(true) {
            list.add(new OOMObject());
        }
    }
}
