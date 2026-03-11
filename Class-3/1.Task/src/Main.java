void main() {
    for (int i = 1; i <= 5; i++) {
        AThread aThread = new AThread();
        aThread.start();
        System.out.println("Main--Thread name: " + aThread.getName());
        aThread.setPriority(i+1);
        System.out.println("Main--Thread priority: " + aThread.getPriority());
        System.out.println("Main--Is thread alive: " +  aThread.isAlive());
    }

    System.out.println("Main--All threads are started!");
}
