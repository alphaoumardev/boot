/*
  Created by:oumar
  Project:boot
  Name:Student
  Date: 8/13/2021
  Time: 1:38 PM
*/

package com.alpha.boot.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Student
{
    @Id
    @SequenceGenerator(name="student_sequence",sequenceName="student_sequence",allocationSize = 1)
    private Long id;
    private String name;
    private  String email;
    @Transient
    private int age;


}