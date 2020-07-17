import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ViewFrame extends JFrame
{
	Container c;
	JButton btnback;
	
	TextArea tadata; 
	ViewFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		tadata=new TextArea(10,30);
		btnback=new JButton("back");
		c.add(tadata);
		c.add(btnback);
		
		Dbhandler db=new Dbhandler();
		String data=db.ViewStudent();
		tadata.setText(data);
		
		
	
		ActionListener a1=(ae) -> {
		MainFrame a=new MainFrame();
		dispose();	
		};
		btnback.addActionListener(a1);
		
		setTitle("VIEW DETAILS");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
		
		
