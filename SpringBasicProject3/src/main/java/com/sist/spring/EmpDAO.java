package com.sist.spring;
import java.util.*;
import java.sql.*;

/*  <순서>
 *  1. MyBasicDataSource 메모리 할당 요청 
 *  2. MyBasicDataSource가 가지고 있는 Setter에 값을 채운다
 *  3. EmpDAO(MyBasicDataSource)
 *  =============================================== 여기까지는 Spring에 요청  
 *  4. MainClass에서 호출해서 사용 
 * 
 */
//SpringBasicProject3 > com.sist.spring2 > EmpDAO와 비교해볼 것 
public class EmpDAO {
	private MyBasicDataSource ds;
	public EmpDAO(MyBasicDataSource ds)
	{
		this.ds=ds;
		try {
			Class.forName(ds.getDriverClassName());
		} catch (Exception e) {}
	}
	
	// ============== Start of 중복코드 ==============
	private Connection conn;
	private PreparedStatement ps;
	
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUserName(),ds.getPassword());
		} catch (Exception e) {}
	}
	
	public void disConnection()
	{
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {}
	}
	// ============== End of 중복코드 ==============
	
	public List<EmpVO> empAllData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		
		try {
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal "
					+ "FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disConnection();
		}
		
		return list;
	}
}
