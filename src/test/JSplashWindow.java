package test;
import javax.swing.*;
import java.awt.*;
import java.net.*;
public class JSplashWindow extends JWindow implements Runnable{

	Thread splashThread=null;
	 public JSplashWindow()
	 {
	  setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//������������Ĺ����ʽ
	  JPanel splash=new JPanel(new BorderLayout());
	  URL url=getClass().getResource("1.jpg");//���ָ����Դ�ļ��ľ���·����
	  if(url!=null)
	  {
	   splash.add(new JLabel(new ImageIcon(url)),BorderLayout.CENTER);
	  }
	  setContentPane(splash);
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();//�����Ļ�Ĵ�С
	  pack();
	  setLocation((screen.width-getSize().width)/2,(screen.height-getSize().height)/2);//ʹ�������ھ�����ʾ
	  start();
	 }
	 public void start()
	 {
	  toFront();//window���toFront()��������������������ʾ��ʱ����ʱ����ǰ�棬��window���setAlwayOnTop(boolean)���������ô����ܱ�������ǰ�档
	  splashThread=new Thread(this);
	  splashThread.start();
	 }
	 public void run()
	 {
	  try
	  {
	   setVisible(true);
	   Thread.sleep(50000);
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	  }
	  dispose();
	 }
	 static void showFrame(String title)
	 {
	  JFrame frame=new JFrame(title);
	  frame.setSize(400,300);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  Dimension screenSize=frame.getToolkit().getScreenSize();//�����Ļ�Ĵ�С
	  Dimension frameSize=frame.getSize();
	  if(frameSize.height>screenSize.height)
	  {
	   frameSize.height=screenSize.height;
	  }
	  if(frameSize.width>screenSize.width)
	  {
	   frameSize.width=screenSize.width;
	  }
	  frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	  frame.setVisible(true);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 showFrame("Demo splash window");
		 JSplashWindow splash=new JSplashWindow();
		 splash.start();
	}

}
