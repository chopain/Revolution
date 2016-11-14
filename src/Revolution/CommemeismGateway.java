package Revolution;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

import static Revolution.ClassType.*;

public class CommemeismGateway {

    private PrintWriter outputToServer;
    private BufferedReader inputFromServer;
    private WorldPane world;
    private ReentrantLock lock = new ReentrantLock();
    private static int newCommentsCount = 0;
    private int curUserComments = 0;

    // Establish the connection to the server.
    public CommemeismGateway(WorldPane world) {
        this.world = world;
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an output stream to send data to the server
            outputToServer = new PrintWriter(socket.getOutputStream());

            // Create an input stream to read data from the server
            inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {

        }

    }


    // Start the chat by sending in the user's handle.
    public void sendHandle(String handle) {
        lock.lock();
        outputToServer.println(SEND_HANDLE);
        outputToServer.println(handle);
        outputToServer.flush();
        lock.unlock();
    }

    // Start the chat by sending in the user's handle.
    public void sendClass(String type) {
        lock.lock();
        outputToServer.println(SEND_CLASS);
        outputToServer.println(type);
        outputToServer.flush();
        lock.unlock();
    }


    // Update player move
    public void move(int move) {
        lock.lock();
        outputToServer.println(SEND_MOVE);
        outputToServer.println(move);
        outputToServer.flush();
        lock.unlock();
    }

    public int getMoveCount() {
        lock.lock();
        outputToServer.println(GET_MOVE_COUNT);
        outputToServer.flush();
        int count = 0;
        try {
            count = Integer.parseInt(inputFromServer.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return count;
    }

    //Get updated position
    public void getMoves() {
        lock.lock();
        outputToServer.println(GET_MOVE);

        outputToServer.flush();
        lock.unlock();

    }


    public ObservableList<String> getClassTypes() {
        ObservableList<String> types = FXCollections.observableArrayList();
        types.add("Bourgeois");
        types.add("Proletariat");
        types.add("Communist");
        return types;
    }
}