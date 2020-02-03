/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
package com.beerrun.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMail {
	private Session session;
	private String username;
	private String password;

	private String portNo;
	private String ldapServer;

	

	public SendMail() throws FileNotFoundException, IOException {
		Properties p = System.getProperties();
		System.out.println("enter the send mail function22222222222222222222222 ");
		p = new Properties();
		p.load(SendMail.class.getResourceAsStream("src/main/resources/messages.properties"));

		setUsername(p.getProperty("ldap.username"));
		
		setPassword(p.getProperty("ldap.password"));
		portNo = p.getProperty("ldap.port");
		System.out.println("port no--------->"+portNo);
		ldapServer = p.getProperty("ldap.host");

		Properties props = new Properties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ldapServer);
		props.put("mail.smtp.port", portNo);
		props.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
			System.out.println("22222222222222"+e1);
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.socketFactory", sf);
		// props.put("mail.smtp.starttls.enable", "false");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(getUsername(),
								getPassword());
					}
				});
		this.session = session;

	}

	public Session getSession() {
		return session;
	}

	
	public void sendMessage(String subject, String content, String to, HttpSession httpSession)
			throws MessagingException {

		// Transport.send(getMessage(subject, content, to)); 
		System.out.println("Done");

		try {
			String fromAdd = "technify.ganapathy@gmail.com";
			String toAdd = to;

			Boolean flag = true;
			Session session;
			Authenticator authenticator = new Authenticator() {
				private PasswordAuthentication authentication;
				{
					authentication = new PasswordAuthentication(
							"technify.ganapathy@gmail.com", "technifybala");
				}

				protected PasswordAuthentication getPasswordAuthentication() {
					return authentication;
				}
			};
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "mail.quascenta.com");

			// tls enabled
			
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.port", "587"); props.put("mail.smtp.auth",
			  "true");
			 
			// ssl enable
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");

			MailSSLSocketFactory sf = null;
			try {
				sf = new MailSSLSocketFactory();
			} catch (GeneralSecurityException e1) {
				e1.printStackTrace();
			}
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.socketFactory", sf);
			session = Session.getInstance(props, authenticator);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAdd));
			message.addRecipient(RecipientType.TO, new InternetAddress(toAdd));
			message.setSubject(subject);
			message.setText(content);
			
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	        Multipart multipart = new MimeMultipart();
	        String rootPath = null;
	        String fullPath = null;
	        
	        
	     // first part (the html)
	        String htmlText = content +"<br><br><img src=\"cid:image\">";
	        messageBodyPart.setContent(htmlText, "text/html");
	        // add it
	        multipart.addBodyPart(messageBodyPart);
	        
	    
	        
	        messageBodyPart = new MimeBodyPart();
	        
        	rootPath = httpSession.getServletContext().getRealPath("/"); //For local path
        	
        	 fullPath = rootPath +File.separator+ "images/img-logo.png";
 	        
 	        // second part (the image)
 	        messageBodyPart = new MimeBodyPart();
 	        DataSource fds = new FileDataSource(
 	        		fullPath);

 	        messageBodyPart.setDataHandler(new DataHandler(fds));
 	        messageBodyPart.setHeader("Content-ID", "<image>");
 	     
 	        multipart.addBodyPart(messageBodyPart);
	       
	        

           
	        message.setContent(multipart);
	        
			Transport.send(message);
			System.out.println("Done");

			flag = true;
			if (flag == false) {

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public void sendMessageWithOutLogo(String subject, String content, String to)
			throws MessagingException {

		// Transport.send(getMessage(subject, content, to)); 
		System.out.println("done------------------------------>33333333333333333333333333");

		try {
			String fromAdd = "technify.ganapathy@gmail.com";
			String toAdd = to;

			Boolean flag = true;
			Session session;
			Authenticator authenticator = new Authenticator() {
				private PasswordAuthentication authentication;
				{
					authentication = new PasswordAuthentication(
							"technify.ganapathy@gmail.com", "technifybala");
				}

				protected PasswordAuthentication getPasswordAuthentication() {
					return authentication;
				}
			};
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");

			// tls enabled
			
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.port", "587"); props.put("mail.smtp.auth",
			  "true");
			 
			// ssl enable
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");

			MailSSLSocketFactory sf = null;
			try {
				sf = new MailSSLSocketFactory();
			} catch (GeneralSecurityException e1) {
				e1.printStackTrace();
			}
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.socketFactory", sf);
			session = Session.getInstance(props, authenticator);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAdd));
			message.addRecipient(RecipientType.TO, new InternetAddress(toAdd));
			message.setSubject(subject);
			message.setText(content);
           
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	        Multipart multipart = new MimeMultipart();
	        
	        messageBodyPart.setContent(content, "text/html");
	        // add it
	        multipart.addBodyPart(messageBodyPart);
	        
	        message.setContent(multipart);
	        
			Transport.send(message);
			System.out.println("end****************333333333333333333***********");

			flag = true;
			if (flag == false) {

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private Message getMessage(String messageSubject, String content, String to)
			throws MessagingException {

		Message message = new MimeMessage(session);
		if (getUsername() != null)
			message.setFrom(new InternetAddress(getUsername()));
		else {
			InternetAddress from = new InternetAddress(
					configureEmail.getEmail_address());

			message.setFrom(from);
		}
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject(messageSubject);
		message.setText(content);
		return message;
	}

	// For Mutiple Mail with attachement This
	public void sendMessageWithAttach(String subject, String content,
			String attachmentFile, String[] to, String senderName, HttpSession httpSession)
			throws MessagingException {
		for (String email : to) {
			sendMessageWithAttach(subject, content, email, attachmentFile,
					senderName,httpSession);
		}
	}

	public void sendMessageWithAttach(String subject, String content,
			String to, String attachmentFile, String senderName, HttpSession httpSession)
			throws MessagingException {

		Session session;
		Authenticator authenticator = new Authenticator() {
			private PasswordAuthentication authentication;
			{
				authentication = new PasswordAuthentication(
						"alert@quascenta.com", "70C645iNWB#g");
			}

			protected PasswordAuthentication getPasswordAuthentication() {
				return authentication;
			}
		};
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "mail.quascenta.com");

		// tls enabled
		
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.port", "587"); props.put("mail.smtp.auth",
		  "true");
		 
		// ssl enable
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");

		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.socketFactory", sf);
		session = Session.getInstance(props, authenticator);
        String rootPath = null;
        String fullPath = null;
		Message message = this.getMessageWithAttach(subject, content, to,session);
		
        
     	rootPath = httpSession.getServletContext().getRealPath("/"); //For local path
     	
     	 fullPath = rootPath +File.separator+ "images/img-logo.png";
	        
	       
	       
		BodyPart messageBodyPart = new MimeBodyPart();

		messageBodyPart.setContent("<b>Dear " + senderName + ",</b><br><b>"
				+ content + "</b>", "text/html");
		Multipart multipart = new MimeMultipart();
		 // first part (the html)
        String htmlText = "<b>Dear " + senderName + ",</b><br><b>"+ content + "</b>" +"<br><br><img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");
        // add it
        multipart.addBodyPart(messageBodyPart);
		
		
		 // second part (the image)
        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(
        		fullPath);

        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");
        
		 multipart.addBodyPart(messageBodyPart);
		 
		if (attachmentFile != null && !"".equals(attachmentFile.trim())) {
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentFile);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(source.getName());
			multipart.addBodyPart(messageBodyPart);
		}

		message.setContent(multipart);
		Transport.send(message);
		System.out.println("Done");

	}

	private Message getMessageWithAttach(String messageSubject, String content,
			String to,Session session) throws MessagingException {
		Message message = new MimeMessage(session);
		try {
			
			
			if (getUsername() != null)
				message.setFrom(new InternetAddress(getUsername(),"eResidue"));
			else {
				InternetAddress from = new InternetAddress();

				message.setFrom(from);
			}
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(messageSubject);
			message.setText(content);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	*//**
	 * @return the username
	 *//*
	public String getUsername() {
		return username;
	}

	*//**
	 * @param username
	 *            the username to set
	 *//*
	public void setUsername(String username) {
		this.username = username;
	}

	*//**
	 * @return the password
	 *//*
	public String getPassword() {
		return password;
	}

	*//**
	 * @param password
	 *            the password to set
	 *//*
	public void setPassword(String password) {
		this.password = password;
	}

	*//**
	 * @return the portNo
	 *//*
	public String getPortNo() {
		return portNo;
	}

	*//**
	 * @return the ldapServer
	 *//*
	public String getLdapServer() {
		return ldapServer;
	}

	*//**
	 * @param ldapServer
	 *            the ldapServer to set
	 *//*
	public void setLdapServer(String ldapServer) {
		this.ldapServer = ldapServer;
	}

}
*/