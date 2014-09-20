package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;
/**
 * 
 * @author zyp
��* @Description ���ðٶȵ�ͼ�����Χ�ļ�����⽵���   
 *				�������ڰٶȵ�ͼ�Ὣ���������ȵ������  
 *				�������������ʹ�þ�γ�ȶ�λ
 * @created Apr 6, 2014 10:03:11 AM
��* @History 
 * @version v1.0
 */
public class BaiduIp {
	
	
	public  List ipGetCoor(String ip){
		StringBuffer document = new StringBuffer();
		try{			
			//http://api.map.baidu.com/location/ip?ak=342c0bced1035142422dc6dce4a863e0&ip=202.198.16.3&coor=bd09ll
//			342c0bced1035142422dc6dce4a863e0
			
			String ipUrl="http://api.map.baidu.com/place/v2/search?&query='吉祥馄饨'&location=38.930553588774,121.644614601936&radius=2000&output=xml&ak=342c0bced1035142422dc6dce4a863e0";
//		http://api.map.baidu.com/location/ip?ak=342c0bced1035142422dc6dce4a863e0&ip=202.198.16.3&coor=bd09ll
			URL url = new URL(ipUrl);
			
			//Զ��url
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line = null;
			while ((line = reader.readLine()) != null)
				document.append(line + " ");
				reader.close();
				}catch(MalformedURLException e) {
					e.printStackTrace(); 	
					}catch(IOException e){
						e.printStackTrace(); 		
						}
		
		String xmlDoc = document.toString();
//		System.out.println("xmlDoc="+xmlDoc);
		  //����һ���µ��ַ�
        StringReader read = new StringReader(xmlDoc);
        //�����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
        InputSource source = new InputSource(read);
        //����һ���µ�SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        
        String shop=null;
        List shops = new ArrayList();
        try {
            //ͨ������Դ����һ��Document
            Document doc = sb.build(source);
            //ȡ�ĸ�Ԫ��
            Element root = doc.getRootElement();
            System.out.println("address:"+root.getAttributeValue("address"));
//            System.out.println("message:"+root.getAttributeValue("message"));
//            System.out.println("PlaceSearchResponse="+root.getName());//�����Ԫ�ص���ƣ����ԣ�
////         
//            System.out.println("rootTest="+root.getAttribute("message"));//�����Ԫ�ص���ƣ����ԣ�
            //�õ���Ԫ��������Ԫ�صļ���
            List jiedian = root.getChildren();
            
            Element et = null;
//            et = (Element) jiedian.get(2);
//            String name=et.getAttributeValue("name");
            for(int i=0;i<jiedian.size();i++){
                et = (Element) jiedian.get(i);//ѭ�����εõ���Ԫ��
                
//                if(et.getAttributeValue("inputindex").equals("1")){
//                    et.setAttribute("name","1");
                }
//                et.setAttribute("age","15");
//            System.out.println("name===:"+et.getAttributeValue("name"));
//            System.out.println("address:"+et.getAttributeValue("address"));
            
            /**//*
             * ��Ҫȡ<result>�µĵ�һ����Ԫ�ص����
             * ������ͽ�굽���
             * String dian
             */
           
            et = (Element) jiedian.get(2);
            List zjiedian = et.getChildren();
            
            for(int j=0;j<zjiedian.size();j++){
                Element xet = (Element) zjiedian.get(j);
//                shop=xet.getChildText("name");
//                shops.add(shop);
                System.out.println(xet.getChildText("x"));
                
            }
//                System.out.println("shops="+shops);
        } catch (JDOMException e) {
            // TODO �Զ���� catch ��
            e.printStackTrace();
        } catch (IOException e) {
            // TODO �Զ���� catch ��
            e.printStackTrace();
        }
        return shops;
	}
	 public static void main(String args[])
	 {
		BaiduIp bi=new BaiduIp();
		bi.ipGetCoor("124.93.200.218");
	    }
}
