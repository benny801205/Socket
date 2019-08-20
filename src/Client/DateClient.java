package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DateClient {

	public static void main(String[] args) throws IOException {

		String ip = "localhost";
		int port = 59090;
		BufferedReader br = null;
		String nextline = null;
		Socket s = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("type something,or type\"end\" to kill this port");
			nextline = br.readLine();
			while (!nextline.equals("end")) {
				s = new Socket(ip, port);

				PrintWriter pr = new PrintWriter(s.getOutputStream());
				pr.println(nextline);
				pr.flush();
				// if the output from server includes the input,we need to order in logical way
				System.out.println("Server response: " + convert(s.getInputStream()));
				pr.close();
				s.close();
				System.out.println("type something,or type\"end\" to kill this port");
				nextline = br.readLine();

			}

		} finally {
			System.out.println("Done");
		}

	}

	/**
	 * convert InputStream to String
	 */
	public static String convert(InputStream inputStream) throws IOException {
		var in = new Scanner(inputStream);
		return in.nextLine();
	}
}