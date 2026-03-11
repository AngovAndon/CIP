void main() {
    //set all those same and in finally close them
    try {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started listening on port 8080 --- for client connection");
        System.out.println("Ready to receive a connection");


        //accept in while true is how we make the server not turn off after one client is done
        while (true) {
            Socket connectionSocket = serverSocket.accept();
            System.out.println("Connection established with --- client: " + connectionSocket.getInetAddress().getHostName());
            PrintWriter outputToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()), true);
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            String messageFromClient = inputFromClient.readLine();
            System.out.println("On Server side -- received from client");
            System.out.println("Client said: " + messageFromClient);

            String newMessage = messageFromClient.toUpperCase();
        }
    }
}
