package com.example.administrator.keshe.keshe;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Administrator
 * @Email 772900182@qq.com
 * @date 2018年1月5日 下午7:01:02
 * 
 */
public class ThreadWriter extends Thread {
	Socket socket;

	public ThreadWriter(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			while (true) {
				String str = sc.next();
				OutputStream os = socket.getOutputStream();
				os.write(str.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
