/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author admin
 */
public class MaHoa {
    public static String toSHA1(String str) {
		 String salt = "asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn";
        String result = null;

        str = str + salt;
        try {
            byte[] dataBytes = str.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(dataBytes);
            result = Base64.getEncoder().encodeToString(hash); // Sử dụng Base64 từ java.util
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(toSHA1("123456"));
	}
}
