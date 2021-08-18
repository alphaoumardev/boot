/*
  Created by:oumar
  Project:boot
  Name:Service
  Date: 8/13/2021
  Time: 2:06 PM
*/
package com.alpha.boot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Services
{
    private final SRepository srepository;

    @Autowired
    public Services(SRepository srepository) {this.srepository = srepository; }

    public List<Student> stdent()
    {
//        return new ArrayList<Student>( List.of(new Student(1L,"AlphaOumar","oumardialo98@gmail.com", LocalDate.now(),23)));
        return srepository.findAll();
    }

    public void createNewStudent(Student student)
    {
        srepository.findByEmail(Student.getEmail());
        srepository.save(student);
        System.out.println("student = " + student);
    }

    public void deleteStudent(Long id)
    {
        boolean bool =srepository.existsById(id);
        if(!bool)
        {
            throw new IllegalStateException("Student with "+id+ "does not exist");
        }
        srepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email)
    {
        boolean bool =srepository.existsById(id);
        if(!bool)
        {
            throw new IllegalStateException("Student with "+id+ "does not exist");
        }
        if(name!=null&& name.length()>0&& !Objects.equals(Student.getName(),name))
        {
            Student.setName(name);
        }
        if(email!=null&& email.length()>0&& !Objects.equals(Student.getEmail(),email))
        {
            Optional<Student> option=srepository.findByEmail(email);
            if(option.isPresent())
            {
                throw new IllegalStateException("The email has been taken");
            }
            Student.setEmail(email);
        }

    }
}
