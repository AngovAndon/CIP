//task 1 and 2 together
void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a hostname: ");
    String hostname = scanner.nextLine();

    try {
//        InetAddress address = InetAddress.getByName(hostname);
//        System.out.println("IP address: " + address.getHostAddress());
//        System.out.println("Canonical hostname: " + address.getCanonicalHostName());
//        System.out.println("Is reachable: " + address.isReachable(5000));
        InetAddress[] addresses = InetAddress.getAllByName(hostname);
        for (InetAddress address : addresses){
            System.out.println(address);
        }
    } catch (UnknownHostException e) {
        System.out.println("Hostname cannot be resolved!");
    } catch (IOException e){
        e.printStackTrace();
    }

}
