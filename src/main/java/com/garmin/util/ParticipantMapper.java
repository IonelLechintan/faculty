package com.garmin.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.garmin.dao.model.ParticipantDTO;

public class ParticipantMapper implements RowMapper<ParticipantDTO> {

	public ParticipantDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParticipantDTO participant = new ParticipantDTO();
		participant.setParticipantId(rs.getString("participantId"));
		participant.setStudentId(rs.getString("studentId"));
		participant.setCourseId(rs.getString("courseId"));

		return participant;
	}

}
