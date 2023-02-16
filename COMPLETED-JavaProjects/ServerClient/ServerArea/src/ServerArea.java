import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerArea {

    public static void main(String[] args) {

        ServerSocket listenerSocket = null;
        String line;
        BufferedReader is;
        BufferedWriter os;
        Socket socketOfServer = null;

        try {
            listenerSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            System.out.println("Server is waiting to accept client...");

        socketOfServer = listenerSocket.accept();
            System.out.println("Client accepted");

            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));

            while (true) {
                line = is.readLine();

                if (line.equals("QUIT")) {
                    os.write(">> ok");
                    os.newLine();
                    os.flush();
                    break;
                }

                double radius  = Double.valueOf(line);
                double area = radius * radius * 3.14;

                os.write("The area of a circle with a radius of " + radius + " is " + area);
                os.newLine();
                os.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("Server stopped");
    }
}
