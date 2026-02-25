void main() {
    try {
        URI uri = URI.create("https://uacs.edu.mk:8080");
        //check port how to be shown this is not fully correct
        URL url = uri.toURL();
        System.out.println(url);
        System.out.println(url.getAuthority());
        System.out.println(url.getProtocol());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getQuery());
        System.out.println(url.getPort());
        System.out.println(url.getPath());

    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
