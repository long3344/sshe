package sshe.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFrame {

	private static OutputStream os=null;
	private static InputStream is=null;
	private static JTextField jtf=null;
	private static JTextArea jta=null;
	
	public static void main(String[] args) {
		fJM();
		try {
			ServerSocket ss=new ServerSocket(654);
			Socket s=ss.accept();
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			while (true) {
				byte[] b=new byte[1024];
				int len=is.read(b);
				
				String string=new String(b,0,len);
				jta.append("客户端说："+string+"\n");
				if (string.equals("拜拜"))
					break;
				
			}
		} catch (Exception e) {
			
		}
	}

	public static void fJM() {
		JFrame jf=new JFrame("服务器端");
		jtf=new JTextField();
		jta=new JTextArea();
		jf.add(jtf,BorderLayout.NORTH);
		jf.add(jta,BorderLayout.CENTER);
		jtf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=jtf.getText();
				jtf.setText("");
				try {
					os.write(s.getBytes());
				} catch (Exception e2) {
				}
			}
		});
		jf.setSize(250, 250);
		jf.setLocation(100,100);
		jf.setVisible(true);
		
		
	}
}
