void main() throws IOException{
    Path filePath = Paths.get("Class-1");
    int days = 7;

    Files.walkFileTree(filePath, new SimpleFileVisitor<>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            LocalDate lastModifiedTime = attr.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate now = LocalDate.now();
            if (lastModifiedTime.isAfter(now.minusDays(days))){
                System.out.println(file);
            }
            return FileVisitResult.CONTINUE;
        }
    });
}
