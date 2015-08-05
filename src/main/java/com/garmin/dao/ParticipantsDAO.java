package com.garmin.dao;

import java.util.List;

public interface ParticipantsDAO {

	public int addStudentToCourse(String participantsId,String studentId,String courseId);
	public boolean getParticipantByStudentIdAndCourseId(String studentId,String courseId);
	public List<String> getAllCoursesByStudentId(String studentId);
}
