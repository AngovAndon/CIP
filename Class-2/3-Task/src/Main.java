void main() {
    String urlString = "https://github.com/";
    String filePathString = "downloadFile01.txt";

    downloadingContentTheOtherWayFileBuffer(urlString, "downloadOnSecondWay");

    try {
        InputStream in = new BufferedInputStream(new URL(urlString).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(filePathString);
        byte[] bufferedData = new byte[1024];
        int dataRead;
        while ((dataRead = in.read(bufferedData, 0, bufferedData.length)) != -1) {
            fileOutputStream.write(bufferedData, 0, dataRead);
        }
        System.out.println("Finished downloading content!");
    } catch(MalformedURLException e){
        e.printStackTrace();
    } catch (IOException e){
        e.printStackTrace();
    }
}

public static void downloadingContentTheOtherWayFileBuffer(String urlString, String filePathString){
    try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathString));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        System.out.println("Finished another download!");
    } catch (MalformedURLException e){
        e.printStackTrace();
    } catch (IOException e){
        e.printStackTrace();
    }
}