package com.onlineinteract.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LaunchSpringbootApp {
	public static void main(String[] args) throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec(
					"java -jar /work/stateful-list-service/target/stateful-list-service-0.0.1-SNAPSHOT.jar");
			InputStream inputStream = exec.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			Thread.sleep(2000);
			exec.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
