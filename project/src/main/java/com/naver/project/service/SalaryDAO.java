package com.naver.project.service;

import java.util.ArrayList;

import com.naver.project.entities.Salary;

public interface SalaryDAO {
	int insertSalaryRow(Salary salary);
	ArrayList<Salary> selectSalaryAll();
	ArrayList<Salary> selectyn();
	Salary selectOne(String empcode);
	int updateSalaryRow(Salary salary);
	int deleteSalaryRow(Salary salary);
	void salaryDelete(Salary salary);
}
