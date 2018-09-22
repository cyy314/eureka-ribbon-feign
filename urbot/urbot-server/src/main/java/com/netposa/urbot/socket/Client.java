package com.netposa.urbot.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import io.reactivex.netty.contexts.AbstractClientContextHandler.NewContextEvent;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 12580);
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();

			PrintStream printStream = new PrintStream(outputStream);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

			DataInputStream dataInputStream = new DataInputStream(inputStream);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String serverMsg = "";
			while (true) {
				String clientMsg = "客户端请求时间:" + new Date();
				System.out.println(clientMsg);
				/*printStream.println(clientMsg);
				if ((serverMsg = bufferedReader.readLine()) != null) {
					System.out.println("服务端响应结果:" + serverMsg);
				}*/
				dataOutputStream.writeUTF(clientMsg);
				serverMsg = dataInputStream.readUTF();
				System.out.println(serverMsg);
				Thread.sleep(1000);
				System.out.println("==================================");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
