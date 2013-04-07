/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;
import java.awt.Graphics;
import java.sql.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author lenovo
 */
public class m2frame extends javax.swing.JFrame {

    /**
     * Creates new form m2frame
     */
    static Connection c=null;
    Statement st;
    ImageIcon icon;
    ImageIcon ic = new ImageIcon("E:/java proj/New folder/sm.jpg");
    PreparedStatement pst;
    ResultSet rs;
    DefaultListModel lm= new DefaultListModel();
  void connection()
  {
      System.out.println("MySQL Connect Example.");
  String url = "jdbc:mysql://localhost:3306/";
  String dbName = "map";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "nive";
  try {
  Class.forName(driver).newInstance();
  c = DriverManager.getConnection(url+dbName,userName,password);
  System.out.println("Connected to the database");
  //c.close();
  //System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
  }
    public m2frame(String l,String cu) {
        this.setVisible(true);
        connection();
        icon = new ImageIcon("E:/java proj/New folder/bg3.jpg");
        initComponents();
        get_data(l,cu);
        this.setVisible(false);
        
    }
    public m2frame(String n) {
        this.setVisible(true);
        connection();
        icon = new ImageIcon("E:/java proj/New folder/bg3.jpg");
        initComponents();
      System.out.print("\n the nameeeeeee  : "+n);
        String N=n;
        get_rest(N);
        this.setVisible(false);
        
    }
public void get_rest(String n)
{
    System.out.print("hello?");
    try
  {
         System.out.print("\n the name  : "+n);
         pst=c.prepareStatement("select addr from Restaurant where name='"+n+"'");
      //System.out.println("heree");
      rs=pst.executeQuery();
      rs.next();
  System.out.println("RESULT : "+rs.getString(1));
      do
        {     System.out.println(rs.getString(1));
      
            lm.addElement(rs.getString(1));
        }while(rs.next());
      if(lm.isEmpty())
      {
           sm.setIcon(ic);
                  lm.addElement("No records!");
      }
       restlist.setModel(lm);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(restlist, e.getMessage());
    }
    restlist.addListSelectionListener(new ListSelectionListener()
   {
       public void valueChanged(ListSelectionEvent e)
       {
          try
          {
              if(e.getValueIsAdjusting()==false)
              {
              if(restlist.getSelectedIndex()==-1)
                  System.out.println("No selection");
              else
              {
                int id=0;
                String ad = (String)restlist.getSelectedValue();
                pst=c.prepareStatement("select id from Restaurant where addr='"+ad+"'");
                rs=pst.executeQuery();
                while(rs.next())
                {
                  id=rs.getInt(1);  
                  System.out.println("the value of id : "+id);
                }
                 //m3frame n3=new m3frame(id);
                 m3frame n3=new m3frame(id);
                 n3.setVisible(true);
                //this.setVisible(false);
              }
              }
          }
          catch(SQLException sq)
          {
              System.out.println("SQL Error : "+sq);
              
          }
       }
   }); 
}
public void get_data(String l,String cu)
{ System.out.println("heree");
  try
  {
      //lm.clear();
      System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+cu);
      pst=c.prepareStatement("select addr from Restaurant where loc='"+l+"' and cus ='"+cu+"'");
      rs=pst.executeQuery();
      System.out.println(l+cu);
      while(rs.next())
        {     System.out.println(rs.getString(1));
      
            lm.addElement(rs.getString(1));
        }
      
      if(lm.isEmpty())
      {
          sm.setIcon(ic);
          lm.addElement("No records!");
      }
       restlist.setModel(lm);
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(restlist, e.getMessage());
    }
//}
//public void ls_sort()
//{
   restlist.addListSelectionListener(new ListSelectionListener()
   {
       public void valueChanged(ListSelectionEvent e)
       {
          try
          {
              if(e.getValueIsAdjusting()==false)
              {
              if(restlist.getSelectedIndex()==-1)
                  System.out.println("No selection");
              else
              {
                int id=0;
                String ad = (String)restlist.getSelectedValue();
                pst=c.prepareStatement("select id from Restaurant where addr='"+ad+"'");
                rs=pst.executeQuery();
                while(rs.next())
                {
                  id=rs.getInt(1);  
                  System.out.println("the value of id : "+id);
                }
                 //m3frame n3=new m3frame(id);
                 m3frame n3=new m3frame(id);
                 n3.setVisible(true);
                 
              }
              }
          }
          catch(SQLException sq)
          {
              System.out.println("SQL Error : "+sq);
              
          }
       }
   }); 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.drawImage(icon.getImage(), 15, 5, null);
                super.paintComponent(g);
            }
        }
        ;
        jRadioButton3 = new javax.swing.JRadioButton();
        Rating = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        restlist = new javax.swing.JList();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        sm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFocusable(false);
        jPanel1.setOpaque(false);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 0, 51));
        jRadioButton3.setText("Cost");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Rating);
        Rating.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        Rating.setForeground(new java.awt.Color(51, 0, 51));
        Rating.setText("Rating");
        Rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RatingActionPerformed(evt);
            }
        });

        restlist.setBackground(new java.awt.Color(241, 224, 151));
        restlist.setFont(new java.awt.Font("Andalus", 3, 18)); // NOI18N
        restlist.setForeground(new java.awt.Color(102, 0, 0));
        restlist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "hotels" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        restlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        restlist.setName("restlist"); // NOI18N
        restlist.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(restlist);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 0, 51));
        jRadioButton1.setText("Popularity");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("E:\\java proj\\New folder\\home.gif")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sm.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Rating, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sm, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(Rating)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(sm, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        int i;
        ArrayList<String> ar1 = new ArrayList<String>();
        ArrayList<String> ar2 = new ArrayList<String>();
        try {
            for (i = 0; i < lm.getSize(); i++) {
                System.out.println(lm.get(i));
                pst = c.prepareStatement("select addr,cost from Restaurant where addr = '" + lm.get(i) + "'");
                rs = pst.executeQuery();
                while (rs.next()) {
                    ar2.add(rs.getString(1));
                    ar1.add(rs.getString(2));
                    
                }
            }
            lm.clear();
            for (i = 0; i < ar1.size(); i++) {
                if(ar1.get(i).matches("Costly"))
                        if(!lm.contains(ar2.get(i)))
                            lm.addElement(ar2.get(i));
             }
            for (i = 0; i < ar1.size(); i++) {
                if(ar1.get(i).matches("Very Costly"))
                        if(!lm.contains(ar2.get(i)))
                            lm.addElement(ar2.get(i));
             }
            for (i = 0; i < ar1.size(); i++) {
                if(ar1.get(i).matches("Cheap"))
                        if(!lm.contains(ar2.get(i)))
                            lm.addElement(ar2.get(i));
             }
            for (i = 0; i < ar1.size(); i++) {
                if(ar1.get(i).matches("Moderate"))
                        if(!lm.contains(ar2.get(i)))
                            lm.addElement(ar2.get(i));
             }
            restlist.setModel(lm);
        } 
        catch (SQLException sql) {
            System.out.println("SQL Error : " + sql);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void RatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RatingActionPerformed
        // TODO add your handling code here:
        int i,j;
        ArrayList<Integer> ar1 = new ArrayList<Integer>();
        ArrayList<Integer> ar3 = new ArrayList<Integer>();
        ArrayList<String> ar2 = new ArrayList<String>();
        try {
            for (i = 0; i < lm.getSize(); i++) {
                System.out.println(lm.get(i));
                pst = c.prepareStatement("select rate,addr from Restaurant where addr = '" + lm.get(i) + "'");
                rs = pst.executeQuery();
                while (rs.next() != false) {
                   // System.out.println("################" + rs.getInt(1));
                    ar1.add(rs.getInt(1));
                    ar3.add(rs.getInt(1));
                    //System.out.println("################" + rs.getString(2));
                    ar2.add(rs.getString(2));
                }
            }
            //System.out.print("\n Helloooooooo" + ar1.size() + ar2.size());
            Collections.sort(ar1);
            lm.clear();
            restlist.removeAll();
            for (i = 0; i < ar1.size(); i++) {
                for(j=0;j<ar3.size();j++)
                {
                    if(ar1.get(i)==ar3.get(j))
                    {
                        if(!lm.contains(ar2.get(j)))
                            lm.addElement(ar2.get(j));
                    }
                }
            }
            restlist.setModel(lm);
        } catch (SQLException sql) {
            System.out.println("SQL Error : " + sql);
        }
    }//GEN-LAST:event_RatingActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        int i,j;
        ArrayList<Integer> ar1 = new ArrayList<Integer>();
         ArrayList<Integer> ar3 = new ArrayList<Integer>();
        ArrayList<String> ar2 = new ArrayList<String>();
        try {
            for (i = 0; i < lm.getSize(); i++) {
                System.out.println(lm.get(i));
                pst = c.prepareStatement("select pop,addr from Restaurant where addr = '" + lm.get(i) + "'");
                rs = pst.executeQuery();
                while (rs.next()) {
                    //System.out.println("################" + rs.getInt(1));
                    ar1.add(rs.getInt(1));
                    ar3.add(rs.getInt(1));
                    ar2.add(rs.getString(2));
                }
            }
            Collections.sort(ar1);
            lm.clear();
            restlist.removeAll();
            for (i = 0; i < ar1.size(); i++) {
                for(j=0;j<ar3.size();j++)
                {
                    if(ar1.get(i)==ar3.get(j))
                        if(!lm.contains(ar2.get(j)))
                           lm.addElement(ar2.get(j));
                }
            }restlist.setModel(lm);
        } catch (SQLException sql) {
            System.out.println("SQL Error : " + sql);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mframe m = new mframe();
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(m2frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(m2frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(m2frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(m2frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
  
  /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new m2frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rating;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList restlist;
    private javax.swing.JLabel sm;
    // End of variables declaration//GEN-END:variables
}
