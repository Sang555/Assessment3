package com.sapient.assessment3.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.sapient.assessment3.model.*;
import com.sapient.assessment3.service.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    

    @GetMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Fetch all users", notes = "API to fetch all the users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listAll(){
        /*List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Vinay"));
        empList.add(new Employee(2, "Harish"));
        //model.addAttribute("empList", empList);
        EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployees(empList);*/
        List<User> userList = userService.listAll();
        return userList;
    }
	@GetMapping(value="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public User findById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id)
	{
		return userService.findById(id);
	}
	
	@GetMapping(value="/{id}/posts", produces= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public User findPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id)
	{
		return userService.findPostById(id);
	} 
	
	@PutMapping(value="/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public void updateUser(@PathVariable("id") int id, User user)
	{
		userService.update(id,user);
	}

	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable long id)
	{
		userService.deleteuser(id);		
	}
    
    @PostMapping(value = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody User user){
        Posts posts1 = new Posts();
        posts1.setId(1);
        posts1.setUser_id(1);
        posts1.setTitle("P1");
        posts1.setBody("post1");
        Posts posts2 = new Posts();
        posts2.setId(2);
        posts2.setUser_id(1);
        posts2.setTitle("P2");
        posts2.setBody("post2");

        List<Posts> posts = new ArrayList<Posts>();
        posts.add(posts1);
        posts.add(posts2);
        user.setPosts(posts);
        UserDetails details = new UserDetails();
        details.setId(1);
        details.setCity("Bangalore");
        details.setState("Karnataka");
        details.setZipCode("577142");
        user.setUserDetails(details);
        userService.saveUser(user);
        System.out.println("Came inside the post method of register user ....");
        
    }
}
