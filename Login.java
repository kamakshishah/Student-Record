import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

class LoginTest extends JFrame
{
	Container c;
	JLabel lbluser,lblpswrd;
	JTextField txtuser;
	JPasswordField txtpswrd;
	JButton b1;
	JLabel background;
	String s1,s2;

	LoginTest()
	{
		c=getContentPane();
		FlowLayout f=new FlowLayout();
		c.setLayout(f);
		lbluser= new JLabel("Username");
		txtuser=new JTextField(20);
		lblpswrd= new JLabel("Password");
		txtpswrd=new JPasswordField(20);
		txtpswrd.setEchoChar('*');
		b1=new JButton("SUBMIT");
	 background=new JLabel(new ImageIcon("C:\\Users\\Mayur\\Downloads\\final.jpg"));
		//background.setLayout(new FlowLayout());

		c.add(lbluser);
		c.add(txtuser);
		
		c.add(lblpswrd);
		c.add(txtpswrd);
		c.add(b1);
		//c.add(background);
		
		
		
				
		ActionListener a1=(be) ->{
			s1=txtuser.getText();s2=txtpswrd.getText();
			if(s1.equals("kamakshi")&&s2.equals("123"))
			{
				try
				{
					SimpleAudioPlayer s = new SimpleAudioPlayer("runjava.wav");	
				}
				catch (Exception e)
				{

				}
				JOptionPane.showMessageDialog(c,"login successful");
			MainFrame m=new MainFrame();
				dispose();	
				
			}
			else{
				JOptionPane.showMessageDialog(c,"login unsuccessful");
				txtuser.setText("");
				txtpswrd.setText("");
				txtuser.requestFocus();
			}
				
		};
		
	
		b1.addActionListener(a1);
		
		
		setTitle("LOGIN");
		setSize(300,300);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);



	}
}


class Login
{
public static void main (String args[])

{
LoginTest l=new LoginTest();

}
}
class SimpleAudioPlayer
{
	public SimpleAudioPlayer(String filePath) throws Exception
	{
		AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		Clip clip = AudioSystem.getClip();

		clip.open(ais);

		clip.start();
	}
}

