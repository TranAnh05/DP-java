package vn.edu.giadinh.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.StudentDTO;
import vn.edu.giadinh.persistence.StudentGateway;

public class StudentListViewUseCase {
	private StudentGateway studentGateway;
	
	
	public StudentListViewUseCase(StudentGateway studentGateway) {
		super();
		this.studentGateway = studentGateway;
	}
	
	public List<StudentListViewDTO> execute() throws SQLException, ParseException {
		List<StudentDTO> listDTO = null;
		List<Student> students = null;
		listDTO = studentGateway.getAll();
		
		//convert StudentDTO => Student
		students = convertToBusinessObjects(listDTO);
		// listViewUI.showList(students);

		return convertToViewDTO(students);
		
	}

	private List<Student> convertToBusinessObjects(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<>();

		for (StudentDTO dto : dtos) {
			Student student = StudentFactory.createStudent(dto);
			students.add(student);
		}

		return students;
	}

	private List<StudentListViewDTO> convertToViewDTO(List<Student> students) {
		List<StudentListViewDTO> itemList = new ArrayList<StudentListViewDTO>();

		for (Student student : students) {
			StudentListViewDTO item = new StudentListViewDTO();
			item.id = student.getId();
			item.name = student.getName();
			item.birthDate = student.getBirthDate();
			item.major = student.getMajor();
			item.gpa = student.calculateGPA();
			item.academicRank = student.classifyAcademic();
			itemList.add(item);
		}
		
		return itemList;
	}
}