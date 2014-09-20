package Two;

import ONE.MailSenderInfo;
import ONE.SimpleMailSender;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //这个类主要是设置邮件   
	      MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost("smtp.163.com");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("samson");    
	      mailInfo.setPassword("695590737");//您的邮箱密码    
	      mailInfo.setFromAddress("samson142@163.com");    
	      mailInfo.setToAddress("1002895777@qq.com");    
	      mailInfo.setSubject("设置邮箱标题 如http://www.guihua.org 中国桂花网");    
	      mailInfo.setContent("设置邮箱内容 如http://www.guihua.org 中国桂花网 是中国最大桂花网站==");    
	         //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//发送文体格式    
	          sms.sendHtmlMail(mailInfo);//发送html格式   
	}

}
