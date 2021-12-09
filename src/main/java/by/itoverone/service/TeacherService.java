package by.itoverone.service;

import by.itoverone.dao.TeacherDAO;
import by.itoverone.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TeacherService {

    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<Teacher> findAll() throws SQLException {
        List<Teacher> teachers = teacherDAO.getAll();
        return teachers;
    }

}
