package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Ben Chung 
 * Reference :https://cs.lmu.edu/~ray/notes/javanetexamples/
 * 2019/08/19
 */
public class DataServer {
	public static void main(String[] args) throws IOException {
		String inputString = "";

		try (var listener = new ServerSocket(59090)) {
			System.out.println("The date server is running...");
			while (true) {
				try (var socket = listener.accept()) {
					inputString = convert(socket.getInputStream());

					PrintWriter pr = new PrintWriter(socket.getOutputStream());
					// inputString=convert(socket.getInputStream());
					pr.println("Input:" + inputString + " and The Server current time is " + new Date().toString());
					pr.flush();

					System.out.println(inputString);
					pr.close();
					socket.close();

				}

			}
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
