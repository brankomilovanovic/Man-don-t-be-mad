/*
 * Project made: Branko Milovanovic student in Singidunum university
 * Man don't be made V1.0 (Beta | 1v1 player)
 * Game made for student project
 * GitLab: https://gitlab.com/brankomilovanovic2000
 * GitHub: https://github.com/brankomilovanovic
 * Enjoy!
 * */


package app;

import java.awt.EventQueue;

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