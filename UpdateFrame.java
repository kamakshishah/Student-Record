import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class UpdateFrame extends JFrame
{
	Container c;
	JButton btnsave,btnback;
	JLabel lblename,lblerno,lblemarks;
	JTextField txterno,txtename,txtemarks;
	
	
	
	UpdateFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		btnsave=new JButton("save");
		btnback=new JButton("back");
		lblerno=new JLabel("ROLL NO");
		lblename=new JLabel("NAME");
		lblemarks=new JLabel("MARKS");
		txtename=new JTextField(15);
		txterno=new JTextField(15);
		txtemarks=new JTextField(15);
		c.add(lblerno);
		c.add(txterno);
		c.add(lblename);
		c.add(txtename);
		c.add(lblemarks);
		c.add(txtemarks);
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
				String ename=txtename.getText();
		int emarks=Integer.parseInt(txtemarks.getText());
		
		
		Student s=new Student();
		s.setErno(erno);
		s.setEname(ename);
		s.setEmarks(emarks);
	
		Dbhandler db=new Dbhandler();
		db.updateStudent(s);
		};
		btnsave.addActionListener(a2);
		
		ActionListener a1=(ae) -> {
		MainFrame a=new MainFrame();
		dispose();	
		};
		btnback.addActionListener(a1);
		
		setTitle("update DETAILS");
		setSize(250,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
			