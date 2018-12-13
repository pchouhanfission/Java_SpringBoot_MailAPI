package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	
@Service
public class EmailService {
	
public String sendmail(String mailto, String name) {

        try{
           String host ="smtp.gmail.com" ;
            String user = "your email";
            String pass = "password";
            String to = mailto;
            String from = "prschouhan14@gmail.com";
            String subject = "UIC Certification";
            String messageText = "<!DOCTYPE html>\n" + 
            		"<html>\n" + 
            		"<head>\n" + 
            		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
            		"</head>\n" + 
            		"\n" + 
            		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"><body>\n" + 
            		"<div style=\"width:730px; padding:30px; border: 10px solid #787878; margin:50px auto; color:rgb(44, 62, 80); text-align:center\">\n" + 
            		"\n" + 
            		"      <div style=\" text-align:center; border: 5px solid #787878\">\n" + 
            		"      <br>\n" + 
            		"            	<span style=\"font-size:50px; font-weight:bold; display:block ; margin-top:30px\">Certificate of Completion</span><br>\n" + 
            		"		<span style=\"font-size:25px; display:block; margin-top:30px\"><i>This is to certify that</i></span><br>\n" + 
            		"		<span style=\"font-size:25px; display:block; margin-top:30px\">"+name+"</span><br>\n" + 
            		"            	<span style=\"font-size:25px; display:block; margin-top:30px\"><i>has completed filling the itinerary successfully</i><span>\n" + 
            		"            	<span style=\"font-size:18px; display:block; margin-top:50px\">Emergency Contact</span> <br/><br/>\n" + 
            		"	<span style=\"font-size:18px; display:block; margin-bottom:30px\">            	\n" + 
            		"	<a href=\"tel:312-636-4150\" style=\"font-size:15px;display:block;color:#007bff\" >312-636-4150</a></span>\n" + 
            		"\n" + 
            		"\n" + 
            		"\n" + 
            		"		\n" + 
            		"      </div>\n" + 
            		"\n" + 
            		"<br>\n" + 
            		"<br>\n" + 
            		"    </div>\n" + 
            		"</body>\n" + 
            		"</html>";
            
            
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from,"UIC.edu"));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setContent(messageText,"text/html");

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("done");
           return "done";
        }catch(Exception ex)
        {
            System.out.println(ex);
            return "Error";
        }
        
    } 
}