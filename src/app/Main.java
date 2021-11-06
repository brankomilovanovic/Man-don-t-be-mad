package app;

import java.awt.EventQueue;

/* Kada igrac udje u kucu do prvog mesta ono postaje zauzeto i sledeci pijun moze da ide samo do sledeceg slobodnog mesta
 * Kada se to odradi ubaciti plavog igraca i mogucnost jedenja jedan drugog
 * kada plavi igrac igra pozicija ce biti trenutna pozicija -20, zbog napredovanja u odnosu na poziciju crvenog
 * 
 * 
 * 
 * */
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