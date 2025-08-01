package vn.edu.giadinh.presentation;

import java.sql.SQLException;
import java.text.ParseException;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewModel;

public class StudentListViewController {
    private StudentViewModel studentViewModel;
    private StudentListViewUI view;
    private StudentListViewUseCase useCase;
    
    public StudentListViewController(StudentViewModel studentViewModel, StudentListViewUI view, StudentListViewUseCase useCase) {
        this.studentViewModel = studentViewModel;
        this.useCase = useCase;
        this.view = view;
    }

    public void execute() throws SQLException, ParseException {
        // Lấy dữ liệu thật lên
        // gửi thông điệp đến model
        // yêu cầu model cập nhật dữ liệu mớis
        studentViewModel.studentList = useCase.execute();

        // Lam thu cong - đúng phải là dùng mẫu observer để làm tự động
        view.showList(studentViewModel);
    }
}
