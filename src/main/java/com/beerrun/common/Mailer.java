package com.beerrun.common;

/******************************************************************************
 * 
 * 
 * 	      test case 									result
 * 
 * normal Email
 * 
 * 1.    same domaiN emailing (gmail to gmail)			passed
 * 
 * 2.	 different domain eailing (gmail to nicheken)
 * 			or (nicheken to gmail)						passed
 * 
 * 
 * attachment email
 * 
 * 1.    same domaiN emailing (gmail to gmail)			passed
 * 
 * 2.	 different domain eailing (gmail to nicheken)
 * 			or (nicheken to gmail)						passed
 * 
 * 3.     if file path is incorrect, it should			passed 
 * 			not send  
 * 
 * 
 * 
 * multipart email
 * 
 * 1.    same domaiN emailing (gmail to gmail)			passed
 * 
 * 2.	 different domain eailing (gmail to nicheken)
 * 			or (nicheken to gmail)						passed
 * 
 * html email
 * 
 * 1.    same domaiN emailing (gmail to gmail)			passed
 * 
 * 2.	 different domain eailing (gmail to nicheken)
 * 			or (nicheken to gmail)						passed
 * 
 * 
 */


import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Mailer 
{
	
	
//	public void email(String email_From, String email_To, String email_Subject,String Email_content)
//	{
//		Session email_session = Session.getInstance(getEmailProperties(),null);
//
//        try {
//        	
//            /****************** Get a Transport object to send e-mail*************************/
//            Transport email_Transporter = email_session.getTransport(Defs.MAIL_TRANSPORT_PROTOCOL);
//
//            /********* Connect only once here Transport.send() disconnects after each send
//             Usually, no username and password is required for SMTP************************/
//            //email_Transporter.connect();
//             email_Transporter.connect(Defs.SMTP_HOST,Defs.AUTHENTICATOR_EMAIL_ADDRESS , Defs.AUTHENTICATOR_EMAIL_PASSWORD);
//
//            /********************instantiate a message*************************/
//            Message email_Message = new MimeMessage(email_session);
//
//            /**************************** Set message attributes*****************************************/
//            /********* 1. setting FROM address ***********************/
//            email_Message.setFrom(new InternetAddress(email_From));
//            
//            /********* 2. setting TO address or TO Addresses***********************/
//            InternetAddress[] address = {new InternetAddress(email_To)};
//            email_Message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_To, true));
//         
//            /********* 3. setting CC address or CC Addresses***********************/
//            /************** Parse a comma-separated list of email addresses. Be strict.********************/
//            email_Message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(email_To, true));
//            
//            /********* 4. setting BCC address or BCC Addresses***********************/
//            /*************** Parse comma/space-separated list.*********************/
//            email_Message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(email_To, false));
//
//            /********* 5. setting SUBJECT for E-mail **********************/
//            email_Message.setSubject(email_Subject);
//            
//            /********* 6. setting SENT DATE for E-mail **********************/
//            email_Message.setSentDate(new Date());
//
//            /********* 7. setting EMail Message  **********************/
//            setTextContent(email_Message ,Email_content);
//            
//            /********* 8. Commiting the email Message contents **********************/
//            email_Message.saveChanges();
//            
//            /********* 9. Sending the email  **********************/
//            email_Transporter.sendMessage(email_Message, address);    
//            
//            /********* 10.closing the transporter  **********************/
//            email_Transporter.close();
//         
//        }
//        catch (MessagingException exc_MessageException) {
//           
//            exc_MessageException.printStackTrace();
//            while (exc_MessageException.getNextException() != null)
//            {
//                Exception ex = exc_MessageException.getNextException();
//                	ex.printStackTrace();
//                	if (!(ex instanceof MessagingException))
//                		break;
//                	else 
//                		exc_MessageException = (MessagingException)ex;
//            }
//        }
//	}
//	
//	public void sendemail(String email_From, String email_To,String email_BCC1,String email_BCC2,String email_Subject,String Email_content)
//	{
//		//Session email_session = Session.getInstance(getEmailProperties(),null);
//		
//		try
//   		{
//			email_From = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
//			String email_CC = "";
//			
//			Properties props = System.getProperties();//new Properties();
//   			props.put("mail.smtp.host",Defs.SMTP_HOST);
// 			props.put("mail.smtp.auth","true");
//   			props.put("mail.smtp.starttls.enable","true");
//   			
//			Session session = Session.getDefaultInstance(props,new Authenticator()
//			
//			{
//				public PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(Defs.AUTHENTICATOR_EMAIL_ADDRESS,Defs.AUTHENTICATOR_EMAIL_PASSWORD);}});
//				session.setDebug(false);		 	
//				Message msg = new MimeMessage(session);
//	   			InternetAddress addressFrom = new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS);
//	   			msg.setFrom(addressFrom);
//	   			
//	   			InternetAddress addressTo = new InternetAddress(email_To);	
//	   			InternetAddress addresBcc1 = new InternetAddress(email_BCC1);
//	   			InternetAddress addresBcc2 = new InternetAddress(email_BCC2);
//	   			
//	   			msg.addRecipient(Message.RecipientType.TO,addressTo); 
//	   			msg.addRecipient(Message.RecipientType.CC,addresBcc1);
//	   			msg.addRecipient(Message.RecipientType.CC,addresBcc2); 
//	   			
//	   			msg.setSubject(email_Subject);
//				MimeBodyPart p1 = new MimeBodyPart();
//	   			p1.setText(Email_content,"text/html");
//	   			Multipart mp = new MimeMultipart();
//	   			mp.addBodyPart(p1);
//	   			
//	   			msg.setContent(mp);
//	       		
////	   			System.out.println("mailer "+msg);
//	       		Transport.send(msg);
//   		}
//		catch(Exception x)
//		{
//			x.printStackTrace();
//		} 
//	}
	
	/*public int SendEmails(Vector email_To,Vector email_BCC1,Vector email_BCC2,String email_Subject,String Email_content)
	{   
		int result = 1;
		//Session email_session = Session.getInstance(getEmailProperties(),null);
		try
   		{
			String email_From = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
			String email_CC = "";
			
			Properties props = System.getProperties();//new Properties();
			props.put("mail.smtp.host",Defs.SMTP_HOST);
			props.put("mail.smtp.auth","true");
//			props.put("mail.smtp.starttls.enable","false");
			props.put("mail.smtp.starttls.enable","true");
			
			System.out.println("Sending Email");
   	      
			Session session = null;
			session = Session.getDefaultInstance(props,new Authenticator()
			{
				public PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(Defs.AUTHENTICATOR_EMAIL_ADDRESS,Defs.AUTHENTICATOR_EMAIL_PASSWORD);}});
				session.setDebug(false);		 	
				Message msg = new MimeMessage(session);
	   			InternetAddress addressFrom = new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS);
	   			msg.setFrom(new InternetAddress(com.opcenter.workday.beans.Defs.stament_ccAddress,com.opcenter.workday.beans.Defs.stament_ccAddress));
	   			InternetAddress addressTo=null;
	   			String email_to="",email_bcc1="",email_bcc2="";
	   			
	   			for(int ln_mail=0;ln_mail<email_To.size();ln_mail++)
	   			{
	   				email_to = email_To.get(ln_mail).toString().trim();
	   				addressTo = new InternetAddress(email_to);
	   				msg.addRecipient(Message.RecipientType.TO,addressTo); 
	   			}
	   			
	   			InternetAddress addresBcc1=null;
	   			for(int ln_mail=0;ln_mail<email_BCC1.size();ln_mail++)
	   			{
	   				email_bcc1 = email_BCC1.get(ln_mail).toString().trim();
	   				addresBcc1 = new InternetAddress(email_bcc1);
		   			msg.addRecipient(Message.RecipientType.CC,addresBcc1);
	   			}
	   			
	   			InternetAddress addresBcc2 = null;
	   			for(int ln_mail=0;ln_mail<email_BCC2.size();ln_mail++)
	   			{
	   				email_bcc2 = email_BCC2.get(ln_mail).toString().trim();
	   				addresBcc2 = new InternetAddress(email_bcc2);
		   			msg.addRecipient(Message.RecipientType.CC,addresBcc2);
	   			}
 
	   			msg.setSubject(email_Subject);
				MimeBodyPart p1 = new MimeBodyPart();
	   			p1.setContent(Email_content,"text/html");
	   			p1.setText(Email_content);
	   			Multipart mp = new MimeMultipart();
	   			mp.addBodyPart(p1);
	   			
	   			msg.setContent(mp);
	       		
//	   			System.out.println("mailer "+msg);
	       		Transport.send(msg);
	       		
	       		System.out.println("result..."+result);
   		}
		catch(Exception x)
		{
			result=0;
			x.printStackTrace();
			
		} 
		return result;
	}*/
	public int sendMail(Vector email_To,Vector email_BCC1, String subject, String content, String pdfname,String file)
    throws MessagingException {

	  	int result = -1;
	  	String host = Defs.SMTP_HOST;
	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
	
	  	// Create properties, get Session
	  	Properties props = System.getProperties(); 
	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
		props.put("mail.smtp.auth","true");
	//	props.put("mail.smtp.starttls.enable","false");
		props.put("mail.smtp.starttls.enable","true");
		
		
	
		Session mailSession = null;
		mailSession = 	Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(user));
		/*InternetAddress[] address = { new InternetAddress(toemail) };
		msg.setRecipients(Message.RecipientType.TO, address);
	
		if(ccemail.length()>0)
		{
		  	InternetAddress[] ccaddress = { new InternetAddress(ccemail) };
		  	msg.setRecipients(Message.RecipientType.CC, ccaddress);
		}*/
		
		String email_to="",email_bcc1="";
		InternetAddress addressTo=null;
		for(int ln_mail=0;ln_mail<email_To.size();ln_mail++)
		{
			email_to = email_To.get(ln_mail).toString().trim();
			addressTo = new InternetAddress(email_to);
			msg.addRecipient(Message.RecipientType.TO,addressTo); 
		}
		
		InternetAddress addresBcc1=null;
		for(int ln_mail=0;ln_mail<email_BCC1.size();ln_mail++)
		{
			email_bcc1 = email_BCC1.get(ln_mail).toString().trim();
			addresBcc1 = new InternetAddress(email_bcc1);
			msg.addRecipient(Message.RecipientType.CC,addresBcc1);
		}
		
	
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setContent(content, "text/html");
		msg.setText(content);
	
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(content);
	
		if(file.length()>0)
		{
	   	Multipart multipart = new MimeMultipart();		
	   	multipart.addBodyPart(messageBodyPart);	
	   	addAtachments(file, multipart,pdfname);		
	   	msg.setContent(multipart);
		}
	
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(host, user, pass);
		transport.sendMessage(msg,msg.getAllRecipients());
		transport.close();     
		result = 1;
		System.out.println("Email send successfully..Mailer...");
		return result;
	}
	 protected void addAtachments(String attachments, Multipart multipart,String pdfname)
		throws MessagingException, AddressException
	{
	//	for(int i = 0; i<= attachments.length -1; i++ )
	//	{
			String filename = attachments;
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));			
			attachmentBodyPart.setFileName(pdfname);		 
			multipart.addBodyPart(attachmentBodyPart);
	//	}
	}
/*
 *     email with attachments
 */	
	public void emailattachments(String email_To ,String email_BCC1,String email_BCC2, String email_Subject, String Email_content ,String email_attachmentFilePath)
	{
  		//Session email_session = Session.getInstance(getEmailProperties(),null);
  		
//		String email_CC="";
        try {
	        	Properties props = System.getProperties();//new Properties();
	   			props.put("mail.smtp.host",Defs.SMTP_HOST);
	 			props.put("mail.smtp.auth","true");
	   			props.put("mail.smtp.starttls.enable","true");
	   			
				Session session = Session.getDefaultInstance(props,new Authenticator()
			{
				public PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(Defs.AUTHENTICATOR_EMAIL_ADDRESS,Defs.AUTHENTICATOR_EMAIL_PASSWORD);}});
				session.setDebug(false);		 	
				Message msg = new MimeMessage(session);
	   			InternetAddress addressFrom = new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS);
	   			msg.setFrom(addressFrom);
	   			
	   			InternetAddress addressTo = new InternetAddress(email_To);	
   			
	   			if(email_BCC1.equalsIgnoreCase(""))
	   			{
	   				
	   			}
	   			else
	   			{
		   			InternetAddress addressCc1 = new InternetAddress(email_BCC1);
		   			msg.addRecipient(Message.RecipientType.CC,addressCc1);
	   			
	   			}
   			
	   			if(email_BCC2.equalsIgnoreCase(""))
	   			{
	   				
	   			}
	   			else
	   			{
	   				InternetAddress addressCc2 = new InternetAddress(email_BCC2);
	   				msg.addRecipient(Message.RecipientType.CC,addressCc2);
	   			}
   			
	   			msg.addRecipient(Message.RecipientType.TO,addressTo); 
   			
//   			msg.addRecipient(Message.RecipientType.BCC,addresBcc1); 
//   			msg.addRecipient(Message.RecipientType.BCC,addresBcc2);
   			
	   			msg.setSubject(email_Subject);
				MimeBodyPart p1 = new MimeBodyPart();
	   			p1.setText(Email_content,"text/html");
	   			Multipart mp = new MimeMultipart();
	   			mp.addBodyPart(p1);
	   			
	   			/**/
	   			MimeBodyPart p3 = new MimeBodyPart();
	   			FileDataSource fds1 = new FileDataSource(email_attachmentFilePath);
	   			p3.setDataHandler(new DataHandler(fds1));
	   			p3.setFileName(fds1.getName());
	   			mp.addBodyPart(p3);
	   			/**/
	       		msg.setContent(mp);
	       		
	       		Transport.send(msg);

        }
        catch (MessagingException exc_MessageException) 
        {
            exc_MessageException.printStackTrace();
            
            while (exc_MessageException.getNextException() != null)
            {
                Exception ex = exc_MessageException.getNextException();
                	ex.printStackTrace();
                	if (!(ex instanceof MessagingException))
                		break;
                	else 
                		exc_MessageException = (MessagingException)ex;
            }
            System.out.println(exc_MessageException.getMessage());
        }
	}
	
//	public void emailBCCattachments(String email_From, String emailBCC_To , String email_Subject, String Email_content ,String email_attachmentFilePath)
//	{
//  		Session email_session = Session.getInstance(getEmailProperties(),null);
//
//        try {
//            /****************** Get a Transport object to send e-mail*************************/
//            Transport email_Transporter = email_session.getTransport(Defs.MAIL_TRANSPORT_PROTOCOL);
//
//            /********* Connect only once here Transport.send() disconnects after each send
//             Usually, no username and password is required for SMTP************************/
//           // email_Transporter.connect();
//           email_Transporter.connect(Defs.SMTP_HOST,Defs.AUTHENTICATOR_EMAIL_ADDRESS , Defs.AUTHENTICATOR_EMAIL_PASSWORD);
//
//            /********************instantiate a message*************************/
//            Message email_Message = new MimeMessage(email_session);
//
//            /**************************** Set message attributes*****************************************/
//            /********* 1. setting FROM address ***********************/
//            email_Message.setFrom(new InternetAddress(email_From));
//
//            /********* 2. setting TO address or TO Addresses***********************/
//            InternetAddress[] address = {new InternetAddress(emailBCC_To)};
//            email_Message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailBCC_To, false));
//         
//            /********* 3. setting CC address or CC Addresses***********************/
//            /************** Parse a comma-separated list of email addresses. Be strict.********************/
//            email_Message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(emailBCC_To, false));
//            
//            /********* 4. setting BCC address or BCC Addresses***********************/
//            /*************** Parse comma/space-separated list.*********************/
//            email_Message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(emailBCC_To, true));
//
//            /********* 5. setting SUBJECT for E-mail **********************/
//            email_Message.setSubject(email_Subject);
//            
//            /********* 6. setting SENT DATE for E-mail **********************/
//            email_Message.setSentDate(new Date());
//
//            /********* 7. setting EMail Message & ATTACHMENT for E-mail **********************/
//            setFileAsAttachment(email_Message, Email_content, email_attachmentFilePath);
//            
//            /********* 8. Commiting the email Message contents **********************/
//            email_Message.saveChanges();
//            
//            /********* 9. Sending the email  **********************/
//            email_Transporter.sendMessage(email_Message, address);           
//            
//            /********* 10.closing the transporter  **********************/
//            email_Transporter.close();
//
//        }
//        catch (MessagingException exc_MessageException) {
//           
//            exc_MessageException.printStackTrace();
//            while (exc_MessageException.getNextException() != null)
//            {
//                Exception ex = exc_MessageException.getNextException();
//                	ex.printStackTrace();
//                	if (!(ex instanceof MessagingException))
//                		break;
//                	else 
//                		exc_MessageException = (MessagingException)ex;
//            }
//        }
//		
//	}
		
	/*
	 * multi part email - more than one kind of mimetype messages are sent in a single mail
	 * 
	 */
	
//	public void emailMultiPart(String email_From, String email_To , String email_Subject, String[] Email_content)
//	{
//		Session email_session = Session.getInstance(getEmailProperties(),null);
//
//        try {
//            /****************** Get a Transport object to send e-mail*************************/
//            Transport email_Transporter = email_session.getTransport(Defs.MAIL_TRANSPORT_PROTOCOL);
//
//            /********* Connect only once here Transport.send() disconnects after each send
//             Usually, no username and password is required for SMTP************************/
//           // email_Transporter.connect();
//            email_Transporter.connect(Defs.SMTP_HOST,Defs.AUTHENTICATOR_EMAIL_ADDRESS , Defs.AUTHENTICATOR_EMAIL_PASSWORD);
//
//            /********************instantiate a message*************************/
//            Message email_Message = new MimeMessage(email_session);
//
//            /**************************** Set message attributes*****************************************/
//            /********* 1. setting FROM address ***********************/
//            email_Message.setFrom(new InternetAddress(email_From));
//
//            /********* 2. setting TO address or TO Addresses***********************/
//            InternetAddress[] address = {new InternetAddress(email_To)};
//            email_Message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_To, true));
//         
//            /********* 3. setting CC address or CC Addresses***********************/
//            /************** Parse a comma-separated list of email addresses. Be strict.********************/
//            email_Message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(email_To, true));
//            
//            /********* 4. setting BCC address or BCC Addresses***********************/
//            /*************** Parse comma/space-separated list.*********************/
//            email_Message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(email_To, false));
//
//            /********* 5. setting SUBJECT for E-mail **********************/
//            email_Message.setSubject(email_Subject);
//            
//            /********* 6. setting SENT DATE for E-mail **********************/
//            email_Message.setSentDate(new Date());
//
//            /********* 7. setting Multipart Email Message  **********************/
//            setMultipartContent(email_Message ,Email_content);
//            /********* 8. Commiting the email Message contents **********************/
//            email_Message.saveChanges();
//            
//            /********* 9. Sending the email  **********************/
//            email_Transporter.sendMessage(email_Message, address);           
//            
//            /********* 10.closing the transporter  **********************/
//            email_Transporter.close();
//
//        }
//        catch (MessagingException exc_MessageException) {
//           
//            exc_MessageException.printStackTrace();
//            while (exc_MessageException.getNextException() != null)
//            {
//                Exception ex = exc_MessageException.getNextException();
//                	ex.printStackTrace();
//                	if (!(ex instanceof MessagingException))
//                		break;
//                	else 
//                		exc_MessageException = (MessagingException)ex;
//            }
//        }
//	}
	
	/*
	 *  sending html texts
	 * 
	 */
//	public void emailMIME(String email_From, String email_To , String email_Subject , String Email_content)
//	{		Session email_session = Session.getInstance(getEmailProperties(),null);
//
//    try {
//        /****************** Get a Transport object to send e-mail*************************/
//        Transport email_Transporter = email_session.getTransport(Defs.MAIL_TRANSPORT_PROTOCOL);
//
//        /********* Connect only once here Transport.send() disconnects after each send
//         Usually, no username and password is required for SMTP************************/
//       // email_Transporter.connect();
//        email_Transporter.connect(Defs.SMTP_HOST,Defs.AUTHENTICATOR_EMAIL_ADDRESS , Defs.AUTHENTICATOR_EMAIL_PASSWORD);
//
//        /********************instantiate a message*************************/
//        Message email_Message = new MimeMessage(email_session);
//
//        /**************************** Set message attributes*****************************************/
//        /********* 1. setting FROM address ***********************/
//        email_Message.setFrom(new InternetAddress(email_From));
//
//        /********* 2. setting TO address or TO Addresses***********************/
//        InternetAddress[] address = {new InternetAddress(email_To)};
//        email_Message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_To, true));
//     
//        /********* 3. setting CC address or CC Addresses***********************/
//        /************** Parse a comma-separated list of email addresses. Be strict.********************/
//        email_Message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(email_To, true));
//        
//        /********* 4. setting BCC address or BCC Addresses***********************/
//        /*************** Parse comma/space-separated list.*********************/
//        email_Message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(email_To, false));
//
//        /********* 5. setting SUBJECT for E-mail **********************/
//        email_Message.setSubject(email_Subject);
//        
//        /********* 6. setting SENT DATE for E-mail **********************/
//        email_Message.setSentDate(new Date());
//        
//        /********* 7. setting (MIME)HTML TEXT Email Message  **********************/
//        setHTMLContent(email_Message,Email_content);
//        
//        /********* 8. Commiting the email Message contents **********************/
//        email_Message.saveChanges();
//        
//        /********* 9. Sending the email  **********************/
//        email_Transporter.sendMessage(email_Message, address);           
//            
//        /********* 10.closing the transporter  **********************/
//        email_Transporter.close();
//
//        }
//        catch (MessagingException exc_MessageException) {
//           
//            exc_MessageException.printStackTrace();
//            while (exc_MessageException.getNextException() != null)
//            {
//                Exception ex = exc_MessageException.getNextException();
//                	ex.printStackTrace();
//                	if (!(ex instanceof MessagingException))
//                		break;
//                	else 
//                		exc_MessageException = (MessagingException)ex;
//            }
//        }
//		
//	}
	
   /*
    * local method for setting simple normal text
    */

//    private  void setTextContent(Message msg , String Email_content) throws MessagingException
//    {
//            // Set message content
//            msg.setText(Email_content);
//            // Alternate form
//            msg.setContent(Email_content, "text/plain");
//
//    }

    /*
     * local method for setting A simple multipart/mixed e-mail. Both body parts are text/plain.
     */
//    private  void setMultipartContent(Message msg , String[] Email_content) throws MessagingException
//    {
//    	
//    	int ln_BodyPartLength = Email_content.length;
//    	
//    	MimeBodyPart[] bodypart = null;
//    	Multipart multipart = new MimeMultipart();
//    	for(int Part_index=0;Part_index<ln_BodyPartLength;Part_index++)
//    	{
//    		bodypart[Part_index] = new MimeBodyPart();
//    		bodypart[Part_index].setText(Email_content[Part_index]);
//    		multipart.addBodyPart(bodypart[Part_index]);
//    	}
//    	
//    	msg.setContent(multipart);
//    	
//    	/*    <      <---<< remove this vijai if problem occurs    >
//    	  
//        // Create and fill first part
//        MimeBodyPart p1 = new MimeBodyPart();
//        p1.setText("hi buddy \n \t This is a test mail with attachements. \n\n  GLC successfully accomplished  multipart mail transfer \n with regards \n S.Vijai K");
//
//        // Create and fill second part
//        MimeBodyPart p2 = new MimeBodyPart();
//        // Here is how to set a charset on textual content
//        p2.setText("multipart messenger bodypart with US-ascii  - Opcenter .", "us-ascii");
//
//        // Create the Multipart.  Add BodyParts to it.
//        Multipart mp = new MimeMultipart();
//        mp.addBodyPart(p1);
//        mp.addBodyPart(p2);
//
//        // Set Multipart as the message's content
//        msg.setContent(mp);
//         
//         
//         <remove this vijai if problem occurs     >>>---->     >         */ 
//    }
//
//    /*
//     * local method for setting a file as an attachment.  Uses JAF FileDataSource.
//     */
//
//
//    private  void setFileAsAttachment(Message msg, String Email_content, String filename)  throws MessagingException {
//
//        // Create and fill first part
//        MimeBodyPart p1 = new MimeBodyPart();
//        p1.setText(Email_content,"text/html");
//
//        // Create second part
//        MimeBodyPart p2 = new MimeBodyPart();
//
//        // Put a file in the second part
//        FileDataSource fds = new FileDataSource(filename);
//        p2.setDataHandler(new DataHandler(fds));
//        p2.setFileName(fds.getName());
//
//        // Create the Multipart.  Add BodyParts to it.
//        Multipart mp = new MimeMultipart();
//        mp.addBodyPart(p1);
//        mp.addBodyPart(p2);
//
//        // Set Multipart as the message's content
//        msg.setContent(mp);
//    }
//
//    /*
//     * local method for setting a single part html content.Sending data of any type is similar.
//     */
//
//
//    private  void setHTMLContent(Message msg,String Email_content) throws MessagingException 
//    {   // HTMLDataSource is an inner class
//        msg.setDataHandler(new DataHandler(new HTMLDataSource(Email_content)));
//    }
//    
//    //this is an inner class
//    static class HTMLDataSource implements DataSource
//    {
//        private String html;
//
//        public HTMLDataSource(String htmlString)
//        {
//            html = htmlString;
//        }
//
//        // Return html string in an InputStream.a new stream must be returned each time.
//        public InputStream getInputStream() throws IOException
//        {
//            if (html == null) throw new IOException("Null HTML");
//            	return new ByteArrayInputStream(html.getBytes());
//        }
//
//        public OutputStream getOutputStream() throws IOException
//        {
//            throw new IOException("This DataHandler cannot write HTML");
//        }
//
//        public String getContentType() 
//        {
//            return "text/html";
//        }
//
//        public String getName() 
//        {
//            return " text/html dataSource to send e-mail only";
//        }
//    }
    /*public void sendMail(String to,String subject,String content) {
		InternetAddress addressTo;
		try {
			addressTo = new InternetAddress(to);
			String from = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host","smtp.gmail.com");
	        properties.put("mail.smtp.auth","true");
	        properties.put("mail.smtp.starttls.enable","true");
	        Session session = Session.getDefaultInstance(properties,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication(){ 
					return new PasswordAuthentication(Defs.AUTHENTICATOR_EMAIL_ADDRESS,Defs.AUTHENTICATOR_EMAIL_PASSWORD);
				}
			});
            MimeMessage message = new MimeMessage(session);
            try {
				message.setFrom(new InternetAddress(from,from));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
            message.setRecipient(Message.RecipientType.TO, addressTo);
            message.setSubject(subject);
            message.setSentDate(new Date());
            
			MimeBodyPart p1 = new MimeBodyPart();
   			p1.setContent(content, "text/html");
   			Multipart mp = new MimeMultipart();
   			mp.addBodyPart(p1);
   			
   			message.setContent(mp);
       		Transport.send(message);
            System.out.println("Email Send Successfully....");
        } catch (AddressException e2) {
        	e2.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}*/

//  public static void main(String args[]) throws MessagingException
//  {
//		String emailaddr ="",ccemail="",file="",pdfname="",body="",client="",query = "",licencecount="",time="",currentdate="";
//		query = "select from "+am_companydetails.class.getName();
//		
//		Vector<String> emailto,emailcc;
//		emailaddr = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
////	    client = "Southern Tier Brewing Company";
//		String subject = "Licenses added";
//		licencecount = "4";
//		time = "4:15 PM";
//		ccemail = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
//		currentdate = "09/03/2011";
//		body = "Client : "+client +"/n"+"# licenses added : " +licencecount+"/n"+"PO #:"+"121"+"/n"+"Signed by:"+"A Cooper"+"/n"+"Title : "+"CFO" +"/n"+"Date : "+currentdate +"/n"+" Time : "+time;
//		Mailer obj_emailsend = new Mailer();
//		emailto = new Vector<String>();
//		emailcc = new Vector<String>();
//		emailto.add(emailaddr);
//		emailcc.add(ccemail);
//	    obj_emailsend.sendMail(emailto, emailcc, subject, body, pdfname, file);
//	    System.out.println("Email...>");
//  }
} //End of class