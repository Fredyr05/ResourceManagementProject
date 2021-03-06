package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.model.Users;
import project.service.UserService;

@RestController
public class UserController {

   @Autowired
   private UserService userService;

   /*---Add new user---*/
   @PostMapping("/user")
   public ResponseEntity<?> save(@RequestBody Users user) {
      long id = userService.save(user);
      return ResponseEntity.ok().body(user);
   }

   /*---Get a user by id---*/
   @GetMapping("/user/{id}")
   public ResponseEntity<Users> get(@PathVariable("id") long id) {
      Users user = userService.get(id);
      return ResponseEntity.ok().body(user);
   }
   
   //user authenticate//
   @PostMapping("/login")
   public ResponseEntity<Users> login(@RequestBody Users user) {
	   
	   boolean success = userService.authenticate(user);
	   
	   user.setPassword(Boolean.toString(success));
      return ResponseEntity.ok().body(user);
   }
   
   

   /*---get all users---*/
   @GetMapping("/user")
   public ResponseEntity<List<Users>> list() {
      List<Users> users = userService.list();
      return ResponseEntity.ok().body(users);
   }

   /*---Update a user by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Users user) {
      userService.update(id, user);
      return ResponseEntity.ok().body("Users has been updated successfully.");
   }

   /*---Delete a user by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      userService.delete(id);
      return ResponseEntity.ok().body("Users has been deleted successfully.");
   }
}