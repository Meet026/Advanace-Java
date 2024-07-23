import java.io.*;
import java.net.*;

public class FactorialClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        System.out.println("Connected to Factorial Server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(System.console().readLine());

        out.println(number);

        String response = in.readLine();
        System.out.println(response);

        socket.close();
    }
}