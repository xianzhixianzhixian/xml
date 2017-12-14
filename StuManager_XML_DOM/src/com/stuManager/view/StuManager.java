/**
 * 作者：樊钰丰
 * 时间：2017.7.18
 * 功能：XML DOM实现学生管理系统
 */

package com.stuManager.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.stuManager.bean.Student;
import com.stuManager.dao.StuDao;

public class StuManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			
			mainUI();
		}
		
	}

	public static void mainUI(){
		
		System.out.println("请选择功能");
		System.out.println("1、查看所有学生成绩");
		System.out.println("2、按照学生id查询学生成绩");
		System.out.println("3、添加一个学生");
		System.out.println("4、按照学生id修改学生成绩");
		System.out.println("5、按照学生id删除学生");
		System.out.println("6、将信息写入文件");
		System.out.println("7、退出系统");
		
		int choice=0;
		Student stu=null;
		String id,name,java,oracle,vb;
		Scanner sc=new Scanner(System.in);
		choice=Integer.parseInt(sc.nextLine());
		
		switch(choice){
		
		case 1:
			ArrayList<Student> list=StuDao.getAllStudent();
			for(int i=0;i<list.size();i++){
				
				stu=list.get(i);
				System.out.println(stu.getName()+" "+stu.getJava()+" "+stu.getOracle()+" "+stu.getVb());
			}
			break;
		case 2:
			System.out.println("请输入学生id");			
			id=sc.nextLine();
			stu=StuDao.select(id);
			System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getJava()+" "+stu.getOracle()+" "+stu.getVb());
			break;
		case 3:
			System.out.println("请输入学生id");
			id=sc.nextLine();
			System.out.println("请输入学生名字");
			name=sc.nextLine();
			System.out.println("请输入学生java成绩");
			java=sc.nextLine();
			System.out.println("请输入学生oracle成绩");
			oracle=sc.nextLine();
			System.out.println("请输入学生vb成绩");
			vb=sc.nextLine();
			stu=new Student();
			stu.setId(id);
			stu.setName(name);
			stu.setJava(Double.parseDouble(java));
			stu.setOracle(Double.parseDouble(oracle));
			stu.setVb(Double.parseDouble(vb));
			StuDao.add(stu);
			break;
		case 4:
			System.out.println("请输入学生id");
			id=sc.nextLine();
			System.out.println("请输入学生java成绩");
			java=sc.nextLine();
			System.out.println("请输入学生oracle成绩");
			oracle=sc.nextLine();
			System.out.println("请输入学生vb成绩");
			vb=sc.nextLine();
			stu=new Student();
			stu.setJava(Double.parseDouble(java));
			stu.setOracle(Double.parseDouble(oracle));
			stu.setVb(Double.parseDouble(vb));
			StuDao.change(id,stu);
			break;
		case 5:
			System.out.println("请输入学生id");
			id=sc.nextLine();
			StuDao.delete(id);
			break;
		case 6:
			StuDao.writeIntoFile();
			break;
		case 7:
			System.exit(0);
			break;
		}
	}
}
