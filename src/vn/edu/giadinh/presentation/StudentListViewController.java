package vn.edu.giadinh.presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewItem;
import vn.edu.giadinh.business.StudentViewModel;

public class StudentListViewController {
    private StudentViewModel studentViewModel;
    private StudentListViewUseCase useCase;
    
    public StudentListViewController(StudentViewModel studentViewModel, StudentListViewUseCase useCase) {
        this.studentViewModel = studentViewModel;
        this.useCase = useCase;
    }

    public void execute() throws SQLException, ParseException {
        // Lấy dữ liệu thật lên
        List<StudentViewItem> listStudent = useCase.execute();

        // Yêu cầu model cập nhật dữ liệu mới
        studentViewModel.updateStudentList(listStudent);
    }
}
