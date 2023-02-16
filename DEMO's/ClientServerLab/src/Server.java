import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    int port = 8000;
    DataInputStream in;
    DataOutputStream out;
    ServerSocket server;
    Socket socket;

    public static void main(String[] args) throws IOException {

        try(Socket myFirstSocket = new Socket("BrandonScottLang.com", 13);
            Scanner scnr = new Scanner(myFirstSocket.getInputStream(), StandardCharsets.UTF_8)){

            while(scnr.hasNextLine())  {
                String line = scnr.nextLine();
                System.out.println(line);
            }
        }
    }
}
