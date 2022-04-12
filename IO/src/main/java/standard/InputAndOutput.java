package standard;

import java.util.Scanner;

/**
 * 演示标准输入输出流
 * System.in    标准输入    InputStream类型   键盘
 * System.out   标准输出    PrintStream类型   显示器
 */
public class InputAndOutput {
    public static void main(String[] args) {

        //System类的public static final InputStream in = null;
        //System.in 编译类型    InputStream
        //System.in 运行类型    BufferedInputStream
        Scanner sc=new Scanner(System.in);
        System.out.println(System.in.getClass());
        //public static final PrintStream out = null;
        //System.on 编译类型    PrintStream
        //System.on 运行类型    PrintStream
        System.out.println(System.out.getClass());
    }
}
