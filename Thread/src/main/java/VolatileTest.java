/**
 * @Author kong
 * @Date 2022/5/27 10:49
 * @Version 1.0
 * @Desc
 */
public class VolatileTest {
    public int inc = 0;

    public synchronized void increase() {
        System.out.println(inc++);
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 1)
            // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
