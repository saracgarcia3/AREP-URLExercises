
package edu.eci.networking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una URL: ");
        String input = sc.nextLine().trim();
        sc.close();

        try {
            URL url = new URL(input);
            System.out.println("getProtocol():  " + url.getProtocol());
            System.out.println("getAuthority(): " + url.getAuthority());
            System.out.println("getHost():      " + url.getHost());
            System.out.println("getPort():      " + url.getPort()); 
            System.out.println("getPath():      " + url.getPath());
            System.out.println("getQuery():     " + url.getQuery());
            System.out.println("getFile():      " + url.getFile());
            System.out.println("getRef():       " + url.getRef());
        } catch (MalformedURLException e) {
            System.err.println("La URL es inválida: " + e.getMessage());
        }
    }
}
