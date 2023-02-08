package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
   List<Student> findByStudentNameOrStudentId(String studentName, int studentId);
    List<Student> getStudentByAgeBetween(int ageFrom,int ageTo);
}
