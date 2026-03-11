private final static String SERVER_ADDRESS = "localhost";
private final static int SERVER_PORT = 8080;

void main() {
    //must be defined here if we want to close them in the finally
    Socket clientSocket = null;
    PrintWriter outputToServer = null;
    BufferedReader inputFromServer = null;
    BufferedReader inputFromUser = null;
    try {
        System.out.println("Connecting to server..." + " -- ADDRESS: " + SERVER_ADDRESS + ", PORT: " + SERVER_PORT);
        clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        System.out.println("On Client Side -- Connection established!");

        outputToServer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
        inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        inputFromUser = new BufferedReader(new InputStreamReader(System.in));

        outputToServer.println("Hello Server");

        String messageFromServer = inputFromServer.readLine();
        System.out.println("On Client side -- received from server");
        System.out.println("Server said: " + messageFromServer);

        //input from a user
        System.out.println("Hey user -- enter a num1: ");
        String num1 = inputFromUser.readLine();

        //now client sends this number to server
        outputToServer.println(num1);

        //input from a user
        System.out.println("Hey user -- enter a num2: ");
        String num2 = inputFromUser.readLine();

        //now client sends this number to server
        outputToServer.println(num2);

        String resultFromServer = inputFromServer.readLine();
        System.out.println("On Client side -- server sent this result: " + resultFromServer);
    } catch (UnknownHostException e){
        System.err.println("Cannot connect to server -- ADDRESS: " + SERVER_ADDRESS + ", PORT: " + SERVER_PORT);
    } catch (IOException e) {
        System.out.println("Error happened while communicating with server -- ADDRESS: " + SERVER_ADDRESS + ", PORT: " + SERVER_PORT);
    }finally {
        try {
            if(clientSocket != null) clientSocket.close();
            if(outputToServer != null) outputToServer.close();
            if(inputFromServer != null) inputFromServer.close();
            if(inputFromUser != null) inputFromUser.close();
        } catch (IOException e){
            e.getMessage();
        }
    }


}
