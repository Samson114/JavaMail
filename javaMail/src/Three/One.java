package Three;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 
 * @author ZYP
 *���Գɹ�
 */
public class One {

    static int port = 25;

    static String server = "smtp.163.com";//�ʼ�������mail.cpip.net.cn

    static String from = "����ƽ";//������,��ʾ�ķ���������

    static String user = "samson142@163.com";//�����������ַ

    static String password = "695590737";//����

   
    public static void sendEmail(String email, String subject, String body) throws UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", "true");
            Transport transport = null;
            Session session = Session.getDefaultInstance(props, null);
            transport = session.getTransport("smtp");
            transport.connect(server, user, password);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
            msg.setFrom(fromAddress);
            InternetAddress[] toAddress = new InternetAddress[1];
            toAddress[0] = new InternetAddress(email);
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");   
            msg.setText(body, "UTF-8");
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws UnsupportedEncodingException
    {

        sendEmail("1002895777@qq.com","�����ʼ�","���ʼ�Ϊ�����ʼ�");//�ռ���
        System.out.println("ok");
    }
}