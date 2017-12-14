/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017.7.25
 * ���ܣ�DOM4J+Java ReflectionС��ϰ
 */

package com.dom4j.test;

import java.io.File;
import java.lang.reflect.Method;

import org.dom4j.*;
import org.dom4j.io.*;

@SuppressWarnings("unused")
public class DOM4J {
	
	private static String name;
	private static String method;
	@SuppressWarnings("rawtypes")
	private static String parameter_type;
	private static String parameter_value;
	private SAXReader saxReader;
	private Document document;
	
	public static void main(String[] args) throws Exception{
		
		DOM4J dom4j=new DOM4J();
		dom4j.readParameters();
	}
	
	public DOM4J() throws Exception{
		
		saxReader=new SAXReader();
		document=saxReader.read(new File("src/program.xml"));
	}
	
	public void readParameters(){
		
		//DOM4J���ܿ��ȡ
		Element root=document.getRootElement();
		Element classA=root.element("class");
		
		Element className=classA.element("name");
		name=className.getText();
		
		Element classMethod=classA.element("method");
		Element methodName=classMethod.element("name");		
		method=methodName.getText();		
		
		Element parameter=classMethod.element("parameter");
		Element parameterType=parameter.element("parameter-type");
		parameter_type=parameterType.getText();
		Element parameterValue=parameter.element("parameter-value");
		parameter_value=parameterValue.getText();
	}
}

class A{
	
	public void show(){
		
	}
}