package vn.edu.giadinh.persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface StudentGateway {
    List<StudentDTO> getAll() throws SQLException, ParseException;
}
