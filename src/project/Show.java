/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hydron
 */
public class Show extends javax.swing.JFrame {

    /**
     * Creates new form Show
     */
    public Show() {
        initComponents();
    }

    //download list of available books in the pdf format
    public void available_download()
    {
     try
     {
     String path = "";
     JFileChooser j = new JFileChooser();
     j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
     int x = j.showSaveDialog(this);
     if(x==JFileChooser.APPROVE_OPTION)
     {
         path = j.getSelectedFile().getPath();
     }
      Document doc = new Document();
        
            PdfWriter.getInstance(doc,new FileOutputStream(path+"/Available Books.pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(6);
            //adding table header
            tbl.addCell("Book Id");
            tbl.addCell("Name ");
            tbl.addCell("Author");
            tbl.addCell("Publication");
            tbl.addCell("Price");
            tbl.addCell("Quantity");
            
            for(int i=0;i<t1.getRowCount();i++)
            {
               // extracting data from jtable
                String id = t1.getValueAt(i,0).toString();
                String name = t1.getValueAt(i,1).toString();
                String author = t1.getValueAt(i,2).toString();
                String publication = t1.getValueAt(i,3).toString();
                String price = t1.getValueAt(i,4).toString();
                String quantity = t1.getValueAt(i,5).toString();
                //adding data to pdf 
                tbl.addCell(id);
                tbl.addCell(name);
                tbl.addCell(author);
                tbl.addCell(publication);
                tbl.addCell(price);
                tbl.addCell(quantity);
            }
            doc.add(tbl);
            
        doc.close();
        JOptionPane.showMessageDialog(this,"File downloaded !!","Success",JOptionPane.INFORMATION_MESSAGE);
         }
        catch(FileNotFoundException | DocumentException ex)
        {
                System.out.println(ex);
        }
     }
    
    public void issued_download()
    {
     try{ 
         String path = "";
         JFileChooser j = new JFileChooser();
         j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         int x = j.showSaveDialog(this);
         if(x==JFileChooser.APPROVE_OPTION)
           {
             path = j.getSelectedFile().getPath();
           }
            Document doc = new Document();
        
            PdfWriter.getInstance(doc,new FileOutputStream(path+"/Issued Books.pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(7);
            //adding table header
            tbl.addCell("Book Id");
            tbl.addCell("Book Name");
            tbl.addCell("Borrower Id");
            tbl.addCell("Borrower Name");
            tbl.addCell("Borrower Contact");
            tbl.addCell("Issued Date");
            tbl.addCell("Returned Date");
            
            for(int i=0;i<t2.getRowCount();i++)
            {
               // extracting data from jtable
                String bkid = t2.getValueAt(i,0).toString();
                String bkname = t2.getValueAt(i,1).toString();
                String borid = t2.getValueAt(i,2).toString();
                String borname = t2.getValueAt(i,3).toString();
                String borcontact = t2.getValueAt(i,4).toString();
                String issued_date = t2.getValueAt(i,5).toString();
                String returned_date = t2.getValueAt(i,6).toString();
                //adding data to pdf 
                tbl.addCell(bkid);
                tbl.addCell(bkname);
                tbl.addCell(borid);
                tbl.addCell(borname);
                tbl.addCell(borcontact);
                tbl.addCell(issued_date);
                tbl.addCell(returned_date);
            }
            doc.add(tbl); 
            doc.close();
            JOptionPane.showMessageDialog(this,"File downloaded !!","Success",JOptionPane.INFORMATION_MESSAGE); 
         }
        catch(FileNotFoundException | DocumentException e)
        {
         System.out.println(e);
        }
    }
    
    public void borrowers_download()
    {
      try{ 
         String path = "";
         JFileChooser j = new JFileChooser();
         j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         int x = j.showSaveDialog(this);
         if(x==JFileChooser.APPROVE_OPTION)
           {
             path = j.getSelectedFile().getPath();
           }
            Document doc = new Document();
        
            PdfWriter.getInstance(doc,new FileOutputStream(path+"/Borrowers.pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(7);
            //adding table header
            tbl.addCell("Borrower Id");
            tbl.addCell("Borrower Name");
            tbl.addCell("Borrower Address");
            tbl.addCell("Borrower Email");
            tbl.addCell("Borrower Contact");
            tbl.addCell("Books Borrowed");
            tbl.addCell("Total Fine");
            
            for(int i=0;i<t3.getRowCount();i++)
            {
               // extracting data from jtable
                String borID = t3.getValueAt(i,0).toString();
                String borName = t3.getValueAt(i,1).toString();
                String borAdd = t3.getValueAt(i,2).toString();
                String borEmail = t3.getValueAt(i,3).toString();
                String borContact = t3.getValueAt(i,4).toString();
                String bksBorrowed = t3.getValueAt(i,5).toString();
                String totalFine = t3.getValueAt(i,6).toString();
                //adding data to pdf 
                tbl.addCell(borID);
                tbl.addCell(borName);
                tbl.addCell(borAdd);
                tbl.addCell(borEmail);
                tbl.addCell(borContact);
                tbl.addCell(bksBorrowed);
                tbl.addCell(totalFine);
            }
            doc.add(tbl); 
            doc.close();
            JOptionPane.showMessageDialog(this,"File downloaded !!","Success",JOptionPane.INFORMATION_MESSAGE); 
         }
        catch(FileNotFoundException | DocumentException e)
        {
         System.out.println(e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        t3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N

        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Author", "Publication", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t1);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Download");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Book22.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jButton3)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Available Books", jPanel1);

        t2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Book Name", "Borrower ID", "Borrower Name", "Borrower Contact", "Issue Date", "Return Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(t2);

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Book22.png"))); // NOI18N
        jButton4.setText("Close");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Download");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("Show");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jButton5)
                .addGap(77, 77, 77)
                .addComponent(jButton4)
                .addGap(89, 89, 89))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Issued Books", jPanel2);

        t3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Borrower ID", "Borrower Name", "Borrower Address", "Borrower Email", "Borrower Contact", "Books Borrowed", "Total Fine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(t3);

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Download");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Book22.png"))); // NOI18N
        jButton7.setText("Close");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("Show");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton7)
                .addGap(81, 81, 81))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Borrowers", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     //download button - available books 
     available_download();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //download button - issued books
        issued_download();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //download button - borrowers
        borrowers_download();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         //Show button - issued books
        try
        {
            DefaultTableModel tbl = (DefaultTableModel) t2.getModel();
            tbl.setNumRows(0);
            Connection con = connect.dbconnection();
            Statement st = con.createStatement();
            String sql = "select * from issued_books";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String BKID = rs.getString("BK_ID");
                String BKNAME = rs.getString("BK_NAME");
                String BORID = rs.getString("BOR_ID");
                String BORNAME = rs.getString("BOR_NAME");
                String BORCONTACT = rs.getString("BOR_CONTACT");
                String ISSDATE = rs.getString("ISS_DATE");
                String RETDATE = rs.getString("RET_DATE");
                
                String data[] = {BKID,BKNAME,BORID,BORNAME,BORCONTACT,ISSDATE,RETDATE};
                tbl.addRow(data);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Database Connection Failed !!!","ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);  
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Close button action
        //JOptionPane.showMessageDialog(this,"Sure to close ?", "Warning",JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //close button action
        //JOptionPane.showMessageDialog(this,"Sure to close ?", "Warning",JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //close button action
        //JOptionPane.showMessageDialog(this,"Sure to close ?", "Warning",JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //show button - avialable books
        try
        {
            DefaultTableModel tbl = (DefaultTableModel) t1.getModel();
            tbl.setNumRows(0);
            Connection con = connect.dbconnection();
            Statement st = con.createStatement();
            String sql = "select * from books";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String BKID = rs.getString("BK_ID");
                String BKNAME = rs.getString("BK_NAME");
                String PUB = rs.getString("BK_PUB");
                String PRICE = rs.getString("BK_PRICE");
                String QUANTITY = rs.getString("BK_QTY");
                String AUTHOR = rs.getString("BK_AUTOR");
                
                String data[] = {BKID,BKNAME,AUTHOR,PUB,PRICE,QUANTITY};
                tbl.addRow(data);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Database Connection Failed !!!","ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);  
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //show button - Borrowers
        try{
            DefaultTableModel tbl = (DefaultTableModel) t3.getModel();
            tbl.setRowCount(0);
                        Connection con = connect.dbconnection();
            Statement st = con.createStatement();
            String sql = "select * from Borrowers";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String BOR_ID = rs.getString("BOR_ID");
                String BOR_NAME = rs.getString("BOR_NAME");
                String BOR_ADDRESS = rs.getString("BOR_ADDRESS");
                String BOR_EMAIL = rs.getString("BOR_EMAIL");
                String BOR_CONTACT = rs.getString("BOR_CONTACT");
                String BK_BORROWED = rs.getString("BK_BORROWED");
                String FINE_AMT = rs.getString("FINE_AMT");
                
                String data[] = {BOR_ID,BOR_NAME,BOR_ADDRESS,BOR_EMAIL,BOR_CONTACT,BK_BORROWED,FINE_AMT};
                tbl.addRow(data);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Database Connection Failed !!!","ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Show f = new Show();
                f.setTitle("Show Details");
                ImageIcon img = new ImageIcon(getClass().getResource("/Images/book16.png"));
                f.setIconImage(img.getImage());
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable t1;
    private javax.swing.JTable t2;
    private javax.swing.JTable t3;
    // End of variables declaration//GEN-END:variables
}
