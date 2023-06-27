/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Library;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 63931
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        BookLoad();
    }
    
    public class CategoryItem {
        int id;
        String name;
        
        public CategoryItem(int id, String name){
            this.id = id; 
            this.name = name;
        }
        
        public String toString() {
            return name;
        }
    }
    
    public class AuthorItem {
        int id;
        String name;
        
        public AuthorItem(int id, String name){
            this.id = id; 
            this.name = name;
        }
        
        public String toString() {
            return name;
        }
    }
    
    public class PublisherItem {
        int id;
        String name;
        
        public PublisherItem(int id, String name){
            this.id = id; 
            this.name = name;
        }
        
        public String toString() {
            return name;
        }
    }
   
    public void Category() {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM category");
            resultSet = preparedStatement.executeQuery();
            inputcategory.removeAllItems();
            
            while(resultSet.next()) {
                inputcategory.addItem(new CategoryItem(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void Author() {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM author");
            resultSet = preparedStatement.executeQuery();
            inputauthor.removeAllItems();
            
            while(resultSet.next()) {
                inputauthor.addItem(new AuthorItem(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void Publisher() {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM publisher");
            resultSet = preparedStatement.executeQuery();
            inputpublisher.removeAllItems();
            
            while(resultSet.next()) {
                inputpublisher.addItem(new PublisherItem(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/library_management_system_db", "root","root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BookLoad(){
        
        int c;
            
        try {
            preparedStatement = connection.prepareStatement("SELECT b.id, b.name, c.name, a.name, p.name, b.contents, b.pages, b.edition FROM book b JOIN category c ON b.category = c.id JOIN author a ON b.author = a.id JOIN publisher p ON b.publisher = p.id");
            resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData rsd = resultSet.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            
            while(resultSet.next()){
                Vector v2 = new Vector();
                
                for(int i = 0; i <= c; i++){
                    v2.add(resultSet.getString("b.id"));
                    v2.add(resultSet.getString("b.name"));
                    v2.add(resultSet.getString("c.name"));
                    v2.add(resultSet.getString("a.name"));
                    v2.add(resultSet.getString("p.name"));
                    v2.add(resultSet.getString("b.contents"));
                    v2.add(resultSet.getString("b.pages"));
                    v2.add(resultSet.getString("b.edition"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputname = new javax.swing.JTextArea();
        inputcategory = new javax.swing.JComboBox();
        inputauthor = new javax.swing.JComboBox();
        inputpublisher = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputcontents = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputnoofpages = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        inputedition = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        addbtn = new javax.swing.JButton();
        addbtn1 = new javax.swing.JButton();
        addbtn2 = new javax.swing.JButton();
        addbtn3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("BOOK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setText("Category");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel4.setText("Author");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel5.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setText("Contents");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setText("No of Pages");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setText("Edition");

        inputname.setColumns(20);
        inputname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputname.setRows(5);
        jScrollPane2.setViewportView(inputname);

        inputcategory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        inputauthor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        inputpublisher.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        inputcontents.setColumns(20);
        inputcontents.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputcontents.setRows(5);
        jScrollPane3.setViewportView(inputcontents);

        inputnoofpages.setColumns(20);
        inputnoofpages.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputnoofpages.setRows(5);
        jScrollPane4.setViewportView(inputnoofpages);

        inputedition.setColumns(20);
        inputedition.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputedition.setRows(5);
        jScrollPane5.setViewportView(inputedition);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(inputcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputauthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputpublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(inputauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(inputpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addGap(23, 23, 23))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addbtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addbtn.setText("ADD");
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        addbtn1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addbtn1.setText("UPDATE");
        addbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn1ActionPerformed(evt);
            }
        });

        addbtn2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addbtn2.setText("DELETE");
        addbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn2ActionPerformed(evt);
            }
        });

        addbtn3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addbtn3.setText("CANCEL");
        addbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CATEGORY", "AUTHOR", "PUBLISHER", "CONTENTS", "NOOFPAGES", "EDITION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        String name = inputname.getText();
        CategoryItem c_item = (CategoryItem) inputcategory.getSelectedItem();
        AuthorItem a_item = (AuthorItem) inputauthor.getSelectedItem();
        PublisherItem p_item = (PublisherItem) inputpublisher.getSelectedItem();
        
        String contents = inputcontents.getText();
        String no_of_pages = inputnoofpages.getText();
        String edition = inputedition.getText();
        
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO book(name, category, author, publisher, contents, pages, edition) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, c_item.id);
            preparedStatement.setInt(3, a_item.id);
            preparedStatement.setInt(4, p_item.id);
            preparedStatement.setString(5, contents);
            preparedStatement.setString(6, no_of_pages);
            preparedStatement.setString(7, edition);
            int k = preparedStatement.executeUpdate();
            
            if(k == 1){
                JOptionPane.showMessageDialog(this, "Publisher Created");
                inputname.setText("");
                inputcategory.setSelectedIndex(-1);
                inputauthor.setSelectedIndex(-1);
                inputpublisher.setSelectedIndex(-1);
                inputcontents.setText("");
                inputnoofpages.setText("");
                inputedition.setText("");
                
                BookLoad();
            }else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        }catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
//        int selectIndex = jTable1.getSelectedRow();
//        
//        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
//        inputname.setText(d1.getValueAt(selectIndex, 1).toString());
//        inputaddress.setText(d1.getValueAt(selectIndex, 2).toString());
//        inputcontact.setText(d1.getValueAt(selectIndex, 3).toString());
//        
//        addbtn.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void addbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addbtn1ActionPerformed

    private void addbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addbtn2ActionPerformed

    private void addbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_addbtn3ActionPerformed

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addbtnMouseClicked

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton addbtn1;
    private javax.swing.JButton addbtn2;
    private javax.swing.JButton addbtn3;
    private javax.swing.JComboBox inputauthor;
    private javax.swing.JComboBox inputcategory;
    private javax.swing.JTextArea inputcontents;
    private javax.swing.JTextArea inputedition;
    private javax.swing.JTextArea inputname;
    private javax.swing.JTextArea inputnoofpages;
    private javax.swing.JComboBox inputpublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}