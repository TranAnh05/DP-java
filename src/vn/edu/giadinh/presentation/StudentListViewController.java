package vn.edu.giadinh.presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.Student;
import vn.edu.giadinh.business.StudentListViewDTO;
import vn.edu.giadinh.business.StudentListViewUseCase;

public class StudentListViewController {
    private StudentViewModel studentViewModel;
    private StudentListViewUseCase useCase;
    
    public StudentListViewController(StudentViewModel studentViewModel, StudentListViewUseCase useCase) {
        this.studentViewModel = studentViewModel;
        this.useCase = useCase;
    }

    public void execute() throws SQLException, ParseException {
        // Lấy dữ liệu thật lên
        List<StudentListViewDTO> listStudentDTO = useCase.execute();
        List<StudentViewItem> listStudentPresentation = convertToPresentation(listStudentDTO);

        // Yêu cầu model cập nhật dữ liệu mới
        studentViewModel.updateStudentList(listStudentPresentation);
    }

    private List<StudentViewItem> convertToPresentation(List<StudentListViewDTO> studentListDTO) {
        List<StudentViewItem> listViewPresentation = new ArrayList<StudentViewItem>();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		int stt = 1;
		for (StudentListViewDTO student : studentListDTO) {
			StudentViewItem item = new StudentViewItem();
			item.stt = stt++;
			item.id = student.id;
			item.name = student.name;
			item.birthDate = fmt.format(student.birthDate);
			item.major = student.major;
			item.gpa = String.format("%.2f",student.gpa);
			item.academicRank = student.academicRank;
			listViewPresentation.add(item);
		}

        return listViewPresentation;
    }
}
