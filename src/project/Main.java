package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
class GUI
{
     JFrame f, jf, f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,df1,df2,df3,pf,pf1,pf2,pf3,pf4,pf5,mf,mf1,mf2,mf3,wf,wf1;
    Container c,c1,c2,c3 ,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,dc1,dc2,dc3,pc,pc1,pc2,pc3,pc4,pc5,mc,mc1,mc2,mc3,wc,wc2;
    JLabel l,l1,l2,l3, l4,label, bgimg, h1,l5,dltLabel,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,d1,d2,dl,dl1,dl2,dl3,dl4,dl5,dl6,
            p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
    JTextField tf1, tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,dltTf,dltNurse,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10
            ,st11,st12,st13,dt1,dt2,dtf,dtf1,dtf2,dtf3,dtf4,dtf5,dtf6,dtf7,ptf,ptf1,ptf2,ptf3,ptf4,ptf5,ptf6,dltPatient,
            pt1,pt2,pt3,pt4,pt5,pt6,pt7,pt8,pt9,pt10,pt11,mt,mt1,mt2,mt3;
    JButton b1,b2,b3,b4,b5,button, b6,b7,b8,b9,insert,update,delete,search , insertNur,delNur,searchNur,updNur,dlt_but,back,dlt_nur,searchBut,searchButt,
            updateButt,pb,pb1,pb2,pb3,pb4,pb5,clear,db1,db2,dlt_pt,mb,mb1,mb2,wb,wb1,doc_sh;
    //String val1,val2,val3;
    Vector v = new Vector();
     Vector v1 = new Vector();
      Vector p = new Vector();
      String data[][];
      String column[];
      JSpinner spinner;
    String opt[]={"ibuprofen","paracetamol","chloroquine","Voltral Emulgel","Risek Capsules 20mg","Risek Capsules 40mg","Motilium Tablets","Mucaine Suspension","Librax Dragees","Sita Met Tablets","Getryl Tablets 2mg","Treviamet Xr 50/500mg","Caldree-600mg","High-C 1000","Acenac Tab 100 MG"};
    JComboBox cb1,cb2,pcb,pcb2;
    DefaultTableModel model1, model2;
    JTable jt1, shw_doc,table;
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
                JOptionPane.showMessageDialog (f,"Please Enter Values") ;
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
         ImageIcon ii = new ImageIcon("bg.jpeg") ;
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
        b2.setBounds(280,100,250,50);
        b2.setFont(new Font("Arial",Font.BOLD,16));
        c1.add(b2);
        b3 = new JButton ("CHECK PATIENT REPORT");
        b3.setBounds(280,200,250,50);
        b3.setFont(new Font("Arial",Font.BOLD,16));
        c1.add(b3);
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
                dl1 = new JLabel ("Enter Patient Id ");
                dl1.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl1.setForeground(Color.BLACK);
                dl1.setBounds(70,70,250,50);
                dc2.add(dl1);
                dtf7 = new JTextField (50);
                dtf7.setBounds(280,80,150,30);
                dc2.add(dtf7);
                
                db1 = new JButton("GO");
                db1.setBounds(440,80,65,30);
                db1.setFont(new Font("Arial",Font.BOLD,16));
                dc2.add(db1);
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
                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM DIAGNOSIS_REPORT WHERE pt_id =?");
                    stmt.setInt(1,Integer.parseInt(dtf7.getText()));
                    ResultSet rs = stmt.executeQuery();
                    if(rs.next())
                    {
                      dtf2.setText(rs.getInt("pt_id")+"");
                      dtf3.setText(rs.getString("details"));  
                      dtf4.setText(rs.getString("remarks"));
                      dtf5.setText(rs.getDate("report_Date")+"");
                      dtf6.setText(rs.getInt("report_id")+"");
                      
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
                
  
                dl2 = new JLabel ("Patient Id");
                dl2.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl2.setForeground(Color.BLACK);
                dl2.setBounds(330,140,250,50);
                dc2.add(dl2);
                
                dtf2 = new JTextField(50);
                dtf2.setBounds(490,150,120,30);
                dc2.add(dtf2);
                
                dl3 = new JLabel ("Details");
                dl3.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl3.setForeground(Color.BLACK);
                dl3.setBounds(330,180,250,50);
                dc2.add(dl3);
                
                dtf3 = new JTextField(50);
                dtf3.setBounds(490,190,120,30);
                dc2.add(dtf3);
                
                dl4 = new JLabel ("Remarks");
                dl4.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl4.setForeground(Color.BLACK);
                dl4.setBounds(330,220,250,50);
                dc2.add(dl4);
                
                dtf4 = new JTextField(50);
                dtf4.setBounds(490,230,120,30);
                dc2.add(dtf4);
                
                dl5 = new JLabel ("Report Date");
                dl5.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl5.setForeground(Color.BLACK);
                dl5.setBounds(330,260,250,50);
                dc2.add(dl5);
                
                dtf5 = new JTextField(50);
                dtf5.setBounds(490,270,120,30);
                dc2.add(dtf5);
                
                dl6 = new JLabel ("Report Id");
                dl6.setFont(new java.awt.Font("Tahoma" , 1, 22)) ;
                dl6.setForeground(Color.BLACK);
                dl6.setBounds(330,300,250,50);
                dc2.add(dl6);
                
                dtf6 = new JTextField(50);
                dtf6.setBounds(490,310,120,30);
                dc2.add(dtf6);
                db2 = new JButton("CLEAR");
                db2.setBounds(430,350,120,30);
                db2.setFont(new Font("Arial",Font.BOLD,16));
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
        b4.setBounds(280,300,250,50);
        b4.setFont(new Font("Arial",Font.BOLD,16));
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
                
                l2 = new JLabel("Medicine Name ");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(20,80,200,24);
                mc.add(l2);
                pcb2 = new JComboBox(opt);
                pcb2.setBounds(30,110,150,30);
                mc.add(pcb2);
                
                l2 = new JLabel("Patient Id");
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
                mc.add(pcb);
                
                l2 = new JLabel("Price");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,80,200,24);
                mc.add(l2);
                
                mt = new JTextField (50);
                mt.setBounds(350,100,50,40);
                mc.add(mt);
                mt.setOpaque(false);
                mt.setBorder(border);
                mt.setFont(font1);
                
                l2 = new JLabel("Quantity");
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(450,80,200,24);
                mc.add(l2);
                
         
                spinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
                spinner.setBounds(470,110,50,30);    
                mc.add(spinner);    
                
                    DefaultTableModel model = new DefaultTableModel(); 
                    JTable jt=new JTable(model);    
                    model.addColumn("PT_ID");
                    model.addColumn("Medicine Name");
                    model.addColumn("Quantity");
                    model.addColumn("Price");
                    JScrollPane scroll = new JScrollPane(jt);
                    scroll.setBounds(30,200,500,100);
                    mc.add(scroll);
                    
                    
                mb = new JButton("Next");
                mb.setBounds(230,150,120,30);
                mb.setFont(new Font("Arial",Font.BOLD,16));
                mc.add(mb);
                mb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {                  
                    DefaultTableModel model = (DefaultTableModel) jt.getModel();
                    model.addRow(new Object[]{pcb.getSelectedItem().toString(), pcb2.getSelectedItem().toString(), spinner.getValue(),mt.getText()});
                    
                    insMed md = new insMed();
                
                try {
                    md.connection();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
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
               
        b5 = new JButton ("EXIT");
        b5.setBounds(280,400,250,50);
        b5.setFont(new Font("Arial",Font.BOLD,16));
        c1.add(b5);
         b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    System.exit(0);
            }});
        c1.add(bgimg);
        jf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        jf.setVisible(true);
        jf.setSize(626,616);
        jf.setResizable(false); 
        }
        if((dsg.equals("rec"))&& (Integer.parseInt(tf1.getText())==i) && (tf2.getText().equals(p)))
        {
        flag = true;
        ImageIcon ii = new ImageIcon("bg.jpeg") ;
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
        b2.setBounds(280,100,220,40);
        b2.setFont(new Font("Arial",Font.BOLD,16));
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
        insert.setBounds(280,100,220,40);
        insert.setFont(new Font("Arial",Font.BOLD,16));
        c3.add(insert);
         insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f4 = new JFrame("Hospital Managment System");
                c4 = f4.getContentPane();
                f4.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
                c4.setLayout(null);
                c4.add(l1);
                ImageIcon ii = new ImageIcon("bg.jpeg") ;
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
                
                tf3 = new JTextField (50);
                tf3.setBounds(350,80,240,49);
                c4.add(tf3);
                tf3.setOpaque(false);
    //    tf1.setText("USER ID");
                tf3.setBorder(border);
                tf3.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c4.add(l2);
                
                    tf4 = new JTextField (50);
                tf4.setBounds(350,140,240,49);
                c4.add(tf4);
                tf4.setOpaque(false);
    //    tf1.setText("USER ID");
                tf4.setBorder(border);
                tf4.setFont(font1);
               
                l2 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c4.add(l2);
                tf5 = new JTextField (50);
            
                tf5.setBounds(350,200,240,49);
                c4.add(tf5);
                tf5.setOpaque(false);
    //    tf1.setText("USER ID");
                tf5.setBorder(border);
                tf5.setFont(font1);
                
                l3 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                c4.add(l3);
                
                tf6 = new JTextField (50);
                tf6.setBounds(350,260,240,49);
                c4.add(tf6);
                tf6.setOpaque(false);
    //    tf1.setText("USER ID");
                tf6.setBorder(border);
                tf6.setFont(font1);                
                
                l4 = new JLabel ("QUALIFICATION", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                c4.add(l4);     
                
                                
                tf7 = new JTextField (50);
                tf7.setBounds(350,320,240,49);
                c4.add(tf7);
                tf7.setOpaque(false);
    //    tf1.setText("USER ID");
                tf7.setBorder(border);
                tf7.setFont(font1); 
                
                b6 = new JButton ("NEXT");
                b6.setBounds(350,360,180,30);
                b6.setFont(new Font("Arial",Font.BOLD,16));
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
                ImageIcon ii = new ImageIcon("bg.jpeg") ;
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
                tf8.setBounds(350,80,240,49);
                c5.add(tf8);
                tf8.setOpaque(false);
                tf8.setBorder(border);
                tf8.setFont(font1);

                l2 = new JLabel ("POSITION", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c5.add(l2);
                
                    tf9 = new JTextField (50);
                tf9.setBounds(350,140,240,49);
                c5.add(tf9);
                tf9.setOpaque(false);
                tf9.setBorder(border);
                tf9.setFont(font1);
               
                l2 = new JLabel ("DUTY SHIFT", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c5.add(l2);
                
                tf10 = new JTextField (50);
                 tf10.setBounds(350,200,240,49);
                c5.add(tf10);
                tf10.setOpaque(false);
                tf10.setBorder(border);
                tf10.setFont(font1);
                
                 b7 = new JButton ("DONE");
                b7.setBounds(350,360,180,30);
                b7.setFont(new Font("Arial",Font.BOLD,16));
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
                c4.add(bgimg);
                f4.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
                f4.setVisible(true);
                f4.setSize(626,616);
                f4.setResizable(false); 
                
            }});
        delete = new JButton ("DELETE");
        delete.setBounds(280,300,220,40);
        delete.setFont(new Font("Arial",Font.BOLD,16));
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
                    doc_sh.setBounds(170,65,220,30);
                    doc_sh.setFont(new Font("Arial",Font.BOLD,16));
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
                    c9.add(scroll2);
                    }});  
                     
                   
                dltLabel = new JLabel ("Insert Id to Delete") ;
                dltLabel.setFont(font1) ;
                dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(350,350,260,30);
                c9.add(dltLabel);
                
                dltTf = new JTextField (50);
                dltTf.setBounds(350,360,240,49);
                c9.add(dltTf);
                dltTf.setOpaque(false);
                dltTf.setBorder(border);
                dltTf.setFont(font1);
                dlt_but = new JButton ("DELETE");
                dlt_but.setBounds(350,405,120,30);
                dlt_but.setFont(new Font("Arial",Font.BOLD,16));
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
        search.setBounds(280,200,220,40);
        search.setFont(new Font("Arial",Font.BOLD,16));
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
            d1 = new JLabel ("Doctor id : ") ;
            d1.setFont(font1) ;
            d1.setForeground(Color.BLACK);
            d1.setBounds(80,50,200,30);
            c11.add(d1);
                
                dt1 = new JTextField (50);
                dt1.setBounds(300,50,140,20);
                c11.add(dt1);
                searchData();
           
            d2 = new JLabel("Specialization : ") ;
            d2.setFont(font1) ;
            d2.setForeground(Color.BLACK);
            d2.setBounds(80,380,140,30);
            c11.add(d2);
                
                dt2 = new JTextField (50);
                dt2.setBounds(300,380,140,20);
                c11.add(dt2);
              searchButt=new JButton("Search");
                searchButt.setBounds(200,450,80,40);
                c11.add(searchButt);
        clear = new JButton ("Clear");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
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
                JOptionPane.showMessageDialog (f11,"Please Enter Values") ;
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
        update.setBounds(280,400,220,50);
        update.setFont(new Font("Arial",Font.BOLD,16));
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
               d1 = new JLabel ("Doctor id : ") ;
            d1.setFont(font1) ;
            d1.setForeground(Color.BLACK);
            d1.setBounds(80,50,200,30);
            c11.add(d1);
                
                dt1 = new JTextField (50);
                dt1.setBounds(300,50,140,20);
                c11.add(dt1);
                searchData();
           
                d2 = new JLabel("Specialization : ") ;
            d2.setFont(font1) ;
            d2.setForeground(Color.BLACK);
            d2.setBounds(80,380,140,30);
            c11.add(d2);
                
                dt2 = new JTextField (50);
                dt2.setBounds(300,380,140,20);
                c11.add(dt2);
                searchButt=new JButton("Search");
                searchButt.setBounds(200,450,80,40);
                c11.add(searchButt);
        clear = new JButton ("Clear");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
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
                updateButt=new JButton("Update");
                updateButt.setBounds(400,450,80,40);
                c11.add(updateButt);
                updateButt.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    updateDoc data = new updateDoc();
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
        b3.setBounds(280,300,220,40);
        b3.setFont(new Font("Arial",Font.BOLD,16));
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
         JButton pInsrt = new JButton("INSERT");
         pInsrt.setBounds(280,100,220,40);
         pInsrt.setFont(new Font("Arial",Font.BOLD,16));
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
            back.setBorderPainted(false);
           pf1.add(back);
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
                ptf.setBounds(350,80,240,49);
                pc1.add(ptf);
                ptf.setOpaque(false);
                ptf.setBorder(border);
                ptf.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                pc1.add(l2);
                
                ptf1 = new JTextField (50);
                ptf1.setBounds(350,140,240,49);
                pc1.add(ptf1);
                ptf1.setOpaque(false);
                ptf1.setBorder(border);
                ptf1.setFont(font1);
               
                l2 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                pc1.add(l2);
                
                ptf2 = new JTextField (50);            
                ptf2.setBounds(350,200,240,49);
                pc1.add(ptf2);
                ptf2.setOpaque(false);
                ptf2.setBorder(border);
                ptf2.setFont(font1);
                
                l3 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                pc1.add(l3);
                
                ptf3 = new JTextField (50);
                ptf3.setBounds(350,260,240,49);
                pc1.add(ptf3);
                ptf3.setOpaque(false);
                ptf3.setBorder(border);
                ptf3.setFont(font1);                
                
                l4 = new JLabel ("ADDRESS", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                pc1.add(l4);     
                
                                
                ptf4 = new JTextField (50);
                ptf4.setBounds(350,320,240,49);
                pc1.add(ptf4);
                ptf4.setOpaque(false);
                ptf4.setBorder(border);
                ptf4.setFont(font1); 
           	
           	l4 = new JLabel ("PHONE NUM", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,360,200,30);
                pc1.add(l4);     
                
                                
                ptf5 = new JTextField (50);
                ptf5.setBounds(350,380,240,49);
                pc1.add(ptf5);
                
                
                ptf5.setOpaque(false);
                ptf5.setBorder(border);
                ptf5.setFont(font1); 
                
                l4 = new JLabel ("DOC ID") ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,420,200,30);
                pc1.add(l4);     
                
                
                l4 = new JLabel ("WARD NUM") ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,460,200,30);
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
         
        JButton pDel = new JButton("DELETE");
        pDel.setBounds(280,300,220,40);
        pDel.setFont(new Font("Arial",Font.BOLD,16));
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
            }});
        dltLabel = new JLabel ("Insert Id to delete", SwingConstants.CENTER) ;
                dltLabel.setFont(font1) ;
               dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(350,120,200,30);
                c12.add(dltLabel);
                
                dltPatient = new JTextField (50);
                dltPatient.setBounds(350,140,240,49);
                c12.add(dltPatient);
                dltPatient.setOpaque(false);
    //    tf1.setText("USER ID");
                dltPatient.setBorder(border);
                dltPatient.setFont(font1);
               dlt_pt = new JButton ("DELETE");
                dlt_pt.setBounds(350,200,120,30);
                dlt_pt.setFont(new Font("Arial",Font.BOLD,16));
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
        JButton pSear = new JButton ("SEARCH");
        pSear.setBounds(280,200,220,40);
        pSear.setFont(new Font("Arial",Font.BOLD,16));
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
              searchButt=new JButton("Search");
                searchButt.setBounds(200,450,80,40);
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
        JButton pUp = new JButton ("UPDATE");
        pUp.setBounds(280,400,220,50);
        pUp.setFont(new Font("Arial",Font.BOLD,16));
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
           
                searchButt=new JButton("Search");
                searchButt.setBounds(200,450,80,40);
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
                updateButt=new JButton("Update");
                updateButt.setBounds(400,450,80,40);
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
        b4.setBounds(280,200,220,40);
        b4.setFont(new Font("Arial",Font.BOLD,16));
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
        insertNur.setBounds(280,100,220,40);
        insertNur.setFont(new Font("Arial",Font.BOLD,16));
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
                tf12.setBounds(350,80,240,49);
                c7.add(tf12);
                tf12.setOpaque(false);
                tf12.setBorder(border);
                tf12.setFont(font1);

                l2 = new JLabel ("F/NAME", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c7.add(l2);
                
                    tf13 = new JTextField (50);
                tf13.setBounds(350,140,240,49);
                c7.add(tf13);
                tf13.setOpaque(false);
                tf13.setBorder(border);
                tf13.setFont(font1);
               
                l2 = new JLabel ("GENDER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c7.add(l2);
                tf14 = new JTextField (50);
            
                tf14.setBounds(350,200,240,49);
                c7.add(tf14);
                tf14.setOpaque(false);
                tf14.setBorder(border);
                tf14.setFont(font1);
                
                l3 = new JLabel ("AGE", SwingConstants.CENTER) ;
                l3.setFont(font1) ;
                l3.setForeground(Color.BLACK);
                l3.setBounds(350,240,200,30);
                c7.add(l3);
                
                tf15 = new JTextField (50);
                tf15.setBounds(350,260,240,49);
                c7.add(tf15);
                tf15.setOpaque(false);
                tf15.setBorder(border);
                tf15.setFont(font1);                
                
                l4 = new JLabel ("QUALIFICATION", SwingConstants.CENTER) ;
                l4.setFont(font1) ;
                l4.setForeground(Color.BLACK);
                l4.setBounds(350,300,200,30);
                c7.add(l4);     
                
                                
                tf16 = new JTextField (50);
                tf16.setBounds(350,320,240,49);
                c7.add(tf16);
                tf16.setOpaque(false);
                tf16.setBorder(border);
                tf16.setFont(font1); 
                
                b8 = new JButton ("NEXT");
                b8.setBounds(350,360,180,30);
                b8.setFont(new Font("Arial",Font.BOLD,16));
                c7.add(b8);
                b8.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                    insert2 data = new insert2();
            if(tf12.getText().equals("")||tf13.getText().equals("")||tf14.getText().equals("")||tf15.getText().equals("")||tf16.getText().equals(""))
            {
                JOptionPane.showMessageDialog (f7,"Please Enter Values") ;
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
                tf17.setBounds(350,80,240,49);
                c8.add(tf17);
                tf17.setOpaque(false);
               tf17.setBorder(border);
                tf17.setFont(font1);

                l2 = new JLabel ("WARD NUMBER", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,120,200,30);
                c8.add(l2);
                
                    tf18 = new JTextField (50);
                tf18.setBounds(350,140,240,49);
                c8.add(tf18);
                tf18.setOpaque(false);
                tf18.setBorder(border);
                tf18.setFont(font1);
               
                l2 = new JLabel ("POSITION", SwingConstants.CENTER) ;
                l2.setFont(font1) ;
                l2.setForeground(Color.BLACK);
                l2.setBounds(350,180,200,30);
                c8.add(l2);
                
                tf19 = new JTextField (50);
            
                tf19.setBounds(350,200,240,49);
                c8.add(tf19);
                tf19.setOpaque(false);
                 tf19.setBorder(border);
                tf19.setFont(font1);
                
                 b9 = new JButton ("DONE");
                b9.setBounds(350,360,180,30);
                b9.setFont(new Font("Arial",Font.BOLD,16));
                c8.add(b9);
                b9.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent a)
                { 
                      insert3 da = new insert3();
                 
                  if(tf17.getText().equals("")||tf18.getText().equals("")||tf19.getText().equals(""))
            {
                JOptionPane.showMessageDialog (f8,"Please Enter Values") ;
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
        stmt2.executeUpdate();
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
        delNur.setBounds(280,300,220,40);
        delNur.setFont(new Font("Arial",Font.BOLD,16));
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
        dltLabel = new JLabel ("Insert Id to delete", SwingConstants.CENTER) ;
                dltLabel.setFont(font1) ;
               dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(350,120,200,30);
                c10.add(dltLabel);
                
                  dltNurse = new JTextField (50);
                dltNurse.setBounds(350,140,240,49);
                c10.add(dltNurse);
                dltNurse.setOpaque(false);
    //    tf1.setText("USER ID");
                dltNurse.setBorder(border);
                dltNurse.setFont(font1);
               dlt_nur = new JButton ("DELETE");
                dlt_nur.setBounds(350,200,120,30);
                dlt_nur.setFont(new Font("Arial",Font.BOLD,16));
                c10.add(dlt_nur);
               
            dlt_nur.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent a)
            {
            
                    deleteNurse dlt = new deleteNurse();
            if(tf1.getText().equals("")||tf2.getText().equals(""))
            {
                JOptionPane.showMessageDialog (f4,"Please Enter Values") ;
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
        searchNur.setBounds(280,200,220,40);
        searchNur.setFont(new Font("Arial",Font.BOLD,16));
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
        
           s1 = new JLabel ("Nurse id : ") ;
            s1.setFont(font1) ;
            s1.setForeground(Color.BLACK);
            s1.setBounds(80,50,200,30);
            c11.add(s1);
                
                st1 = new JTextField (50);
                st1.setBounds(300,50,140,20);
                c11.add(st1);
            searchData();    
           s12 = new JLabel ("Ward Number : ") ;
            s12.setFont(font1) ;
            s12.setForeground(Color.BLACK);
            s12.setBounds(80,380,140,30);
            c11.add(s12);
                
                st12 = new JTextField (50);
                st12.setBounds(300,380,140,20);
                c11.add(st12);
                clear = new JButton ("Clear");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
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
               searchBut=new JButton("Search");
                searchBut.setBounds(200,450,80,40);
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
        updNur.setBounds(280,400,220,50);
        updNur.setFont(new Font("Arial",Font.BOLD,16));
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
               s1 = new JLabel ("Nurse id : ") ;
            s1.setFont(font1) ;
            s1.setForeground(Color.BLACK);
            s1.setBounds(80,50,200,30);
            c11.add(s1);
                
                st1 = new JTextField (50);
                st1.setBounds(300,50,140,20);
                c11.add(st1);
                searchData();
           
            s12 = new JLabel("Ward Number : ") ;
            s12.setFont(font1) ;
            s12.setForeground(Color.BLACK);
            s12.setBounds(80,380,140,30);
            c11.add(s12);
                
                st12 = new JTextField (50);
                st12.setBounds(300,380,140,20);
                c11.add(st12);
                searchButt=new JButton("Search");
                searchButt.setBounds(200,450,80,40);
                c11.add(searchButt);
        clear = new JButton ("Clear");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
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
                updateButt=new JButton("Update");
                updateButt.setBounds(400,450,80,40);
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
        b5.setBounds(280,400,220,50);
        b5.setFont(new Font("Arial",Font.BOLD,16));
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
                
           s2 = new JLabel ("Name : ") ;
            s2.setFont(font1) ;
            s2.setForeground(Color.BLACK);
            s2.setBounds(80,80,200,30);
            c11.add(s2);
                
              st2 = new JTextField (50);   //Name
                st2.setBounds(300,80,140,20);
                c11.add(st2);
            s3 = new JLabel ("Father Name : ") ;
            s3.setFont(font1) ;
            s3.setForeground(Color.BLACK);
            s3.setBounds(80,110,140,30);
            c11.add(s3);
                
                st3 = new JTextField (50);  //father name
                st3.setBounds(300,110,140,20);
                c11.add(st3);
            s4 = new JLabel ("Gender : ") ; 
            s4.setFont(font1) ;
            s4.setForeground(Color.BLACK);
            s4.setBounds(80,140,140,30);
            c11.add(s4);
                
                st4 = new JTextField (50); //gender
                st4.setBounds(300,140,140,20);
                c11.add(st4);
                 s5 = new JLabel ("Age : ") ;
            s5.setFont(font1) ;
            s5.setForeground(Color.BLACK);
            s5.setBounds(80,170,140,30);
            c11.add(s5);
                
                st5 = new JTextField (50);  //age
                st5.setBounds(300,170,140,20);
                c11.add(st5);
             s6 = new JLabel ("Qualification : ") ;
            s6.setFont(font1) ;
            s6.setForeground(Color.BLACK);
            s6.setBounds(80,200,140,30);
            c11.add(s6);
                
                st6 = new JTextField (50);
                st6.setBounds(300,200,140,20);
                c11.add(st6);
            s7 = new JLabel ("Joining Date : ") ;
            s7.setFont(font1) ;
            s7.setForeground(Color.BLACK);
            s7.setBounds(80,230,140,30);
            c11.add(s7);
                
                st7 = new JTextField (50);
                st7.setBounds(300,230,140,20);
                c11.add(st7);
                s8 = new JLabel ("Leaving Date : ") ;
            s8.setFont(font1) ;
            s8.setForeground(Color.BLACK);
            s8.setBounds(80,260,140,30);
            c11.add(s8);
                
                st8 = new JTextField (50);
                st8.setBounds(300,260,140,20);
                c11.add(st8);
                s9 = new JLabel ("Designation : ") ;
            s9.setFont(font1) ;
            s9.setForeground(Color.BLACK);
            s9.setBounds(80,290,140,30);
            c11.add(s9);
                
                st9 = new JTextField (50);
                st9.setBounds(300,290,140,20);
                c11.add(st9);
                s10 = new JLabel ("Staff ID : ") ;
            s10.setFont(font1) ;
            s10.setForeground(Color.BLACK);
            s10.setBounds(80,320,140,30);
            c11.add(s10);
                
                st10 = new JTextField (50);
                st10.setBounds(300,320,140,20);
                c11.add(st10);
                s11 = new JLabel ("Duty Shift : ") ;
            s11.setFont(font1) ;
            s11.setForeground(Color.BLACK);
            s11.setBounds(80,350,140,30);
            c11.add(s11);
                
                st11 = new JTextField (50);
                st11.setBounds(300,350,140,20);
                c11.add(st11);
               
                s13 = new JLabel ("Position : ") ;
            s13.setFont(font1) ;
            s13.setForeground(Color.BLACK);
            s13.setBounds(80,410,140,30);
            c11.add(s13);
                
                st13 = new JTextField (50);
                st13.setBounds(300,410,140,20);
                c11.add(st13);
           }
    public void searchPatientData(){
            p1 = new JLabel ("Patient id : ") ;
            p1.setFont(font1) ;
            p1.setForeground(Color.BLACK);
            p1.setBounds(80,50,200,30);
            c13.add(p1);
                
                pt1 = new JTextField (50);
                pt1.setBounds(300,50,140,20);
                c13.add(pt1);
           p2 = new JLabel ("Name : ") ;
            p2.setFont(font1) ;
            p2.setForeground(Color.BLACK);
            p2.setBounds(80,80,200,30);
            c13.add(p2);
                
              pt2 = new JTextField (50);   //Name
                pt2.setBounds(300,80,140,20);
                c13.add(pt2);
            p3 = new JLabel ("Father Name : ") ;
            p3.setFont(font1) ;
            p3.setForeground(Color.BLACK);
            p3.setBounds(80,110,140,30);
            c13.add(p3);
                
                pt3 = new JTextField (50);  //father name
                pt3.setBounds(300,110,140,20);
                c13.add(pt3);
            p4 = new JLabel ("Age : ") ; 
            p4.setFont(font1) ;
            p4.setForeground(Color.BLACK);
            p4.setBounds(80,140,140,30);
            c13.add(p4);
                
                pt4 = new JTextField (50); //gender
                pt4.setBounds(300,140,140,20);
                c13.add(pt4);
                 p5 = new JLabel ("Gender : ") ;
            p5.setFont(font1) ;
            p5.setForeground(Color.BLACK);
            p5.setBounds(80,170,140,30);
            c13.add(p5);
                
                pt5 = new JTextField (50);  //age
                pt5.setBounds(300,170,140,20);
                c13.add(pt5);
             p6 = new JLabel ("Address : ") ;
            p6.setFont(font1) ;
            p6.setForeground(Color.BLACK);
            p6.setBounds(80,200,140,30);
            c13.add(p6);
                
                pt6 = new JTextField (50);
                pt6.setBounds(300,200,140,20);
                c13.add(pt6);
            p7 = new JLabel ("Phone Number : ") ;
            p7.setFont(font1) ;
            p7.setForeground(Color.BLACK);
            p7.setBounds(80,230,140,30);
            c13.add(p7);
                
                pt7 = new JTextField (50);
                pt7.setBounds(300,230,140,20);
                c13.add(pt7);
                p8 = new JLabel ("Entry Date : ") ;
            p8.setFont(font1) ;
            p8.setForeground(Color.BLACK);
            p8.setBounds(80,260,140,30);
            c13.add(p8);
                
                pt8 = new JTextField (50);
                pt8.setBounds(300,260,140,20);
                c13.add(pt8);
                p9 = new JLabel ("Discharge Date : ") ;
            p9.setFont(font1) ;
            p9.setForeground(Color.BLACK);
            p9.setBounds(80,290,140,30);
            c13.add(p9);
                
                pt9 = new JTextField (50);
                pt9.setBounds(300,290,140,20);
                c13.add(pt9);
                p10 = new JLabel ("Ward Number: ") ;
            p10.setFont(font1) ;
            p10.setForeground(Color.BLACK);
            p10.setBounds(80,320,140,30);
            c13.add(p10);
                
                pt10 = new JTextField (50);
                pt10.setBounds(300,320,140,20);
                c13.add(pt10);
                p11 = new JLabel ("Doctor ID : ") ;
            p11.setFont(font1) ;
            p11.setForeground(Color.BLACK);
            p11.setBounds(80,350,140,30);
            c13.add(p11);
                
                pt11 = new JTextField (50);
                pt11.setBounds(300,350,140,20);
                c13.add(pt11);
                clear = new JButton ("Clear");
        clear.setBounds(300,450,80,40);
        clear.setFont(new Font("Arial",Font.BOLD,16));
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
}
public class Main{

    public static void main(String[] args) {
        GUI g = new GUI();     
          g.Draw(); 
    }
    
}
