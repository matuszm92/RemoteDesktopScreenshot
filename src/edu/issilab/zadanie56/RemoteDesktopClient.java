/**
 * 
 */
package edu.issilab.zadanie56;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author Igor Mr�z
 *
 */
public class RemoteDesktopClient {
	public static void main(String[] args) {
		try {
			DataInputStream stdIn = new DataInputStream(System.in);
			String fromUser;			
			System.out.println("Correct commands: shot [jpg, jpeg, bmp, wbmp, png, gif], exit.");
			System.out.println("Command: ");
			while ((fromUser = stdIn.readLine()) != null) {
				new ProcessRequest("localhost", 4000).process(fromUser, stdIn);
			}
			stdIn.close();
		} catch (UnknownHostException e) {
			System.err.println("Nie znalaz�em hosta");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Nie mog� znale�� po��czenia z hostem");
			System.exit(1);
		}		
	}
}
