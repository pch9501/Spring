package com.sist.spring;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 아래의 4개는 Spring을 통해 이 값이 넘어와야 사용할 수 있다
	// ==> Getter, Setter 생성 
	// 사실, 아래의 코딩 일일이 하지 않아도 JDBC 관련 클래스 상속받아서 처리 가능. 
	// 하지만 우리는 학습을 위해 getter setter getConnection 만들어보는 것...
	
	private String driverName;
	private String url;
	private String userName;
	private String password;
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void init(){
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(url,userName,password);
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
