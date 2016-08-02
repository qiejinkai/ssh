package com.qjk.ssh.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import com.sun.mail.smtp.SMTPMessage;

public final class MailSendHelper {

	public static String from = "marketing@efunding.cn";
	public static String mail_smtp_host ="smtp.ym.163.com";
	public static String mail_smtp_user = "marketing@efunding.cn";
	public static String mail_smtp_password = "123456";
	public static String default_contentType = "text/html; charset=utf-8";

	private volatile static Session _session = null;

	/**
	 * 发送邮件
	 **/
	public static boolean sendEmail(String toEmail, String title,
			String content, String contentType) throws Exception {

		if (_session == null) {

			synchronized (MailSendHelper.class) {

				if (_session == null) {

					final Properties props = new Properties();

					props.put("mail.smtp.host", mail_smtp_host);
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.user", mail_smtp_user);
					props.put("mail.smtp.password", mail_smtp_password);

					Authenticator auth = new Authenticator() {

						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(
									props.getProperty("mail.smtp.user"),
									props.getProperty("mail.smtp.password"));
						}
					};

					_session = Session.getDefaultInstance(props, auth);
				}

			}
		}
		
		if(Value.isEmpty(toEmail)||Value.isEmpty(content)){
			return false;
		}

		contentType = Value.isEmpty(contentType)?default_contentType:contentType;
		
		SMTPMessage message = new SMTPMessage(_session);

		message.setContent(content, contentType);
		message.setSubject(title);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail));

		Transport.send(message);

		return true;

	}
}
