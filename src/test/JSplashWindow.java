package test;
import javax.swing.*;
import java.awt.*;
import java.net.*;
public class JSplashWindow extends JWindow implements Runnable{

	Thread splashThread=null;
	 public JSplashWindow()
	 {
	  setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置启动界面的光标样式
	  JPanel splash=new JPanel(new BorderLayout());
	  URL url=getClass().getResource("1.jpg");//获得指定资源文件的绝对路径。
	  if(url!=null)
	  {
	   splash.add(new JLabel(new ImageIcon(url)),BorderLayout.CENTER);
	  }
	  setContentPane(splash);
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();//获得屏幕的大小
	  pack();
	  setLocation((screen.width-getSize().width)/2,(screen.height-getSize().height)/2);//使启动窗口居中显示
	  start();
	 }
	 public void start()
	 {
	  toFront();//window类的toFront()方法可以让启动界面显示的时候暂时在最前面，用window类的setAlwayOnTop(boolean)方法可以让窗口总保持在最前面。
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
	  Dimension screenSize=frame.getToolkit().getScreenSize();//获得屏幕的大小
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
