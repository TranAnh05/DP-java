package vn.edu.giadinh.business;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.Publisher;

public class StudentViewModel extends Publisher{
    private List<StudentViewItem> studentList;

    public StudentViewModel() {
        this.studentList = new ArrayList<>();
    }

    public void updateStudentList(List<StudentViewItem> newList) {
        this.studentList = newList;

        // Sau khi cập nhật dữ liệu, thông báo cho tất cả các Subscriber
        notifySubscribers();
    }

    public List<StudentViewItem> getStudentList() {
        return studentList;
    }
}
