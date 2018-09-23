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
import java.util.Date;

public class ServerThread implements Runnable {
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			while (true) {
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();

				DataInputStream dataInputStream = new DataInputStream(inputStream);
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				PrintStream printStream = new PrintStream(outputStream);

				String clientMsg = "";
				/*if ((clientMsg = bufferedReader.readLine()) != null) {
					System.out.println("接收到客户端信息:" + clientMsg);
				}*/
				clientMsg = dataInputStream.readUTF();
				System.out.println(clientMsg);

				String serverMsg = "服务端响应时间:" + new Date();
				System.out.println(serverMsg);
				//printStream.println(serverMsg);
				dataOutputStream.writeUTF(serverMsg);
				System.out.println("**********************************");
			}
		} catch (Exception e) {
			System.out.println("客户端连接异常");
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
