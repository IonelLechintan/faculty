package com.garmin.dao;

public interface ParticipantsDAO {

	public int addStudentToCourse(String participantsId,String studentId,String courseId);
	public int getParticipantByStudentIdAndCourseId(String studentId,String courseId);
}
