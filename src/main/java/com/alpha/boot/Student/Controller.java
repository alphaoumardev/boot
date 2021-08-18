/*
  Created by:oumar
  Project:boot
  Name:Controller
  Date: 8/13/2021
  Time: 1:59 PM
*/
package com.alpha.boot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/student")
public class Controller
{
    private final Services services;

    @Autowired
    public Controller(Services services){ this.services = services; }

    @RequestMapping(value="/all")
    public List<Student> stdent()
    {
        return services.stdent();
    }

    @PostMapping(path="/newstudent")
    public void newStudent( @RequestBody Student student)
    {
        services.createNewStudent(student);
    }
    @DeleteMapping(path="/{StudentId}")
    public void deleteStudents(@PathVariable("StudentId") Long id)
    {
        services.deleteStudent(id);
    }
    @PutMapping(path="/{StudentId}")
    public void updateStudents(@PathVariable("StudentId") Long id, @RequestParam(required=false)String name, @RequestParam(required=false)String email)
    {
        services.updateStudent(id, name, email);
    }

}
