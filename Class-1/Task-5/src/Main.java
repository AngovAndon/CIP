void main() {
    Path fileFile = Paths.get("Class-1/Task-5/src/binaryFile.bin");

    byte[] dataToWrite = {1, 2, 3, 4, 5, 6, 10, 'C'};
    try {
        Files.write(fileFile, dataToWrite);
        System.out.println("Data successfully added!");

        byte[] readData = Files.readAllBytes(fileFile);
        for (byte b : readData){
            System.out.print(b + " ");
        }
    } catch (IOException e){
        e.printStackTrace();
    }

}
