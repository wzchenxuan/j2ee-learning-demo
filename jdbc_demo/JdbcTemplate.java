import java.sql.Connection;
import java.sql.PreparedStatement;	
import java.sql.ResultSet;

import com.wzchenxuan.shopping.util.JdbcUtil;

public class JdbcTemplate {
	private JdbcTemplate(){
	}
	
	//DML操作模板
	public static int update(String sql, Object...params){
		Connection conn1=null;
		PreparedStatement ps1=null;
		try {
			conn1=JdbcUtil.getconnection();
			ps1=conn1.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps1.setObject(i+1, params[i]);
			}
			return ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn1, ps1, null);
		}
		return 0;
	}
	
	
	//DQL操作模板
	public static  <T>T query(String sql,IResultSetHandler<T> rsh,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getconnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();
			return rsh.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

}
