import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TANVIR
 */
public class ResultInputFrame extends javax.swing.JFrame {

    /**
     * Creates new form ResultInputFrame
     */
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    String sq2 = null;
    static String dept = null;
    String intake=null;
    
   /* private void selectBBA()
    {
        sql = "SELECT DISTINCT INTAKE FROM STUDENT WHERE DEPT = '"+dept+"'";
        sq2 = "SELECT DISTINCT TITLE FROM COURSE NATURAL JOIN ASG NATURAL JOIN STUDENT WHERE INTAKE =";
    }
    private void selectCSE(){
        sql = "SELECT DISTINCT INTAKE FROM STUDENT@CSELNK WHERE DEPT = '"+dept+"'";
        sq2 = "SELECT DISTINCT TITLE FROM STUDENT@CSELNK NATURAL JOIN ASG@CSELNK NATURAL JOIN COURSE@CSELNK WHERE INTAKE =";
    }
    private void selectEEE(){
        JOptionPane.showMessageDialog(null,"EEE Department not found");
    }
    private void selectENG(){
        JOptionPane.showMessageDialog(null,"ENG Department not found");
    } */
    
   /* void selectdept(String dept){
        switch(dept){
            case "CSE":
            selectCSE();
            break;
            case "EEE":
            selectEEE();
            break;
            case "ENG":
            selectENG();
            break;
            case "BBA":
            selectBBA();
            break;
        }
    }*/
    double findGpt(double mark){
        double gpt;
        if(mark>=80) gpt = 4.00;
        else if(mark >= 75) gpt = 3.75;
        else if(mark >= 70) gpt = 3.50;
        else if(mark >= 65) gpt = 3.25;
        else if(mark >= 60) gpt = 3.00;
        else if(mark >= 55) gpt = 2.75;
        else if(mark >= 50) gpt = 2.50;
        else if(mark >= 45) gpt = 2.25;
        else if(mark >= 40) gpt = 2.00;
        else gpt = 0.00;
        
        return gpt;
    }
    public ResultInputFrame() {
        initComponents();
        verdictfild.setText("");
        setResizable(false);
        dept = TeacherLoignFrame.getdept();
        conn = JavaConnectDb.ConnctDb();
        //selectdept(dept);
        sql = "SELECT DISTINCT INTAKE FROM STUDENT@"+dept+"LNK WHERE DEPT = '"+dept+"'";
        sq2 = "SELECT DISTINCT TITLE FROM STUDENT@"+dept+"LNK NATURAL JOIN ASG@"+dept+"LNK NATURAL JOIN COURSE@"+dept+"LNK WHERE INTAKE =";
        try {
            st = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = (ResultSet) st.executeQuery(sql);
            while(rs.next()){
                intakebox.addItem(Integer.toString(rs.getInt("INTAKE")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex); 
        }
        intakebox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                String sq = null;
                intake = (String) intakebox.getSelectedItem();
                
                if(!intake.equals("Select Intake")){ 
                    try {
                        //System.out.println(intakebox.getSelectedItem());
                        sq = sq2 + intakebox.getSelectedItem();
                        rs = (ResultSet) st.executeQuery(sq);
                        coursebox.removeAllItems();
                        String title=null;
                        while(rs.next()){
                            title = rs.getString("TITLE");
                            coursebox.addItem(title);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ResultInputFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    coursebox.removeAllItems();
                    coursebox.addItem("Select Course");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        intakebox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        coursebox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        idfild = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        markfild = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        verdictfild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
        jLabel4.setText("Bangladesh University of Business and Technology");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("Result Input");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(148, 148, 148))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Course:");

        intakebox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        intakebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Intake" }));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Intake:");

        coursebox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        coursebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Id:");

        idfild.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Mark:");

        markfild.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        verdictfild.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        verdictfild.setForeground(new java.awt.Color(0, 204, 0));
        verdictfild.setText("Success!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(idfild, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(intakebox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coursebox, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verdictfild)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(markfild, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intakebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(coursebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idfild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(markfild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(verdictfild)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            verdictfild.setText("");
            String course = (String) coursebox.getSelectedItem();
            String id = (String)idfild.getText();
            double mark = Double.parseDouble((String)markfild.getText());
            double gpt = findGpt(mark);
            /*System.out.println("s"+dept+"e");
            System.out.println("s"+intake+"e");
            System.out.println("s"+course+"e");
            System.out.println("s"+id+"e");
            System.out.println("s"+gpt+"e");*/
            
            String qry = "SELECT ID FROM STUDENT@"+dept+"LNK WHERE ID = '"+id+"'AND INTAKE = "+intake;
            st = (Statement)conn.createStatement();
            ResultSet student = (ResultSet) st.executeQuery(qry);
            if(student.next()){
                //JOptionPane.showMessageDialog(null, "Id found.");
                student.close();
                st.close();
                try{
                    qry = "SELECT CODE FROM COURSE@"+dept+"LNK WHERE TITLE = '"+course+"'";
                    st = (Statement)conn.createStatement();
                    rs = (ResultSet) st.executeQuery(qry);
                    System.out.println(qry);
                    int count =0;
                    String code = null;
                    while(rs.next()){
                        count++;
                        code = rs.getString("CODE");
                        System.out.println(code);
                    }
                    //System.out.println(count);
                    rs.close();
                    st.executeUpdate("INSERT INTO ASG@"+dept+"LNK VALUES('"+id+"','"+code+"','"+mark+"',"+gpt+")");
                    st.close();
                    verdictfild.setForeground(new java.awt.Color(0, 204, 0));
                    verdictfild.setText("Success!");
                }
                catch(Exception e){
                    verdictfild.setForeground(new java.awt.Color(255, 0, 0));
                    verdictfild.setText("Error!");
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }
            else{
                verdictfild.setForeground(new java.awt.Color(255, 0, 0));
                verdictfild.setText("Error!");
                JOptionPane.showMessageDialog(null, "Id does not exist!");
                student.close();
                st.close();
            }
           
        }
        catch(Exception e){
            verdictfild.setForeground(new java.awt.Color(255, 0, 0));
            verdictfild.setText("Error");
            JOptionPane.showMessageDialog(null,"Invalid input!");
        }
        
        
        
        
        
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
            java.util.logging.Logger.getLogger(ResultInputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultInputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultInputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultInputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultInputFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> coursebox;
    private javax.swing.JTextField idfild;
    private javax.swing.JComboBox<String> intakebox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField markfild;
    private javax.swing.JLabel verdictfild;
    // End of variables declaration//GEN-END:variables
}