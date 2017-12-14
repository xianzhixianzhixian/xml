/**
 * 作者：樊钰丰
 * 时间：2017.7.13
 * 功能：DOM4J配合XPATH案例
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

	//DOM4J配合XPATH案例
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1、得到SAXReader解析器
		SAXReader saxReader=new SAXReader();
		//2、指定去解析哪个文件
		Document document=saxReader.read(new File("src/com/xpath/day4/test.xml"));
		//3、得到根元素
		//Element root=document.getRootElement();
		//4、可以使用XPATH随心读取文件
		//document.selectSingleNode("")返回单个元素
		
		//List<Element> e=document.selectNodes("/AAA/CCC"); //返回多个元素
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("//BBB"); //找出所有BBB元素
		//System.out.println(((Element)e.get(e.size()-1)).getText());
		
		//List<Element> e=document.selectNodes("//DDD/BBB"); //找出所有父节点为DDD的BBB元素
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/AAA/CCC/DDD/*"); //选择/AAA/CCC/DDD下的元素
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/*/*/*/BBB"); //选出有三个祖先元素的BBB元素
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("//*"); //选出所有元素
		//System.out.println(e.size());
		
		//List<Element> e=document.selectNodes("/AAA/BBB[1]"); //选出AAA元素下的第一个BBB元素
		//System.out.println(e.size()+((Element)e.get(0)).getText());
		
		//如果确定只有一个Node元素，则可以使用selectSingleNode
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[1]");
		//System.out.println(e.getText());
		
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[last()]"); //选出AAA元素下的最后一个BBB元素
		//System.out.println(e.getText());
		
		//List<Attribute> e=document.selectNodes("//@id"); //选择所有的id属性,得到的结果是Attribute集合
		//System.out.println(((Attribute)e.get(0)).getText());
		
		//List<Element> e=document.selectNodes("//BBB[@id]"); //选出所有具有id属性的BBB元素
		//System.out.println(e.size()+((Element)e.get(0)).getText());
		
		//     //BBB[@name] 选出所有具有name属性的BBB元素
		//     //BBB[@*] 选出所有具有任意属性的BBB元素
		//     //BBB[not(@*)] 选出没有属性的BBB元素
		//     //BBB[@id='b1'] 选出有属性id且其值为'b1'的BBB元素
		//     //BBB[@name='bbb'] 选出有属性name且其值为'bbb'的BBB元素
		//	   //*[count(BBB)=2] 选出含有2个BBB子元素的元素
		
		//找出AAA下的第一个BBB下的第二个CCC元素中KKK的值
		//Element e=(Element) document.selectSingleNode("/AAA/BBB[1]/CCC[1]/KKK");
		//System.out.println(e.getText());
		
		List<Element> e=document.selectNodes("/AAA/BBB[1]/CCC[1]/KKK");
		System.out.println(e.get(0).getText());
	}

}







