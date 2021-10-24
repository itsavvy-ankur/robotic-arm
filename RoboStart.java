import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class RoboStart implements ActionListener
 {


JLabel lblCaption;
 JLabel lblAddr,alert;
 JTextField txtAdd;
JFrame wk;
static String lpt_add,slpt_add;
public void set(int a,int b,int c,int d,SpringLayout sl,Component com)
{
Spring e=Spring.constant(a);
Spring f=Spring.constant(b);
Spring g=Spring.constant(c);
Spring h=Spring.constant(d);

SpringLayout.Constraints ar=sl.getConstraints(com);
ar.setX(e);
ar.setY(f);
ar.setWidth(g);
ar.setHeight(h);
}

public RoboStart()
{




	wk = new JFrame("PC Controlled PnP Robotic Arm");
	Toolkit theKit=wk.getToolkit();
	Dimension wndSize=theKit.getScreenSize();
	//wk.setBounds(0,0,448,371);   
	wk.setSize(448,371);
	wk.setLocation((wndSize.width - wk.getWidth())/2,(wndSize.height - wk.getHeight())/2);
	wk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wk.setResizable(false);
	SpringLayout sl=new SpringLayout();
	
	Container c=wk.getContentPane();
                c.setLayout(sl);





lblCaption=new JLabel("Pick & Place Robotic Arm");
lblCaption.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));

c.add(lblCaption);
set(100,25,300,35,sl,lblCaption);


lblAddr = new JLabel("Enter LPT1 Address :");
lblAddr.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
c.add(lblAddr);
set(45,100,150,35,sl,lblAddr);


txtAdd=new JTextField(25);

txtAdd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

txtAdd.setText(RScreen1.lpt_add);
c.add(txtAdd);
set(200,100,200,35,sl,txtAdd);

/*alert = new JLabel();
alert.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
c.add(alert);
set(45,135,150,35,sl,alert);*/





JButton b_ok = new JButton("OK");
b_ok.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
c.add(b_ok);
set(100,180,75,35,sl,b_ok);
b_ok.addActionListener(this);


JButton b_exit = new JButton("EXIT");
b_exit.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
c.add(b_exit);
set(210,180,75,35,sl,b_exit);
b_exit.addActionListener(this);


wk.setVisible(true);


}



public void actionPerformed(ActionEvent e)
{

String str = e.getActionCommand();
String add = "";
add=txtAdd.getText();

 if(str.equals("OK"))
  {	
        
	if(add.equals("")||add.equals("Enter Parallel Port Address"))
	{
	
	
	txtAdd.setText("Enter Parallel Port Address");
		
	//System.out.println(RoboStart.lpt_add);
	} 
	else
	{
	RoboStart.lpt_add = txtAdd.getText();
	wk.setVisible(false);  
   
  	//  RScreen1 ob = new RScreen1(RoboStart.lpt_add);
  	new RScreen1(RoboStart.lpt_add);
   	new RScreen1().jf.setVisible(true); 
	}
   
  }

if(str.equals("EXIT")) 
 {

 System.exit(-1);
  

 }

}




 }





