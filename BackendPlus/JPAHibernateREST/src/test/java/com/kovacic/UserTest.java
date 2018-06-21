package com.kovacic;

import com.kovacic.entity.dto.UserDto;
import com.kovacic.service.ISkillService;
import com.kovacic.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-dev.properties")
public class UserTest extends AbstractTestNGSpringContextTests {

    private String skillName = "Automation Testing";
    private String email = "test@tester.com";
    private Long userID = 0L;



    @Autowired
    private IUserService userService;

    @Autowired
    private ISkillService skillService;


    @Test(priority = 10)
    public void testCreateUser() {
        UserDto user = new UserDto();
        user.setUserName("Test101");
        user.setPassword("Test@101.");
        user.setEmail(email);
        user.setNote("notifications");

        user.setSkillDtos(skillService.getSkills().getBody());

        ResponseEntity<UserDto> response = userService.saveUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

        response = userService.getUserByEmail(email);

        userID = response.getBody().getID();
        System.err.println("ID: " + userID);


    }

    @Test(priority = 20)
    public void testReadUserByEmail() {
        ResponseEntity<UserDto> response = userService.getUserByEmail(email);

        System.err.println(response.getBody().getEmail());
        System.err.println(response.getBody().getUserName());
        System.err.println(response.getBody().getNote());

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK, "HTTP status should be " + HttpStatus.OK.toString());
        Assert.assertTrue(response.getBody().getID() != null, "Should not be null!");
    }


    @Test(priority = 30)
    public void testReadUser() {
        List<UserDto> response = userService.getAllUsers().getBody();

        for (UserDto user :response) {
            System.err.println(user.getEmail());
            System.err.println(user.getUserName());
            System.err.println(user.getNote());
        }
    }


    @Test(priority = 40, dependsOnMethods = "testCreateUser")
    public void testReadUserById() {
        ResponseEntity<UserDto> response = userService.getUserById(userID);

        System.err.println(response.getBody().getEmail());
        System.err.println(response.getBody().getUserName());
        System.err.println(response.getBody().getNote());

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK, "HTTP status should be " + HttpStatus.OK.toString());
        Assert.assertTrue(response.getBody().getID().equals(userID), "Should not be null!");
    }





    @Test(priority = 50)
    public void testDeleteUser() {
        UserDto userDto = userService.getUserByEmail(email).getBody();
        ResponseEntity<UserDto> response = userService.deleteUser(userDto);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
    }




}
