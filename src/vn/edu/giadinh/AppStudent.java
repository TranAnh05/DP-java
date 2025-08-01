package vn.edu.giadinh;

import java.sql.SQLException;
import java.text.ParseException;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewModel;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewController;
import vn.edu.giadinh.presentation.StudentListViewUI;

public class AppStudent {

	public static void main(String[] args) {
		StudentListViewUI view = new StudentListViewUI();
		StudentViewModel model = new StudentViewModel();
		StudentListViewUseCase listViewUseCase  = null;
		StudentListViewController controller = null;

        
		try {
			StudentListViewDAO listViewDAO = new StudentListViewDAO();
			listViewUseCase = new StudentListViewUseCase(listViewDAO);
			controller = new StudentListViewController(model, view, listViewUseCase);
			controller.execute();
			view.setVisible(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}