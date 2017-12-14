/**
 * 作者：樊钰丰
 * 时间：2017.7.11
 * 功能：使用dom技术对xml文件进行crud操作
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

	//使用dom技术对xml文件进行crud操作
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//创建一个DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//通过DocumentBuilderFactory得到一个DocumentBuilder对象
		DocumentBuilder documentBuilder=dbf.newDocumentBuilder();
		//指定解析哪个XML文件
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
		
		NodeList nodeList=document.getElementsByTagName("学生");
		Element target=null;
		for(int i=0;i<nodeList.getLength();i++){
			
			target= (Element) nodeList.item(i);
			Element name=(Element) target.getElementsByTagName("名字").item(0);
			Element age=(Element) target.getElementsByTagName("年龄").item(0);
			Element intro=(Element) target.getElementsByTagName("介绍").item(0);
			
			
			if(name.getTextContent().equals("林青霞")){
				
				name.setTextContent("朱茵");
				age.setTextContent("21");
				intro.setTextContent("大美女");
				break;
			}
		}
		
		//更新XML文档
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf=tff.newTransformer();
		
		tf.transform(new DOMSource(document), new StreamResult("src/class2.xml"));
	}
	
	//更新元素(把第一个学生的名字改成宋江)
	public static void update(Document document) throws Exception{
		
		//找到学生
		Element element=(Element)document.getElementsByTagName("学生").item(0);
		//获取学生下的节点
		Element element_name=(Element)element.getElementsByTagName("名字").item(0);
		element_name.setTextContent("宋江");
		element_name.setAttribute("sex", "男");

		//更新XML文档
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf=tff.newTransformer();
		
		//这样也可以,new StreamResult(new File("src/class2.xml"))
		tf.transform(new DOMSource(document), new StreamResult("src/class2.xml"));
	}
	
	//删除一个元素(删除一个学生)
	public static void delete(Document document) throws Exception{
		
		//首先找到目标学生
		//Node node=document.getElementsByTagName("学生").item(0);
		//通过父节点删除子节点
		//node.getParentNode().removeChild(node);
		
		//删除学生的sex属性
		Element element=(Element)document.getElementsByTagName("学生").item(0);
		element.removeAttribute("sex");
		
		
		//更新XML文档
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf=tff.newTransformer();
		
		//这样也可以,new StreamResult("src/class.xml")
		tf.transform(new DOMSource(document), new StreamResult(new File("src/class2.xml")));
	}
	
	//添加一个学生到XML文件中
	public static void add(Document document) throws Exception{
		
		//创建一个新的学生节点
		Element newStu=document.createElement("学生");
		
		//添加一个属性值
		newStu.setAttribute("sex", "男");
		
		Element newStu_name=document.createElement("名字");
		newStu_name.setTextContent("小明");
		Element newStu_age=document.createElement("年龄");
		newStu_age.setTextContent("30");
		Element newStu_intro=document.createElement("介绍");
		newStu_intro.setTextContent("这是一个好孩子");
		
		//将元素加入newStu中
		newStu.appendChild(newStu_name);
		newStu.appendChild(newStu_age);
		newStu.appendChild(newStu_intro);
		
		//把新的学生添加到根元素
		document.getDocumentElement().appendChild(newStu);
		
		//更新XML文档
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf=tff.newTransformer();
		
		//这样也可以,new StreamResult("src/class.xml")
		tf.transform(new DOMSource(document), new StreamResult(new File("src/class2.xml")));
	}
	
	//具体查询某一个学生的信息(第一个学生的所有信息)
	public static void read(Document doc){
		
		NodeList nl=doc.getElementsByTagName("学生");
		//取出第一个学生
		Element stu=(Element) nl.item(0);
		System.out.println(stu.getElementsByTagName("名字").getLength());
		//stu.getElementsByTagName("名字").item(0);此时Element("名字")里面的item只有一个
		System.out.println(stu.getElementsByTagName("名字").item(0).getTextContent());
		//取出学生属性值
		System.out.println(stu.getAttribute("sex"));
		
		//System.out.println(nl.getLength());
	}
	
	//遍历输出节点的信息
	public static void list(Node node){
		
		//如果节点类型是元素节点,则输出(除去空格和换行符)
		if(node.getNodeType()==node.ELEMENT_NODE){
			
			System.out.println(node.getNodeName());
		}
		
		//取出node的子节点
		NodeList nodeList=node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			
			//再去显示
			Node n=nodeList.item(i);
			list(n);
		}
	}
}
