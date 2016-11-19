package net.mcshsz.config;

import java.sql.*;
import java.util.ArrayList;

import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.mcshsz.banned.main;

public class InsertDB{

	private String Url;
	private String User;
	private String Password;
	private String Table;
 
	private String DBDRIVER = "com.mysql.jdbc.Driver";//"com.mysql.jdbc.Driver";
 
 
	public InsertDB(String Url, String User, String Password, String Table){
		this.Url = Url;
		this.User = User;
		this.Password = Password;
		this.Table = Table;
	}

    
    /**
     * 插入数据 需要 InsertDB.SQL (SQL.add(""))
     * @return 插入数据是否成功  true|false
     * @throws Exception
     */
	public boolean SetINSERT(String sql){
		//String sql = "INSERT INTO Novel_Player(Player,breath,sscience,Head) VALUE("+ SQL +")";
        Connection conn = null ;
        Statement stmt = null;
        try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e1) {
			System.out.println("[Bss] 内部错误001 加载对应驱动失败");
			return false;
		}
        try {
			conn = DriverManager.getConnection(Url, User, Password);
		} catch (SQLException e) {
			System.out.println("[Bss] 内部错误002 数据库连接失败");
			return false;
		}
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("[Bss] 内部错误003");
			return false;
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("[Bss] 内部错误004 数据插入失败！");
			return false;
		}
		 
		 
		System.out.println("[Bss] 调试结束");
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("[Bss] 内部错误005 关闭失败！");
			return false;
		}
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("[Bss] 内部错误006 关闭失败！");
			return false;
		}//关闭数据库
    }
    

    /**
     * 需要PlayerSql.add(Player);
     * @param Player
     * @return 
     * @throws Exception
     */
    public ArrayList<String> getSelect(String sql){
    	ArrayList<String> dbs = new ArrayList<String>();//返回查询结果
        Connection conn = null ;
        PreparedStatement pstmt = null;
        try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库加载驱动失败");
		}
        try {
			conn = DriverManager.getConnection(Url, User, "123.com");
		} catch (SQLException e) {
			System.out.println("数据库连接失败，请查看是否正确连接到数据库");
			return dbs;
		}
		dbs.removeAll(dbs);
		//System.out.println("SQLwrit");
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("数据读取失败！");
		}
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int col = 0;
		try {
			col = rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				for (int iu = 1; iu <= col; iu++) {
					dbs.add(rs.getString(iu));
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//System.out.println("数据读取完成->" + dbs);
        try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("数据库连接失败 001");
		}
        try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭失败");
		}
        return dbs;
    }
    
    
 
}

    
  
    
    
