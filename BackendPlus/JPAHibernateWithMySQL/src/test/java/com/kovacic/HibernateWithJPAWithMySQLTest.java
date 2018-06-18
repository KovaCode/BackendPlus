package com.kovacic;

import com.kovacic.entity.Student;
import com.kovacic.exception.ResourceNotFoundException;
import com.kovacic.repository.StudentRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class HibernateWithJPAWithMySQLTest extends AbstractTestNGSpringContextTests {
    private Logger logger = LoggerFactory.logger(this.getClass());
    private Student student = new Student();
    private Long studentId = 0L;

    @Autowired
    private StudentRepository studentRepository;

    @DataProvider(name = "Students")
    public static Object[][] students() {
        return new Object[][]{{"John Smith", "1234567890"}, {"Malcolm X", "9876543210"}, {"Elvis", "1231231231"}, {"Gandhi", "1231231231"}};
    }

    @BeforeTest
    public void startTest() {
        logger.info("Test started at");
    }

    @AfterTest
    public void stopTest() {
        logger.info("Test ended at");
    }

    @Test(priority = 10)
    public void createStudent() {
        String studentName = "John Smith";
        student.setName(studentName);
        String studentPassport = "1234567890";
        student.setPassportNumber(studentPassport);

        student = studentRepository.saveAndFlush(student);
        studentId = student.getId();

        logger.info("Student " + student.getName() + " (" + studentId + ") is saved!");
        Assert.assertEquals(student.getName(), studentName, "Student name should be equal");
        logger.info("Test is PASSED!");
    }

    @Test(priority = 11, dataProvider = "Students")
    public void createMultiplestudents(String name, String passportNumber) {
        Student student = new Student();
        student.setName(name);
        student.setPassportNumber(passportNumber);

        student = studentRepository.saveAndFlush(student);
        studentId = student.getId();

        logger.info("Student " + student.getName() + " (" + studentId + ") is saved!");
        Assert.assertEquals(student.getName(), name, "Student name should be equal");
        Assert.assertEquals(student.getPassportNumber(), passportNumber, "Student passport number should be equal");
        logger.info("Test is PASSED!");
    }

    @Test(priority = 20)
    public void readAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        Assert.assertTrue(studentRepository.findAll().size() >1);
    }

    @Test(priority = 30)
    public void updateStudent() {
        Student studentOLD = studentRepository.findAll().get(0);
        Long studentId = studentOLD.getId();
        String studentNameUP = "John Smith Jr.";
        studentOLD.setName(studentNameUP);
        String studentPassportUP = "0987654321";
        studentOLD.setPassportNumber(studentPassportUP);
        studentRepository.saveAndFlush(studentOLD);

        Student studentUpdate = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Students", "id", studentId));
        Assert.assertEquals(studentUpdate.getName(), studentNameUP, "Updated names should be equal!");


    }

    @Test(priority = 40)
    public void deleteStudent() {

        Student studentForDeletion = new Student("Test", "00000000000");
        studentForDeletion = studentRepository.saveAndFlush(studentForDeletion);

        Long studentForDeletionID = studentForDeletion.getId();
        logger.info("Student added with ID: " + studentForDeletionID);

        studentRepository.delete(studentForDeletion);
        Assert.assertTrue(!studentRepository.existsById(studentForDeletionID));
    }

}