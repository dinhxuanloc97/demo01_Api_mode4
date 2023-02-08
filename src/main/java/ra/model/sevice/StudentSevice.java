package ra.model.sevice;

import ra.model.entity.Student;

import java.util.List;

public interface StudentSevice {
    List<Student> findAll();
    Student findById(int studentId);
    Student saveOrUpdate(Student student);
    void delete(int studentId);
    List<Student> searchByName(String studentName,int studentId);
    List<Student> getStudentByAgeBetween(int ageFrom,int ageTo);
}
