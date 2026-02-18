void main() {
    Path filePath = Paths.get("Class-1/Task-6/src/appendText.txt");
    String appendData = "\nTest\n";

    try{
        Files.write(filePath, appendData.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println("Successfully appended to file!");
    }catch (IOException e){
        e.printStackTrace();
    }
}
