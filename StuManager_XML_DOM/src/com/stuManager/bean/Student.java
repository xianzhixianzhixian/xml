/**
 * ���ߣ����ڷ�
 * ʱ�䣺2017��7.18
 * ���ܣ�XMLѧ������ϵͳ(ʵ��)
 */

package com.stuManager.bean;

public class Student {
	
	private String id; //ѧ��id
	private String name; //ѧ������
	private double java; //ѧ��java�ɼ�
	private double oracle; //ѧ��oracle�ɼ�
	private double vb; //ѧ��vb�ɼ�
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getJava() {
		return java;
	}
	public void setJava(double java) {
		this.java = java;
	}
	public double getOracle() {
		return oracle;
	}
	public void setOracle(double oracle) {
		this.oracle = oracle;
	}
	public double getVb() {
		return vb;
	}
	public void setVb(double vb) {
		this.vb = vb;
	}

}
