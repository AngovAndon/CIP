//simple message from client to server and response back
//also client send numbers server computes the result and sends back

void main() {
    //set all those same and in finally close them
    try {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started listening on port 8080 --- for client connection");
        System.out.println("Ready to receive a connection");
        Socket connectionSocket = serverSocket.accept();
        System.out.println("Connection established with --- client: " + connectionSocket.getInetAddress().getHostName());
        PrintWriter outputToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()), true);
        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        String messageFromClient = inputFromClient.readLine();
        System.out.println("On Server side -- received from client");
        System.out.println("Client said: " + messageFromClient);

        //server is sending a message to client
        outputToClient.println("Hello client");

        int num1 = Integer.parseInt(inputFromClient.readLine());
        System.out.println("On Server side -- client sent num1: " + num1);

        int num2 = Integer.parseInt(inputFromClient.readLine());
        System.out.println("On Server side -- client sent num2: " + num2);

        //calculating
        int sum = num1 + num2;
        outputToClient.println(sum);
        System.out.println("On Server side -- Result is: " + sum + " -- and is sent to client");

    } catch (IOException e) {
        System.err.println("Error happened on SERVER side");
    }
}
