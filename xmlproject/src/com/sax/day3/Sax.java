/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017.7.12
 * ���ܣ�SAX��������XML�ļ�
 * SAX�������ܶ�XML�ļ�����crud����
 */

package com.sax.day3;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax {

	//ʹ��SAX��������XML�ļ�
	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		//1������һ��SAXParserFactory
		SAXParserFactory spf=SAXParserFactory.newInstance();
		//2������SAXParser��������parser��������
		SAXParser saxParser=spf.newSAXParser();
		//3��������������¼������������������
		//saxParser.parse("src/class2.xml", new MyDefaultHandler());
		saxParser.parse("src/class2.xml", new MyDefaultHandler2());
	}

}

//˼�����ֻ��ʾ����������
//�����¼�������
class MyDefaultHandler2 extends DefaultHandler{

	private boolean isName=false;
	private boolean isAge=false;
	
	//�����ĵ���ʼ
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	//����XML�ļ��е�һ��Ԫ��
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, name, attributes);
		
		if(name.equals("����")){
			
			this.isName=true;
		}else if(name.equals("����")){
			
			this.isAge=true;
		}
	}
	
	//����XML�ļ��е��ı�
	@Override
	public void characters(char[] arg0, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(arg0, start, length);
		
		//��ʾ�ı�����
		//char[] arg0���ĵ����������ĵ������е�����
		//start��ʾ���ֵ��ı����ĵ��г��ֵ�λ�ã�length��ʾ�ı��ĳ���
		String con=new String(arg0,start,length);
		if(!con.trim().equals("") && (isName || isAge)){
			
			System.out.println(con);
		}
		isName=false;
		isAge=false;
	}
	
	//����XML�ļ���һ��Ԫ�ؽ�β</xx>
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(arg0, arg1, arg2);
	}

	//�����ĵ�����
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
}

//�����¼�������
class MyDefaultHandler extends DefaultHandler{

	//�����ĵ���ʼ
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	//����XML�ļ��е�һ��Ԫ��
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, name, attributes);
		
		System.out.println(name);
	}
	
	//����XML�ļ��е��ı�
	@Override
	public void characters(char[] arg0, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(arg0, start, length);
		
		//��ʾ�ı�����
		//char[] arg0���ĵ�����
		//start��ʾ���ֵ��ı����ĵ��г��ֵ�λ�ã�length��ʾ�ı��ĳ���
		String con=new String(arg0,start,length);
		if(!con.trim().equals("")){
			
			System.out.println(con);
		}
	}
	
	//����XML�ļ���һ��Ԫ�ؽ���</xx>
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(arg0, arg1, arg2);
	}

	//�����ĵ�����
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
}