public class AThread extends Thread {
    private int count = 10;
    private static int threadCount = 0;
    private int threadNumber = ++threadCount;

    public AThread() {
        System.out.println("Created thread with number " + threadNumber);
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread ( " + threadNumber + " ) and count ( " + count + " ) is running");
            count--;
            if (count == 0) {return;}
        }
    }
}
