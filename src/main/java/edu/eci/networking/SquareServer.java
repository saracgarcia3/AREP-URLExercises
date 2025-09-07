package edu.eci.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {
    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 35000;
        System.out.println("Servidor iniciado en puerto " + port + " ...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket client = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                    String line;
                    while ((line = in.readLine()) != null) {
                        try {
                            long n = Long.parseLong(line.trim());
                            long sq = n * n;
                            out.println(sq);
                        } catch (NumberFormatException e) {
                            out.println("ERROR: ingresa un entero válido");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el servidor: " + e.getMessage());
        }
    }
}

