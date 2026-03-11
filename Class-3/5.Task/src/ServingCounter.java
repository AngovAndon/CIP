public class ServingCounter {
    private String[] dishes;
    private int capacity;
    private int countUnserved = 0;

    public ServingCounter(int capacity) {
        this.capacity = capacity;
        dishes = new String[capacity];
        System.out.println("ServingCounter constructor is ready with max dish capacity of " + capacity);
    }

    public synchronized void addDish(String chef, String dish) {
        try {
            while (countUnserved >= capacity) {
                System.out.println("Chef " + chef + " waiting - no space ");
                wait();
            }
            dishes[countUnserved] = dish;
            countUnserved++;
            System.out.println("Chef " + chef + " put " + dish + " on the counter!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized String takeDish(String waiter) {
        String dish = null;
        try {
            while (countUnserved <= 0) {
                System.out.println("Waiter " + waiter + " waiting - for dish");
                wait();
            }
            dish = dishes[countUnserved - 1];
            countUnserved--;
            System.out.println("Waiter " + waiter + " took the dish " + dish);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dish;
    }

}
