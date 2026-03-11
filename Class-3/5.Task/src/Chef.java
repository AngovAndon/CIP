public class Chef implements Runnable {
    private String name;
    private String[] specialties;
    private ServingCounter servingCounter;

    public Chef(String name, String[] specialties, ServingCounter servingCounter) {
        this.name = name;
        this.specialties = specialties;
        this.servingCounter = servingCounter;
    }

    @Override
    public void run(){
        try {
            String meal = specialties[(int) Math.random() * specialties.length];
            System.out.println("Chef " + name + " " + "is preparing dish: " + meal);
            Thread.sleep(1000);
            servingCounter.addDish(name, meal);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Chef is going home");
        }
    }
}
