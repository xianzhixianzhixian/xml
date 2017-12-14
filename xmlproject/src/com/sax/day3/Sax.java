/**
 * 作者：樊钰丰
 * 时间：2017.7.12
 * 功能：SAX技术解析XML文件
 * SAX技术不能对XML文件进行crud操作
 */

package com.sax.day3;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax {

	//使用SAX技术解析XML文件
	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		//1、创建一个SAXParserFactory
		SAXParserFactory spf=SAXParserFactory.newInstance();
		//2、创建SAXParser解析器，parser：解析器
		SAXParser saxParser=spf.newSAXParser();
		//3、将解析对象和事件处理器对象关联起来
		//saxParser.parse("src/class2.xml", new MyDefaultHandler());
		saxParser.parse("src/class2.xml", new MyDefaultHandler2());
	}

}

//思考如何只显示姓名和年龄
//定义事件处理类
class MyDefaultHandler2 extends DefaultHandler{

	private boolean isName=false;
	private boolean isAge=false;
	
	//发现文档开始
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	//发现XML文件中的一个元素
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, name, attributes);
		
		if(name.equals("名字")){
			
			this.isName=true;
		}else if(name.equals("年龄")){
			
			this.isAge=true;
		}
	}
	
	//发现XML文件中的文本
	@Override
	public void characters(char[] arg0, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(arg0, start, length);
		
		//显示文本内容
		//char[] arg0是文档本身，即文档中所有的内容
		//start表示发现的文本在文档中出现的位置，length表示文本的长度
		String con=new String(arg0,start,length);
		if(!con.trim().equals("") && (isName || isAge)){
			
			System.out.println(con);
		}
		isName=false;
		isAge=false;
	}
	
	//发现XML文件中一个元素结尾</xx>
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(arg0, arg1, arg2);
	}

	//发现文档结束
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
}

//定义事件处理类
class MyDefaultHandler extends DefaultHandler{

	//发现文档开始
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	//发现XML文件中的一个元素
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, name, attributes);
		
		System.out.println(name);
	}
	
	//发现XML文件中的文本
	@Override
	public void characters(char[] arg0, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(arg0, start, length);
		
		//显示文本内容
		//char[] arg0是文档本身
		//start表示发现的文本在文档中出现的位置，length表示文本的长度
		String con=new String(arg0,start,length);
		if(!con.trim().equals("")){
			
			System.out.println(con);
		}
	}
	
	//发现XML文件中一个元素介绍</xx>
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(arg0, arg1, arg2);
	}

	//发现文档结束
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
}