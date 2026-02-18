void main() {
    Path dirPath = Paths.get("Class-1/Task-2/src");
    String ext = ".java";

    try {
        DirectoryStream<Path> files = Files.newDirectoryStream(dirPath, "*" + ext);
        for (Path f : files){
            System.out.println(f);
        }
    } catch (IOException e){
        e.printStackTrace();
    }
}
