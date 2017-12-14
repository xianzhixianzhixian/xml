/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017.7.13
 * ���ܣ�DOM4J��XML�ļ�����crud����
 * ͬʱ���DOM4J�������������
 * //�����������
 * OutputFormat output=OutputFormat.createPrettyPrint();
 * output.setEncoding("UTF-8"); //�������
 * 
 * //���ı������д�뵽XML�ļ�
 * //�������new FileOutputStream("src/com/dom4j/day4/class.xml")
 * XMLWriter writer=new XMLWriter(new FileOutputStream("src/com/dom4j/day4/class.xml"),output);
 * writer.write(document);
 * writer.close();
 */

package com.dom4j.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4J{
	
	//��ʾʹ��dom4j��xml�ļ�����crud����
	public static void main(String[] args) throws Exception{
		
		//1���õ�������
		SAXReader saxReader=new SAXReader();
		//2��ָ�������ĸ�XML�ļ�
		Document document=saxReader.read(new File("src/com/dom4j/day4/class.xml"));
		
		//document.getRootElement()��ø�Ԫ��(�༶),Ȼ�����XML�ļ�
		//list(document.getRootElement());
		read(document);
		//add(document);
		//del(document);
		//update(document);
		//addByIndex(document);
	}
	
	//����Ԫ��(������ѧ���������3)
	@SuppressWarnings("deprecation")
	public static void update(Document document) throws Exception, Exception{
		
		//�õ�����ѧ��������
		List<Element> stus= document.getRootElement().elements("ѧ��");
		//��el��ȡ�����䲢�޸�
		for(Element el:stus){
			
			Element age=el.element("����");
			age.setText(Integer.parseInt(age.getText())+3+"");
			//���Ľڵ�����
			Element name=el.element("����");
			name.setAttributeValue("�ص�", "�й�");
		}
		
		//ֱ������������������
		//�����������
		//OutputFormat output=OutputFormat.createCompactFormat();
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("UTF-8"); //�������
		
		//���ı������д�뵽XML�ļ�
		//�������new FileOutputStream("src/com/dom4j/day4/class.xml")
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/com/dom4j/day4/class.xml"),output);
		writer.write(document);
		writer.close();
	}
	
	//����һ��Ԫ�ص�ָ��λ��(�ֳ嵽����ϼ�����ǲ�����ǰ)
	public static void addByIndex(Document document) throws Exception{
		
		//����һ��Ԫ��
		Element newHero=DocumentHelper.createElement("ѧ��");
		newHero.setText("�ֳ�");
		//�õ�����ѧ����list
		List<Element> allHeros=document.getRootElement().elements("ѧ��");
		
		
		for(int i=0;i<allHeros.size();i++){
			
			//ȡ�������˵�����
			Element name=allHeros.get(i).element("����");
			if(name.getText().equals("����ϼ")){
				
				allHeros.add(i+1, newHero);
				//
				break;
			}
		}
		//ֱ������������������
		//�����������
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("UTF-8"); //�������
		
		//���ı������д�뵽XML�ļ�
		//�������new FileOutputStream("src/com/dom4j/day4/class.xml")
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/com/dom4j/day4/class.xml"),output);
		writer.write(document);
		writer.close();
	}
	
	//ɾ��Ԫ��(ɾ����һ��ѧ��)
	public static void del(Document document) throws Exception{
		
		//�ҵ���Ԫ��
		Element stu=document.getRootElement().element("ѧ��");
		//ɾ������
		stu.remove(stu.attribute("sex"));
		//ɾ���ڵ�
		//stu.getParent().remove(stu);
		
		//ֱ������������������
		//�����������
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("UTF-8"); //�������
		
		//���ı������д�뵽XML�ļ�
		//�������new FileOutputStream("src/com/dom4j/day4/class.xml")
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/com/dom4j/day4/class.xml"),output);
		writer.write(document);
		writer.close();
	}
	
	//����Ԫ��(Ҫ������һ��ѧ����XML��)
	public static void add(Document document) throws Exception{
		
		//���ȴ���һ��ѧ���ڵ����Node=Element
		Element newStu=DocumentHelper.createElement("ѧ��");
		Element newStu_name=DocumentHelper.createElement("����");
		newStu_name.addAttribute("����", "����");
		newStu_name.setText("���ǲ�����");
		Element newStu_age=DocumentHelper.createElement("����");
		newStu_age.setText("19");
		Element newStu_intro=DocumentHelper.createElement("����");
		newStu_intro.setText("ľҶ��");
		
		//��������Ԫ��(�ڵ�)�ӵ�newStu��
		newStu.add(newStu_name);
		newStu.add(newStu_age);
		newStu.add(newStu_intro);
		
		//��newStu�ڵ�ӵ���Ԫ����
		document.getRootElement().add(newStu);
		
		//ֱ������������������
		//�����������
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("UTF-8"); //�������
		
		//���ı������д�뵽XML�ļ�
		//�������new FileOutputStream("src/com/dom4j/day4/class.xml")
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/com/dom4j/day4/class.xml"),output);
		writer.write(document);
		writer.close();
	}
	
	//�ƶ���ȡĳһ��ѧ��(��ȡ��һ��ѧ������Ϣ)
	public static void read(Document document){
		
		//�õ���Ԫ��
		Element root=document.getRootElement();
		//System.out.println("root"+root.getName());
		//root.elements("ѧ��");��ʾȡ��rootԪ���µ�����ѧ��Ԫ��
		//.get(0);��ʾȡ��rootԪ���µĵ�һ��ѧ��Ԫ��
		Element stu=(Element) root.elements("ѧ��").get(0);
		
		//root.element("ѧ��")��ʾȡ��rootԪ���µĵ�һ��ѧ��Ԫ��
		//root.elements("ѧ��")��ʾȡ��rootԪ��������ѧ��Ԫ��
		System.out.println(stu.element("����").getTextTrim());
		System.out.println(stu.element("����").attributeValue("���"));
		System.out.println(stu.element("����").getTextTrim());
		System.out.println(stu.element("����").getTextTrim());
		
		//��������Ĵ����Ƿ��ܹ�(���ȡ)==>XPATH�������ȡ
		//Element stu2=(Element) root.element("����"); �����Ǵ������
		Element stu2=(Element) document.selectSingleNode("/�༶/ѧ��[1]");
		System.out.println("XPATH��"+stu2.attributeValue("sex"));
	}
	
	//����XML�ļ�
	public static void list(Element element){
		
		System.out.println(element.getName()+element.getTextTrim());
		
		Iterator iterator=element.elementIterator();
		
		while(iterator.hasNext()){
			
			Element e=(Element) iterator.next();
			//�ݹ�
			list(e);
		}
	}
}



















