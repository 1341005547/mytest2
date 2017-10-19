package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/***
 * JDBC工具
 * @author Administrator
 *
 */
public class UtilDao {
	
	static String URL = "jdbc:mysql://localhost:3306/mydatebase";
    static Connection conn = null;
    static PreparedStatement ps = null;
    /**
	 * 完成链接的作用
	 */
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "wangnj6511");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接错误");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接错误");
		}
		return conn;
	}
	/**
	 * 完成关流的作用
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		if(conn != null || ps != null || rs != null){
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("关流失败");
			}
			
		}
	}
	/**
	 * 重写executeUpdate()
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int executeUpdate(String sql,Object[] obj){
		Connection conn = null;
	    PreparedStatement ps = null;
	    int n = 0;
	    conn = getConnection();
	    
	    try {
	    	//执行更新语句
			ps =  conn.prepareStatement(sql);
			if(obj != null){
				for(int i =1; i <= obj.length; i++){
					ps.setObject(i, obj[i-1]);
				}
			}
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(conn,ps,null);
		}
		return n;
		
	}

	
}

