package cn.edu.nuc.rsa;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class RsaImpl extends JFrame{

	public static final String DIALOG_TITLE = "RSA公钥算法实现及其应用";
	public static final String ABOUT_MENU_TITLE = "关于";
	public static final String PLAY_MENU_TITLE = "演示";
	JMenuBar menubar = new JMenuBar();
	JMenu aboutMenu = new JMenu(ABOUT_MENU_TITLE);
	JMenu play = new JMenu(PLAY_MENU_TITLE);
	JMenuItem simplePlay = new JMenuItem("简单演示");
	
	public RsaImpl() {
		play.add(simplePlay);
		aboutMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				JDialog about = new JDialog(RsaImpl.this, "about", true);
				about.setSize(300, 200);
				about.setLocation(400, 150);
				about.setVisible(true);
				//aboutMenu.setSelected(false);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menubar.add(play);
		menubar.add(aboutMenu);
		
		this.setJMenuBar(menubar);
		//设置背景图片
		this.setBackGround(new ImageIcon("images/body.jpg"));
		//设置图标
		this.setIconImage(new ImageIcon("images/title1.jpg").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(DIALOG_TITLE);
		this.setSize(800, 494);
		this.setLocation(300, 100);
		//去掉最大化按钮
		this.setResizable(false);
		this.setVisible(true);
	}

	private void setBackGround(ImageIcon imageIcon) {
		JLabel label = new JLabel(imageIcon);
		label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel)this.getContentPane();
		jp.setOpaque(false);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RsaImpl rsaImpl = new RsaImpl();
		System.out.println(rsaImpl.getWidth() + "===" + rsaImpl.getHeight());
	}

}
