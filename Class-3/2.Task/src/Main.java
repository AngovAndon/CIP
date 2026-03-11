void main() throws InterruptedException {
    Thread thread1 = new Thread(new TickTack("Casio1", 650));
    Thread thread2 = new Thread(new TickTack("Casio2", 950));

    thread1.start();
    thread2.start();
}
