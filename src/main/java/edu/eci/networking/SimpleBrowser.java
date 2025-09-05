
package edu.eci.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class SimpleBrowser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una URL para descargar: ");
        String input = sc.nextLine().trim();
        sc.close();

        if (!input.startsWith("http://") && !input.startsWith("https://")) {
            input = "https://" + input;
        }

        try {
            URL url = new URL(input);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", 
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resultado.html"), StandardCharsets.UTF_8))) {
                
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("Descarga completa. Revisa el archivo resultado.html.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}