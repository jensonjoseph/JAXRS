package com.jensonjo.jaxrsclient.net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetClientGet {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/messenger/webapi/messages");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			if (con.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
			}

			Scanner scan = new Scanner(con.getInputStream());

			System.out.println("Output from server..");
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			con.disconnect();
			scan.close();
			
			
			url = new URL("http://localhost:8080/messenger/webapi/messages/2");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			
			scan = new Scanner(con.getInputStream());
			System.out.println("2 nd Output from server..");
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			con.disconnect();
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
