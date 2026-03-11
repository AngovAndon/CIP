public class TickTack implements Runnable {
    private String name;
    private int rate;
    public TickTack(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Inside the thread -- Tick " + name);
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Inside the thread -- Tack " + name);
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
