package com.netposa.urbot.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(12580);
			ExecutorService service = Executors.newFixedThreadPool(50);
			while(true){
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				/*Thread thread = new Thread(serverThread);
				thread.start();*/
				service.submit(serverThread);
				System.out.println("服务端已监听到客户端的请求");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
