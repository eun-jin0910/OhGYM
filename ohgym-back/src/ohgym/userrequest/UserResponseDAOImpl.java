package ohgym.userrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResponseDAOImpl implements UserResponseDAO {
	// �����
	@Override
	public String categoryName(String str, Connection conn) throws SQLException {
		String sql = "SELECT exercise FROM exercise_type WHERE no = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("exercise");
			}
		}
		return null;
	}
	// ��� ����
	@Override
	public String scoreNum(String str, Connection conn) throws SQLException {
		String sql = "SELECT avg(score) FROM comment WHERE teacher_id IN (SELECT id FROM teacher_exercise WHERE exercise_type = '" + str + "')";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getDouble("avg(score)"));
			}
		}
		return null;
	}
	// ���� ��û��
	@Override
	public String requestNum(String str, Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM request WHERE exercise_type = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
	}
	// Ȱ�� ���� ��
	@Override
	public String activeNum(String str, Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM teacher_exercise WHERE exercise_type = '" + str + "'";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
	}
	// ���� ��
	@Override
	public String reviewNum(String str, Connection conn) throws SQLException {
		String sql = "SELECT count(*) FROM comment WHERE teacher_id IN (SELECT id FROM teacher_exercise WHERE exercise_type = '" + str + "')";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return String.valueOf(rs.getInt("count(*)"));
			}
		}
		return null;
	}
}