package ohgym.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ohgym.dbutil.ConnectionProvider;

public class UserServiceImpl implements UserService {
	private UserDAO dao;
	
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public User readUserInfo(String id) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.selectById(conn,id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public int updateUser(User user) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.update(conn,user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int deleteUser(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.delete(conn,id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

}
