package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn=null;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Visual FoxPro Driver};SourceType=DBF;Exclusive=No;SourceDB=C:\\Users\\myzhong2012\\Desktop\\dbf");
			pstm=conn.prepareStatement("select * from req");
			rs=	pstm.executeQuery();
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
