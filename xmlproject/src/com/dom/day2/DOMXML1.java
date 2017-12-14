/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017.7.11
 * ���ܣ�ʹ��dom������xml�ļ�����crud����
 */

package com.dom.day2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMXML1 {

	//ʹ��dom������xml�ļ�����crud����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//����һ��DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//ͨ��DocumentBuilderFactory�õ�һ��DocumentBuilder����
		DocumentBuilder documentBuilder=dbf.newDocumentBuilder();
		//ָ�������ĸ�XML�ļ�
		Document document=documentBuilder.parse("src/class2.xml");
		
		//System.out.print(document);
		
		//list(document);
		//read(document);
		//add(document);
		//delete(document);
		//update(document);
		changeSpecificPerson(document);
	}
	
	public static void changeSpecificPerson(Document document) throws Exception{
		
		NodeList nodeList=document.getElementsByTagName("ѧ��");
		Element target=null;
		for(int i=0;i<nodeList.getLength();i++){
			
			target= (Element) nodeList.item(i);
			Element name=(Element) target.getElementsByTagName("����").item(0);
			Element age=(Element) target.getElementsByTagName("����").item(0);
			Element intro=(Element) target.getElementsByTagName("����").item(0);
			
			
			if(name.getTextContent().equals("����ϼ")){
				
				name.setTextContent("����");
				age.setTextContent("21");
				intro.setTextContent("����Ů");
				break;
			}
		}
		
		//����XML�ĵ�
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ�������õ�һ��ת����
		Transformer tf=tff.newTransformer();
		
		tf.transform(new DOMSource(document), new StreamResult("src/class2.xml"));
	}
	
	//����Ԫ��(�ѵ�һ��ѧ�������ָĳ��ν�)
	public static void update(Document document) throws Exception{
		
		//�ҵ�ѧ��
		Element element=(Element)document.getElementsByTagName("ѧ��").item(0);
		//��ȡѧ���µĽڵ�
		Element element_name=(Element)element.getElementsByTagName("����").item(0);
		element_name.setTextContent("�ν�");
		element_name.setAttribute("sex", "��");

		//����XML�ĵ�
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ�������õ�һ��ת����
		Transformer tf=tff.newTransformer();
		
		//����Ҳ����,new StreamResult(new File("src/class2.xml"))
		tf.transform(new DOMSource(document), new StreamResult("src/class2.xml"));
	}
	
	//ɾ��һ��Ԫ��(ɾ��һ��ѧ��)
	public static void delete(Document document) throws Exception{
		
		//�����ҵ�Ŀ��ѧ��
		//Node node=document.getElementsByTagName("ѧ��").item(0);
		//ͨ�����ڵ�ɾ���ӽڵ�
		//node.getParentNode().removeChild(node);
		
		//ɾ��ѧ����sex����
		Element element=(Element)document.getElementsByTagName("ѧ��").item(0);
		element.removeAttribute("sex");
		
		
		//����XML�ĵ�
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ�������õ�һ��ת����
		Transformer tf=tff.newTransformer();
		
		//����Ҳ����,new StreamResult("src/class.xml")
		tf.transform(new DOMSource(document), new StreamResult(new File("src/class2.xml")));
	}
	
	//���һ��ѧ����XML�ļ���
	public static void add(Document document) throws Exception{
		
		//����һ���µ�ѧ���ڵ�
		Element newStu=document.createElement("ѧ��");
		
		//���һ������ֵ
		newStu.setAttribute("sex", "��");
		
		Element newStu_name=document.createElement("����");
		newStu_name.setTextContent("С��");
		Element newStu_age=document.createElement("����");
		newStu_age.setTextContent("30");
		Element newStu_intro=document.createElement("����");
		newStu_intro.setTextContent("����һ���ú���");
		
		//��Ԫ�ؼ���newStu��
		newStu.appendChild(newStu_name);
		newStu.appendChild(newStu_age);
		newStu.appendChild(newStu_intro);
		
		//���µ�ѧ����ӵ���Ԫ��
		document.getDocumentElement().appendChild(newStu);
		
		//����XML�ĵ�
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ�������õ�һ��ת����
		Transformer tf=tff.newTransformer();
		
		//����Ҳ����,new StreamResult("src/class.xml")
		tf.transform(new DOMSource(document), new StreamResult(new File("src/class2.xml")));
	}
	
	//�����ѯĳһ��ѧ������Ϣ(��һ��ѧ����������Ϣ)
	public static void read(Document doc){
		
		NodeList nl=doc.getElementsByTagName("ѧ��");
		//ȡ����һ��ѧ��
		Element stu=(Element) nl.item(0);
		System.out.println(stu.getElementsByTagName("����").getLength());
		//stu.getElementsByTagName("����").item(0);��ʱElement("����")�����itemֻ��һ��
		System.out.println(stu.getElementsByTagName("����").item(0).getTextContent());
		//ȡ��ѧ������ֵ
		System.out.println(stu.getAttribute("sex"));
		
		//System.out.println(nl.getLength());
	}
	
	//��������ڵ����Ϣ
	public static void list(Node node){
		
		//����ڵ�������Ԫ�ؽڵ�,�����(��ȥ�ո�ͻ��з�)
		if(node.getNodeType()==node.ELEMENT_NODE){
			
			System.out.println(node.getNodeName());
		}
		
		//ȡ��node���ӽڵ�
		NodeList nodeList=node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			
			//��ȥ��ʾ
			Node n=nodeList.item(i);
			list(n);
		}
	}
}
