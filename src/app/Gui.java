package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.HashMap;
import java.util.Map;

//import java.awt.EventQueue;

public class Gui {

	private static JFrame frame;
	
	//Dice
	private static JButton buttonDice = new JButton();
	
	//Players red
	private static JButton playerRed1 = new JButton("1");
	private static JButton playerRed2 = new JButton("2");
	private static JButton playerRed3 = new JButton("3");
	private static JButton playerRed4 = new JButton("4");
	
	//Players blue
	private static JButton playerBlue1 = new JButton("1");
	private static JButton playerBlue2 = new JButton("2");
	private static JButton playerBlue3 = new JButton("3");
	private static JButton playerBlue4 = new JButton("4");
	
	//Position on table
	static Map<Integer, String> position = new HashMap<>();
	
	public Gui() {
		super();
		//initialize();
	}
	
	public Gui(JFrame frame) {
		super();
		Gui.frame = frame;
	}

	public Window getFrame() {
		return frame;
	}
	
	public JButton getButtonDice() {
		return buttonDice;
	}
	
	//Get method for red players
	public JButton getPlayerRed1() {
		return playerRed1;
	}
	
	public JButton getPlayerRed2() {
		return playerRed2;
	}
	
	public JButton getPlayerRed3() {
		return playerRed3;
	}
	
	public JButton getPlayerRed4() {
		return playerRed4;
	}
	
	//Get method for blue players
	public JButton getPlayerBlue1() {
		return playerBlue1;
	}
	
	public JButton getPlayerBlue2() {
		return playerBlue2;
	}
	
	public JButton getPlayerBlue3() {
		return playerBlue3;
	}
	
	public JButton getPlayerBlue4() {
		return playerBlue4;
	}
	
	//In case of editing GUI
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public static void initialize() throws HeadlessException {
		frame = new JFrame();
		frame.setBounds(100, 100, 983, 859);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		playerRed1.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerRed1.setForeground(Color.WHITE);
		playerRed1.setBackground(Color.RED);
		playerRed1.setBounds(81, 83, 61, 61);
		frame.getContentPane().add(playerRed1);
		Game.playerRed1();
		
		playerRed2.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerRed2.setForeground(Color.WHITE);
		playerRed2.setBackground(Color.RED);
		playerRed2.setBounds(152, 83, 61, 61);
		frame.getContentPane().add(playerRed2);
		Game.playerRed2();
		
		playerRed3.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerRed3.setForeground(Color.WHITE);
		playerRed3.setBackground(Color.RED);
		playerRed3.setBounds(81, 155, 61, 61);
		frame.getContentPane().add(playerRed3);
		Game.playerRed3();
		
		playerRed4.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerRed4.setForeground(Color.WHITE);
		playerRed4.setBackground(Color.RED);
		playerRed4.setBounds(152, 155, 61, 61);
		frame.getContentPane().add(playerRed4);
		Game.playerRed4();
		
		playerBlue1.setForeground(Color.WHITE);
		playerBlue1.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerBlue1.setBackground(Color.BLUE);
		playerBlue1.setBounds(649, 657, 61, 61);
		frame.getContentPane().add(playerBlue1);
		Game.playerBlue1();
		
		playerBlue2.setForeground(Color.WHITE);
		playerBlue2.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerBlue2.setBackground(Color.BLUE);
		playerBlue2.setBounds(578, 657, 61, 61);
		frame.getContentPane().add(playerBlue2);
		Game.playerBlue2();
		
		playerBlue3.setForeground(Color.WHITE);
		playerBlue3.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerBlue3.setBackground(Color.BLUE);
		playerBlue3.setBounds(649, 585, 61, 61);
		frame.getContentPane().add(playerBlue3);
		Game.playerBlue3();
		
		playerBlue4.setForeground(Color.WHITE);
		playerBlue4.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerBlue4.setBackground(Color.BLUE);
		playerBlue4.setBounds(578, 585, 61, 61);
		frame.getContentPane().add(playerBlue4);
		Game.playerBlue4();
		
		buttonDice.setFont(new Font("Tahoma", Font.BOLD, 45));
		buttonDice.setForeground(Color.BLACK);
		buttonDice.setBackground(Color.WHITE);
		buttonDice.setText("<html>• • •<br>• • •<br>• • •<br>");
		buttonDice.setBounds(796, 11, 154, 154);
		frame.getContentPane().add(buttonDice);
		Game.rollsDice();
		
		JLabel currentPlayerRollsDice = new JLabel();
		currentPlayerRollsDice.setHorizontalAlignment(SwingConstants.CENTER);
		currentPlayerRollsDice.setVerticalAlignment(SwingConstants.TOP);
		currentPlayerRollsDice.setFont(new Font("Tahoma", Font.BOLD, 11));
		currentPlayerRollsDice.setBounds(773, 178, 174, 51);
		currentPlayerRollsDice.setText("<html>The player is currently playing:<br>Player 1<br>PRESS THE DICE!!!");
		frame.getContentPane().add(currentPlayerRollsDice);
		
		JLabel position_1_red_house_entrance = new JLabel("");
		position_1_red_house_entrance.setForeground(Color.WHITE);
		position_1_red_house_entrance.setBackground(Color.WHITE);
		position_1_red_house_entrance.setBounds(10, 369, 61, 61);
		position_1_red_house_entrance.setOpaque(true);
		frame.getContentPane().add(position_1_red_house_entrance);
		
		JLabel position_3 = new JLabel("");
		position_3.setOpaque(true);
		position_3.setForeground(Color.WHITE);
		position_3.setBackground(Color.WHITE);
		position_3.setBounds(81, 297, 61, 61);
		frame.getContentPane().add(position_3);
		
		JLabel position_2_red_start = new JLabel("\u25BA");
		position_2_red_start.setFont(new Font("MS Gothic", Font.BOLD, 99));
		position_2_red_start.setHorizontalAlignment(SwingConstants.CENTER);
		position_2_red_start.setOpaque(true);
		position_2_red_start.setForeground(Color.BLACK);
		position_2_red_start.setBackground(Color.WHITE);
		position_2_red_start.setBounds(10, 297, 61, 61);
		frame.getContentPane().add(position_2_red_start);
		position.put(1, "10,297");
		
		JLabel position_5 = new JLabel("");
		position_5.setOpaque(true);
		position_5.setForeground(Color.WHITE);
		position_5.setBackground(Color.WHITE);
		position_5.setBounds(223, 297, 61, 61);
		frame.getContentPane().add(position_5);
		
		JLabel position_7 = new JLabel("");
		position_7.setOpaque(true);
		position_7.setForeground(Color.WHITE);
		position_7.setBackground(Color.WHITE);
		position_7.setBounds(294, 225, 61, 61);
		frame.getContentPane().add(position_7);
		
		JLabel position_4 = new JLabel("");
		position_4.setOpaque(true);
		position_4.setForeground(Color.WHITE);
		position_4.setBackground(Color.WHITE);
		position_4.setBounds(152, 297, 61, 61);
		frame.getContentPane().add(position_4);
		
		JLabel position_8 = new JLabel("");
		position_8.setOpaque(true);
		position_8.setForeground(Color.WHITE);
		position_8.setBackground(Color.WHITE);
		position_8.setBounds(294, 153, 61, 61);
		frame.getContentPane().add(position_8);
		
		JLabel position_9 = new JLabel("");
		position_9.setOpaque(true);
		position_9.setForeground(Color.WHITE);
		position_9.setBackground(Color.WHITE);
		position_9.setBounds(294, 83, 61, 61);
		frame.getContentPane().add(position_9);
		
		JLabel position_13 = new JLabel("");
		position_13.setOpaque(true);
		position_13.setForeground(Color.WHITE);
		position_13.setBackground(Color.WHITE);
		position_13.setBounds(436, 83, 61, 61);
		frame.getContentPane().add(position_13);
		
		JLabel position_10 = new JLabel("");
		position_10.setOpaque(true);
		position_10.setForeground(Color.WHITE);
		position_10.setBackground(Color.WHITE);
		position_10.setBounds(294, 11, 61, 61);
		frame.getContentPane().add(position_10);
		
		JLabel position_11_orange_house_entrance = new JLabel("");
		position_11_orange_house_entrance.setOpaque(true);
		position_11_orange_house_entrance.setForeground(Color.WHITE);
		position_11_orange_house_entrance.setBackground(Color.WHITE);
		position_11_orange_house_entrance.setBounds(365, 11, 61, 61);
		frame.getContentPane().add(position_11_orange_house_entrance);
		
		JLabel position_12_orange_start = new JLabel("\u25BC");
		position_12_orange_start.setHorizontalAlignment(SwingConstants.CENTER);
		position_12_orange_start.setFont(new Font("MS Gothic", Font.BOLD, 49));
		position_12_orange_start.setOpaque(true);
		position_12_orange_start.setForeground(Color.BLACK);
		position_12_orange_start.setBackground(Color.WHITE);
		position_12_orange_start.setBounds(436, 11, 61, 61);
		frame.getContentPane().add(position_12_orange_start);
		
		JLabel position_14 = new JLabel("");
		position_14.setOpaque(true);
		position_14.setForeground(Color.WHITE);
		position_14.setBackground(Color.WHITE);
		position_14.setBounds(436, 153, 61, 61);
		frame.getContentPane().add(position_14);
		
		JLabel position_16 = new JLabel("");
		position_16.setOpaque(true);
		position_16.setForeground(Color.WHITE);
		position_16.setBackground(Color.WHITE);
		position_16.setBounds(436, 297, 61, 61);
		frame.getContentPane().add(position_16);
		
		JLabel position_15 = new JLabel("");
		position_15.setOpaque(true);
		position_15.setForeground(Color.WHITE);
		position_15.setBackground(Color.WHITE);
		position_15.setBounds(436, 225, 61, 61);
		frame.getContentPane().add(position_15);
		
		JLabel position_17 = new JLabel("");
		position_17.setOpaque(true);
		position_17.setForeground(Color.WHITE);
		position_17.setBackground(Color.WHITE);
		position_17.setBounds(507, 297, 61, 61);
		frame.getContentPane().add(position_17);
		
		JLabel position_18 = new JLabel("");
		position_18.setOpaque(true);
		position_18.setForeground(Color.WHITE);
		position_18.setBackground(Color.WHITE);
		position_18.setBounds(578, 297, 61, 61);
		frame.getContentPane().add(position_18);
		
		JLabel position_19 = new JLabel("");
		position_19.setOpaque(true);
		position_19.setForeground(Color.WHITE);
		position_19.setBackground(Color.WHITE);
		position_19.setBounds(649, 297, 61, 61);
		frame.getContentPane().add(position_19);
		
		JLabel position_20 = new JLabel("");
		position_20.setOpaque(true);
		position_20.setForeground(Color.WHITE);
		position_20.setBackground(Color.WHITE);
		position_20.setBounds(720, 297, 61, 61);
		frame.getContentPane().add(position_20);
		
		JLabel position_21_blue_house_entrance = new JLabel("");
		position_21_blue_house_entrance.setOpaque(true);
		position_21_blue_house_entrance.setForeground(Color.WHITE);
		position_21_blue_house_entrance.setBackground(Color.WHITE);
		position_21_blue_house_entrance.setBounds(720, 369, 61, 61);
		frame.getContentPane().add(position_21_blue_house_entrance);
		
		JLabel position_22_blue_start = new JLabel("\u25C4");
		position_22_blue_start.setHorizontalAlignment(SwingConstants.CENTER);
		position_22_blue_start.setFont(new Font("MS Gothic", Font.BOLD, 99));
		position_22_blue_start.setOpaque(true);
		position_22_blue_start.setForeground(Color.BLACK);
		position_22_blue_start.setBackground(Color.WHITE);
		position_22_blue_start.setBounds(720, 441, 61, 61);
		frame.getContentPane().add(position_22_blue_start);
		
		JLabel position_6 = new JLabel("");
		position_6.setOpaque(true);
		position_6.setForeground(Color.WHITE);
		position_6.setBackground(Color.WHITE);
		position_6.setBounds(294, 297, 61, 61);
		frame.getContentPane().add(position_6);
		
		JLabel position_26 = new JLabel("");
		position_26.setOpaque(true);
		position_26.setForeground(Color.WHITE);
		position_26.setBackground(Color.WHITE);
		position_26.setBounds(436, 441, 61, 61);
		frame.getContentPane().add(position_26);
		
		JLabel position_27 = new JLabel("");
		position_27.setOpaque(true);
		position_27.setForeground(Color.WHITE);
		position_27.setBackground(Color.WHITE);
		position_27.setBounds(436, 513, 61, 61);
		frame.getContentPane().add(position_27);
		
		JLabel position_28 = new JLabel("");
		position_28.setOpaque(true);
		position_28.setForeground(Color.WHITE);
		position_28.setBackground(Color.WHITE);
		position_28.setBounds(436, 585, 61, 61);
		frame.getContentPane().add(position_28);
		
		JLabel position_32_green_start = new JLabel("\u25B2");
		position_32_green_start.setHorizontalAlignment(SwingConstants.CENTER);
		position_32_green_start.setFont(new Font("MS Gothic", Font.BOLD, 49));
		position_32_green_start.setOpaque(true);
		position_32_green_start.setForeground(Color.BLACK);
		position_32_green_start.setBackground(Color.WHITE);
		position_32_green_start.setBounds(294, 729, 61, 61);
		frame.getContentPane().add(position_32_green_start);
		
		JLabel position_34 = new JLabel("");
		position_34.setOpaque(true);
		position_34.setForeground(Color.WHITE);
		position_34.setBackground(Color.WHITE);
		position_34.setBounds(294, 585, 61, 61);
		frame.getContentPane().add(position_34);
		
		JLabel position_35 = new JLabel("");
		position_35.setOpaque(true);
		position_35.setForeground(Color.WHITE);
		position_35.setBackground(Color.WHITE);
		position_35.setBounds(294, 513, 61, 61);
		frame.getContentPane().add(position_35);
		
		JLabel position_37 = new JLabel("");
		position_37.setOpaque(true);
		position_37.setForeground(Color.WHITE);
		position_37.setBackground(Color.WHITE);
		position_37.setBounds(223, 441, 61, 61);
		frame.getContentPane().add(position_37);
		
		JLabel position_38 = new JLabel("");
		position_38.setOpaque(true);
		position_38.setForeground(Color.WHITE);
		position_38.setBackground(Color.WHITE);
		position_38.setBounds(152, 441, 61, 61);
		frame.getContentPane().add(position_38);
		
		JLabel position_39 = new JLabel("");
		position_39.setOpaque(true);
		position_39.setForeground(Color.WHITE);
		position_39.setBackground(Color.WHITE);
		position_39.setBounds(81, 441, 61, 61);
		frame.getContentPane().add(position_39);
		
		JLabel position_40 = new JLabel("");
		position_40.setOpaque(true);
		position_40.setForeground(Color.WHITE);
		position_40.setBackground(Color.WHITE);
		position_40.setBounds(10, 441, 61, 61);
		frame.getContentPane().add(position_40);
		
		JLabel position_33 = new JLabel("");
		position_33.setOpaque(true);
		position_33.setForeground(Color.WHITE);
		position_33.setBackground(Color.WHITE);
		position_33.setBounds(294, 657, 61, 61);
		frame.getContentPane().add(position_33);
		
		JLabel position_36 = new JLabel("");
		position_36.setOpaque(true);
		position_36.setForeground(Color.WHITE);
		position_36.setBackground(Color.WHITE);
		position_36.setBounds(294, 441, 61, 61);
		frame.getContentPane().add(position_36);
		
		JLabel position_25 = new JLabel("");
		position_25.setOpaque(true);
		position_25.setForeground(Color.WHITE);
		position_25.setBackground(Color.WHITE);
		position_25.setBounds(507, 441, 61, 61);
		frame.getContentPane().add(position_25);
		
		JLabel position_24 = new JLabel("");
		position_24.setOpaque(true);
		position_24.setForeground(Color.WHITE);
		position_24.setBackground(Color.WHITE);
		position_24.setBounds(578, 441, 61, 61);
		frame.getContentPane().add(position_24);
		
		JLabel position_23 = new JLabel("");
		position_23.setOpaque(true);
		position_23.setForeground(Color.WHITE);
		position_23.setBackground(Color.WHITE);
		position_23.setBounds(649, 441, 61, 61);
		frame.getContentPane().add(position_23);
		
		JLabel position_29 = new JLabel("");
		position_29.setOpaque(true);
		position_29.setForeground(Color.WHITE);
		position_29.setBackground(Color.WHITE);
		position_29.setBounds(436, 657, 61, 61);
		frame.getContentPane().add(position_29);
		
		JLabel position_30 = new JLabel("");
		position_30.setOpaque(true);
		position_30.setForeground(Color.WHITE);
		position_30.setBackground(Color.WHITE);
		position_30.setBounds(436, 729, 61, 61);
		frame.getContentPane().add(position_30);
		
		JLabel position_31_green_house_entrance = new JLabel("");
		position_31_green_house_entrance.setOpaque(true);
		position_31_green_house_entrance.setForeground(Color.WHITE);
		position_31_green_house_entrance.setBackground(Color.WHITE);
		position_31_green_house_entrance.setBounds(365, 729, 61, 61);
		frame.getContentPane().add(position_31_green_house_entrance);
		
		JButton playerYellow1 = new JButton("1");
		playerYellow1.setForeground(Color.WHITE);
		playerYellow1.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerYellow1.setBackground(Color.ORANGE);
		playerYellow1.setBounds(649, 83, 61, 61);
		frame.getContentPane().add(playerYellow1);
		
		JButton playerYellow2 = new JButton("2");
		playerYellow2.setForeground(Color.WHITE);
		playerYellow2.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerYellow2.setBackground(Color.ORANGE);
		playerYellow2.setBounds(578, 83, 61, 61);
		frame.getContentPane().add(playerYellow2);
		
		JButton playerYellow3 = new JButton("3");
		playerYellow3.setForeground(Color.WHITE);
		playerYellow3.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerYellow3.setBackground(Color.ORANGE);
		playerYellow3.setBounds(578, 155, 61, 61);
		frame.getContentPane().add(playerYellow3);
		
		JButton playerYellow4 = new JButton("4");
		playerYellow4.setForeground(Color.WHITE);
		playerYellow4.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerYellow4.setBackground(Color.ORANGE);
		playerYellow4.setBounds(649, 155, 61, 61);
		frame.getContentPane().add(playerYellow4);
		
		JButton playerGreen1 = new JButton("1");
		playerGreen1.setForeground(Color.WHITE);
		playerGreen1.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerGreen1.setBackground(Color.GREEN);
		playerGreen1.setBounds(81, 657, 61, 61);
		frame.getContentPane().add(playerGreen1);
		
		JButton playerGreen2 = new JButton("2");
		playerGreen2.setForeground(Color.WHITE);
		playerGreen2.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerGreen2.setBackground(Color.GREEN);
		playerGreen2.setBounds(152, 657, 61, 61);
		frame.getContentPane().add(playerGreen2);
		
		JButton playerGreen3 = new JButton("3");
		playerGreen3.setForeground(Color.WHITE);
		playerGreen3.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerGreen3.setBackground(Color.GREEN);
		playerGreen3.setBounds(152, 585, 61, 61);
		frame.getContentPane().add(playerGreen3);
		
		JButton playerGreen4 = new JButton("4");
		playerGreen4.setForeground(Color.WHITE);
		playerGreen4.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerGreen4.setBackground(Color.GREEN);
		playerGreen4.setBounds(81, 585, 61, 61);
		frame.getContentPane().add(playerGreen4);
		
		JLabel playerOrangeLabel = new JLabel("Player orange is not in function");
		playerOrangeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerOrangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerOrangeLabel.setBounds(555, 225, 182, 14);
		frame.getContentPane().add(playerOrangeLabel);
		
		JLabel playerGreenLabel = new JLabel("Player green is not in function");
		playerGreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerGreenLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerGreenLabel.setBounds(57, 560, 182, 14);
		frame.getContentPane().add(playerGreenLabel);
		
		JLabel position_red_house_1 = new JLabel("");
		position_red_house_1.setOpaque(true);
		position_red_house_1.setForeground(Color.WHITE);
		position_red_house_1.setBackground(Color.RED);
		position_red_house_1.setBounds(81, 369, 61, 61);
		frame.getContentPane().add(position_red_house_1);
		
		JLabel position_red_house_2 = new JLabel("");
		position_red_house_2.setOpaque(true);
		position_red_house_2.setForeground(Color.WHITE);
		position_red_house_2.setBackground(Color.RED);
		position_red_house_2.setBounds(152, 369, 61, 61);
		frame.getContentPane().add(position_red_house_2);
		
		JLabel position_red_house_3 = new JLabel("");
		position_red_house_3.setOpaque(true);
		position_red_house_3.setForeground(Color.WHITE);
		position_red_house_3.setBackground(Color.RED);
		position_red_house_3.setBounds(223, 369, 61, 61);
		frame.getContentPane().add(position_red_house_3);
		
		JLabel position_red_house_4 = new JLabel("");
		position_red_house_4.setOpaque(true);
		position_red_house_4.setForeground(Color.WHITE);
		position_red_house_4.setBackground(Color.RED);
		position_red_house_4.setBounds(294, 369, 61, 61);
		frame.getContentPane().add(position_red_house_4);
		
		JLabel position_blue_house_1 = new JLabel("");
		position_blue_house_1.setOpaque(true);
		position_blue_house_1.setForeground(Color.WHITE);
		position_blue_house_1.setBackground(Color.BLUE);
		position_blue_house_1.setBounds(649, 369, 61, 61);
		frame.getContentPane().add(position_blue_house_1);
		
		JLabel position_blue_house_2 = new JLabel("");
		position_blue_house_2.setOpaque(true);
		position_blue_house_2.setForeground(Color.WHITE);
		position_blue_house_2.setBackground(Color.BLUE);
		position_blue_house_2.setBounds(578, 369, 61, 61);
		frame.getContentPane().add(position_blue_house_2);
		
		JLabel position_blue_house_3 = new JLabel("");
		position_blue_house_3.setOpaque(true);
		position_blue_house_3.setForeground(Color.WHITE);
		position_blue_house_3.setBackground(Color.BLUE);
		position_blue_house_3.setBounds(507, 369, 61, 61);
		frame.getContentPane().add(position_blue_house_3);
		
		JLabel position_blue_house_4 = new JLabel("");
		position_blue_house_4.setOpaque(true);
		position_blue_house_4.setForeground(Color.WHITE);
		position_blue_house_4.setBackground(Color.BLUE);
		position_blue_house_4.setBounds(436, 369, 61, 61);
		frame.getContentPane().add(position_blue_house_4);
		
		JLabel position_green_house_1 = new JLabel("");
		position_green_house_1.setOpaque(true);
		position_green_house_1.setForeground(Color.WHITE);
		position_green_house_1.setBackground(Color.GREEN);
		position_green_house_1.setBounds(365, 657, 61, 61);
		frame.getContentPane().add(position_green_house_1);
		
		JLabel position_green_house_2 = new JLabel("");
		position_green_house_2.setOpaque(true);
		position_green_house_2.setForeground(Color.WHITE);
		position_green_house_2.setBackground(Color.GREEN);
		position_green_house_2.setBounds(365, 585, 61, 61);
		frame.getContentPane().add(position_green_house_2);
		
		JLabel position_green_house_3 = new JLabel("");
		position_green_house_3.setOpaque(true);
		position_green_house_3.setForeground(Color.WHITE);
		position_green_house_3.setBackground(Color.GREEN);
		position_green_house_3.setBounds(365, 513, 61, 61);
		frame.getContentPane().add(position_green_house_3);
		
		JLabel position_green_house_4 = new JLabel("");
		position_green_house_4.setOpaque(true);
		position_green_house_4.setForeground(Color.WHITE);
		position_green_house_4.setBackground(Color.GREEN);
		position_green_house_4.setBounds(365, 441, 61, 61);
		frame.getContentPane().add(position_green_house_4);
		
		JLabel position_orange_house_1 = new JLabel("");
		position_orange_house_1.setOpaque(true);
		position_orange_house_1.setForeground(Color.WHITE);
		position_orange_house_1.setBackground(Color.ORANGE);
		position_orange_house_1.setBounds(365, 83, 61, 61);
		frame.getContentPane().add(position_orange_house_1);
		
		JLabel position_orange_house_2 = new JLabel("");
		position_orange_house_2.setOpaque(true);
		position_orange_house_2.setForeground(Color.WHITE);
		position_orange_house_2.setBackground(Color.ORANGE);
		position_orange_house_2.setBounds(365, 155, 61, 61);
		frame.getContentPane().add(position_orange_house_2);
		
		JLabel position_orange_house_3 = new JLabel("");
		position_orange_house_3.setOpaque(true);
		position_orange_house_3.setForeground(Color.WHITE);
		position_orange_house_3.setBackground(Color.ORANGE);
		position_orange_house_3.setBounds(365, 225, 61, 61);
		frame.getContentPane().add(position_orange_house_3);
		
		JLabel position_orange_house_4 = new JLabel("");
		position_orange_house_4.setOpaque(true);
		position_orange_house_4.setForeground(Color.WHITE);
		position_orange_house_4.setBackground(Color.ORANGE);
		position_orange_house_4.setBounds(365, 297, 61, 61);
		frame.getContentPane().add(position_orange_house_4);
	}

}
