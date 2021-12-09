package by.itoverone.controller;

import by.itoverone.entity.Teacher;
import by.itoverone.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all-teachers")
    public String getAllTeachers(Model model) throws SQLException {
        List<Teacher> allTeachers = teacherService.findAll();
        model.addAttribute("teachers", allTeachers);
        return "all_teachers";
    }

}