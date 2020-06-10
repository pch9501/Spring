package com.sist.spring2;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	@Select("SELECT * FROM emp")
	public List<EmpVO> empAllData();
}
