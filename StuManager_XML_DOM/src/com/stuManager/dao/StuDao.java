/**
 * 作者：樊钰丰
 * 时间：2017.7.18
 * 功能：修改XML类
 * DOM技术读取XML文件不能跨层读取
 */

package com.stuManager.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.stuManager.bean.Student;

public class StuDao {
	
	private static DocumentBuilderFactory documentBuilderFactory=null;
	private static DocumentBuilder documentBuilder=null;
	private static Document document=null;
	
	static{
		
		try{
			
			documentBuilderFactory=DocumentBuilderFactory.newInstance();
			documentBuilder=documentBuilderFactory.newDocumentBuilder();
			document=documentBuilder.parse("src/stu.xml");
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//返回所有学生列表
	public static ArrayList<Student> getAllStudent(){
		
		ArrayList<Student> stuList=new ArrayList<Student>();
		NodeList nodeList=document.getElementsByTagName("student");
		
		for(int i=0;i<nodeList.getLength();i++){
			
			Element element=(Element) nodeList.item(i);
			
			Element element_name=(Element) element.getElementsByTagName("name").item(0);
			Element element_course=(Element) element.getElementsByTagName("course").item(0);
			
			Element element_course_java=(Element) element_course.getElementsByTagName("java").item(0);
			Element element_course_oracle=(Element) element_course.getElementsByTagName("oracle").item(0);
			Element element_course_vb=(Element) element_course.getElementsByTagName("vb").item(0);
			
			
			Student temp=new Student();
			temp.setId(element.getAttribute("id"));
			temp.setName(element_name.getTextContent());
			temp.setJava(Double.parseDouble(element_course_java.getTextContent()));
			temp.setOracle(Double.parseDouble(element_course_oracle.getTextContent()));
			temp.setVb(Double.parseDouble(element_course_vb.getTextContent()));
			
			stuList.add(temp);
		}
		
		return stuList;
	}
	
	//添加学生
	public static void add(Student stu){
		
		Element stu_temp=document.createElement("student");
		stu_temp.setAttribute("id", stu.getId());
		
		Element stu_temp_name=document.createElement("name");
		stu_temp_name.setTextContent(stu.getName());
		
		Element stu_temp_course=document.createElement("course");
		Element stu_temp_course_java=document.createElement("java");
		stu_temp_course_java.setTextContent(stu.getJava()+"");
		Element stu_temp_course_oracle=document.createElement("oracle");
		stu_temp_course_oracle.setTextContent(stu.getOracle()+"");
		Element stu_temp_course_vb=document.createElement("vb");
		stu_temp_course_vb.setTextContent(stu.getVb()+"");
		stu_temp_course.appendChild(stu_temp_course_java);
		stu_temp_course.appendChild(stu_temp_course_oracle);
		stu_temp_course.appendChild(stu_temp_course_vb);
		
		stu_temp.appendChild(stu_temp_name);
		stu_temp.appendChild(stu_temp_course);
		
		//一定要这样插入节点
		document.getElementsByTagName("student").item(0).getParentNode().appendChild(stu_temp);
		
	}
	
	//删除学生
	public static void delete(String id){
		
		NodeList nodeList=document.getElementsByTagName("student");
		
		for(int i=0;i<nodeList.getLength();i++){
			
			Element element=(Element) nodeList.item(i);
			
			if(element.getAttribute("id").equals(id)){
				
				//要从父节点移除或者添加子节点
				element.getParentNode().removeChild(element);
				break;
			}
		}
	}
	
	//修改学生
	public static void change(String id,Student stu){
		
		NodeList nodeList=document.getElementsByTagName("student");
		boolean isExist=false;
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<nodeList.getLength();i++){
			
			Element element=(Element) nodeList.item(i);
			
			if(element.getAttribute("id").equals(id)){
				
				String java,oracle,vb;
				
				isExist=true;
				
				Element element_course=(Element) element.getElementsByTagName("course").item(0);
				
				Element element_course_java=(Element) element_course.getElementsByTagName("java").item(0);
				Element element_course_oracle=(Element) element_course.getElementsByTagName("oracle").item(0);
				Element element_course_vb=(Element) element_course.getElementsByTagName("vb").item(0);
				
				element_course_java.setTextContent(stu.getJava()+"");
				element_course_oracle.setTextContent(stu.getOracle()+"");
				element_course_vb.setTextContent(stu.getVb()+"");
			}
		}
		
		if(isExist==false){
			
			System.out.println("无符合条件学生存在");
		}
	}
	
	//查找学生
	public static Student select(String id){
		
		Student stu_temp=null;
		
		NodeList nodeList=document.getElementsByTagName("student");
		
		//不要忘记加item()函数
		for(int i=0;i<nodeList.getLength();i++){
			
			Element element=(Element) nodeList.item(i);
			
			if(element.getAttribute("id").equals(id)){
				
				stu_temp=new Student();
				
				stu_temp.setId(id);
				stu_temp.setName(element.getElementsByTagName("name").item(0).getTextContent());
				
				Element element_course=(Element) element.getElementsByTagName("course").item(0);
				
				Element element_course_java=(Element) element_course.getElementsByTagName("java").item(0);
				Element element_course_oracle=(Element) element_course.getElementsByTagName("oracle").item(0);
				Element element_course_vb=(Element) element_course.getElementsByTagName("vb").item(0);
				
				stu_temp.setJava(Double.parseDouble(element_course_java.getTextContent()));
				stu_temp.setOracle(Double.parseDouble(element_course_oracle.getTextContent()));
				stu_temp.setVb(Double.parseDouble(element_course_vb.getTextContent()));
				
				return stu_temp;
			}
		}
		
		return stu_temp;
	}
	
	//将内存中DOM树发生的变化写入文件
	public static void writeIntoFile(){
		
		TransformerFactory transformerFactory=null;
		Transformer transformer=null;
		
		try{
			
			transformerFactory=TransformerFactory.newInstance();
			transformer=transformerFactory.newTransformer();
			
			transformer.transform(new DOMSource(document), new StreamResult("src/stu.xml"));
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}		
	}
}











