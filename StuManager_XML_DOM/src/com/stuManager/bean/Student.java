/**
 * 作者：樊钰丰
 * 时间：2017。7.18
 * 功能：XML学生管理系统(实例)
 */

package com.stuManager.bean;

public class Student {
	
	private String id; //学生id
	private String name; //学生姓名
	private double java; //学生java成绩
	private double oracle; //学生oracle成绩
	private double vb; //学生vb成绩
	
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
