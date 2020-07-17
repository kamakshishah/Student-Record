import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class AddFrame extends JFrame
{
	Container c;
	JButton btnsave,btnback;
	JLabel lblename,lblerno,lblemarks;
	JTextField txterno,txtename,txtemarks;
	AddFrame()
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
		
		
		
		
		txterno.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(c, "Only numbers are allowed!");
                    txterno.setText(" ");
                }
            }
});
		
		
		
		txtename.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e3){

                char ch = e3.getKeyChar();
                if(Character.isAlphabetic(ch)|| ch == ' '){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only alphabets are allowed!");
                    txtename.setText(" ");
                }
            }
});


		txtemarks.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e4){

                char ch = e4.getKeyChar();
                if(ch< 100 || ch>0){
                }
                else{
                    JOptionPane.showMessageDialog(null, "between  0 to 100");
                    txtemarks.setText(" ");
                }
            }
});

/*
		txtemarks.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e5){

                char ch = e5.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    txtemarks.setText(" ");
                }
            }
});
*/
	
		c.add(lblerno);
		c.add(txterno);
		c.add(lblename);
		c.add(txtename);
		c.add(lblemarks);
		c.add(txtemarks);
		c.add(btnsave);
		c.add(btnback);
		
		
		ActionListener a2=(ae) -> {
		int erno=Integer.parseInt(txterno.getText());
		String ename=txtename.getText();
		int emarks=Integer.parseInt(txtemarks.getText());
		Student s=new Student();
		s.setErno(erno);
		s.setEname(ename);
		s.setEmarks(emarks);
		Dbhandler db=new Dbhandler();
		db.addStudent(s);
		};
		btnsave.addActionListener(a2);
		
		ActionListener a1=(ae) -> {
		MainFrame a=new MainFrame();
		dispose();	
		};
		btnback.addActionListener(a1);
		
		setTitle("ADD DETAILS");
		setSize(250,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
		
		
