package com.naver.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.naver.project.entities.Commute;

public interface CommuteDAO {
	int insertRow(Commute commute);
	ArrayList<Commute> selectAll();
	Commute selectOne(HashMap commutesearch);
	int updateRow(Commute commute);
	int deleteRow(Commute commute);
}
