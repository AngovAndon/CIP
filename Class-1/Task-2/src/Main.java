void main() {
    Path filePath = Paths.get("Class-1/Task-2/src/content.txt");

    try{
        List<String> lines = Files.readAllLines(filePath);
        System.out.println("Number of lines is: " + lines.size());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
