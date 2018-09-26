import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*CREATE TABLE `product` (
		  `id` bigint(11) NOT NULL AUTO_INCREMENT,
		  `productName` varchar(50) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
*/
public class jdbc_mysql_connection {
	//这里为了缩短篇幅省略的异常捕获，实际项目需要捕获异常
	public static void main(String[] args) throws Exception {
		//配置数据库信息
		String url="jdbc:mysql:///jdbcdemo";
		String user="root";
		String password="admin";
		//加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获得数据库链接
		Connection conn1 = DriverManager.getConnection(url, user, password);
		Statement st1=conn1.createStatement();
		ResultSet rs1=st1.executeQuery("SELECT * FROM product");
		//处理结果集
		while (rs1.next()) {
			System.out.println(rs1.getInt("id")+" "+rs1.getString("productname"));
		}
		//关闭资源链接
		rs1.close();
		st1.close();
		conn1.close();
	}
}
