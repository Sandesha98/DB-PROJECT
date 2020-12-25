package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

class GUI
{
     JFrame f, jf, f2,f3,f4,f5,f6,f7,f8,f9,f10,f11;
    Container c,c1,c2,c3 ,c4,c5,c6,c7,c8,c9,c10,c11;
    FlowLayout fl;
    JLabel l,l1,l2,l3, l4,label, bgimg, h1,l5,dltLabel;
    JTextField tf1, tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,dltTf,dltNurse;
    JButton b1,b2,b3,b4,b5,button, b6,b7,b8,b9,insert,update,delete,search , insertNur,delNur,searchNur,updNur,dlt_but,back,dlt_nur;
    //String val1,val2,val3;
   Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
   JTable table;
   Font font1 = new Font("SansSerif", Font.BOLD, 20);
    void Draw()
    {		
        
	f = new JFrame("Hospital Managment System");
	c = f.getContentPane();
	c.setLayout(null);
        ImageIcon ii = new ImageIcon("login.jpeg") ;
        bgimg = new JLabel("",ii,JLabel.CENTER);
        bgimg.setBounds(0,0,626,616);   
        
	l = new JLabel ("Hospital Managment System") ;
        c.add(l);
        //c.setBackground(Color.cyan);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 5));
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
         ImageIcon ii = new ImageIcon("bg.jpg") ;
        bgimg = new JLabel("",ii,JLabel.CENTER);
        bgimg.setBounds(0,0,626,616); 
        jf = new JFrame("Hospital Managment System");
        f.setVisible(false);
        c1 = jf.getContentPane();
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
        b4 = new JButton ("GIVE MEDICINE");
        b4.setBounds(280,300,250,50);
        b4.setFont(new Font("Arial",Font.BOLD,16));
        c1.add(b4);
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
        //f.setSize(1235,710);
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
        //f.setVisible(false);
        c2.setLayout(null);
        l1 = new JLabel ("Hospital Managment System") ;
        l1.setFont(new java.awt.Font("Tahoma" , 1, 30)) ;
        l1.setForeground(Color.BLACK);
        l1.setBounds(70,00,600,60);
        c2.add(l1); Icon icon = new ImageIcon("b.jpeg");
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
        //11 = new JLabel ("Hospital Managment System") ;
        //11.setFont(new java.awt.Font("Tahoma" , 1, 30)) ;
        //11.setForeground(Color.BLACK);
        //11.setBounds(70,10,600,60);
         insert = new JButton ("INSERT");
        insert.setBounds(280,100,220,40);
        insert.setFont(new Font("Arial",Font.BOLD,16));
        c3.add(insert);
         insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f4 = new JFrame("Hospital Managment System");
                c4 = f4.getContentPane();
                c4.setLayout(null);
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
                JOptionPane.showMessageDialog (f4,"Please Enter Values") ;
                f4.setVisible(false);
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
             
                f4.setVisible(false);  
         
                c5.setLayout(null);
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
                tf8.setBounds(350,80,240,49);
                c5.add(tf8);
                tf8.setOpaque(false);
    //    tf1.setText("USER ID");
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
    //    tf1.setText("USER ID");
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
    //    tf1.setText("USER ID");
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
                 
                  if(tf1.getText().equals("")||tf2.getText().equals(""))
            {
                JOptionPane.showMessageDialog (f4,"Please Enter Values") ;
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
                //f.setSize(1235,710);
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
                //f.setSize(1235,710);
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
                    f6.setVisible(true);
            }});
        dltLabel = new JLabel ("Insert Id to delete", SwingConstants.CENTER) ;
                dltLabel.setFont(font1) ;
               dltLabel.setForeground(Color.BLACK);
                dltLabel.setBounds(350,120,200,30);
                c9.add(dltLabel);
                
                  dltTf = new JTextField (50);
                dltTf.setBounds(350,140,240,49);
                c9.add(dltTf);
                dltTf.setOpaque(false);
    //    tf1.setText("USER ID");
                dltTf.setBorder(border);
                dltTf.setFont(font1);
               dlt_but = new JButton ("DELETE");
                dlt_but.setBounds(350,200,120,30);
                dlt_but.setFont(new Font("Arial",Font.BOLD,16));
                c9.add(dlt_but);
               
            dlt_but.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent a)
            {
            
                    delete dlt = new delete();
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
             class delete
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
       String val = "delete doctor,staff from staff inner join doctor on doctor.st_id=staff.st_id where doctor.d_id = ?";
              PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dltTf.getText()));
            stmt.executeUpdate();
         
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
         //f9.setVisible(false);
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
                //f.setSize(1235,710);
                f9.setSize(626,616);
                f9.setResizable(false);  
             }
        });
        search = new JButton ("SEARCH");
        search.setBounds(280,200,220,40);
        search.setFont(new Font("Arial",Font.BOLD,16));
        c3.add(search);
        update = new JButton ("UPDATE");
        update.setBounds(280,400,220,50);
        update.setFont(new Font("Arial",Font.BOLD,16));
        c3.add(update);
        c3.add(l);
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
        //f.setVisible(false);
        c6.setLayout(null);
      
         insertNur = new JButton ("INSERT");
        insertNur.setBounds(280,100,220,40);
        insertNur.setFont(new Font("Arial",Font.BOLD,16));
        c6.add(insertNur);
         insertNur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                f7 = new JFrame("Hospital Managment System");
                c7 = f7.getContentPane();
                c7.setLayout(null);
                ImageIcon ii = new ImageIcon("bg.jpg") ;
                bgimg = new JLabel("",ii,JLabel.CENTER);
                bgimg.setBounds(0,0,626,616); 
                
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
             
                f8.setVisible(false);  
         
                c8.setLayout(null);
                ImageIcon ii = new ImageIcon("bg.jpg") ;
                bgimg = new JLabel("",ii,JLabel.CENTER);
                bgimg.setBounds(0,0,626,616); 
                
                 
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
     //   String st1 = "insert into doctor(duty_shift,position,specialization) values(?,?,?)" ;
        PreparedStatement stmt = con.prepareStatement(st);
      //  PreparedStatement stmt1 = con.prepareStatement(st1) ;
        //stmt.setInt(1, Integer.parseInt(tf8.getText()));//st_id
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
        c10.setLayout(null);
        c10.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           //c9.add(back);
          back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f9.setVisible(false);
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
       String val = "delete nurse,staff from staff inner join nurse on nurse.st_id=staff.st_id where nurse.n_id = ?";
              PreparedStatement stmt = con.prepareStatement(val);
            stmt.setInt(1,Integer.parseInt(dltNurse.getText()));
            stmt.executeUpdate();
         
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
        // f10.setVisible(false);
         //f9.setVisible(false);
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
                f10.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
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
        c11.setLayout(null);
        c11.add(l1);
        Icon icon = new ImageIcon("b.jpeg");
             back = new JButton(icon);
             back.setBounds(8,15,42,36);
            back.setBorderPainted(false);
           //c9.add(back);
          /*back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                    f9.setVisible(false);
                    f6.setVisible(true);
            }});*/
          
             }});
        updNur = new JButton ("UPDATE");
        updNur.setBounds(280,400,220,50);
        updNur.setFont(new Font("Arial",Font.BOLD,16));
        c6.add(updNur);
        c6.add(l);
        c6.add(bgimg);
        f6.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
	f6.setVisible(true);
	f6.setSize(626,616);
	f6.setResizable(false); 
        }
        });
        
        b5 = new JButton ("CHECK WARD INFO");
        b5.setBounds(280,400,220,50);
        b5.setFont(new Font("Arial",Font.BOLD,16));
        c2.add(b5);
        c2.add(bgimg);
        f2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        f2.setVisible(true);
        f2.setSize(626,616);
        f2.setResizable(false);
        }
        }
        if(flag==false)
        {
        JOptionPane.showMessageDialog (jf,"Either of the value is incorrect!") ;
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

    // String opt[] = new String[3];
}

public class Main{

    public static void main(String[] args) {
        GUI g = new GUI();
          g.Draw();
    }
    
}
