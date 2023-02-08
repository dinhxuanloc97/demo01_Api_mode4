package ra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Student;
import ra.model.sevice.StudentSevice;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentSevice studentSevice;
    @GetMapping
    public List<Student> getAllStudent(){
        return studentSevice.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable ("studentId") int studentId){
        return studentSevice.findById(studentId);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentSevice.saveOrUpdate(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId,@RequestBody Student student){
        Student studentUpdate = studentSevice.findById(studentId);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setBrithDay(student.getBrithDay());
        studentUpdate.setStudentStatus(student.getStudentStatus());
        //Cap nhat
        return studentSevice.saveOrUpdate(studentUpdate);
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentSevice.delete(studentId);
    }

    @GetMapping("/search")
    public  List<Student> searchByNameOrId(@RequestParam ("studentName") String studentName,@RequestParam("studentId")int studentId){
        return studentSevice.searchByName(studentName,studentId);
    }

    @GetMapping("/searchByAge")
    public List<Student> getStudentFromTo(@RequestParam("ageFrom") int ageFrom,@RequestParam("ageTo") int ageTo){
        return studentSevice.getStudentByAgeBetween(ageFrom,ageTo);
    }

}
