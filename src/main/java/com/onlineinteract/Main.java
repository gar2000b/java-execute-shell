package com.onlineinteract;

import java.io.IOException;

/**
 * Launches an instance of an application (notepad.exe), waits for 2
 * secs, then kills the app.
 * 
 * @author Digilogue
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec("notepad.exe");
			Thread.sleep(2000);
			exec.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}