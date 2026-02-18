void main() {
    long timestamp = System.currentTimeMillis();
    String fileName = "UniqueFile_" + timestamp + ".txt";
    Path filePath = Paths.get(fileName);

    if (Files.exists(filePath)){
        System.out.println("File already exists!!!");
    } else {
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    File file = new File(fileName);
    System.out.println("File name: " + file.getName());
    System.out.println("File location: " + file.getPath());
    System.out.println("File abs path: " + file.getAbsolutePath());
    System.out.println("Read privilege: " + file.canRead());
    System.out.println("Write privilege: " + file.canWrite());
    System.out.println("Execute privilege: " + file.canExecute());


}
