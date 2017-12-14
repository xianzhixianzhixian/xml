package com.stuManaget.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.stuManager.bean.Student;
import com.stuManager.dao.StuDao;

public class StuManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		while(true){
			
			mainUI();
		}
	}

public static void mainUI() throws Exception{
		
		System.out.println("��ѡ����");
		System.out.println("1���鿴����ѧ���ɼ�");
		System.out.println("2������ѧ��id��ѯѧ���ɼ�");
		System.out.println("3������һ��ѧ��");
		System.out.println("4������ѧ��id�޸�ѧ���ɼ�");
		System.out.println("5������ѧ��idɾ��ѧ��");
		System.out.println("6������Ϣд���ļ�");
		System.out.println("7���˳�ϵͳ");
		
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
				System.out.println("id��\t"+stu.getId()+"\tname��\t"+stu.getName()+"\tjava��\t"+stu.getJava()
				                   +"\toracle��\t"+stu.getOracle()+"\tvb��\t"+stu.getVb());
			}
			break;
		case 2:
			System.out.println("������ѧ��id");			
			id=sc.nextLine();
			stu=StuDao.getStudentById(id);
			System.out.println("id��\t"+stu.getId()+"\tname��\t"+stu.getName()+"\tjava��\t"+stu.getJava()
            +"\toracle��\t"+stu.getOracle()+"\tvb��\t"+stu.getVb());
			break;
		case 3:
			System.out.println("������ѧ��id");
			id=sc.nextLine();
			System.out.println("������ѧ������");
			name=sc.nextLine();
			System.out.println("������ѧ��java�ɼ�");
			java=sc.nextLine();
			System.out.println("������ѧ��oracle�ɼ�");
			oracle=sc.nextLine();
			System.out.println("������ѧ��vb�ɼ�");
			vb=sc.nextLine();
			stu=new Student();
			stu.setId(id);
			stu.setName(name);
			stu.setJava(Double.parseDouble(java));
			stu.setOracle(Double.parseDouble(oracle));
			stu.setVb(Double.parseDouble(vb));
			StuDao.addStudent(stu);
			break;
		case 4:
			System.out.println("������ѧ��id");
			id=sc.nextLine();
			System.out.println("������ѧ��java�ɼ�");
			java=sc.nextLine();
			System.out.println("������ѧ��oracle�ɼ�");
			oracle=sc.nextLine();
			System.out.println("������ѧ��vb�ɼ�");
			vb=sc.nextLine();
			stu=new Student();
			stu.setId(id);
			stu.setJava(Double.parseDouble(java));
			stu.setOracle(Double.parseDouble(oracle));
			stu.setVb(Double.parseDouble(vb));
			StuDao.changeStudent(stu,id);
			break;
		case 5:
			System.out.println("������ѧ��id");
			id=sc.nextLine();
			StuDao.deleteStudentById(id);
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