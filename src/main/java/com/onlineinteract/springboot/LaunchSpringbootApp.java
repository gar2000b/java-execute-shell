package com.onlineinteract.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LaunchSpringbootApp {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec(
					"java -jar /work/stateful-list-service/target/stateful-list-service-0.0.1-SNAPSHOT.jar");
			new Thread(() -> {
				try {
					Thread.sleep(20000);
					exec.destroy();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
			InputStream inputStream = exec.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				if (line.contains("Tomcat started on port(s): 8080"))
					System.out.println("Application launched successfully!");
			}
			System.out.println("Process destroyed, exiting.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
