/**
 * 作者：樊钰丰
 * 时间：2017.7.13
 * 功能：SAX技术XML学生管理系统界面
 */

package com.stumanager.view;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.stumanager.service.StudentService;

@SuppressWarnings("unused")
public class StuManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		StudentService studentService=new StudentService();
		
		//显示操作界面
		System.out.println("查看所有学生成绩：view");
		System.out.println("退出系统：exit");
		
		//获取用户希望干什么
		String operType=sc.nextLine();
		if(operType.equals("view")){
			
			SAXParser saxParser=StudentService.getSaxParser();
			saxParser.parse("src/com/stumanager/view/stu.xml", new StudentService());
			
		}else if(operType.equals("exit")){
			
			System.exit(0);
		}
		
	}

}