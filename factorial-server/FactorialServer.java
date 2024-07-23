import java.io.*;
import java.net.*;

public class FactorialServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Factorial Server started. Listening for incoming connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Incoming connection from " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input = in.readLine();
            int number = Integer.parseInt(input);
            int factorial = calculateFactorial(number);

            out.println("Factorial of " + number + " is " + factorial);

            socket.close();
        }
    }

    private static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}