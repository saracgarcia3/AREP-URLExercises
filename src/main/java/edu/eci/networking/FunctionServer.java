package edu.eci.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.DoubleUnaryOperator;

public class FunctionServer {
    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 35000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado en puerto " + port + " ...");

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String inputLine;
                DoubleUnaryOperator operation = Math::cos; 

                while ((inputLine = in.readLine()) != null) {
                    inputLine = inputLine.trim();

                    if (inputLine.startsWith("fun:")) {
                        switch (inputLine.substring(4).toLowerCase()) {
                            case "sin":
                                operation = Math::sin;
                                out.println("Operación cambiada a SENO");
                                break;
                            case "cos":
                                operation = Math::cos;
                                out.println("Operación cambiada a COSENO");
                                break;
                            default:
                                out.println("Operación desconocida (usa fun:sin o fun:cos)");
                        }
                    } else {
                        try {
                            double num = Double.parseDouble(inputLine);
                            double result = operation.applyAsDouble(num);
                            out.println("Resultado: " + result);
                        } catch (NumberFormatException e) {
                            out.println("Entrada no válida: " + inputLine);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
