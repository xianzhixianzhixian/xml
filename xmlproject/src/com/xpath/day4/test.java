/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017.7.13
 * ���ܣ�DOM4J���XPATH����
 */

package com.xpath.day4;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;

public class test {

	//DOM4J���XPATH����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1���õ�SAXReader������
		SAXReader saxReader=new SAXReader();
		//2��ָ��ȥ�����ĸ��ļ�
		Document document=saxReader.read(new File("src/com/xpath/day4/test.xml"));
		//3���õ���Ԫ��
		//Element root=document.getRootElement();
		//4������ʹ��XPATH���Ķ�ȡ�ļ�
		//document.selectSingleNode("")���ص���Ԫ��
		
		//List<Element> e=document.selectNodes("/AAA/CCC"); //���ض��Ԫ��
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("//BBB"); //�ҳ�����BBBԪ��
		//System.out.println(((Element)e.get(e.size()-1)).getText());
		
		//List<Element> e=document.selectNodes("//DDD/BBB"); //�ҳ����и��ڵ�ΪDDD��BBBԪ��
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/AAA/CCC/DDD/*"); //ѡ��/AAA/CCC/DDD�µ�Ԫ��
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/*/*/*/BBB"); //ѡ������������Ԫ�ص�BBBԪ��
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("//*"); //ѡ������Ԫ��
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/AAA/BBB[1]"); //ѡ��AAAԪ���µĵ�һ��BBBԪ��
		//System.out.println(e.size()+((Element)e.get(0)).getText());
		
		//���ȷ��ֻ��һ��NodeԪ�أ������ʹ��selectSingleNode
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[1]");
		//System.out.println(e.getText());
		
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[last()]"); //ѡ��AAAԪ���µ����һ��BBBԪ��
		//System.out.println(e.getText());
		
		//List<Attribute> e=document.selectNodes("//@id"); //ѡ�����е�id����,�õ��Ľ����Attribute����
		//System.out.println(((Attribute)e.get(0)).getText());
		
		//List<Element> e=document.selectNodes("//BBB[@id]"); //ѡ�����о���id���Ե�BBBԪ��
		//System.out.println(e.size()+((Element)e.get(0)).getText());
		
		//     //BBB[@name] ѡ�����о���name���Ե�BBBԪ��
		//     //BBB[@*] ѡ�����о����������Ե�BBBԪ��
		//     //BBB[not(@*)] ѡ��û�����Ե�BBBԪ��
		//     //BBB[@id='b1'] ѡ��������id����ֵΪ'b1'��BBBԪ��
		//     //BBB[@name='bbb'] ѡ��������name����ֵΪ'bbb'��BBBԪ��
		//	   //*[count(BBB)=2] ѡ������2��BBB��Ԫ�ص�Ԫ��
		
		//�ҳ�AAA�µĵ�һ��BBB�µĵڶ���CCCԪ����KKK��ֵ
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[1]/CCC[1]/KKK");
		//System.out.println(e.getText());
		
		List<Element> e=document.selectNodes("/AAA/BBB[1]/CCC[1]/KKK");
		System.out.println(e.get(0).getText());
	}

}







