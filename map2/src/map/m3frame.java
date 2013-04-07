/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;
import java.awt.Graphics;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jl.player.Player;
import java.io.*;
/**
 *
 * @author lenovo
 */
public class m3frame extends javax.swing.JFrame {

    static  Connection c;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
static int Id;
ImageIcon back = new ImageIcon("E:/java proj/New Folder/fo1.jpg");
public m3frame()
{

}
    public m3frame(int id) {
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
 
  
  } catch (Exception e) {
  e.printStackTrace();
  }
Id=id;
        

        initComponents();

        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.drawImage(back.getImage(), 15, 5, null);
                super.paintComponent(g);
            }
        }
        ;
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        credit = new javax.swing.JLabel();
        map = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        String t7 =null;
        try
        {
            pst=c.prepareStatement("select cus from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            t7=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        ImageIcon icon1 = new ImageIcon("C://Users/lenovo/Pictures/"+t7+".jpg");
        cuisine = new javax.swing.JLabel(icon1);
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setFocusable(false);
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("ADDRESS : ");

        jLabel5.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("TIME :");

        String t1 =null;
        try
        {
            pst=c.prepareStatement("select time from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            t1=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        time.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(102, 0, 0));
        time.setText(t1);

        jLabel7.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("COST : ");

        String t2 =null;
        try
        {
            pst=c.prepareStatement("select cost from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            t2=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        cost.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        cost.setForeground(new java.awt.Color(102, 0, 0));
        cost.setText(t2);

        jLabel9.setFont(new java.awt.Font("Kristen ITC", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Wanna Rate !?");

        slider.setBackground(new java.awt.Color(242, 202, 242));
        slider.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        slider.setForeground(new java.awt.Color(102, 0, 51));
        slider.setMajorTickSpacing(1);
        slider.setMaximum(5);
        slider.setMinimum(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(new ChangeListener() {
            // This method is called whenever the slider's value is changed
            public void stateChanged(ChangeEvent evt) {

                if (!slider.getValueIsAdjusting()) {
                    // Get new value
                    int value = slider.getValue();
                    int val;
                    try
                    {
                        pst=c.prepareStatement("select pop from Restaurant where id="+Id+"");
                        rs=pst.executeQuery();
                        rs.next();
                        val=rs.getInt(1);
                        val+=value;
                        pst=c.prepareStatement("update Restaurant set pop="+val+" where id="+Id+"");
                        pst.executeUpdate();

                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }

                }
            }
        });

        jLabel4.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("CREDIT CARD : ");

        String t5 =null;
        try
        {
            pst=c.prepareStatement("select name from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            t5=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        name.setFont(new java.awt.Font("Kristen ITC", 1, 36)); // NOI18N
        name.setForeground(new java.awt.Color(102, 0, 0));
        name.setText(t5);

        String t6 =null;
        try
        {
            pst=c.prepareStatement("select ccd from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            t6=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        credit.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        credit.setForeground(new java.awt.Color(102, 0, 0));
        credit.setText(t6);

        map.setBackground(new java.awt.Color(238, 200, 200));
        map.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        map.setForeground(new java.awt.Color(102, 0, 102));
        map.setIcon(new javax.swing.ImageIcon("E:\\java proj\\New folder\\map.gif")); // NOI18N
        map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("E:\\java proj\\New folder\\menucard.jpg")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cuisine.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        cuisine.setForeground(new java.awt.Color(102, 0, 0));
        cuisine.setText(t7);

        jButton1.setIcon(new javax.swing.ImageIcon("E:\\java proj\\New folder\\home.gif")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("RATE!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("CUISINE : ");

        String tt =null;
        try
        {
            pst=c.prepareStatement("select addr from Restaurant where id="+Id+"");
            rs=pst.executeQuery();
            rs.next();
            tt=rs.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        jTextArea1.setText(tt);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(455, 455, 455)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(credit)
                                    .addComponent(cost)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(223, 223, 223)
                                        .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(353, 353, 353)
                                .addComponent(time))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(320, 320, 320)
                                        .addComponent(cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(52, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(credit))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(map)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton2)))
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderActionPerformed
      
    }//GEN-LAST:event_orderActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try
        {
            FileInputStream is = new FileInputStream("ap.mp3");
            Player p = new Player(is);
            p.play();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(this,"Thank You for rating.!!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mframe m = new mframe();
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        m4frame f = new m4frame(Id);
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapActionPerformed
        // TODO add your handling code here:
        mapmain m = new mapmain(Id);

        m.setVisible(true);
    }//GEN-LAST:event_mapActionPerformed
public static void main(String args[]) {
     
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
            java.util.logging.Logger.getLogger(m3frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(m3frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(m3frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(m3frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new m3frame().setVisible(true);
                }
        });
       
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cost;
    private javax.swing.JLabel credit;
    private javax.swing.JLabel cuisine;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton map;
    private javax.swing.JLabel name;
    private javax.swing.JSlider slider;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
