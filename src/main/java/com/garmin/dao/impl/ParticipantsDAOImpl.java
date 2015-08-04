package com.garmin.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

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

	public int getParticipantByStudentIdAndCourseId(String studentId, String courseId) {
		String sql = "select * from participants where studentId=? and courseId=?";

		ParticipantDTO partipantDTO = jdbcTemplateObject.queryForObject(sql, new Object[] { studentId, courseId },
				new ParticipantMapper());

		return 1;

	}
}
