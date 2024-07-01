package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.StudentRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class SchoolApplication implements CommandLineRunner{
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course introToProgramming = new Course("Intro to Programming");
		Course advancedArchitecture = new Course("Advanced System Architecture");
		courseRepository.save(introToProgramming);
		courseRepository.save(advancedArchitecture);

		Department softwareDept = new Department("Software Engineering");
		departmentRepository.save(softwareDept);

		Student studentAlice = new Student(1L, "Alice Green");
		Student studentBob = new Student(2L, "Bob White");
		Student studentCarol = new Student(3L, "Carol Black");

		studentAlice.setDepartment(softwareDept);
		studentBob.setDepartment(softwareDept);
		studentCarol.setDepartment(softwareDept);

		Grade gradeA = new Grade("A", introToProgramming);
		gradeRepository.save(gradeA);
		studentAlice.addGrade(gradeA);

		Grade gradeBPlus = new Grade("B+", advancedArchitecture);
		gradeRepository.save(gradeBPlus);
		studentAlice.addGrade(gradeBPlus);

		Grade gradeB = new Grade("B", introToProgramming);
		gradeRepository.save(gradeB);
		studentBob.addGrade(gradeB);

		Grade gradeC = new Grade("C", introToProgramming);
		gradeRepository.save(gradeC);
		studentCarol.addGrade(gradeC);

		Grade gradeCPlus = new Grade("C+", advancedArchitecture);
		gradeRepository.save(gradeCPlus);
		studentCarol.addGrade(gradeCPlus);

		studentRepository.save(studentAlice);
		studentRepository.save(studentBob);
		studentRepository.save(studentCarol);

		List<Student> softwareEngineeringStudents = studentRepository.getStudentsFromDepartment("Software Engineering");
		System.out.println("------ All students from the Software Engineering department ------");
		softwareEngineeringStudents.forEach(student -> System.out.println(student));

		List<Student> architectureStudents = studentRepository.getStudentsWhoTookCourse("Advanced System Architecture");
		System.out.println("------ All students who took Advanced System Architecture ------");
		architectureStudents.forEach(student -> System.out.println(student));

	}


}

