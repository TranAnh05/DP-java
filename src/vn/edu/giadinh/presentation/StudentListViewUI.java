package vn.edu.giadinh.presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import vn.edu.giadinh.Subscriber;
import vn.edu.giadinh.business.StudentViewItem;
import vn.edu.giadinh.business.StudentViewModel;
import java.awt.*;
// import java.awt.event.*;

public class StudentListViewUI extends JFrame implements Subscriber{
    private JTextField txtSearch;
    private JButton btnAdd;
    private JTable table;
    private DefaultTableModel model;

    private StudentViewModel studentViewModel;

    public StudentListViewUI(StudentViewModel viewModel) {
        super("Danh sách sinh viên");
        this.studentViewModel = viewModel;

        // đăng ký với viewModel (Puslisher)
        this.studentViewModel.addSubscriber(this);



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);
        setLocationRelativeTo(null);

        // Panel top
        JPanel top = new JPanel(new BorderLayout(5,5));
        txtSearch = new JTextField();
        btnAdd = new JButton("Thêm");
        top.add(txtSearch, BorderLayout.CENTER);
        top.add(btnAdd, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // Table
        String[] cols = {"STT","ID","Họ & tên","Ngày sinh","Chuyên ngành","Điểm TB","Xếp loại"};
        model = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
        update(); 
    }

    // public void showList(StudentViewModel studentViewModel) {
    //     model.setRowCount(0);
    //     for (StudentViewItem item : studentViewModel.studentList) {
    //         Object[] row = {
    //             item.stt,
    //             item.id,
    //             item.name,
    //             item.birthDate,
    //             item.major,
    //             item.gpa,
    //             item.academicRank
    //         };
    //         model.addRow(row);
    //     }
    // }

     @Override
    public void update() {
        List<StudentViewItem> students = studentViewModel.getStudentList();

        model.setRowCount(0);
        for (StudentViewItem item : students) {
            Object[] row = {
                item.stt,
                item.id,
                item.name,
                item.birthDate,
                item.major,
                item.gpa,
                item.academicRank
            };
            model.addRow(row);
        }
    }
}