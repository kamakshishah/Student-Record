import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class DeleteFrame extends JFrame
{
	Container c;
	JButton btnsave,btnback;
	JLabel lblerno;
	
	JTextField txterno;
	DeleteFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		btnsave=new JButton("save");
		btnback=new JButton("back");
	lblerno=new JLabel("ROLL NO");
	txterno=new JTextField(15);
	
	c.add(lblerno);
		c.add(txterno);
		c.add(btnsave);
		c.add(btnback);
		
		ActionListener a2=(ae) -> {
			
			try
				{
					SimpleAudioPlayer s = new SimpleAudioPlayer("runjava.wav");	
				}
				catch (Exception e)
				{

				}
			
		int erno=Integer.parseInt(txterno.getText());
		Student s=new Student();
		s.setErno(erno);
		Dbhandler db=new Dbhandler();
		db.deleteStudent(s);
		};
		btnsave.addActionListener(a2);
		
		ActionListener a1=(ae) -> {
		MainFrame a=new MainFrame();
		dispose();	
		};
		btnback.addActionListener(a1);
		
		setTitle("DELETE DETAILS");
		setSize(250,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
			