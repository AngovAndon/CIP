//while loop for sending to the server from the client until the message is not .
//while loop another one not the while(true) for accepting, this one for while reading is not null
//because if disconected then stop
//inside if the recieved is . break
//copy the client under source and name it secondClient
//but then call both clients but then it won't connect the second until the first is done
//for simultaneous we need threads
//in the server in the same while true
//after accepting do newThread
//additional class ThreadHelper and implements Runnable
//and the run method will have what we say below
//and the connection should be class atribute in this ThreadHelper class
//like private Socket connectionSocket
//and a constructor with the connectionSocket in it
//and we must handle the exceptions in the run method
//try catch to everything inside that run
//and start that Thread
//and evertyhing that was previously in the server now in the run method of new tread
//and now in the server new Thread(new ThreadHelper(connectionSocket)).start();
void main() {

}
