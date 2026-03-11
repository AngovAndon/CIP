public class Waiter implements Runnable {
    private String name;
    private ServingCounter servingCounter;

    public Waiter(String name, ServingCounter servingCounter) {
        this.name = name;
        this.servingCounter = servingCounter;
    }

}
