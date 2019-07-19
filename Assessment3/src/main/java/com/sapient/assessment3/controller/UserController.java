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
	@GetMapping(value="/user/{id}", produces= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public User findById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id)
	{
		return userService.findById(id);
	}
	
	@GetMapping(value="/user/{id}/posts", produces= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public List<Posts> findPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id)
	{
		return userService.findPostById(id);
	} 
	@GetMapping(value="/user/{id}/posts/{pid}", produces= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public Posts findPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id,@ApiParam(value="FIND BY PID")@PathVariable("pid") long pid)
	{
		return userService.findPostByIdById(id,pid);
	} 
	
	@PutMapping(value="/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public void updateUser(@PathVariable("id") int id, User user)
	{
		userService.update(id,user);
	}

	@DeleteMapping(value="/user/{id}")
	public void deleteProduct(@PathVariable long id)
	{
		userService.deleteuser(id);		
	}
    
    @PostMapping(value = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody User user){

        userService.saveUser(user);
        System.out.println("Came inside the post method of register user ....");
        
    }
	@PostMapping(value="/user/{id}/posts", consumes= {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public void putPostById(@ApiParam(value="FIND BY ID")@PathVariable("id") long id,@Valid @RequestBody List<Posts> posts )
	{
		userService.putPostById(id,posts);
	} 
}
