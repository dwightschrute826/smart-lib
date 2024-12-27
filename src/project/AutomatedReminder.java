/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;

/**
 *
 * @author Hydron
 */
public class AutomatedReminder {
    
    public static void remind(){
        //getting the list of patrons from database
        List<Patron> patrons = getPatrons();
        for(Patron patron : patrons){
           List<Item> items = getItems(patron);
           for(Item item : items){
               java.util.Date dueDate = calculateDueDate(item);
               String to = patron.getEmail();
               String title = item.getTitle();
               //check if its time to send first email(3 days before due date)
               if(isTimeToSendEmail(dueDate, -3))
               {
                   sendReminderEmail(to,"First Reminder: Your book is due in 3 Days.",title, dueDate);
               }
               //check if its time to send seccond email(on due date)
               if(isTimeToSendEmail(dueDate, 0))
               {
                   sendReminderEmail(to,"Second Reminder: Book due today.", title, dueDate);
               }
               //check if its time to send the third email(3 days after due date)
               if(isTimeToSendEmail(dueDate, 3))
               {
                   sendReminderEmail(to,"Last Reminder: Book is overdue.", title, dueDate);
               } 
           }
        }
    }
    
    //method to get the list of patrons
    private static List<Patron> getPatrons(){
        List<Patron> patrons =  new ArrayList<>();
        try{
           Connection con  = connect.dbconnection();
           Statement st = con.createStatement();
           String sql = "SELECT * FROM BORROWERS";
           ResultSet rs = st.executeQuery(sql);
           while(rs.next())
           {
              String id = rs.getString("BOR_ID");
              String email = rs.getString("BOR_EMAIL");
              patrons.add(new Patron(id,email)); 
           }
           con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return patrons;
    }
    
    //method to get the list of items checked-out by the patron
    private static List<Item> getItems(Patron patron){
        List<Item> items = new ArrayList<>();
        try{
          Connection con = connect.dbconnection();
          Statement st = con.createStatement();
          String BORID = patron.getId();
          String sql = "Select * from Issued_Books where BOR_ID = '"+BORID+"'";
          ResultSet rs = st.executeQuery(sql);
          while(rs.next())
          {   
              String id = rs.getString("BK_ID");
              String title = rs.getString("BK_NAME");
              String dueDate = rs.getString("RET_DATE");
              items.add(new Item(id,title,dueDate));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return items;
    }
    
    //method to calculate the due date
    private static java.util.Date calculateDueDate(Item item){
        String temp = item.getDueDate();
        java.util.Date date = java.sql.Date.valueOf(temp);
        return date;
    }
    
    //method to check if the it is time to send email or not
    private static boolean isTimeToSendEmail(java.util.Date dueDate,int daysBeforeDueDate){
        //calculate the email send date based on the due date and the speccified days before due date
        java.util.Date emailSendDate = new java.util.Date(dueDate.getTime()+daysBeforeDueDate*24*60*60*1000);
        return new java.util.Date().compareTo(emailSendDate)>=0; 
    }
    
    //method to send email reminder
    private static void sendReminderEmail(String to,String subject, String title,java.util.Date dueDate){
        //setting the required credentials
        String from = "smartlib20@gamil.com";
        String host = "smtp.gmail.com";
        String username = "smartlib20";
        String password = "mgryydlyntwdnzla";
        //creating  SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", host);
        //creating session for seending mail
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        
        try{
        //creating MIME email message   
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText("This is reminder that your book \""+title+"\"is due on "+dueDate.toString()+". Please submit it as soon as possible.");
        //sending email
        Transport.send(message);
        System.out.println("Reminder mail sent successfully to "+to);
        }
        catch(MessagingException e){
            e.printStackTrace();
        } 
    }

    private static class Patron {
        private String id;
        private String email;
      
        public Patron(String id,String email) {
            this.id = id;
            this.email = email;
        }
        
        public String getId()
        {
            return this.id;
        }
        
        public String getEmail(){
            return this.email;
        }
    }

    private static class Item {
        private String id;
        private String title;
        private String dueDate;
        
        public Item(String id,String title,String dueDate) {
            this.id = id;
            this.title = title;
            this.dueDate = dueDate;
        }
        
        public String getId()
        {
            return this.id;
        }
        
        public String getTitle()
        {
            return this.title;
        }
        
        public String getDueDate()
        {
            return this.dueDate;
        }
    }
}
