import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


class MainFrame extends JFrame
{
	Container c;
	JButton btnadd,btnview,btnupdate,btndelete;
	JLabel lbladd,lblview,lblupdate,lbldelete,lbltitle;
	
	MainFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		btnadd=new JButton("ADD");
		btnview=new JButton("VIEW");
		btnupdate=new JButton("UPDATE");
		btndelete=new JButton("DELETE");
		
		
		lbladd=new JLabel("ADD STUDENT");
		lblview=new JLabel("VIEW STUDENT");
		lblupdate=new JLabel("UPDATE STUDENT ");
		lbldelete=new JLabel("DELETE STUDENT");
		
		
		
		
		lbltitle=new JLabel("THADOMAL SHAHANI ENGINEERING COLLEGE");
		lbltitle.setBounds(100,10,600,50);
		lbladd.setBounds(80,50,200,100);
		lblview.setBounds(80,150,200,100);
		lblupdate.setBounds(80,250,200,100);
		lbldelete.setBounds(80,350,200,100);
		btnadd.setBounds(250,90,100,30);
		btnview.setBounds(250,190,100,30);
		btnupdate.setBounds(250,290,100,30);
		
		btndelete.setBounds(250,390,100,30);
		c.add(lbltitle);
		
		
		c.add(lbladd);
		
		c.add(btnadd);
		c.add(lblview);
		c.add(btnview);
		c.add(lblupdate);
		c.add(btnupdate);
		c.add(lbldelete);
		c.add(btndelete);
		
		ActionListener a1=(ae) -> {
		AddFrame a=new AddFrame();
		this.dispose();	
		};
		btnadd.addActionListener(a1);
		
		ActionListener a2=(ae) -> {
		ViewFrame a4=new ViewFrame();
		this.dispose();	
		};
		btnview.addActionListener(a2);
		
		ActionListener a9=(ae) -> {
		DeleteFrame a8=new DeleteFrame();
		this.dispose();	
		};
		btndelete.addActionListener(a9);
		
				ActionListener a7=(ae) -> {
		UpdateFrame a6=new UpdateFrame();
		this.dispose();	
		};
		btnupdate.addActionListener(a7);
		

		
		
		
			
		setTitle("WELCOME");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class Dbhandler
{
	public void addStudent(Student s)
	{
		
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=null;
		Transaction t=null;
		try
		{
			session = factory.openSession();
			System.out.println("session open");
			t=session.beginTransaction();
			session.save(s);
			t.commit();
			System.out.println("record inserted");
			JOptionPane.showMessageDialog(new JDialog(),"record inserted");
				
		}
		catch(Exception e1)
		{
			System.out.println("issues" + e1);
			t.rollback();
			JOptionPane.showMessageDialog(new JDialog(),"issues"+e1);
				
		}
		finally
		{
			session.close();
			System.out.println("session closed");
		}
	}
	
public String ViewStudent()
	
	{
		StringBuffer sb=new StringBuffer();
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=null;
		//Transaction t=null;
		try
		{
			session = factory.openSession();
			System.out.println("session open");
			java.util.List<Student> s =new java.util.ArrayList<>();
			s=session.createQuery("from Student").list();
			for(Student m : s)
			{
			System.out.println(m.getErno() + " " + m.getEname() + " " + m.getEmarks());
			sb.append(m.getErno() + " " + m.getEname() + " " + m.getEmarks() + "\n");
			}
			

				
		}
		catch(Exception e)
		{
			System.out.println("issues" + e);
			
			JOptionPane.showMessageDialog(new JDialog(),"issues"+e);
				
		}
		finally
		{
			session.close();
			System.out.println("session closed");
		}
		return sb.toString();
	}
	
	public void deleteStudent(Student s)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory factory=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;
try
{
session =factory.openSession();
System.out.println("Session open");
t=session.beginTransaction();
Student s1=null;
s1=(Student)session.get(Student.class,s.getErno());

if(s1!=null)
{

session.delete(s1);

t.commit();
JOptionPane.showMessageDialog(new JDialog()," records deleted");
System.out.println("Record deleted");

}	
else
{
JOptionPane.showMessageDialog(new JDialog()," no entry with such roll number");
t.rollback();
}



}
catch(Exception e)
{
System.out.println("ISSUE :"+e);
JOptionPane.showMessageDialog(new JDialog(),"Issue"+e);
t.rollback();

}
finally
{
session.close();
System.out.println("Session closed");

}
}

public void updateStudent(Student s)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory=cfg.buildSessionFactory();

Session session=null;

Transaction t=null;
try
{
session=factory.openSession();
System.out.println("Session open");
t=session.beginTransaction();


int rno=s.getErno();
Student e=(Student)session.get(Student.class,rno);


if(e!=null)
{
String name=s.getEname();;
e.setEname(name);
int marks=s.getEmarks();
e.setEmarks(marks);
session.save(e);
t.commit();
System.out.println("Record updated");
JOptionPane.showMessageDialog(new JDialog(),"Record Updated");


}
else{
System.out.println("Student record DOES NOT EXIST");
JOptionPane.showMessageDialog(new JDialog(),"Entry with this roll number does no exist");

}
}

catch(Exception e2)
{
System.out.println("ISSUE :"+e2);
JOptionPane.showMessageDialog(new JDialog(),"Issue"+e2);
t.rollback();

}
finally
{
session.close();
System.out.println("Session closed");

}

}

}
	
		
		
		
		
