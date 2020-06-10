package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;

public interface MemberMapper {
	// 이전에 mapper에서의 resultType => 리턴형, parameterType => 매개변수, id => 메소드명
	// 아래의 @SelectKey~@Insert 코딩은 이전에 mapper에서 다음과 같이 코딩하던 것과 같다.
	/* 
	 * <insert id="memberInsert" parameterType="MemberVO">
	 * 		<selectKey keyProperty="no" resultType="int" order="BEFORE">
	 * 			SELECT NVL(MAX(no)+1,1) as no FROM spring_member
	 * 		</selectKey>
	 * </insert>
	 */
	
	@SelectKey(keyProperty="no",resultType=int.class,before=true,
			statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	@Insert("INSERT INTO spring_member VALUES("
			+ "#{no},#{name},#{sex},#{addr},#{tel})"
			)
	public void memberInsert(MemberVO vo);
	//  ====              ============
	//     resultType        parameterType

	
	
	// 아래의 @Select 코딩은 이전에 mapper에서 다음과 같이 코딩하던 것과 같다.
	/* 
	 * <select id="memberAllData" parameterType="MemberVO">
	 * 		SELECT * FROM spring_member
	 * </insert>
	 */
	@Select("SELECT * FROM spring_member")
	public List<MemberVO> memberAllData();
	
	@Select("SELECT * FROM spring_member "
			+ "WHERE no=#{no}")
	public MemberVO memberDetailData(int no);
}
