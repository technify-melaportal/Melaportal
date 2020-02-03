package com.beerrun.common;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class emailsend 
{ 
	
	
//	public void setAuthentication(String username,String password)
//	{
//	  	Defs.AUTHENTICATOR_EMAIL_ADDRESS=username;
//   	  	Defs.AUTHENTICATOR_EMAIL_PASSWORD=password;
//	}
	
	
	
	public int SendAppEmail(String fromadd,String frompass,String toemail,String ccemail, String subject, String content, String pdfname,String file,String username)  throws MessagingException 
	{
	 	int result = -1;
		Properties props = new Properties(); 
		Session session = Session.getDefaultInstance(props, null);    
		try {     
//				System.out.println("Inside Mail Try Function start");
				Message msg = new MimeMessage(session);   
				
				if(fromadd.equalsIgnoreCase("")){
					msg.setFrom(new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS));//, "technify"));  
					msg.addRecipient(Message.RecipientType.BCC,new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS));
				}
				else
				{
					msg.setFrom(new InternetAddress(fromadd));//, "technify"));
					msg.addRecipient(Message.RecipientType.BCC,new InternetAddress(fromadd));
				}
				
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail,username)); 
				if(ccemail.length()>0)
				{
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(ccemail));	
				}
			
				
				msg.setSubject(subject);      
				
								
				
				MimeBodyPart p1 = new MimeBodyPart();
	   			p1.setText(content,"text/plain");
	   			Multipart mp = new MimeMultipart();
	   			mp.addBodyPart(p1);
	   			msg.setContent(mp);
	       		
//	   			System.out.println("mailer "+msg);
	       		Transport.send(msg);
				result =1;
			}
		    catch (AddressException e)
		    { 
		    	System.out.println("Inside Mail Catch Function 1");
		    	e.printStackTrace();
			}
			catch (MessagingException e)
			{     
				System.out.println("Inside Mail Catch 2");
				e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
				
				e.printStackTrace();
		}
		 return  result;
	}
	
	
	public int SendAppEmailtoMany(String toemail,Vector ccemail, String subject, String content, String pdfname,String file,String username)  throws MessagingException 
	{
	 	int result = -1;
		Properties props = new Properties(); 
		Session session = Session.getDefaultInstance(props, null);  
		Vector eachelement=new Vector();
		String cmail="",cname="";
		
		
		try {     
//				System.out.println("Inside Mail Try Function start");
				Message msg = new MimeMessage(session);   
				msg.setFrom(new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS));//, "technify"));  
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail,username)); 
			
				
				if(ccemail.size()>0)
				{
					for(int i=0;i<ccemail.size();i++)
					{
						cmail="";cname="";
						
						eachelement=(Vector) ccemail.get(i);
						if(eachelement.size()>0)
						cmail=eachelement.get(0).toString();
						if(eachelement.size()>1)
						cname=eachelement.get(1).toString();
						
						msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cmail,cname));	
					}
					
				}
				msg.setSubject(subject);      
				
				MimeBodyPart p1 = new MimeBodyPart();
	   			p1.setText(content,"text/plain");
	   			Multipart mp = new MimeMultipart();
	   			mp.addBodyPart(p1);
	   			msg.setContent(mp);
	       		
//	   			System.out.println("mailer "+msg);
	       		Transport.send(msg);
				result =1;
			}
		    catch (AddressException e)
		    { 
		    	System.out.println("Inside Mail Catch Function 1");
		    	e.printStackTrace();
			}
			catch (MessagingException e)
			{     
				System.out.println("Inside Mail Catch 2");
				e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
				
				e.printStackTrace();
		}
		 return  result;
	}
	
//	=======================================================================================================================================================
	public int sendMail(String user,String pass,String toemail,String ccemail,String bccemail, String subject, String content, String pdfname,String file)
           throws MessagingException {
		
   	  	int result = -1;
   	  	String host = Defs.SMTP_HOST;
   	  	
//   	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
//   	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
      
   	  	// Create properties, get Session
   	  	Properties props = System.getProperties(); 
   	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
      
      	Session mailSession = Session.getDefaultInstance(props, null);
      	Message msg = new MimeMessage(mailSession);
      	msg.setFrom(new InternetAddress(user));
      	InternetAddress[] address = { new InternetAddress(toemail) };
      	System.out.println("ccemail"+address);
      	msg.setRecipients(Message.RecipientType.TO, address);
      
      	if(ccemail.length()>0)
      	{
    	  	InternetAddress[] ccaddress = { new InternetAddress(ccemail) };
    	  	msg.setRecipients(Message.RecipientType.CC, ccaddress);
      	}
      	
      	if(bccemail.length()>0)
      	{
	      	InternetAddress addressbcc=null;
			int emailaddress=0;
			
			String temp="";
			Vector vct_cc=new Vector();
		    StringTokenizer obj_st = new StringTokenizer(bccemail, ",");
			{
				while(obj_st.hasMoreTokens())
				{ 
		    			temp = obj_st.nextToken();
		    			vct_cc.add(temp);
				}
			}
			emailaddress=vct_cc.size();
			for(int index=0;index<emailaddress;index++) //email_To.size()
			{
			
				addressbcc=new InternetAddress(vct_cc.get(index).toString());
				
				msg.addRecipient(Message.RecipientType.BCC,addressbcc); 
			
			}
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
      	System.out.println(".....Email send successfully.....");
   	  	
//   	 Properties props = new Properties();
//     props.put("mail.smtp.host", "smtp.gmail.com");
//     props.put("mail.from", "na@opcenterllc.com");
//     Session session = Session.getInstance(props, null);
//
//     try {
//         MimeMessage msg = new MimeMessage(session);
//         msg.setFrom();
//         msg.setRecipients(Message.RecipientType.TO,
//                           "na@opcenterllc.com");
//         msg.setSubject("JavaMail hello world example");
//         msg.setSentDate(new Date());
//         msg.setText("Hello, world!\n");
//         Transport.send(msg);
//     } catch (MessagingException mex) {
//         System.out.println("send failed, exception: " + mex);
//     }
      	return result;
	}
	
	
	public int emailAll(Vector toemail, Vector ccemail, String subject,String content, String pdfname, String file)
			throws MessagingException {

		int result = -1;
		String temp = "";
		int index = 0;
		String host = Defs.SMTP_HOST;

		String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
		String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;

		// Create properties, get Session
		Properties props = System.getProperties();
		props.put("mail.smtp.host", Defs.SMTP_HOST);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session mailSession = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(user));

		InternetAddress[] ccaddress;

		if (toemail.size() > 0) {
			ccaddress = new InternetAddress[toemail.size()];
			for (index = 0; index < toemail.size(); index++) {
				temp = toemail.get(index).toString();
				ccaddress[index] = new InternetAddress(temp);
			}

			msg.setRecipients(Message.RecipientType.CC, ccaddress);
		}

		if (ccemail.size() > 0) {
			ccaddress = new InternetAddress[ccemail.size()];
			for (index = 0; index < ccemail.size(); index++) {
				temp = ccemail.get(index).toString();
				ccaddress[index] = new InternetAddress(temp);
			}

			msg.setRecipients(Message.RecipientType.CC, ccaddress);
		}

		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setContent(content, "text/html");
		msg.setText(content);

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(content);

		if (file.length() > 0) {
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			addAtachments(file, multipart, pdfname);
			msg.setContent(multipart);
		}

		Transport transport = mailSession.getTransport("smtp");
		transport.connect(host, user, pass);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		result = 1;
		System.out.println("....Email send successfully.....");
		return result;
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------
	
	
	public int sendMailALL(String toemail,Vector ccemail, String subject, String content, String pdfname,String file)
		throws MessagingException {
	
		int result = -1;
   	  	String host = Defs.SMTP_HOST;
//   	  	Vector vct_inner1 = new Vector();
   		 
   	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
   	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
      
   	  	// Create properties, get Session
   	  	Properties props = System.getProperties(); 
   	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
      
      	Session mailSession = Session.getDefaultInstance(props, null);
      	Message msg = new MimeMessage(mailSession);
      	msg.setFrom(new InternetAddress(user));
      	InternetAddress[] address = { new InternetAddress(toemail) };
      	msg.setRecipients(Message.RecipientType.TO, address);
      
      	InternetAddress[] ccaddress;
      	
    		
      	if(ccemail.size()>0)
	  	{
			ccaddress=new InternetAddress[ccemail.size()];
			for(int index=0;index<ccemail.size();index++)
			{
				String temp=ccemail.get(index).toString().trim();
				ccaddress[index]=new InternetAddress(temp);
			}
			
		  	msg.setRecipients(Message.RecipientType.CC,ccaddress);
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
      	System.out.println(".....Email send successfully.....");
      	

	return result;
}
	
    protected void addAtachments(String attachments, Multipart multipart,String pdfname)
			throws MessagingException, AddressException
	{
//		for(int i = 0; i<= attachments.length -1; i++ )
//		{
			String filename = attachments;
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));			
			attachmentBodyPart.setFileName(pdfname);		 
			multipart.addBodyPart(attachmentBodyPart);
//		}
	}
   
   	public static void main(String[] args) 
	{
		/*
		String toemail="",subject,body, messageBody;
		String[] file = new String[1];
		
		toemail = "technify.jk@gmail.com";
		subject = "We enclose an RMA as requested. It consists of a Packing List to be inserted into the box, and an RMA Bar code to be stuck outside the box.";
		body = "RMA C7126";
		messageBody = "testing email for RMA C7126";
		file[0] = "F:/JK/19-11-2010/WindsorRMA/WebContent/windsor_documents/Documents/RMAAndShipping/C7126.pdf";
		
		try
		{
			emailsend obj_email = new emailsend();
//			obj_email.sendMail(toemail,subject,body,messageBody,file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Email send successfully.....");
		*/
   		String toemail="",ccemail="",subject="",content="",pdfname="",file="";
   		try
		{
//   			toemail="pi@opcenterllc.com,na@opcenterllc.com,siva@opcenterllc.com";
//   			toemail="na@opcenterllc.com";
//   			ccemail="technify.siva@gmail.com";
//   			subject="Confirmation:";
//   			content="GAE Mail verification";
//   			file="C:\\Users\\technify14\\Desktop\\Restart Griaule.bmp";
//   			pdfname="BeerRunFeedback.bmp";
//   			
//			emailsend obj_email = new emailsend();
//			obj_email.sendMail(toemail,ccemail,subject,content,pdfname,file);
//			
//			
		   Vector to=new Vector();
//			to.add("pi@opcenterllc.com");
//			to.add(" ");
//			to.add(" ");
			
			Vector cc=new Vector();
			
//			obj_email.sendMailALL(to,cc,subject,content,pdfname,file);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public int sendMail_supp(String toemail, Vector cctoadd,
			String subject, String body, String pdfname, String file,
			String name)  throws MessagingException 
	{
		int result = -1;
		try 
		{
			
		  	String host = Defs.SMTP_HOST;
		  	
		  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
		  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
		
		  	// Create properties, get Session
		  	Properties props = System.getProperties(); 
		  	props.put("mail.smtp.host",Defs.SMTP_HOST);
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable","true");
		
			Session mailSession = Session.getDefaultInstance(props, null);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(user));
			InternetAddress[] address = { new InternetAddress(toemail) };
			msg.setRecipients(Message.RecipientType.TO, address);

			InternetAddress[] ccaddress;

			if(cctoadd.size()>0)
		  	{
				ccaddress=new InternetAddress[cctoadd.size()];
				for(int index=0;index<cctoadd.size();index++)
				{
					String temp=cctoadd.get(index).toString().trim();
					ccaddress[index]=new InternetAddress(temp);
				}
				
			  	msg.setRecipients(Message.RecipientType.CC,ccaddress);
		  	}
//			int i = 0;
//			for(i = 0;i<cctoadd.size();i++)
//			{
//			  	
//			}
		
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(body, "text/html");
			msg.setText(body);
		
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
		
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
			System.out.println(".....Email send successfully.....");
		  	
		// Properties props = new Properties();
		//props.put("mail.smtp.host", "smtp.gmail.com");
		//props.put("mail.from", "na@opcenterllc.com");
		//Session session = Session.getInstance(props, null);
		//
		//try {
		//  MimeMessage msg = new MimeMessage(session);
		//  msg.setFrom();
		//  msg.setRecipients(Message.RecipientType.TO,
		//                    "na@opcenterllc.com");
		//  msg.setSubject("JavaMail hello world example");
		//  msg.setSentDate(new Date());
		//  msg.setText("Hello, world!\n");
		//  Transport.send(msg);
		//} catch (MessagingException mex) {
		//  System.out.println("send failed, exception: " + mex);
		//}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
		
	}

//    toemail,ccemail,subject,body,pdfname,file
	
	public void sendMailALL_support(String toemail, String ccemail,String subject, String body, String pdfname, String file) 
	{
		try {
			
		
		int result = -1;
   	  	String host = Defs.SMTP_HOST;
//   	  	Vector vct_inner1 = new Vector();
   		 
   	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
   	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
      
   	  	// Create properties, get Session
   	  	Properties props = System.getProperties(); 
   	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
      
      	Session mailSession = Session.getDefaultInstance(props, null);
      	Message msg = new MimeMessage(mailSession);
      	msg.setFrom(new InternetAddress(user));
      	InternetAddress[] address = { new InternetAddress(toemail) };
      	msg.setRecipients(Message.RecipientType.TO, address);
      
//      	InternetAddress[] ccaddress;
      	
      	
    	if(!ccemail.equalsIgnoreCase(""))
    	{
//    		ccaddress=new InternetAddress[ccemail];
    		InternetAddress[] ccaddress = { new InternetAddress(ccemail) };
    	  	msg.setRecipients(Message.RecipientType.CC, ccaddress);
    	}
      	/*if(ccemail.size()>0)
	  	{
			ccaddress=new InternetAddress[ccemail.size()];
			for(int index=0;index<ccemail.size();index++)
			{
				String temp=ccemail.get(index).toString().trim();
				ccaddress[index]=new InternetAddress(temp);
			}
			
		  	msg.setRecipients(Message.RecipientType.CC,ccaddress);
	  	}*/
      
      	msg.setSubject(subject);
      	msg.setSentDate(new Date());
      	msg.setContent(body, "text/html");
      	msg.setText(body);
      
      	BodyPart messageBodyPart = new MimeBodyPart();
      	messageBodyPart.setText(body);
	
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
      	System.out.println(".....Email send successfully.....");
      	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
//	return result;

		
	}
   	
	// kr for Emailing SO & PO
	
	public int sendMailALL_SOPO(String toemail,Vector ccemail, String subject, String content, String pdfname,String file, final String sendorUser, final String sendorPass)throws MessagingException 
	{
	
		int result = -1;
		
	
		String host = Defs.SMTP_HOST;
		String user="",pass="";
	  	
		System.out.println("ccemail value is----"+ccemail);
//	    		String email_CC="";
			System.out.println("Mail Sending---------->"+file);
			
			
            Properties props =System.getProperties();//new Properties();
       			props.put("mail.smtp.host",Defs.SMTP_HOST);
     			props.put("mail.smtp.auth","true");
       			props.put("mail.smtp.starttls.enable","true");
     //  			props.put("mail.smtp.port", "587");

       		
       			
				if(sendorUser.equalsIgnoreCase("") && sendorPass.equalsIgnoreCase(""))
				{
					user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
					pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
			   	  	
//					Session session = Session.getDefaultInstance(props,new Authenticator()
//	    			{
//					public PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(Defs.AUTHENTICATOR_EMAIL_ADDRESS,Defs.AUTHENTICATOR_EMAIL_PASSWORD);}});
//	    			session.setDebug(false);		 	
//	    			msg = new MimeMessage(session);
//	       			InternetAddress addressFrom = new InternetAddress(Defs.AUTHENTICATOR_EMAIL_ADDRESS);
//	       			msg.setFrom(addressFrom);
				}
				else
				{
					user = sendorUser;
					pass =sendorPass;
//					Session session = Session.getDefaultInstance(props,new Authenticator()
//	    			{
//	    				public PasswordAuthentication getPasswordAuthentication(){ return new PasswordAuthentication(sendorUser,sendorPass);}});
//	    				session.setDebug(false);		 	
//	        			msg = new MimeMessage(session);
//	           			InternetAddress addressFrom = new InternetAddress(sendorUser);
//	           			msg.setFrom(addressFrom);
        		}
   			
				
      			Session mailSession = Session.getDefaultInstance(props, null);
				Message msg = new MimeMessage(mailSession);
			  	msg.setFrom(new InternetAddress(user));
			  	InternetAddress[] address = { new InternetAddress(toemail) };
			  	msg.setRecipients(Message.RecipientType.TO, address);
  
  	
       			
       			InternetAddress addressCc=null;
       			int emailaddress=0;
       			
       			String temp="";
       			Vector vct_cc=new Vector();
       			temp = ccemail.get(0).toString();
       			System.out.println("temp value is----"+temp);
       		    StringTokenizer obj_st = new StringTokenizer(temp, ",");
       			{
       				while(obj_st.hasMoreTokens())
       				{ 
   			    			temp = obj_st.nextToken();
   			    			vct_cc.add(temp);
   			    			System.out.println("inside while vct_cc value is----"+vct_cc);
       				}
       			}
       			
       			emailaddress=vct_cc.size();
       			System.out.println("emailaddress----->"+emailaddress);
   				
       	    
				 
				for(int index=0;index<emailaddress;index++) //email_To.size()
       			{
       			
       				addressCc=new InternetAddress(vct_cc.get(index).toString());
       				
       					msg.addRecipient(Message.RecipientType.CC,addressCc); 
       			
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
            System.out.println("end section--------->");
            return result;
}


	// kr support ticket 
	
	public int sendMail_support(String toemail,Vector ccemail, String subject, String content, String pdfname,String file,String pdfname1,String file1)
	throws MessagingException {

		System.out.println("enter the send mail suppor funtion------");
	int result = -1;
	  	String host = Defs.SMTP_HOST;
//	  	Vector vct_inner1 = new Vector();
		 
	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
  
	  	// Create properties, get Session
	  	Properties props = System.getProperties(); 
	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.starttls.enable","true");
  
  	Session mailSession = Session.getDefaultInstance(props, null);
  	Message msg = new MimeMessage(mailSession);
  	msg.setFrom(new InternetAddress(user));
  	InternetAddress[] address = { new InternetAddress(toemail) };
  	msg.setRecipients(Message.RecipientType.TO, address);
  
  	InternetAddress[] ccaddress;
  	
		
  	if(ccemail.size()>0)
  	{
		ccaddress=new InternetAddress[ccemail.size()];
		for(int index=0;index<ccemail.size();index++)
		{
			String temp=ccemail.get(index).toString().trim();
			ccaddress[index]=new InternetAddress(temp);
		}
		
	  	msg.setRecipients(Message.RecipientType.CC,ccaddress);
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
      	addAtachments_support(file, multipart,pdfname);	
      	if(!file1.equalsIgnoreCase("")) {
     	addAtachments_support(file1, multipart,pdfname1);	
      	}
      	msg.setContent(multipart);
  	}
  
  	//

  	BodyPart messageBodyPart1 = new MimeBodyPart();
  	messageBodyPart1.setText(content);
  System.out.println("messageBodyPart1------>"+messageBodyPart1);
/*  if(file1.length()>0)
  	{
      	Multipart multipart1 = new MimeMultipart();		
      	multipart1.addBodyPart(messageBodyPart1);	
      	addAtachments_support1(file1, multipart1,pdfname1);		
      	msg.setContent(multipart1);
  	}*/
  	
//  	System.out.println("msg------->"+msg);
  	
  	//
  	
  	Transport transport = mailSession.getTransport("smtp");
  	transport.connect(host, user, pass);
  	transport.sendMessage(msg,msg.getAllRecipients());
  	transport.close();     
  	result = 1;
  	System.out.println(".....Email send successfully.....");
  	

return result;
}

	//user welcome mail
	public int welcomeusermail(String toemail,Vector ccemail,String subject,String body) throws AddressException, MessagingException
	{
		String file="";
		int result = -1;
	  	String host = Defs.SMTP_HOST;
//	  	Vector vct_inner1 = new Vector();
		 
	  	String user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
	  	String pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
  
	  	// Create properties, get Session
	  	Properties props = System.getProperties(); 
	  	props.put("mail.smtp.host",Defs.SMTP_HOST);
	  	props.put("mail.smtp.auth","true");
	  	props.put("mail.smtp.starttls.enable","true");
  
	  	Session mailSession = Session.getDefaultInstance(props, null);
	  	Message msg = new MimeMessage(mailSession);
	  	msg.setFrom(new InternetAddress(user));
	  	InternetAddress[] address = { new InternetAddress(toemail) };
	  	msg.setRecipients(Message.RecipientType.TO, address);
  
	  	InternetAddress[] ccaddress;
  	
		
	  	if(ccemail.size()>0)
	  	{
			ccaddress=new InternetAddress[ccemail.size()];
			for(int index=0;index<ccemail.size();index++)
			{
				String temp=ccemail.get(index).toString().trim();
				ccaddress[index]=new InternetAddress(temp);
			}
			
		  	msg.setRecipients(Message.RecipientType.CC,ccaddress);
	  	}
  
	  	msg.setSubject(subject);
	  	msg.setSentDate(new Date());
	  	msg.setContent(body, "text/html");
	  	msg.setText(body);
	  	
	  	MimeBodyPart messageBodyPart = new MimeBodyPart();
	  	messageBodyPart.setText(body,"UTF-8","html");
  	
	  	Multipart multipart = new MimeMultipart();
	  	if(file.length()>0)
      	{
	      	multipart.addBodyPart(messageBodyPart);	
	      	addAtachments(file, multipart,"");		
	      	msg.setContent(multipart);
      	}
    	else
    	{
    		multipart.addBodyPart(messageBodyPart);
    		msg.setContent(multipart);
    	}
	  	
	  	
	  	Transport transport = mailSession.getTransport("smtp");
	  	transport.connect(host, user, pass);
	  	transport.sendMessage(msg,msg.getAllRecipients());
	  	transport.close();     
	  	result = 1;
	  	System.out.println(".....Email send successfully.....");
  	

	  	return result;
	}
	protected void addAtachments_support(String attachments, Multipart multipart,String pdfname)
			throws MessagingException, AddressException
	{
			String filename = attachments;
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));			
			attachmentBodyPart.setFileName(pdfname);		 
			multipart.addBodyPart(attachmentBodyPart);
	}
	
	
	protected void addAtachments_support1(String attachments, Multipart multipart,String pdfname)
			throws MessagingException, AddressException
	{
			String filename = attachments;
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));			
			attachmentBodyPart.setFileName(pdfname);		 
			multipart.addBodyPart(attachmentBodyPart);
	}
	
}