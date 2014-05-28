package test;

import java.awt.*;

import javax.swing.*;

public class GridLayoutTest extends JFrame{

	JLabel label1 = new JLabel("ÄãºÃ");
	JTextField text1 = new JTextField(30);
	JButton[] buttons = new JButton[10];
	GridLayout layout = new GridLayout(5, 2);
	public GridLayoutTest() {
		label1 = new JLabel("ÄãºÃ");
		
		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton("°´Å¥" + i);
			this.add(buttons[i]);
		}
		this.setLayout(layout);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridLayoutTest grid = new GridLayoutTest();
	}

}
