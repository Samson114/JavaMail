package Two;

import ONE.MailSenderInfo;
import ONE.SimpleMailSender;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //�������Ҫ�������ʼ�   
	      MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost("smtp.163.com");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("samson");    
	      mailInfo.setPassword("695590737");//������������    
	      mailInfo.setFromAddress("samson142@163.com");    
	      mailInfo.setToAddress("1002895777@qq.com");    
	      mailInfo.setSubject("����������� ��http://www.guihua.org �й�����");    
	      mailInfo.setContent("������������ ��http://www.guihua.org �й����� ���й�������վ==");    
	         //�������Ҫ�������ʼ�   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//���������ʽ    
	          sms.sendHtmlMail(mailInfo);//����html��ʽ   
	}

}
