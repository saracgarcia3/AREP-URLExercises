package edu.eci.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FunctionClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 35000;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado a " + host + ":" + port);
            System.out.println("Escribe un número o cambia la operación con fun:sin | fun:cos");
            System.out.println("Escribe 'exit' para salir");

            String userInput;
            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine().trim();
                if (userInput.equalsIgnoreCase("exit")) break;

                out.println(userInput);
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}

