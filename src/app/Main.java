package app;

import java.awt.EventQueue;

/* TODO: Dodati obavestenja za igrace ispod njihovih pijuna. */

public class Main {

	Gui gui = new Gui();
	
	public static void main(String[] args) {
		System.out.println("Game start!");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.gui.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		Gui.initialize();
	}
}