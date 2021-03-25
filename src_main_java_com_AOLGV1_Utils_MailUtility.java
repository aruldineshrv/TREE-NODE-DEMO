package com.AOLGV1.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.AOLGV1.pojo.mcxAttributes;




public class MailUtility {
	final static Logger logger = Logger.getLogger(MailUtility.class);
	public static void verifyThresholdPrepareNotification(mcxAttributes mcxattributes) {
		if(mcxattributes.getThreshold()>0&&mcxattributes.getThreshold()<10)
		{
			if(!verifyPreviousNotifcations(mcxattributes))
			 sendMailNotification(mcxattributes);
			else
			 logger.info("Already Notified");	
		}
		else
		{
			 logger.info("Threshold Not IN Range");
		}
		ReportGenerator.generateSignals(mcxattributes);
	}
	
    @SuppressWarnings("deprecation")
	private static boolean verifyPreviousNotifcations(mcxAttributes mcxattributes) {
    	   boolean AlreadyNotified=false;
		   Date date = new Date();
	       try {
	    	   Properties connectionProperties = new Properties();
		       Session session = Session.getDefaultInstance(connectionProperties,null);
	           Store store = session.getStore(AppConstants.RCVR_STORE);
	           store.connect(AppConstants.RCVR_IMAP_HOST,AppConstants.RCVR_USERID,AppConstants.RCVR_PASSWORD);
	           Folder inbox = store.getFolder(AppConstants.RCVR_INBOX);
	           inbox.open(Folder.READ_ONLY);
	           Message messages[] = inbox.getMessages();
	       	   List<Message> messageList=new ArrayList<Message>();
	           for(Message message:messages) 
	           	{
	        	   messageList.add(message);
	           	}
	           messageList.sort((o1,o2) -> {
				try {
					return o1.getReceivedDate().compareTo(o2.getReceivedDate());
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				return 0;
			});
	           Collections.reverse(messageList); 
	           for(Message message:messageList) 
		           	{
	        	    logger.info("Mail Index :"+message.getMessageNumber()  +" MAIL SUBJECT :"+message.getSubject()+ " Recieved Date"+message.getReceivedDate()+ "  Bean Value"+mcxattributes.getType());
	            	   if(message.getSentDate().getDay()==date.getDay()&&message.getSubject().equalsIgnoreCase(mcxattributes.getType()))
	            	   {
	            		   AlreadyNotified=true;
		            	    break;
	            	   }
		           	}
	       		} catch (Exception e) {
	           e.printStackTrace();
	       }
	    logger.info("AlreadyNotified::::"+AlreadyNotified);
    	return AlreadyNotified;
	}

	public static void sendMailNotification(mcxAttributes mcxattributes) {
		 VoiceCall.invokePSTN_Alert();
         Properties prop = new Properties();
	     prop.put(AppConstants.SENDER_HOST_KEY,AppConstants.SENDER_HOST_VALUE);
	     prop.put(AppConstants.SENDER_PORT_KEY,AppConstants.SENDER_PORT_VALUE);
	     prop.put(AppConstants.SENDER_AUTH_KEY,AppConstants.SENDER_AUTH_VALUE);
	     prop.put(AppConstants.SENDER_SOCKET_KEY,AppConstants.SENDER_SOCKET_VALUE);
	     prop.put(AppConstants.SENDER_CLASS_KEY,AppConstants.SENDER_CLASS_VALUE);
         Session session = Session.getInstance(prop,new javax.mail.Authenticator() 
         		{
                     protected PasswordAuthentication getPasswordAuthentication() 
                     	{
                    	 	return new PasswordAuthentication(AppConstants.SENDER_USERID, AppConstants.SENDER_PASSWORD);
                     	}
                 });
          try {
                 Message message = new MimeMessage(session);
                 message.setFrom(new InternetAddress(AppConstants.SENDER_USERID));
                 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(AppConstants.RCVR_USERID));
                 message.setSubject(mcxattributes.getType());
                 String messageContent=getContent(mcxattributes);
                 message.setContent(messageContent, "text/html; charset=utf-8");
                 Transport.send(message);
                 logger.info("Notification Sent");
             }
          catch (MessagingException e) {
                 e.printStackTrace();
             }
         }
	private static String getContent(mcxAttributes mcxattributes) {
		  return "<p>BULLSH REVERSAL AHEAD&nbsp;</p>\r\n" + 
           		"<table width='420'><tbody>\r\n" + 
           		"<tr style='BACKGROUND-COLOR: aquamarine;'>\r\n" + 
           		"<td><strong>Open</strong></td>\r\n" + 
           		"<td><strong>High</strong></td>\r\n" + 
           		"<td><strong>Low</strong></td>\r\n" + 
           		"<td><strong>Close</strong></td>\r\n" + 
           		"<td><strong>Trend Line</strong></td>\r\n" + 
           		"</tr>\r\n" + 
           		"<tr style='BACKGROUND: darkgray;'>\r\n" + 
           		"<td>"+mcxattributes.getOpen()+"</td>\r\n" +
           		"<td>"+mcxattributes.getHigh()+"</td>\r\n" +
           		"<td>"+mcxattributes.getLow()+"</td>\r\n" +
           		"<td>"+mcxattributes.getClose()+"</td>\r\n" +
           		"<td>"+mcxattributes.getTrend()+"</td>\r\n" +
           		"</tr>\r\n" + 
           		"</tbody>\r\n" + 
           		"</table>";
		}

	public static void main(String args[])
	{
		mcxAttributes bean=new mcxAttributes();
		bean.setClose(4170);
		bean.setOpen(4160);
		bean.setHigh(4175);
		bean.setLow(4158);
		bean.setTrend(4148);;
		bean.setThreshold(10);
		bean.setType(AppConstants.BULLISH);
		bean.setPattern(AppConstants.PATTERN_GREEN);
		verifyPreviousNotifcations(bean);
		
	}
	
	
     }