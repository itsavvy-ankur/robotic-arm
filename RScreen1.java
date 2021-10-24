import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;




public class RScreen1 implements ActionListener
 {

   
   static String lpt_add;
   JFrame jf;
   ButtonGroup step_mode = new ButtonGroup();
   ButtonGroup mtr_grp = new ButtonGroup();
   JRadioButton si_step , hf_step,tor_step,mtr_1,mtr_2,mtr_3;
   JButton btn_lft,btn_rt,btn_up,btn_dwn,btn_exit;
   JLabel lblAlert;
   static String motor,mode;


   
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
     public RScreen1(String str)
	{
         RScreen1.lpt_add = str;
         System.out.println(lpt_add);
        
        }
     public RScreen1()
	{
	System.out.println("Motor"+"       "+"Mode");
   	jf=new JFrame("Manual Control Window");
	Toolkit theKit1=jf.getToolkit();
	Dimension wndSize1=theKit1.getScreenSize();
	jf.setBounds((wndSize1.width-800)/2,(wndSize1.height-600)/2,800,600);   
	jf.setResizable(false);
	//jf.setLocation((wndSize1.width-500)/2,(wndSize1.height-500)/2);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	SpringLayout sl1=new SpringLayout();
	Container c1=jf.getContentPane();
        c1.setLayout(sl1);


        lblAlert = new JLabel("Choose Your Motor And Stepping Mode");
        lblAlert.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	c1.add(lblAlert);
	set(110,410,350,35,sl1,lblAlert);





       /*   *************
           Choice of Motors here
         ************ */

        	mtr_1= new JRadioButton("Motor 1");
		mtr_1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

		mtr_2= new JRadioButton("Motor 2");
		mtr_2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
 	
		mtr_3= new JRadioButton("Motor 3");
		mtr_3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

	        mtr_grp.add(mtr_1);
		c1.add(mtr_1);
		set(20,20,150,35,sl1,mtr_1);

		mtr_grp.add(mtr_2);
		c1.add(mtr_2);
 		set(20,60,150,35,sl1,mtr_2);

		mtr_grp.add(mtr_3);
		c1.add(mtr_3);	
		set(20,100,180,35,sl1,mtr_3);	












       /* *********
        Stepping Modes Here
         ************ */

        si_step= new JRadioButton("Single Stepping");
	si_step.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

	hf_step= new JRadioButton("Half Stepping");
	hf_step.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
 
	tor_step= new JRadioButton("High Torque Stepping");
	tor_step.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

        step_mode.add(si_step);
	c1.add(si_step);
	set(200,20,150,35,sl1,si_step);

	step_mode.add(hf_step);
	c1.add(hf_step);
 	set(200,60,150,35,sl1,hf_step);

	step_mode.add(tor_step);
	c1.add(tor_step);	
	set(200,100,180,35,sl1,tor_step);	
  
	


	
	/* ****************************
	Motor Control Buttons   
	***************************** */          

         btn_up = new JButton("UP");
         c1.add(btn_up);
         set(225,180,75,50,sl1,btn_up);
	 btn_up.setEnabled(false);


	 btn_lft = new JButton("LEFT");
         c1.add(btn_lft);
         set(125,240,75,50,sl1,btn_lft);
	 btn_lft.setEnabled(false);

	 btn_rt = new JButton("RIGHT");
         c1.add(btn_rt);
         set(325,240,75,50,sl1,btn_rt);
	 btn_rt.setEnabled(false);

	 btn_dwn = new JButton("DOWN");
         c1.add(btn_dwn);
         set(225,300,75,50,sl1,btn_dwn);
	 btn_dwn.setEnabled(false);


	 JButton back = new JButton("BACK");
	 back.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	 c1.add(back);
	 set(75,475,100,35,sl1,back);


	 JButton btn_exit = new JButton("EXIT");
	 btn_exit.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	 c1.add(btn_exit);
	 set(275,475,100,35,sl1,btn_exit);	 

	/* ****************************
		Action Listeners Here
	***************************** */          
	back.addActionListener(this);
	
	mtr_1.addActionListener(this);
        mtr_2.addActionListener(this);
	mtr_3.addActionListener(this);	
	
	si_step.addActionListener(this);
	hf_step.addActionListener(this);
	tor_step.addActionListener(this);
	btn_exit.addActionListener(this);






	/* *************************************
	JInternal Frame for USB CAM Interfacing
	**************************************** */    

	//JDesktopPane desk = new JDesktopPane();
	      







 }

public void actionPerformed(ActionEvent e)
{

String str = e.getActionCommand();



if(str.equals("BACK"))
  {
   
      new RoboStart().slpt_add=RScreen1.lpt_add;
   //new RoboStart().wk.setVisible(true);
   jf.setVisible(false);
  }

if(e.getSource()==mtr_1||e.getSource()==mtr_2||e.getSource()==mtr_3)
 {
    motor = e.getActionCommand();
    
    System.out.println(motor+" "+mode);
   if(si_step.isSelected()||hf_step.isSelected()||tor_step.isSelected())
    {
     lblAlert.setText("Choose Your Direction Control Buttons");
    }
   else
    lblAlert.setText("Choose Your Stepping Mode");	
}




if(e.getSource()==si_step||e.getSource()==hf_step||e.getSource()==tor_step)
   {

    mode = e.getActionCommand();
  
    System.out.println(motor+" "+mode);
   if(mtr_1.isSelected()||mtr_2.isSelected()||mtr_3.isSelected())
     {
      lblAlert.setText("Choose Your Direction Control Buttons");
     }
   else
    lblAlert.setText("Choose Your Motor");
   }



if(str.equals("Motor 1"))
 {



    btn_lft.setEnabled(true);
    btn_rt.setEnabled(true);
    btn_up.setEnabled(false);
    btn_dwn.setEnabled(false);
  
 }


else if(str.equals("Motor 2"))
 {

 
    btn_up.setEnabled(true);
    btn_dwn.setEnabled(true);
    btn_lft.setEnabled(false);
    btn_rt.setEnabled(false);
   
  }


else if(str.equals("Motor 3"))
 {

   btn_lft.setEnabled(true);
    btn_rt.setEnabled(true);
    btn_up.setEnabled(false);
    btn_dwn.setEnabled(false);
   
 }





 
if(e.getSource()==btn_lft)
  {
   
   

    
  }


if(str.equals("EXIT"))
 { 
  System.out.println("Exiting Application");
  System.exit(-1);
 }


}


   
}
