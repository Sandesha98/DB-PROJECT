//updated
package project;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
class GUI
{
     JFrame f, jf, f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,df1,df2,df3,pf,pf1,pf2,pf3,pf4,pf5,mf,mf1,mf2,mf3,wf,wf1,cf1,rf,rf1;
    Container c,c1,c2,c3 ,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,dc1,dc2,dc3,pc,pc1,pc2,pc3,pc4,pc5,mc,mc1,mc2,mc3,wc,wc2,cc1,rc;
    JLabel l,l1,l2,l3, l4,label, bgimg, h1,l5,dltLabel,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,d1,d2,dl,dl1,dl2,dl3,dl4,dl5,dl6,
            p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,rl;
    JTextField tf1, tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,dltTf,dltNurse,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10
            ,st11,st12,st13,dt1,dt2,dtf,dtf1,dtf2,dtf3,dtf4,dtf5,dtf6,dtf7,ptf,ptf1,ptf2,ptf3,ptf4,ptf5,ptf6,dltPatient,rt,rt1,
            pt1,pt2,pt3,pt4,pt5,pt6,pt7,pt8,pt9,pt10,pt11,mt,mt1,mt2,mt3;
    JButton b1,b2,b3,b4,b5,button, b6,b7,b8,b9,insert,update,delete,search , insertNur,delNur,searchNur,updNur,dlt_but,back,dlt_nur,searchBut,searchButt,
            updateButt,pInsrt,pDel,pSear,pUp, pb,pb1,pb2,pb3,pb4,pb5,clear,db1,db2,dlt_pt,mb,mb1,mb2,wb,wb1,doc_sh,nur_sh,ct,rb;
    //String val1,val2,val3;
    Vector v = new Vector();
     Vector v1 = new Vector();
      Vector p = new Vector();
      String data[][];
      String column[];
      JSpinner spinner;
    String opt[]={"ibuprofen","paracetamol","chloroquine","Voltral Emulgel","Risek Capsules 20mg","Risek Capsules 40mg","Motilium Tablets","Mucaine Suspension","Librax Dragees","Sita Met Tablets","Getryl Tablets 2mg","Treviamet Xr 50/500mg","Caldree-600mg","High-C 1000","Acenac Tab 100 MG"};
    JComboBox cb1,cb2,pcb,pcb2;
    DefaultTableModel model1, model2,model3,model4;
    JTable jt1, shw_doc,table,shw_nur,shw_pat,d_pat;
   Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
   Font font1 = new Font("SansSerif", Font.BOLD, 20);
    void Draw()
    {		
        
	f = new JFrame("Hospital Managment System");
	c = f.getContentPane();
	c.setLayout(null);
        ImageIcon ii = new ImageIcon("login.jpeg") ;
        bgimg = new JLabel("",ii,JLabel.CENTER);
        bgimg.setBounds(0,0,626,616);   
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
	l = new JLabel ("Hospital Managment System") ;
        l.setFont(new java.awt.Font("Tahoma" , 1, 30)) ;
	l.setForeground(Color.BLACK);
	l.setBounds(70,10,600,60);
        c.add(l);
       
        tf1 = new JTextField (50);
       tf1.setBounds(220,232,240,49);
        c.add(tf1);
        tf1.setOpaque(false);
    //    tf1.setText("USER ID");
        tf1.setBorder(border);
        tf1.setFont(font1);
    tf2 = new JPasswordField(50);
       tf2.setBounds(220,323,242,49);
        c.add(tf2);
        tf2.setOpaque(false);
        tf2.setBorder(border);
        tf2.setFont(font1);
        b1 = new JButton ();
	b1.setBounds(160,452,295,36);
	b1.setFont(new Font("Arial",Font.BOLD,16));
        c.add(b1);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setFocusable(false);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
            db d = new db();
            if(tf1.getText().equals("")||tf2.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    d.openConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
         
                class db{
        private Connection con;
        private Statement stat;
        public Connection openConnection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
                
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
        String query= "Select * from login";
        stat = con.createStatement();
        boolean flag = false ;
        ResultSet rs = stat.executeQuery(query);
        while (rs.next())
        {
        int i = rs.getInt("user_id");
        String p = rs.getString("password");
        String dsg =rs.getString("designation");
        if((dsg.equals("doc")) && (Integer.parseInt(tf1.getText())==i) && (tf2.getText().equals(p)))
        {
        flag = true;
         ImageIcon ii = new ImageIcon("bg.jpg") ;
        bgimg = new JLabel("",ii,JLabel.CENTER);
        bgimg.setBounds(0,0,626,616); 
        jf = new JFrame("Hospital Managment System");
        f.setVisible(false);
        c1 = jf.getContentPane();
       jf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c1.setLayout(null);
        l1 = new JLabel ("Hospital Managment System") ;
        l1.setFont(new java.awt.Font("Tahoma" , 1, 30)) ;
        l1.setForeground(Color.BLACK);
        l1.setBounds(70,00,600,60);
        c1.add(l1);
       Icon icon = new ImageIcon("b.jpeg");
       back = new JButton(icon);
        back.setBounds(8,15,42,36);
        back.setBorderPainted(false);
        c1.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    jf.setVisible(false);
                    f.setVisible(true);
            }});
        b2 = new JButton ("CHECK PATIENT");
        b2.setBounds(350,100,250,50);
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c1.add(b2);
         b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae)
          {
            cf1 = new JFrame("Hospital Managment System");
            cc1 = cf1.getContentPane();
            cf1.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
            cc1.setLayout(null);
            cc1.add(l1);
            Icon icon = new ImageIcon("b.jpeg");
            back = new JButton(icon);
            back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
            cc1.add(back);
            
            JDateChooser chooser = new JDateChooser();
            chooser.setLocale(Locale.US);

            //JPanel panel = new JPanel();
            JLabel k = new JLabel("SELECT DATE");
           k.setFont(new Font("Arial",Font.BOLD,16));
            k.setForeground(Color.BLACK);
            k.setBounds(100,100,250,50);
            cc1.add(k);
            chooser.setBounds(260,110,190,30);
            chooser.setBackground(Color.WHITE);
        chooser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            cc1.add(chooser);
            
            ct = new JButton ("GO");
            ct.setBounds(460,110,70,32);
            ct.setFont(new Font("Arial",Font.BOLD,16));
            
        ct.setBackground(Color.WHITE);
        ct.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            cc1.add(ct);
            ct.addActionListener(new ActionListener()
            {
          public void actionPerformed(ActionEvent ae)
          {
                model3 = new DefaultTableModel(); 
                shw_pat =new JTable(model3);    
                model3.addColumn("P-ID");
                model3.addColumn("NAME ");
                model3.addColumn("F/NAME");
                model3.addColumn("GENDER");
                model3.addColumn("AGE");
                model3.addColumn("WARD NUM");
                model3.addColumn("D-ID");
                shw_Pat2 pt = new shw_Pat2();
                
                try {
                     pt.connection();
                    } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                  }
                JScrollPane scroll3 = new JScrollPane(shw_pat);
                scroll3.setBounds(5,150,600,200);
                cc1.add(scroll3); 
          }});
           back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    
                    jf.setVisible(true);
                    cf1.setVisible(false);
            }});
                cf1.setFont(font1);
                cc1.add(bgimg);
                cf1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                cf1.setVisible(true);
                cf1.setSize(626,616);
                cf1.setResizable(false);
            }});
        b3 = new JButton ("CHECK PATIENT REPORT");
        b3.setBounds(350,200,250,50);
        b3.setFont(new Font("Arial",Font.BOLD,16));
        c1.add(b3);
        b3.setBackground(Color.WHITE);
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                df2 = new JFrame("Hospital Managment System");
                dc2 = df2.getContentPane();
                df2.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                dc2.setLayout(null);
                dc2.add(l1);
             Icon icon = new ImageIcon("b.jpeg");
       back = new JButton(icon);
        back.setBounds(8,15,42,36);
        back.setBorderPainted(false);
        dc2.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    df2.setVisible(false);
                    jf.setVisible(true);
            }});
                dl1 = new JLabel ("ENTER REPORT ID");
                dl1.setFont(font1) ;
                dl1.setForeground(Color.BLACK);
                dl1.setBounds(50,70,250,50);
                dc2.add(dl1);
                dtf7 = new JTextField (50);
                dtf7.setBounds(260,80,150,30);
              dtf7.setFont(font1);  
                dc2.add(dtf7);
                
                db1 = new JButton("GO");
                db1.setBounds(420,80,65,30);
                db1.setFont(new Font("Arial",Font.BOLD,16));
                
        db1.setBackground(Color.WHITE);
        db1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                dc2.add(db1);
                db1.setBackground(Color.WHITE);
                db1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                db1.addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent ae)
                    {
                        report data11 = new report();

                          if(dtf7.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog (null,"Please Enter Values") ;
                    }
                    else{
                        try {
                            data11.openConnection22();
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    }
                   class report{
                private Connection con;
                public Connection openConnection22() throws SQLException
                {
                    if(con==null)
                    {
                    String url = "jdbc:mysql://localhost/";
                    String dbName="projectdb";
                    String dr="com.mysql.jdbc.Driver"; 

                    String user="root";
                    String pass="";
                    try{
                    Class.forName(dr);
                    this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM DIAGNOSIS_REPORT WHERE report_id =?");
                    stmt.setInt(1,Integer.parseInt(dtf7.getText()));
                    ResultSet rs = stmt.executeQuery();
                    if(rs.next())
                    {
                      dtf2.setText(rs.getInt("report_id")+"");
                      dtf3.setText(rs.getString("details"));  
                      dtf4.setText(rs.getString("remarks"));
                      dtf5.setText(rs.getDate("report_Date")+"");
                      dtf6.setText(rs.getInt("pt_id")+"");
                      
                    }
                     else
                    {
                     JOptionPane.showMessageDialog(null,"Record not found");
                    }
                          con.close();
                     }
                    catch(ClassNotFoundException e)
                    {
                    System.out.println("Not Connected");
                    }
                    }
                    return con;
                }
            }
                });
                
  
                dl2 = new JLabel ("REPORT ID");
                dl2.setFont(font1) ;
                dl2.setForeground(Color.BLACK);
                dl2.setBounds(340,140,250,50);
                dc2.add(dl2);
                
                dtf2 = new JTextField(50);
                dtf2.setBounds(490,155,120,25);
                dc2.add(dtf2);
                
                dl3 = new JLabel ("DETAILS");
                dl3.setFont(font1) ;
                dl3.setForeground(Color.BLACK);
                dl3.setBounds(340,180,250,50);
                dc2.add(dl3);
                
                dtf3 = new JTextField(50);
                dtf3.setBounds(490,195,120,25);
               dtf3.setFont(font1);
                dc2.add(dtf3);
                
                dl4 = new JLabel ("REMARKS");
                dl4.setFont(font1);
                dl4.setForeground(Color.BLACK);
                dl4.setBounds(340,220,250,50);
                dc2.add(dl4);
                
                dtf4 = new JTextField(50);
                dtf4.setBounds(490,235,120,25);
                dtf4.setFont(font1);
                dc2.add(dtf4);
                
                dl5 = new JLabel ("REPORT DATE");
                dl5.setFont(font1);
                dl5.setForeground(Color.BLACK);
                dl5.setBounds(340,260,250,50);
                dc2.add(dl5);
                
                dtf5 = new JTextField(50);
                dtf5.setBounds(490,275,120,25);
                dtf5.setFont(font1);
                dc2.add(dtf5);
                
                dl6 = new JLabel ("PATIENT ID");
                dl6.setFont(font1);
                dl6.setForeground(Color.BLACK);
                dl6.setBounds(340,300,250,50);
                dc2.add(dl6);
                
                dtf6 = new JTextField(50);
                dtf6.setBounds(490,315,120,25);
                dtf6.setFont(font1);
                dc2.add(dtf6);
                db2 = new JButton("CLEAR");
                db2.setBounds(430,350,120,30);
                db2.setFont(new Font("Arial",Font.BOLD,16));
                
        db2.setBackground(Color.WHITE);
        db2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                dc2.add(db2);
                db2.addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent ae)
                    {
                      
                      dtf2.setText("");
                      dtf3.setText("");  
                      dtf4.setText("");
                      dtf5.setText("");
                      dtf6.setText("");
                      dtf7.setText("");
                    }
                });
                dtf2.setFont(font1);
                dc2.add(bgimg);
                df2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                df2.setVisible(true);
                df2.setSize(626,616);
                df2.setResizable(false); 
            }
        });
        /************************************* GIVE MEDICINEE *******************************************/
        
        b4 = new JButton ("GIVE MEDICINE");
        b4.setBounds(350,300,250,50);
        b4.setFont(new Font("Arial",Font.BOLD,16));
        b4.setBackground(Color.WHITE);
        b4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c1.add(b4);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                mf = new JFrame("Hospital Managment System");
                mc = mf.getContentPane();
                mf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                mc.setLayout(null);
                mc.add(l1);
                Icon icon = new ImageIcon("b.jpeg");
                back = new JButton(icon);
                back.setBounds(8,15,42,36);
                back.setBorderPainted(false);
                mc.add(back);
                
                l2 = new JLabel("MEDICINE NAME");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(20,80,200,24);
                mc.add(l2);
                pcb2 = new JComboBox(opt);
                pcb2.setBounds(30,110,150,30);
                pcb2.setBackground(Color.WHITE);
        pcb2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                mc.add(pcb2);
                
                l2 = new JLabel("PATIENT ID");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(210,80,200,24);
                mc.add(l2);           
                
                getP pp = new getP();
                try 
                {
                    pp.connection();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                 pcb.setBounds(220,110 ,70, 30);
                 pcb.setBackground(Color.WHITE);
        pcb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                mc.add(pcb);
                
                l2 = new JLabel("PRICE");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,80,200,24);
                mc.add(l2);
                
                mt = new JTextField (50);
                mt.setBounds(330,110,100,25);
                mt.setBackground(Color.WHITE);
               mt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                mc.add(mt);
                
                mt.setFont(font1);
                
                l2 = new JLabel("QUANTITY");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(450,80,200,24);
                mc.add(l2);
                
         
                spinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
                spinner.setBounds(470,110,50,30); 
                spinner.setBackground(Color.WHITE);
            spinner.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                mc.add(spinner);    
                
                    DefaultTableModel model = new DefaultTableModel(); 
                    JTable jt=new JTable(model);    
                    model.addColumn("PT_ID");
                    model.addColumn("Medicine Name");
                    model.addColumn("Quantity");
                    model.addColumn("Price");
                    JScrollPane scroll = new JScrollPane(jt);
                    scroll.setBounds(30,200,500,200);
                    mc.add(scroll);
                    
                    
                mb = new JButton("NEXT");
                mb.setBounds(230,150,120,30);
                mb.setFont(new Font("Arial",Font.BOLD,16));
        mb.setBackground(Color.WHITE);
        mb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                mc.add(mb);
                mb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {                  
                    if(mt.getText().equals(""))
                    {
                    JOptionPane.showMessageDialog(null,"Please Enter values");
                    }
                else
                    {
                try {
                    DefaultTableModel model = (DefaultTableModel) jt.getModel();
                    model.addRow(new Object[]{pcb.getSelectedItem().toString(), pcb2.getSelectedItem().toString(), spinner.getValue(),mt.getText()});
                    insMed md = new insMed();
                    md.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                }});

                back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {
                    mf.setVisible(false);
                    jf.setVisible(true);
                }});
                mc.add(bgimg);
                mf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                mf.setVisible(true);
                mf.setSize(626,616);
                mf.setResizable(false);
            }
        });back.setBounds(8,15,42,36);
                back.setBorderPainted(false);
               
        b5 = new JButton ("CREATE PATIENT REPORT");
        b5.setBounds(350,400,250,50);
        b5.setFont(new Font("Arial",Font.BOLD,16));
        b5.setBackground(Color.WHITE);
        b5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c1.add(b5);
        b5.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent ae)
           {
                rf = new JFrame("Hospital Managment System");
                rc = rf.getContentPane();
                rf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                rc.setLayout(null);
                rc.add(l1);
                Icon icon = new ImageIcon("b.jpeg");
                back = new JButton(icon);
                back.setBounds(8,15,42,36);
                back.setBorderPainted(false);
                rc.add(back);
                
                rl = new JLabel("PATIENT ID", SwingConstants.CENTER);
                rl.setFont(new Font("Arial",Font.BOLD,16));
                rl.setFont(font1) ;
                rl.setForeground(Color.BLACK);
                rl.setBounds(350,110,200,30);
                rc.add(rl);           
                
                getP pp = new getP();
                try 
                {
                    pp.connection();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                 pcb.setBounds(420,140 ,70, 30);
              pcb.setFont(new Font("Arial",Font.BOLD,16));
                 pcb.setBackground(Color.WHITE);
                pcb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
              rc.add(pcb);
                
                
                rl = new JLabel ("DETAILS", SwingConstants.CENTER) ;
                //rl.setFont(new Font("Arial",Font.BOLD,16));
                rl.setFont(font1) ;
                rl.setForeground(Color.BLACK);
                rl.setBounds(350,180,200,30);
                rc.add(rl);
                
                rt = new JTextField (50);
                rt.setBounds(350,210,200,25);
                 rc.add(rt);
                rt.setFont(font1);
                
                rl = new JLabel ("REMARKS", SwingConstants.CENTER) ;
                rl.setFont(font1) ;
                rl.setForeground(Color.BLACK);
                rl.setBounds(350,240,200,30);
                rc.add(rl);
                
                rt1 = new JTextField (50);
                rt1.setBounds(350,270,200,25);
                rt1.setFont(font1);
                     rc.add(rt1);
                rb = new JButton("SAVE");
                rb.setBounds(410,310,90,30);
                rb.setFont(font1);
                rb.setBackground(Color.WHITE);
                rb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));      
                rc.add(rb);
                rb.addActionListener(new ActionListener()
                {
                    createRep cr = new createRep();
                    public void actionPerformed(ActionEvent ae)
                    {
                         if(rt.getText().equals("")||rt1.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog (null,"Please Enter Values") ;
                       // f4.setVisible(false);
                    }
                    else{
                        try {
                            cr.connection();
                            JOptionPane.showMessageDialog(null, "Added Successfully");
                            rf.setVisible(false);
                        } 
                        catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
                        
                    }
                    
                });
                
                
                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        rf.setVisible(false);
                        jf.setVisible(true);
                    }});
                rc.add(bgimg);
                rf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                rf.setVisible(true);
                rf.setSize(626,616);
                rf.setResizable(false);
           }
        });
        c1.add(bgimg);
        jf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        jf.setVisible(true);
        jf.setSize(626,616);
        jf.setResizable(false); 
        }
        if((dsg.equals("rec"))&& (Integer.parseInt(tf1.getText())==i) && (tf2.getText().equals(p)))
        {
        flag = true;
        ImageIcon ii = new ImageIcon("bg.jpg") ;
        bgimg = new JLabel("",ii,JLabel.CENTER);
        bgimg.setBounds(0,0,626,616); 
        f2 = new JFrame("Hospital Managment System");
        c2 = f2.getContentPane();
       f2.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c2.setLayout(null);
        l1 = new JLabel ("Hospital Managment System") ;
        l1.setFont(new java.awt.Font("Tahoma" , 1, 30)) ;
	l1.setForeground(Color.BLACK);
	l1.setBounds(70,00,600,60);
        c2.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
        back = new JButton(icon);
        back.setBounds(8,15,42,36);
        back.setBorderPainted(false);
        c2.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f2.setVisible(false);
                    f.setVisible(true);
            }});
        b2 = new JButton ("DOCTOR");
        b2.setBounds(350,100,220,40);
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setBackground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c2.add(b2);
        b2.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent ae)
        {
        f3 = new JFrame("Hospital Managment System");
        c3 = f3.getContentPane();
        c3.setLayout(null);
        f3.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c3.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
        back = new JButton(icon);
        back.setBounds(8,15,42,36);
        back.setBorderPainted(false);
        c3.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f3.setVisible(false);
                    f2.setVisible(true);
            }});
        
         insert = new JButton ("INSERT");
        insert.setBounds(350,100,220,40);
        insert.setFont(new Font("Arial",Font.BOLD,16));
         insert.setBackground(Color.WHITE);
        insert.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c3.add(insert);
         insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f4 = new JFrame("Hospital Managment System");
                c4 = f4.getContentPane();
                f4.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                c4.setLayout(null);
                c4.add(l1);
                ImageIcon ii = new ImageIcon("bg.jpg") ;
                bgimg = new JLabel("",ii,JLabel.CENTER);
                bgimg.setBounds(0,0,626,616); 
            Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c4.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f4.setVisible(false);
                    f3.setVisible(true);
            }});
                l2 = new JLabel ("NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,60,200,30);
                c4.add(l2);
                
                tf3 = new JTextField(50);
                tf3.setBounds(350,90,200,25);
                c4.add(tf3);
                tf3.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c4.add(l2);
                
                 tf4 = new JTextField(50);
                tf4.setBounds(350,150,200,25);
                c4.add(tf4);
                tf4.setFont(font1);
               
                l2 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c4.add(l2);
                tf5 = new JTextField(50);
                tf5.setBounds(350,210,200,25);
                c4.add(tf5);
                tf5.setFont(font1);
                
                l3 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                c4.add(l3);
                
                tf6 = new JTextField(50);
                tf6.setBounds(350,270,200,25);
                c4.add(tf6);
                tf6.setFont(font1);                
                
                l4 = new JLabel ("QUALIFICATION", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                c4.add(l4);     
                
                                
                tf7 = new JTextField (50);
                tf7.setBounds(350,330,200,25);
                c4.add(tf7);
                tf7.setFont(font1); 
                
                b6 = new JButton ("NEXT");
                b6.setBounds(390,380,120,30);
                b6.setFont(new Font("Arial",Font.BOLD,16));
               b6.setBackground(Color.WHITE);
        b6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                c4.add(b6);
                b6.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    insert data = new insert();
            if(tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
                //f4.setVisible(false);
                //f4.setVisible(true);
            }
            else{
                try {
                    data.openConnection1();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               
                f5 = new JFrame("Hospital Managment System");
                c5 = f5.getContentPane();
                f5.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
               c5.setLayout(null);
               f5.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                c5.add(l1);
                ImageIcon ii = new ImageIcon("bg.jpg") ;
                bgimg = new JLabel("",ii,JLabel.CENTER);
                bgimg.setBounds(0,0,626,616); 
                Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c5.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f5.setVisible(false);
                    f4.setVisible(true);
            }});
                l2 = new JLabel ("SPECIALIZATION", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,60,200,30);
                c5.add(l2);
                
                tf8 = new JTextField (50);
                tf8.setBounds(350,90,200,25);
                c5.add(tf8);
                tf8.setFont(font1);

                l2 = new JLabel ("POSITION", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c5.add(l2);
                
                    tf9 = new JTextField (50);
                tf9.setBounds(350,150,200,25);
                c5.add(tf9);
                tf9.setFont(font1);
               
                l2 = new JLabel ("DUTY SHIFT", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c5.add(l2);
                
                tf10 = new JTextField (50);
                 tf10.setBounds(350,210,200,25);
                c5.add(tf10);
                
                 b7 = new JButton ("DONE");
                b7.setBounds(400,260,100,30);
                b7.setFont(new Font("Arial",Font.BOLD,16));
                b7.setBackground(Color.WHITE);
              b7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                c5.add(b7);
                b7.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                      insert1 data1 = new insert1();
                 
                  if(tf8.getText().equals("")||tf9.getText().equals("")||tf10.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    data1.openConnection2();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                  
                }
                
                                
                class insert1{
                 private Connection con;
        private Statement stat;
        public Connection openConnection2() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
                
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
      
        String st1 = "insert into doctor(duty_shift,position,specialization,st_id) values(?,?,?,?)";
      stat = con.createStatement();
      ResultSet idMax = stat.executeQuery("select MAX(st_id) st_id from staff");
        int id2 = 0; 
        if ( idMax.next() ){
           id2 = idMax.getInt(1);  
        }
      PreparedStatement stmt1 = con.prepareStatement(st1) ;
      stmt1.setString(1, tf10.getText());  // duty_shift
        stmt1.setString(2, tf9.getText());  //position
        stmt1.setString(3, tf8.getText()); // specialization
        
        stmt1.setInt(4,id2);
        stmt1.executeUpdate();
        JOptionPane.showMessageDialog(null,"Insertion Successful");
        }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
          }   
                });
                
                 c5.add(bgimg);
                f5.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f5.setVisible(true);
                f5.setSize(626,616);
                f5.setResizable(false); 
                
            }
                
                class insert{
                 private Connection con;
       // private Statement stat;
        public Connection openConnection1() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
                
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
        String st = "insert into staff(Name,FatherName,Gender,Age,Qualification,JoiningDate,Designation) values(?,?,?,?,?,current_date(),?)";
        PreparedStatement stmt = con.prepareStatement(st);
        stmt.setString(1, tf3.getText());  //name
        stmt.setString(2, tf4.getText());  //fname
        stmt.setString(3, tf5.getText()); //gender
        stmt.setInt(4, Integer.parseInt(tf6.getText())); //age
        stmt.setString(5, tf7.getText());//qualification
        stmt.setString(6,"doc"); // designation
         int i =stmt.executeUpdate();
      }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
             }
                
          });                
                c4.add(bgimg);
                f4.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f4.setVisible(true);
                f4.setSize(626,616);
                f4.setResizable(false); 
                
            }});
        delete = new JButton ("DELETE");
        delete.setBounds(350,300,220,40);
        delete.setFont(new Font("Arial",Font.BOLD,16));
        delete.setBackground(Color.WHITE);
        delete.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c3.add(delete);
        delete.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f9 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c9 = f9.getContentPane();
        c9.setLayout(null);
        f9.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c9.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c9.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f9.setVisible(false);
                    f3.setVisible(true);
            }});
// *********************************** DOCTOR TABLE *******************************************
                   
                    doc_sh = new JButton ("SHOW ALL DOCTORS");
                    doc_sh.setBounds(180,65,220,30);
                    doc_sh.setFont(new Font("Arial",Font.BOLD,16));
                    doc_sh.setBackground(Color.WHITE);
                    doc_sh.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                    c9.add(doc_sh);
                    doc_sh.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        model2 = new DefaultTableModel(); 
                    shw_doc =new JTable(model2);    
                    model2.addColumn("DOCTOR ID");
                    model2.addColumn("NAME ");
                    model2.addColumn("DUTY SHIFT");
                    model2.addColumn("POSITION");
                    model2.addColumn("SPECIALIZATION");
                    model2.addColumn("STAFF ID");
                        shw_Doc sd = new shw_Doc();
                        try 
                        {
                            sd.connection();
                        } 
                        catch (SQLException ex) 
                        {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JScrollPane scroll2 = new JScrollPane(shw_doc);
                    scroll2.setBounds(5,100,580,250);
                    scroll2.setBackground(Color.WHITE);
                    scroll2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                    c9.add(scroll2);
                    }});  
                     
                   
                dltLabel = new JLabel ("INSERT ID") ;
                dltLabel.setFont(font1) ;
                dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(400,350,260,30);
                c9.add(dltLabel);
                
                dltTf = new JTextField (50);
                dltTf.setBounds(350,380,200,25);
                c9.add(dltTf);
                dltTf.setFont(font1);
                dlt_but = new JButton ("DELETE");
                dlt_but.setBounds(400,420,100,30);
                dlt_but.setFont(new Font("Arial",Font.BOLD,16));
                dlt_but.setBackground(Color.WHITE);
               dlt_but.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                c9.add(dlt_but);
               
            dlt_but.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent a)
            {
            
              delete dlt = new delete();
            if(dltTf.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    dlt.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }            
        }
            }
             class delete
             {
              private Connection con;
        public Connection connection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
           
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "delete doctor,staff from staff inner join doctor on doctor.st_id=staff.st_id where doctor.d_id = ?";
              PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dltTf.getText()));
            int i=stmt.executeUpdate();
         if(i==1)
         {
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
         }
         if(i==0)
         {
         JOptionPane.showMessageDialog(null,"Not Found");
         }
         
            con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
        
             }});     
             
                 c9.add(bgimg);
                f9.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f9.setVisible(true);
                f9.setSize(626,616);
                f9.setResizable(false);  
             }
        });
        search = new JButton ("SEARCH");
        search.setBounds(350,200,220,40);
        search.setFont(new Font("Arial",Font.BOLD,16));
        search.setBackground(Color.WHITE);
        search.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c3.add(search);
        search.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
     
        f11 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c11 = f11.getContentPane();
        c11.setLayout(null);
        f11.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c11.add(l1);
             Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c11.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f11.setVisible(false);
                    f3.setVisible(true);
            }});
            d1 = new JLabel ("DOCTOR ID: ") ;
            d1.setFont(font1) ;
            d1.setForeground(Color.BLACK);
            d1.setBounds(120,50,200,30);
            c11.add(d1);
                
                dt1 = new JTextField (50);
                dt1.setBounds(340,55,140,20);
                c11.add(dt1);
                searchData();
           
            d2 = new JLabel("SPECIALIZATION: ") ;
            d2.setFont(font1) ;
            d2.setForeground(Color.BLACK);
            d2.setBounds(120,380,200,30);
            c11.add(d2);
                
                dt2 = new JTextField (50);
                dt2.setBounds(340,385,140,20);
                c11.add(dt2);
              searchButt=new JButton("SEARCH");
                searchButt.setBounds(210,450,100,40);
                searchButt.setFont(new Font("Arial",Font.BOLD,16));
        searchButt.setBackground(Color.WHITE);
        searchButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c11.add(searchButt);
        clear = new JButton ("CLEAR");
        clear.setBounds(320,450,100,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBackground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c11.add(clear);
         clear.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                dt1.setText("");
                dt2.setText("");
                st2.setText("");
                st3.setText("");
                st4.setText("");
                st5.setText("");
                st6.setText("");
                st7.setText("");
                st8.setText("");
                st9.setText("");
                st10.setText("");
                st11.setText("");
                st13.setText("");
                }
                }); 
              searchButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchDoc data = new searchDoc();
            if(d1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                
                });
                c11.add(bgimg);
                
                f11.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f11.setVisible(true);
                //f.setSize(1235,710);
                f11.setSize(626,616);
                f11.setResizable(false);
             }});
        update = new JButton ("UPDATE");
        update.setBounds(350,400,220,40);
        update.setFont(new Font("Arial",Font.BOLD,16));
        update.setBackground(Color.WHITE);
        update.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c3.add(update);
        update.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f11 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c11 = f11.getContentPane();
        f11.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c11.setLayout(null);
        c11.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c11.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f11.setVisible(false);
                    f3.setVisible(true);
            }});
               d1 = new JLabel ("DOCTOR: ") ;
            d1.setFont(font1) ;
            d1.setForeground(Color.BLACK);
            d1.setBounds(120,50,200,30);
            c11.add(d1);
                
                dt1 = new JTextField (50);
                dt1.setBounds(340,55,140,20);
                c11.add(dt1);
                searchData();
           
                d2 = new JLabel("SPECIALIZATION: ") ;
            d2.setFont(font1) ;
            d2.setForeground(Color.BLACK);
            d2.setBounds(120,380,200,30);
            c11.add(d2);
                
                dt2 = new JTextField (50);
                dt2.setBounds(340,385,140,20);
                c11.add(dt2);
                searchButt=new JButton("SEARCH");
                searchButt.setBounds(180,450,80,40);
                searchButt.setFont(new Font("Arial",Font.BOLD,16));
        searchButt.setBackground(Color.WHITE);
        searchButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c11.add(searchButt);
        clear = new JButton ("CLEAR");
        clear.setBounds(280,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBackground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c11.add(clear);
         clear.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                dt1.setText("");
                dt2.setText("");
                st2.setText("");
                st3.setText("");
                st4.setText("");
                st5.setText("");
                st6.setText("");
                st7.setText("");
                st8.setText("");
                st9.setText("");
                st10.setText("");
                st11.setText("");
                st13.setText("");
                }
                }); 
              searchButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchDoc data = new searchDoc();
            if(dt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                
                });
                updateButt=new JButton("UPDATE");
                updateButt.setBounds(380,450,80,40);
                updateButt.setBackground(Color.WHITE);
                updateButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                c11.add(updateButt);
                updateButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    updateDoc data = new updateDoc();
            if(dt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }       catch (ParseException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
                }
                });
                c11.add(bgimg);
                f11.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f11.setVisible(true);
                //f.setSize(1235,710);
                f11.setSize(626,616);
                f11.setResizable(false);
             }});
        //c3.add(l);
        c3.add(bgimg);
        f3.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
	f3.setVisible(true);
	f3.setSize(626,616);
	f3.setResizable(false); 
        }
        });
        
        
        b3 = new JButton ("PATIENT");
        b3.setBounds(350,300,220,40);
        b3.setFont(new Font("Arial",Font.BOLD,16));
        b3.setBackground(Color.WHITE);
        b3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        c2.add(b3);
        b3.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent ae)
        {
         pf = new JFrame("Hospital Managment System");
         pc = pf.getContentPane();
         pf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
         pc.setLayout(null);
         pc.add(l1);
         Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           pc.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    pf.setVisible(false);
                    f2.setVisible(true);
            }});
          pInsrt = new JButton("INSERT");
         pInsrt.setBounds(350,100,220,40);
         pInsrt.setFont(new Font("Arial",Font.BOLD,16));
         pInsrt.setBackground(Color.WHITE);
        pInsrt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
         pc.add(pInsrt);
         pInsrt.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent ae)
        {
            pf1= new JFrame("Hospital Managment System");
            pc1 = pf1.getContentPane();   
            pc1.setLayout(null);
            pf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
            pc1.add(l1);
            Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            //back.setBorderPainted(false);
           pc1.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    pf1.setVisible(false);
                    pf.setVisible(true);
            }});
                l2 = new JLabel ("NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,60,200,30);
                pc1.add(l2);
                
                ptf = new JTextField (50);
                ptf.setBounds(350,90,200,25);
                pc1.add(ptf);
                ptf.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                pc1.add(l2);
                
                ptf1 = new JTextField (50);
                ptf1.setBounds(350,150,200,25);
                pc1.add(ptf1);
                ptf1.setFont(font1);
               
                l2 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                pc1.add(l2);
                
                ptf2 = new JTextField (50);            
                ptf2.setBounds(350,210,200,25);
                pc1.add(ptf2);
                ptf2.setFont(font1);
                
                l3 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                pc1.add(l3);
                
                ptf3 = new JTextField (50);
                ptf3.setBounds(350,270,200,25);
                pc1.add(ptf3);
                ptf3.setFont(font1);                
                
                l4 = new JLabel ("ADDRESS", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                pc1.add(l4);     
                
                                
                ptf4 = new JTextField (50);
                ptf4.setBounds(350,330,200,25);
                pc1.add(ptf4);
                ptf4.setFont(font1); 
           	
           	l4 = new JLabel ("PHONE NUM", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,360,200,30);
                pc1.add(l4);     
                
                                
                ptf5 = new JTextField (50);
                ptf5.setBounds(350,390,200,25);
                pc1.add(ptf5);
                ptf5.setFont(font1); 
                
                l4 = new JLabel ("DOCTOR ID") ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,420,200,30);
                pc1.add(l4);     
                
                
                l4 = new JLabel ("WARD NUM") ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,450,200,30);
                pc1.add(l4); 
                
                getW w = new getW();
                try 
                {
                    w.connection();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                 cb2.setBounds(490,460 ,70, 30);
                pc1.add(cb2);
                
                getD g = new getD();
                try 
                {
                    g.connection();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                cb1.setBounds(490,420,70,30);
                pc1.add(cb1);
                
                
               
                
                pb2 = new JButton("SAVE");
                pb2.setBounds(400,530,110,40);
                pb2.setFont(new Font("Arial",Font.BOLD,16));
                pb2.setBackground(Color.WHITE);
                pb2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                pc1.add(pb2);
                
                pb2.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                {
                     insPat da = new insPat();
                 
                  
            
                try {
                    da.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
                });
            
            pc1.add(bgimg);
            pf1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
            pf1.setVisible(true);
            pf1.setSize(626,616);
            pf1.setResizable(false);
        }
        });
         
       pDel = new JButton("DELETE");
        pDel.setBounds(350,300,220,40);
        pDel.setFont(new Font("Arial",Font.BOLD,16));
        pDel.setBackground(Color.WHITE);
        pDel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        pc.add(pDel);
        pDel.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f12 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c12 = f12.getContentPane();
        f12.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c12.setLayout(null);
        c12.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c12.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f12.setVisible(false);
                    pf.setVisible(true);
            }});JButton s = new JButton("SHOW ALL PATIENTS");
                  s.setBackground(Color.WHITE);
                   s.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
          s.setBounds(170,65,220,30);
          s.setFont(new Font("Arial",Font.BOLD,16));
          c12.add(s);
          s.addActionListener(new ActionListener() 
          {
            public void actionPerformed(ActionEvent ae)
             {       
                model4 = new DefaultTableModel(); 
                d_pat =new JTable(model4);    
                model4.addColumn("P-ID");
                model4.addColumn("NAME ");
                model4.addColumn("F/NAME");
                model4.addColumn("GENDER");
                model4.addColumn("AGE");
                model4.addColumn("WARD NUM");
                model4.addColumn("DOC ID");
                shw_Pat pt = new shw_Pat();
                try 
                        {
                            pt.connection();
                        } 
                        catch (SQLException ex) 
                        {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                JScrollPane scroll4 = new JScrollPane(d_pat);
                scroll4.setBounds(5,100,580,250);
                c12.add(scroll4);   
             }});
                dltLabel = new JLabel ("INSERT ID") ;
                dltLabel.setFont(font1) ;
               dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(400,350,200,30);
                c12.add(dltLabel);
                
                dltPatient = new JTextField (50);
                dltPatient.setBounds(350,380,200,25);
                c12.add(dltPatient);
                dltPatient.setFont(font1);
               dlt_pt = new JButton ("DELETE");
                dlt_pt.setBounds(400,420,120,30);
                dlt_pt.setFont(new Font("Arial",Font.BOLD,16));
                dlt_pt.setBackground(Color.WHITE);
               dlt_pt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
                c12.add(dlt_pt);
               
            dlt_pt.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent a)
            {
            
                    deletePatient dlt = new deletePatient();
            if(dltPatient.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    dlt.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }            
        }
            }
             });     
             
                 c12.add(bgimg);
                f12.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f12.setVisible(true);
                //f.setSize(1235,710);
                f12.setSize(626,616);
                f12.setResizable(false);  
             }
        }); 
        pSear = new JButton ("SEARCH");
        pSear.setBounds(350,200,220,40);
        pSear.setFont(new Font("Arial",Font.BOLD,16));
        pSear.setBackground(Color.WHITE);
        pSear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
        pc.add(pSear); 
        pSear.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             {
                 f13 = new JFrame("Hospital Managment System");
                c13 = f13.getContentPane();
                f13.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                c13.setLayout(null);
                c13.add(l1);
               Icon icon = new ImageIcon("b.jpeg");
       back = new JButton(icon);
        back.setBounds(8,15,42,36);
        back.setBorderPainted(false);
        c13.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f13.setVisible(false);
                    pf.setVisible(true);
            }});
               searchPatientData();
              searchButt=new JButton("SEARCH");
                searchButt.setBounds(180,450,80,40);
              searchButt.setFont(new Font("Arial",Font.BOLD,16));
        searchButt.setBackground(Color.WHITE);
        searchButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c13.add(searchButt);
         
              searchButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchPatient data = new searchPatient();
            if(pt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                
                });
                c13.add(bgimg);
                f13.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f13.setVisible(true);
                f13.setSize(626,616);
                f13.setResizable(false);
             }});
        pUp = new JButton ("UPDATE");
        pUp.setBounds(350,400,220,40);
        pUp.setFont(new Font("Arial",Font.BOLD,16));
        pUp.setBackground(Color.WHITE);
        pUp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pc.add(pUp);
         pUp.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f13 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c13 = f13.getContentPane();
        f13.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c13.setLayout(null);
        c13.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
          c13.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f13.setVisible(false);
                    pf.setVisible(true);
            }});
                searchPatientData();
           
                searchButt=new JButton("SEARCH");
                searchButt.setBounds(180,450,80,40);
                searchButt.setFont(new Font("Arial",Font.BOLD,16));
        searchButt.setBackground(Color.WHITE);
        searchButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c13.add(searchButt);
              searchButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchPatient data = new searchPatient();
            if(pt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                
                });
                updateButt=new JButton("UPDATE");
                updateButt.setBounds(380,450,80,40);
                updateButt.setFont(new Font("Arial",Font.BOLD,16));
        updateButt.setBackground(Color.WHITE);
        updateButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c13.add(updateButt);
                updateButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    updatePatient data = new updatePatient();
            if(pt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }       catch (ParseException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
                }
                });
                c13.add(bgimg);
                f13.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f13.setVisible(true);
                f13.setSize(626,616);
                f13.setResizable(false);
             }});
         pc.add(bgimg);
         pf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
         pf.setVisible(true);
         pf.setSize(626,616);
         pf.setResizable(false); 
        }
        });

        /*****************************nurse*************/
        b4 = new JButton ("NURSE");
        b4.setBounds(350,200,220,40);
        b4.setFont(new Font("Arial",Font.BOLD,16));
        b4.setBackground(Color.WHITE);
        b4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c2.add(b4);
        b4.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent ae)
        {
        f6 = new JFrame("Hospital Managment System");
        c6 = f6.getContentPane();
        f6.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c6.setLayout(null);
       c6.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c6.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f6.setVisible(false);
                    f2.setVisible(true);
            }}); 
         insertNur = new JButton ("INSERT");
        insertNur.setBounds(350,100,220,40);
        insertNur.setFont(new Font("Arial",Font.BOLD,16));
        insertNur.setBackground(Color.WHITE);
        insertNur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c6.add(insertNur);
         insertNur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f7 = new JFrame("Hospital Managment System");
                c7 = f7.getContentPane();
                f7.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                c7.setLayout(null);
                c7.add(l1);
            Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c7.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f7.setVisible(false);
                    f6.setVisible(true);
            }});
                l2 = new JLabel ("NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,60,200,30);
                c7.add(l2);
                
                tf12 = new JTextField (50);
                tf12.setBounds(350,90,200,25);
                c7.add(tf12);
                tf12.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c7.add(l2);
                
                    tf13 = new JTextField (50);
                tf13.setBounds(350,150,200,25);
                c7.add(tf13);
                tf13.setFont(font1);
               
                l2 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c7.add(l2);
                tf14 = new JTextField (50);
            
                tf14.setBounds(350,210,200,25);
                c7.add(tf14);
                tf14.setFont(font1);
                
                l3 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                c7.add(l3);
                
                tf15 = new JTextField (50);
                tf15.setBounds(350,270,200,25);
                c7.add(tf15);
                tf15.setFont(font1);                
                
                l4 = new JLabel ("QUALIFICATION", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                c7.add(l4);     
                
                                
                tf16 = new JTextField (50);
                tf16.setBounds(350,330,200,25);
                c7.add(tf16);
                tf16.setFont(font1); 
                
                b8 = new JButton ("NEXT");
                b8.setBounds(400,380,100,30);
                b8.setFont(new Font("Arial",Font.BOLD,16));
                b8.setBackground(Color.WHITE);
        b8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c7.add(b8);
                b8.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    insert2 data = new insert2();
            if(tf12.getText().equals("")||tf13.getText().equals("")||tf14.getText().equals("")||tf15.getText().equals("")||tf16.getText().equals(""))
            {
                 JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    data.openConnection1();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                f8 = new JFrame("Hospital Managment System");
                c8 = f8.getContentPane();
                f8.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
             c8.setLayout(null); 
             c8.add(l1);
                Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c8.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f8.setVisible(false);
                    f7.setVisible(true);
            }});
                l2 = new JLabel ("DUTY SHIFT", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,60,200,30);
                c8.add(l2);
                
                tf17 = new JTextField (50);
                tf17.setBounds(350,90,200,25);
                c8.add(tf17);
                tf17.setFont(font1);

                l2 = new JLabel ("WARD NUMBER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c8.add(l2);
                
                    tf18 = new JTextField (50);
                tf18.setBounds(350,150,200,25);
                c8.add(tf18);
                tf18.setFont(font1);
               
                l2 = new JLabel ("POSITION", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c8.add(l2);
                
                tf19 = new JTextField (50);
            
                tf19.setBounds(350,210,200,25);
                c8.add(tf19);
                tf19.setFont(font1);
                
                 b9 = new JButton ("DONE");
                b9.setBounds(400,260,100,30);
                b9.setFont(new Font("Arial",Font.BOLD,16));
                b9.setBackground(Color.WHITE);
        b9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c8.add(b9);
                b9.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                      insert3 da = new insert3();
                 
                  if(tf17.getText().equals("")||tf18.getText().equals("")||tf19.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }
            else{
                try {
                    da.openConnection2();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                  
                }
                
                                
                class insert3{
                 private Connection con;
        private Statement stat;
        public Connection openConnection2() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
                
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
      
        String st2 = "insert into nurse(duty_shift,st_id,ward_num,position) values(?,?,?,?)";
      stat = con.createStatement();
      ResultSet idMax = stat.executeQuery("select MAX(st_id) st_id from staff");
        int id3 = 0; 
        if ( idMax.next() ){
           id3 = idMax.getInt(1);  
        }
      PreparedStatement stmt2 = con.prepareStatement(st2) ;
      stmt2.setString(1, tf17.getText());  // duty_shift
       stmt2.setInt(2,id3); //st_id
       stmt2.setInt(3, Integer.parseInt(tf18.getText()));  //ward num
      //  stmt2.setInt(3, 4);  //ward num
         stmt2.setString(4, tf19.getText()); // position
        int i= stmt2.executeUpdate();
        if(i==1)
        {
        JOptionPane.showMessageDialog(null,"Insertion Successful");
        f8.setVisible(false);
        }
        }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
          }   
                });
                
                 c8.add(bgimg);
                f8.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f8.setVisible(true);
                //f.setSize(1235,710);
                f8.setSize(626,616);
                f8.setResizable(false); 
                
            }
                
                class insert2{
                 private Connection con;
       // private Statement stat;
        public Connection openConnection1() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
                
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
        String st = "insert into staff(Name,FatherName,Gender,Age,Qualification,JoiningDate,Designation) values(?,?,?,?,?,current_date(),?)";
       PreparedStatement stmt = con.prepareStatement(st);
      stmt.setString(1, tf12.getText());  //name
        stmt.setString(2, tf13.getText());  //fname
        stmt.setString(3, tf14.getText()); //gender
        stmt.setInt(4, Integer.parseInt(tf15.getText())); //age
        stmt.setString(5, tf16.getText());//qualification
        stmt.setString(6,"nurse"); // designation
         stmt.executeUpdate();
      }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
             }
                
          });                
                c7.add(bgimg);
                f7.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f7.setVisible(true);
                //f.setSize(1235,710);
                f7.setSize(626,616);
                f7.setResizable(false); 
                
            }
              });
         
        delNur = new JButton ("DELETE");
        delNur.setBounds(350,300,220,40);
        delNur.setFont(new Font("Arial",Font.BOLD,16));
        delNur.setBackground(Color.WHITE);
        delNur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c6.add(delNur);
      
        delNur.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f10 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c10 = f10.getContentPane();
        f10.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c10.setLayout(null);
        c10.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c10.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f10.setVisible(false);
                    f6.setVisible(true);
            }});
                    nur_sh = new JButton ("SHOW ALL NURSES");
                    nur_sh.setBounds(180,65,220,30);
                    nur_sh.setFont(new Font("Arial",Font.BOLD,16));
                    nur_sh.setBackground(Color.WHITE);
                   nur_sh.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                    c10.add(nur_sh);
                    nur_sh.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                    model3 = new DefaultTableModel(); 
                    shw_nur =new JTable(model3);    
                    model3.addColumn("NURSE ID");
                    model3.addColumn("NAME ");
                    model3.addColumn("DUTY SHIFT");
                    model3.addColumn("POSITION");
                    model3.addColumn("WARD NUMBER");
                    model3.addColumn("STAFF ID");
                        shw_Nurse nu = new shw_Nurse();
                        try 
                        {
                            nu.connection1();
                        } 
                        catch (SQLException ex) 
                        {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JScrollPane scroll3 = new JScrollPane(shw_nur);
                    scroll3.setBounds(5,100,580,250);
                    c10.add(scroll3);
                    }});
                dltLabel = new JLabel ("INSERT ID") ;
                dltLabel.setFont(font1) ;
                dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(400,350,260,30);
                c10.add(dltLabel);
                
                  dltNurse = new JTextField (50);
                dltNurse.setBounds(350,380,200,25);
                c10.add(dltNurse);               dltNurse.setFont(font1);
               dlt_nur = new JButton ("DELETE");
                dlt_nur.setBounds(400,420,110,30);
                dlt_nur.setFont(new Font("Arial",Font.BOLD,16));
                dlt_nur.setBackground(Color.WHITE);
                dlt_nur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c10.add(dlt_nur);
               
            dlt_nur.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent a)
            {
            
                    deleteNurse dlt = new deleteNurse();
            if(dltNurse.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
            }

            else{
                try {
                    dlt.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }            
        }
            }
             class deleteNurse
             {
              private Connection con;
        public Connection connection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
           
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "delete nurse,staff from staff inner join nurse on nurse.st_id=staff.st_id where nurse.n_id = ?";
              PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dltNurse.getText()));
         int i=stmt.executeUpdate();
         if(i==1)
         {
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
         }
         if(i==0)
         {
         JOptionPane.showMessageDialog(null,"Not Found");
         }
          con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        }
        
             }});     
             
                 c10.add(bgimg);
                f10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
                f10.setVisible(true);
                //f.setSize(1235,710);
                f10.setSize(626,616);
                f10.setResizable(false);  
             }
        });
      
        searchNur = new JButton ("SEARCH");
        searchNur.setBounds(350,200,220,40);
        searchNur.setFont(new Font("Arial",Font.BOLD,16));
        searchNur.setBackground(Color.WHITE);
        searchNur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c6.add(searchNur);
        searchNur.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
                 f11 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c11 = f11.getContentPane();
        f11.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c11.setLayout(null);
        c11.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           c11.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f11.setVisible(false);
                    f6.setVisible(true);
            }});
        
           s1 = new JLabel ("NURSE ID: ") ;
            s1.setFont(font1) ;
            s1.setForeground(Color.BLACK);
            s1.setBounds(120,50,200,30);
            c11.add(s1);
                
                st1 = new JTextField (50);
                st1.setBounds(340,55,140,20);
                c11.add(st1);
            searchData();    
           s12 = new JLabel ("WARD NUMBER: ") ;
            s12.setFont(font1) ;
            s12.setForeground(Color.BLACK);
            s12.setBounds(120,380,140,30);
            c11.add(s12);
                
                st12 = new JTextField (50);
                st12.setBounds(340,385,140,20);
                c11.add(st12);
                clear = new JButton ("CLEAR");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBackground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c11.add(clear);
         clear.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                st1.setText("");
                st2.setText("");
                st3.setText("");
                st4.setText("");
                st5.setText("");
                st6.setText("");
                st7.setText("");
                st8.setText("");
                st9.setText("");
                st10.setText("");
                st11.setText("");
                st12.setText("");
                st13.setText("");
                }
                });
               searchBut=new JButton("SEARCH");
                searchBut.setBounds(200,450,80,40);
                searchBut.setFont(new Font("Arial",Font.BOLD,16));
        searchBut.setBackground(Color.WHITE);
        searchBut.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c11.add(searchBut);
              searchBut.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchNur data = new searchNur();
            if(st1.getText().equals(""))
            {
               JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                });
                c11.add(bgimg);
                
                f11.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f11.setVisible(true);
                //f.setSize(1235,710);
                f11.setSize(626,616);
                f11.setResizable(false);
             }});
        updNur = new JButton ("UPDATE");
        updNur.setBounds(350,400,220,40);
        updNur.setFont(new Font("Arial",Font.BOLD,16));
        updNur.setBackground(Color.WHITE);
        updNur.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c6.add(updNur);
         updNur.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent a)
             { 
         f11 = new JFrame("Hospital Managment System");
        //f8.setVisible(false);
        c11 = f11.getContentPane();
        f11.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
        c11.setLayout(null);
        c11.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
          c11.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f11.setVisible(false);
                    f6.setVisible(true);
            }});
               s1 = new JLabel ("NURSE ID: ") ;
            s1.setFont(font1) ;
            s1.setForeground(Color.BLACK);
            s1.setBounds(120,50,200,30);
            c11.add(s1);
                
                st1 = new JTextField (50);
                st1.setBounds(340,55,140,20);
                c11.add(st1);
                searchData();
           
            s12 = new JLabel("WARD NUMBER: ") ;
            s12.setFont(font1) ;
            s12.setForeground(Color.BLACK);
            s12.setBounds(120,380,200,30);
            c11.add(s12);
                
                st12 = new JTextField (50);
                st12.setBounds(340,385,200,20);
                c11.add(st12);
                searchButt=new JButton("SEARCH");
                searchButt.setBounds(180,450,80,40);
                searchButt.setFont(new Font("Arial",Font.BOLD,16));
                searchButt.setBackground(Color.WHITE);
        searchButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c11.add(searchButt);
        clear = new JButton ("CLEAR");
        clear.setBounds(280,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBackground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c11.add(clear);
         clear.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                st1.setText("");
                st12.setText("");
                st2.setText("");
                st3.setText("");
                st4.setText("");
                st5.setText("");
                st6.setText("");
                st7.setText("");
                st8.setText("");
                st9.setText("");
                st10.setText("");
                st11.setText("");
                st13.setText("");
                }
                }); 
              searchButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    searchNur data = new searchNur();
            if(st1.getText().equals(""))
            {
                JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }
                
                });
                updateButt=new JButton("UPDATE");
                updateButt.setBounds(380,450,80,40);
                updateButt.setFont(new Font("Arial",Font.BOLD,16));
                updateButt.setBackground(Color.WHITE);
        updateButt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                c11.add(updateButt);
                updateButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    updateNur data = new updateNur();
            if(st1.getText().equals(""))
            {
                 JOptionPane.showMessageDialog (null,"Please Enter Values") ;
               // f4.setVisible(false);
            }
            else{
                try {
                    data.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }       catch (ParseException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
                }
                });
                c11.add(bgimg);
                f11.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f11.setVisible(true);
                f11.setSize(626,616);
                f11.setResizable(false);
             }});
        c6.add(bgimg);
        f6.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
	f6.setVisible(true);
	f6.setSize(626,616);
	f6.setResizable(false); 
        }
        });
        /******************************** CHECKK WARD INFO************************/
        
        b5 = new JButton ("CHECK WARD INFO");
        b5.setBounds(350,400,220,40);
        b5.setFont(new Font("Arial",Font.BOLD,16));
        b5.setBackground(Color.WHITE);
        b5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c2.add(b5);
        b5.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                    wf = new JFrame("Hospital Managment System");
                    wc = wf.getContentPane();
                    wf.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    wc.setLayout(null);
                    wc.add(l1);
                    
                    Icon icon = new ImageIcon("b.jpeg");
                    back = new JButton(icon);
                    back.setBounds(8,15,42,36);
                    back.setBorderPainted(false);
                    wc.add(back);
                    
                    l4 = new JLabel ("WARD NUM") ;
                    l4.setFont(font1) ;
                    l4.setForeground(Color.BLACK);
                    l4.setBounds(70,60,200,30);
                    wc.add(l4); 
                
                    getW w = new getW();
                    try 
                    {
                        w.connection();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cb2.setBounds(210,60 ,70, 30);
                    wc.add(cb2);
                    
                    model1 = new DefaultTableModel(); 
                    jt1=new JTable(model1);    
                    model1.addColumn("PATIENT ID");
                    model1.addColumn("PATIENT NAME");
                    model1.addColumn("NURSE ID");
                    model1.addColumn("WARD NUM");
                    model1.addColumn("WARD Name");
                
                    JScrollPane scroll1 = new JScrollPane(jt1);
                    scroll1.setBounds(5,100,600,200);
                    wc.add(scroll1);
                    
                    
                    
                    wb = new JButton("GO");
                    wb.setBounds(290,60,82,30);
                    wb.setFont(new Font("Arial",Font.BOLD,16));
        wb.setBackground(Color.WHITE);
        wb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                    wc.add(wb);
                    wb.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        searchWard sw = new searchWard();
                        try {
                            sw.connection();
                            } 
                        catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }});
                    
                    back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                         wf.setVisible(false);
                         f2.setVisible(true);
                    }});
                        wc.add(bgimg);
                        wf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                        wf.setVisible(true);
                        wf.setSize(626,616);
                        wf.setResizable(false);
                    }});
        c2.add(bgimg);
        f2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        f2.setVisible(true);
        f2.setSize(626,616);
        f2.setResizable(false);
        }
        }
        if(flag==false)
        {
        JOptionPane.showMessageDialog (null,"Either of the value is incorrect!") ;
        }
        con.close();
        }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        }}}
                );
        

         c.add(bgimg);
       f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
	f.setVisible(true);
	f.setSize(626,616);
	f.setResizable(false); 
    }
   public void searchData(){
                
           s2 = new JLabel ("NAME: ") ;
            s2.setFont(font1) ;
            s2.setForeground(Color.BLACK);
            s2.setBounds(120,80,200,30);
            c11.add(s2);
                
              st2 = new JTextField (50);   //Name
                st2.setBounds(340,85,140,20);
                c11.add(st2);
            s3 = new JLabel ("FATHER NAME: ") ;
            s3.setFont(font1) ;
            s3.setForeground(Color.BLACK);
            s3.setBounds(120,110,200,30);
            c11.add(s3);
                
                st3 = new JTextField (50);  //father name
                st3.setBounds(340,115,140,20);
                c11.add(st3);
            s4 = new JLabel ("GENDER: ") ; 
            s4.setFont(font1) ;
            s4.setForeground(Color.BLACK);
            s4.setBounds(120,140,140,30);
            c11.add(s4);
                
                st4 = new JTextField (50); //gender
                st4.setBounds(340,145,140,20);
                c11.add(st4);
                 s5 = new JLabel ("AGE: ") ;
            s5.setFont(font1) ;
            s5.setForeground(Color.BLACK);
            s5.setBounds(120,170,140,30);
            c11.add(s5);
                
                st5 = new JTextField (50);  //age
                st5.setBounds(340,175,140,20);
                c11.add(st5);
             s6 = new JLabel ("QUALIFICATION: ") ;
            s6.setFont(font1) ;
            s6.setForeground(Color.BLACK);
            s6.setBounds(120,200,200,30);
            c11.add(s6);
                
                st6 = new JTextField (50);
                st6.setBounds(340,205,140,20);
                c11.add(st6);
            s7 = new JLabel ("JOINING DATE: ") ;
            s7.setFont(font1) ;
            s7.setForeground(Color.BLACK);
            s7.setBounds(120,230,200,30);
            c11.add(s7);
                
                st7 = new JTextField (50);
                st7.setBounds(340,235,140,20);
                c11.add(st7);
                s8 = new JLabel ("LEAVING DATE: ") ;
            s8.setFont(font1) ;
            s8.setForeground(Color.BLACK);
            s8.setBounds(120,260,200,30);
            c11.add(s8);
                
                st8 = new JTextField (50);
                st8.setBounds(340,265,140,20);
                c11.add(st8);
                s9 = new JLabel ("DESIGNATION: ") ;
            s9.setFont(font1) ;
            s9.setForeground(Color.BLACK);
            s9.setBounds(120,290,200,30);
            c11.add(s9);
                
                st9 = new JTextField (50);
                st9.setBounds(340,295,140,20);
                c11.add(st9);
                s10 = new JLabel ("STAFF ID: ") ;
            s10.setFont(font1) ;
            s10.setForeground(Color.BLACK);
            s10.setBounds(120,320,140,30);
            c11.add(s10);
                
                st10 = new JTextField (50);
                st10.setBounds(340,325,140,20);
                c11.add(st10);
                s11 = new JLabel ("DUTY SHIFT: ") ;
            s11.setFont(font1) ;
            s11.setForeground(Color.BLACK);
            s11.setBounds(120,350,140,30);
            c11.add(s11);
                
                st11 = new JTextField (50);
                st11.setBounds(340,355,140,20);
                c11.add(st11);
               
                s13 = new JLabel ("POSITION: ") ;
            s13.setFont(font1) ;
            s13.setForeground(Color.BLACK);
            s13.setBounds(120,410,140,30);
            c11.add(s13);
                
                st13 = new JTextField (50);
                st13.setBounds(340,415,140,20);
                c11.add(st13);
           }
    public void searchPatientData(){
            p1 = new JLabel ("PATIENT ID: ") ;
            p1.setFont(font1) ;
            p1.setForeground(Color.BLACK);
            p1.setBounds(80,50,200,30);
            c13.add(p1);
                
                pt1 = new JTextField (50);
                pt1.setBounds(300,50,140,20);
                c13.add(pt1);
           p2 = new JLabel ("NAME: ") ;
            p2.setFont(font1) ;
            p2.setForeground(Color.BLACK);
            p2.setBounds(120,80,200,30);
            c13.add(p2);
                
              pt2 = new JTextField (50);   //Name
                pt2.setBounds(340,85,140,20);
                c13.add(pt2);
            p3 = new JLabel ("FATHER NAME: ") ;
            p3.setFont(font1) ;
            p3.setForeground(Color.BLACK);
            p3.setBounds(120,110,200,30);
            c13.add(p3);
                
                pt3 = new JTextField (50);  //father name
                pt3.setBounds(340,115,140,20);
                c13.add(pt3);
            p4 = new JLabel ("AGE: ") ; 
            p4.setFont(font1) ;
            p4.setForeground(Color.BLACK);
            p4.setBounds(120,140,140,30);
            c13.add(p4);
                
                pt4 = new JTextField (50); //gender
                pt4.setBounds(340,145,140,20);
                c13.add(pt4);
                 p5 = new JLabel ("GENDER: ") ;
            p5.setFont(font1) ;
            p5.setForeground(Color.BLACK);
            p5.setBounds(120,170,140,30);
            c13.add(p5);
                
                pt5 = new JTextField (50);  //age
                pt5.setBounds(340,175,140,20);
                c13.add(pt5);
             p6 = new JLabel ("ADDRESS: ") ;
            p6.setFont(font1) ;
            p6.setForeground(Color.BLACK);
            p6.setBounds(120,200,140,30);
            c13.add(p6);
                
                pt6 = new JTextField (50);
                pt6.setBounds(340,205,140,20);
                c13.add(pt6);
            p7 = new JLabel ("PHONE NUMBER: ") ;
            p7.setFont(font1) ;
            p7.setForeground(Color.BLACK);
            p7.setBounds(120,230,200,30);
            c13.add(p7);
                
                pt7 = new JTextField (50);
                pt7.setBounds(340,235,140,20);
                c13.add(pt7);
                p8 = new JLabel ("ENTRY DATE: ") ;
            p8.setFont(font1) ;
            p8.setForeground(Color.BLACK);
            p8.setBounds(120,260,200,30);
            c13.add(p8);
                
                pt8 = new JTextField (50);
                pt8.setBounds(340,265,140,20);
                c13.add(pt8);
                p9 = new JLabel ("DISCHARGE DATE: ") ;
            p9.setFont(font1) ;
            p9.setForeground(Color.BLACK);
            p9.setBounds(120,290,200,30);
            c13.add(p9);
                
                pt9 = new JTextField (50);
                pt9.setBounds(340,295,140,20);
                c13.add(pt9);
                p10 = new JLabel ("WARD NUMBER: ") ;
            p10.setFont(font1) ;
            p10.setForeground(Color.BLACK);
            p10.setBounds(120,320,200,30);
            c13.add(p10);
                
                pt10 = new JTextField (50);
                pt10.setBounds(340,325,140,20);
                c13.add(pt10);
                p11 = new JLabel ("DOCTOR ID: ") ;
            p11.setFont(font1) ;
            p11.setForeground(Color.BLACK);
            p11.setBounds(120,350,200,30);
            c13.add(p11);
                
                pt11 = new JTextField (50);
                pt11.setBounds(300,350,140,20);
                c13.add(pt11);
                clear = new JButton ("CLEAR");
        clear.setBounds(380,455,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBackground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        c13.add(clear);
         clear.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                {
                pt1.setText("");
                pt2.setText("");
                pt3.setText("");
                pt4.setText("");
                pt5.setText("");
                pt6.setText("");
                pt7.setText("");
                pt8.setText("");
                pt9.setText("");
                pt10.setText("");
                pt11.setText("");
                }
                });
 }
class searchDoc
{
                private Connection con;
         public Connection connection() throws SQLException
         {
         if(con==null)
         {
         String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "SELECT * FROM doctor JOIN staff using(st_id) WHERE d_id=?";
            PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
              st2.setText(rs.getString("Name"));
              st3.setText(rs.getString("FatherName"));
              st4.setText(rs.getString("Gender"));
              st4.setEditable(false);
              st5.setText(rs.getInt("Age")+"");
              st6.setText(rs.getString("Qualification"));
              st7.setText(rs.getDate("JoiningDate")+"");
              st8.setText(rs.getDate("LeavingDate")+"");
              st9.setText(rs.getString("Designation"));
              st9.setEditable(false);
              st10.setText(rs.getInt("st_id")+"");
              st10.setEditable(false);
              st11.setText(rs.getString("duty_shift"));
              dt2.setText(rs.getString("specialization"));
              st13.setText(rs.getString("Position"));
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Record not found");
            }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}
class searchWard
{
         private Connection con;
         public Connection connection() throws SQLException
         {
         if(con==null)
         {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
            
            Class.forName(dr);
            this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
            String val = "SELECT WARD.ward_num,WARD.Ward_Name, nurse.n_id,patient.pt_id,patient.Name FROM ((WARD JOIN nurse using(ward_num)) JOIN patient using(ward_num))";
            PreparedStatement stmt = con.prepareStatement(val);
           // stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
              DefaultTableModel model1 = (DefaultTableModel) jt1.getModel();
              model1.addRow(new Object[]{rs.getInt("pt_id"),rs.getString("Name"), rs.getInt("n_id"),rs.getInt("ward_num"),rs.getString("Ward_Name")});
            }
            
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}
class shw_Doc
{
         private Connection con;
         public Connection connection() throws SQLException
         {
         if(con==null)
         {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
            
            Class.forName(dr);
            this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
            String val = "SELECT d.d_id,s.Name,d.duty_shift,d.position,d.specialization,d.st_id FROM doctor d join staff s using(st_id);";
            PreparedStatement stmt = con.prepareStatement(val);
           // stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
              model2 = (DefaultTableModel) shw_doc.getModel();
              model2.addRow(new Object[]{rs.getInt("d_id"),rs.getString("Name"),rs.getString("duty_shift"), rs.getString("position"),rs.getString("specialization"),rs.getInt("st_id")});
            }
            
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}
class shw_Nurse
{
         private Connection con;
         public Connection connection1() throws SQLException
         {
         if(con==null)
         {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
            
            Class.forName(dr);
            this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
            String val = "SELECT n.n_id,s.Name,n.duty_shift,n.position,n.ward_num,n.st_id FROM nurse n join staff s using(st_id);";
            PreparedStatement stmt = con.prepareStatement(val);
           // stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
              model3 = (DefaultTableModel) shw_nur.getModel();
              model3.addRow(new Object[]{rs.getInt("n_id"),rs.getString("Name"),rs.getString("duty_shift"), rs.getString("position"),rs.getInt("ward_num"),rs.getInt("st_id")});
            }
            
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}

class updateDoc
                {
                private Connection con;
         public Connection connection() throws SQLException, ParseException
         {
         if(con==null)
         {
         String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "Update doctor join staff using(st_id) set name = ?,fathername = ?,age = ?,qualification = ?,JoiningDate = ?,LeavingDate = ?,duty_shift = ?, specialization=?,Position=? where d_id= '"+dt1.getText()+"'";
            PreparedStatement stmt = con.prepareStatement(val);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(st7.getText());
        java.sql.Date d = new java.sql.Date(parsed.getTime());
         SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date pd = format1.parse(st8.getText());
        java.sql.Date d1 = new java.sql.Date(pd.getTime());
         //   stmt.setInt(1,Integer.parseInt(dt1.getText()));
              stmt.setString(1,st2.getText());
              stmt.setString(2,st3.getText());
              stmt.setInt(3,Integer.parseInt(st5.getText()));
              stmt.setString(4,st6.getText());
              stmt.setDate(5,d);
              stmt.setDate(6,d1);
              stmt.setString(7,st11.getText());
               stmt.setString(8,dt2.getText());  
               stmt.setString(9,st13.getText());
                
            int i = stmt.executeUpdate();
            if(i==1)
            {JOptionPane.showMessageDialog(null,"Updated Successfully"); 
            f11.setVisible(false);
            }
            con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
class searchNur
                {
                private Connection con;
        private Statement stat;
        public Connection connection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "SELECT * FROM nurse JOIN staff using(st_id) WHERE n_id=?";
            PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(st1.getText()));
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
              st2.setText(rs.getString("Name"));
              st3.setText(rs.getString("FatherName"));
              st4.setText(rs.getString("Gender"));
              st4.setEditable(false);
              st5.setText(rs.getInt("Age")+"");
              st6.setText(rs.getString("Qualification"));
              st7.setText(rs.getDate("JoiningDate")+"");
              st8.setText(rs.getDate("LeavingDate")+"");
              st9.setText(rs.getString("Designation"));
              st9.setEditable(false);
              st10.setText(rs.getInt("st_id")+"");
              st10.setEditable(false);
              st11.setText(rs.getString("duty_shift"));
              st12.setText(rs.getInt("Ward_num")+"");
              st13.setText(rs.getString("Position"));
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Record not found");
            }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
class deletePatient
             {
              private Connection con;
        public Connection connection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "delete from patient where pt_id = ?";
              PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dltPatient.getText()));
            int i=stmt.executeUpdate();
         if(i==1)
         {
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
         }
         if(i==0)
         {
         JOptionPane.showMessageDialog(null,"Not Found");
         }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
class searchPatient
                {
                private Connection con;
        public Connection connection() throws SQLException
        {
        if(con==null)
        {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
       String val = "SELECT * FROM patient WHERE pt_id=?";
            PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(pt1.getText()));
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
              pt2.setText(rs.getString("Name"));
              pt3.setText(rs.getString("FatherName"));
              pt4.setText(rs.getInt("Age")+"");
              pt5.setText(rs.getString("Gender"));
              pt5.setEditable(false);
              pt6.setText(rs.getString("Address"));
              pt7.setText(rs.getString("PhoneNumber"));
              pt8.setText(rs.getDate("EntryDate")+"");
              pt9.setText(rs.getDate("DischargeDate")+"");
              pt10.setText(rs.getInt("ward_Num")+"");
              //pt10.setEditable(false);
              pt11.setText(rs.getInt("d_id")+"");
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Record not found");
            }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
   class updateNur
                {
                private Connection con;
         public Connection connection() throws SQLException, ParseException
         {
         if(con==null)
         {
         String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
      String val = "Update Nurse join staff using(st_id) set name = ?,fathername = ?,age = ?,qualification = ?,JoiningDate = ?,LeavingDate = ?,duty_shift = ?,ward_num=?, Position=? where n_id= '"+st1.getText()+"'";
            PreparedStatement stmt = con.prepareStatement(val);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(st7.getText());
        java.sql.Date d = new java.sql.Date(parsed.getTime());
         SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date pd = format1.parse(st8.getText());
        java.sql.Date d1 = new java.sql.Date(pd.getTime());
         //   stmt.setInt(1,Integer.parseInt(dt1.getText()));
              stmt.setString(1,st2.getText());
              stmt.setString(2,st3.getText());
              stmt.setInt(3,Integer.parseInt(st5.getText()));
              stmt.setString(4,st6.getText());
              stmt.setDate(5,d);
              stmt.setDate(6,d1);
              stmt.setString(7,st11.getText());
               stmt.setInt(8,Integer.parseInt(st12.getText()));  
               stmt.setString(9,st13.getText());
               int i= stmt.executeUpdate();
            if(i==1)
            {JOptionPane.showMessageDialog(null,"Updated Successfully"); 
           f11.setVisible(false);
            }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
   class updatePatient
                {
                private Connection con;
         public Connection connection() throws SQLException, ParseException
         {
         if(con==null)
         {
         String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
        Class.forName(dr);
        this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
      String val = "Update patient set name = ? , fathername = ?,age = ?,Address= ?,PhoneNumber=?,EntryDate = ?,DischargeDate = ?,ward_num=?, d_id=? where pt_id= '"+pt1.getText()+"'";
            PreparedStatement stmt = con.prepareStatement(val);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(pt8.getText());
        java.sql.Date d = new java.sql.Date(parsed.getTime());
         SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date pd = format1.parse(pt9.getText());
        java.sql.Date d1 = new java.sql.Date(pd.getTime());
         //   stmt.setInt(1,Integer.parseInt(dt1.getText()));
              stmt.setString(1,pt2.getText());
              stmt.setString(2,pt3.getText());
              stmt.setInt(3,Integer.parseInt(pt4.getText()));
              stmt.setString(4,pt6.getText());
              stmt.setString(5,pt7.getText());
              stmt.setDate(6,d);
              stmt.setDate(7,d1);
               stmt.setInt(8,Integer.parseInt(pt10.getText()));  
               stmt.setInt(9,Integer.parseInt(pt11.getText()));
                 int i=stmt.executeUpdate();
            if(i==1)
            {JOptionPane.showMessageDialog(null,"Updated Successfully"); 
            f13.setVisible(false);
            }
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }}
   class shw_Pat
{
         private Connection con;
         public Connection connection() throws SQLException
         {
         if(con==null)
         {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
            
            Class.forName(dr);
            this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
            String val = "SELECT pt_id, Name,fatherName,Gender,Age,ward_num,d_id FROM patient;";
            PreparedStatement stmt = con.prepareStatement(val);
           // stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
              model4 = (DefaultTableModel) d_pat.getModel();
              model4.addRow(new Object[]{rs.getInt("pt_id"),rs.getString("Name"),rs.getString("fatherName"),rs.getString("Gender"), rs.getString("Age"),rs.getInt("ward_num"),rs.getInt("d_id")});
            }
            
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}
class shw_Pat2
{
         private Connection con;
         public Connection connection() throws SQLException
         {
         if(con==null)
         {
        String url = "jdbc:mysql://localhost/";
        String dbName="projectdb";
        String dr="com.mysql.jdbc.Driver"; 
        String user="root";
        String pass="";
        try{
            
            Class.forName(dr);
            this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
            String val = "SELECT pt_id, Name,fatherName,Gender,Age,ward_num,d_id FROM patient;";
            PreparedStatement stmt = con.prepareStatement(val);
           // stmt.setInt(1,Integer.parseInt(dt1.getText()));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
              model3 = (DefaultTableModel) shw_pat.getModel();
              model3.addRow(new Object[]{rs.getInt("pt_id"),rs.getString("Name"),rs.getString("fatherName"),rs.getString("Gender"), rs.getString("Age"),rs.getInt("ward_num"),rs.getInt("d_id")});
            }
            
         con.close();
             }
        catch(ClassNotFoundException e)
        {
        System.out.println("Not Connected");
        }
        }
        return con;
        
        }
}

class insPat
{
    private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String in = "INSERT INTO patient(Name,fathername,Age,Gender,Address,PhoneNumber,EntryDate,ward_Num,d_id) values(?,?,?,?,?,?,current_date(),?,?)";
                PreparedStatement stmt = con.prepareStatement(in);
                stmt.setString(1,ptf.getText()); //name
                stmt.setString(2, ptf1.getText()); //f-name
                stmt.setInt(3, Integer.parseInt(ptf2.getText())); //age 
                stmt.setString(4, ptf3.getText()); //gender 
                stmt.setString(5, ptf4.getText()); //Add
                stmt.setString(6, ptf5.getText()); //Ph#
                String val = cb1.getSelectedItem().toString();
                String val1 = cb2.getSelectedItem().toString();
                int i = Integer.parseInt(val1); // ward_num
                int ii = Integer.parseInt(val); // d_id
                stmt.setInt(7, i);
                stmt.setInt(8, ii);
                int j=stmt.executeUpdate();
                
                if(j==1)
                {
                JOptionPane.showMessageDialog(null,"Updated Successfully");
                }con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        
        }
             }
/********** MEDICINE INSERT**************/
class insMed
{
    private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String in = "INSERT INTO Medicine(Med_name,pt_id,price,Quantity) value(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(in);
                stmt.setString(1,pcb2.getSelectedItem().toString()); //m-name
                String val = pcb.getSelectedItem().toString();
                int ii = Integer.parseInt(val); // p_id
                
                stmt.setInt(2, ii); //p-id
               
                stmt.setInt(3, Integer.parseInt(mt.getText())); //price 
                int val1 = (Integer) spinner.getValue();
                
                stmt.setInt(4, val1); //Quantity 
                
                
                stmt.executeUpdate();
                con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        
        }
             }
class getD
{
 private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String d = "select d_id from doctor" ;
                PreparedStatement stmt = con.prepareStatement(d);
               
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    int i = rs.getInt("d_id");
                    v.add(i) ;
                    
                }
                cb1 = new JComboBox(v);
                
                con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        }
}
   class getW
{
 private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String d = "select Ward_Num from WARD" ;
                PreparedStatement stmt = con.prepareStatement(d);
               
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    int x = rs.getInt("Ward_Num");
                    v1.add(x) ;
                    
                }
                cb2 = new JComboBox(v1);
                
                con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        }
}
   /******** GET PATIENT ID **************/
    class getP
{
 private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String d = "select pt_id from patient" ;
                PreparedStatement stmt = con.prepareStatement(d);
               
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    int x = rs.getInt("pt_id");
                    p.add(x) ;
                    
                }
                pcb = new JComboBox(p);
                
                con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        }
}
class createRep
{
    private Connection con;
    private Statement stat;
    public Connection connection() throws SQLException
        {
           if(con==null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName="projectdb";
            String dr="com.mysql.jdbc.Driver"; 
            String user="root";
            String pass="";
            try{
                Class.forName(dr);
                this.con =(Connection)DriverManager.getConnection(url+dbName,user,pass);
                String in = "INSERT INTO DIAGNOSIS_REPORT(details,remarks,report_Date,pt_id) value(?,?,current_date(),?)";
                PreparedStatement stmt = con.prepareStatement(in);
                stmt.setString(1,rt.getText());//details
                stmt.setString(2, rt1.getText()); //remarks 
                String val = pcb.getSelectedItem().toString();
                int ii = Integer.parseInt(val); // p_id
                stmt.setInt(3, ii); //p-id 
                stmt.executeUpdate();
                con.close();
            }
            catch(ClassNotFoundException e)
            {
            System.out.println("Not Connected");
            }
        }
        return con;
        
}
 }
}
public class Main{

    public static void main(String[] args) {
        GUI g = new GUI();     
          g.Draw(); 
    }
    
}
