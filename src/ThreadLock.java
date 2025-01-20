public class ThreadLock {
    public void printWithDelay(String name, Object lockOn) throws InterruptedException {
        synchronized (lockOn) {
            System.out.println(name + " started and waiting for 3 seconds.");
            Thread.sleep(3000);
            System.out.println(name + " ends");
        }
    }
    public void printWithDelay2(String name, Object lockOn) throws InterruptedException {
        synchronized (lockOn) {
            System.out.println(name + " started and waiting for 3 seconds.");
            Thread.sleep(3000);
            System.out.println(name + " ends");
        }
    }
    public static void main(String[] args) {
        ThreadLock tl = new ThreadLock();

        Thread t1 = new Thread(() -> {
            try {
                tl.printWithDelay("Thread 1", tl);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                tl.printWithDelay2("Thread 2", tl);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
