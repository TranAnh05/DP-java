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
		StudentViewModel model = new StudentViewModel();
		StudentListViewUseCase listViewUseCase  = null;
		StudentListViewUI view = new StudentListViewUI(model);
		StudentListViewController controller = null;

        
		try {
			StudentListViewDAO listViewDAO = new StudentListViewDAO();
			listViewUseCase = new StudentListViewUseCase(listViewDAO);
			
			controller = new StudentListViewController(model, listViewUseCase);
			controller.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}