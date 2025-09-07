package edu.eci.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 35000;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader kb = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado a " + host + ":" + port);
            System.out.println("Escribe un número (o 'exit' para salir):");

            String user;
            while ((user = kb.readLine()) != null) {
                if (user.equalsIgnoreCase("exit")) break;
                out.println(user);                 
                String resp = in.readLine();       
                System.out.println("Cuadrado: " + resp);
            }
        } catch (IOException e) {
            System.err.println("Error cliente: " + e.getMessage());
        }
    }
}

