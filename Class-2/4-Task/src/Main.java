import java.awt.*;

void main() {
    if (!Desktop.isDesktopSupported()){
        System.out.println("Desktop operations are not supported!");
        return;
    }

    try {
        Desktop desktop = Desktop.getDesktop();
//        File file = new File("UniqueFile.txt");
//        desktop.open(file);
        URI uri = new URI("mailto:f.filkova.ivana@gmail.com?subject=Test&body=Body%20Test");
        desktop.mail(uri);

    } catch (IOException e){
        e.printStackTrace();
    } catch (URISyntaxException e){
        e.printStackTrace();
    }

}
