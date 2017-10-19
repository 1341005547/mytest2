package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ��ȡProperties�ۺ���,Ĭ�ϰ󶨵�classpath�µ�config.properties�ļ���
 * @author ��־�� QQ:695520848
 */

public class UtilProperties {
    private String configPath=null; //�����ļ���·��

    private Properties props=null; //�����ļ�����
    
	/*Ĭ�Ϲ��캯�����Զ��ҵ�classpath�µ�config.properties��*/
    UtilProperties() throws IOException{
        InputStream in = UtilProperties.class.getClassLoader().getResourceAsStream("config.properties");//����
        props = new Properties();//�����ļ�����
        props.load(in);//���������ļ�
        in.close();//�ر���Դ
    }
    
    /**
     * ����keyֵ��ȡ���õ�ֵ
     * Jun 26, 2010 9:15:43 PM
     * @author ��־��
     * @param ��
     * @returnֵ
@throws IOException 
     */
    public String readValue(String key) throws IOException {
        return  props.getProperty(key);
    }
    
    /**
     * ��ȡproperties��ȫ����Ϣ
     * @author ��־��
     * @throws FileNotFoundException �����ļ�û���ҵ�
     * @throws IOException �ر���Դ�ļ������߼��������ļ�����
     */
    public Map<String,String> readAllProperties() throws FileNotFoundException,IOException  {
        Map<String,String> map=new HashMap<String,String>();
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String Property = props.getProperty(key);
            map.put(key, Property);
        }
        return map;
    }

    /**
     * ����ĳ��key��ֵ,���������ļ���
     * @author ��־��
     * @param ������ֵ��
     * @return key ����Ӧ��ֵ 
     * @throws IOException 
     */
    public void setValue(String key,String value) throws IOException {
        Properties prop = new Properties();
        InputStream fis = new FileInputStream(this.configPath);
        prop.load(fis);
        // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
        // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
        OutputStream fos = new FileOutputStream(this.configPath);
        prop.setProperty(key, value);
        // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
        // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
        prop.store(fos,"last update");
        //�ر��ļ�
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) {
        UtilProperties p;
        try {
            p = new UtilProperties();
            System.out.println(p.readAllProperties());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
