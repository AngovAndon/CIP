void main() {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    for(int i = 1; i <= 10; i++) {
        executor.execute(new Worker("Message " + i));
    }
    executor.shutdown();
    while(!executor.isTerminated()) {}
    System.out.println("All threads terminated");
}
