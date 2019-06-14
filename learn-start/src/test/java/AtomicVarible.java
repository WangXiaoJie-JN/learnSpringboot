import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicVarible {

        private static final int THREADS_CONUT = 10;
        //1.
        //public static AtomicInteger count = new AtomicInteger(0);
        // 3. 提高性能
        public static LongAdder count = new LongAdder();

       // 2.使用volatile不能是线程安全，因为不能保证原子性
       // public static volatile int count = 0;

        public static void increase() {
            // 1. add 1 to count /atomicInteger
            //count.incrementAndGet();
            // add a num and get
            // count.addAndGet(3);

            // 2. 使用volatitle关键字时
            //count ++;

            // 3. longadder
            //count.add(2);
            count.increment();
        }

        public static void main(String[] args) {
            Thread[] threads = new Thread[THREADS_CONUT];
            for (int i = 0; i < THREADS_CONUT; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000; i++) {
                            increase();
                        }
                    }
                });
                threads[i].start();
            }

            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
            System.out.println(count);
        }
}
