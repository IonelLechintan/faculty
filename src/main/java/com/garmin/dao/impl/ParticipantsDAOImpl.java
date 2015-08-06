package com.garmin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.garmin.dao.ParticipantsDAO;
import com.garmin.dao.model.ParticipantDTO;
import com.garmin.util.ParticipantMapper;

public class ParticipantsDAOImpl implements ParticipantsDAO {
	private JdbcTemplate jdbcTemplateObject;

	public ParticipantsDAOImpl(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public int addStudentToCourse(String participantsId, String studentId, String courseId) {
		String sql = "insert into participants(participantId,studentId,courseId)  values(?,?,?) ";
		return jdbcTemplateObject.update(sql, participantsId, studentId, courseId);
	}

	public List<String> getAllCoursesByStudentId(String studentId) {
		String sql = "select * from participants courseId where studentId = ?";
		return (List<String>) jdbcTemplateObject.query(sql, new Object[] { studentId }, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(3);
			}
		});
	}

	public boolean getParticipantByStudentIdAndCourseId(String studentId, String courseId) {
		String sql = "select * from participants where studentId=? and courseId=?";
		try {
			ParticipantDTO partipantDTO = jdbcTemplateObject.queryForObject(sql, new Object[] { studentId, courseId },
					new ParticipantMapper());
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public List<String> getAllStudentsByCourseId(String courseId) {
		String sql = "select * from participants studentId where courseId = ?";
		return (List<String>) jdbcTemplateObject.query(sql, new Object[] { courseId }, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(2);
			}
		});
	}

	public int deleteCourse(String courseId) {
		String sql = "delete from participants where courseId=?";
		return jdbcTemplateObject.update(sql, courseId);
	}
	
	public int deleteStudent(String studentId) {
		String sql = "delete from participants where studentId=?";
		return jdbcTemplateObject.update(sql, studentId);
	}
}