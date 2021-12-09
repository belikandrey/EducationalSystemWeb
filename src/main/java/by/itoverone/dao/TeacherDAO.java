package by.itoverone.dao;

import by.itoverone.entity.Teacher;
import by.itoverone.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherDAO {
    private DBUtil dbUtil;

    @Autowired
    public TeacherDAO(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public List<Teacher> getAll() throws SQLException {
        Connection connection = dbUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT Id, Name, SubjectName, Age" +
                " FROM Teacher");
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next()) {
            Teacher teacher = getTeacherFromRS(resultSet);
            teachers.add(teacher);
        }
        connection.close();
        return teachers;
    }

    public boolean saveTeacher(Teacher teacher) throws SQLException {
        Connection connection = dbUtil.getConnection();
        Statement statement = connection.createStatement();
        String SQL = "INSERT INTO Teacher(Id,Name, SubjectName, Age) " +
                "VALUES(" + teacher.getId() + ", " + teacher.getName() + "," +
                teacher.getSubjectName() + ", " + teacher.getAge() + ")";
        boolean result = statement.execute(SQL);
        connection.close();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Teacher(Id,Name, SubjectName, Age)" +
                " values(?,?,?,?)" );
        preparedStatement.setInt(1, teacher.getId());
        preparedStatement.setString(2, teacher.getName());
        preparedStatement.setString(3, teacher.getSubjectName());
        preparedStatement.setInt(4, teacher.getAge());

        preparedStatement.execute();

        return result;
    }


    private Teacher getTeacherFromRS(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String subjectName = resultSet.getString("SubjectName");
        int age = resultSet.getInt("Age");
        return new Teacher(id, name, subjectName, age);
    }


}
