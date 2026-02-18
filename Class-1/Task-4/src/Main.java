void main() {
    Path dirPath = Paths.get("Class-1/Task-4/src");
    try {
        Stream<Path> stream = Files.list(dirPath);
        if (stream.findFirst().isPresent()){
            System.out.println("Directory is not empty");
        } else {
            System.out.println("Directory is empty");
        }
    } catch (IOException e) {
         e.printStackTrace();
    }
}
