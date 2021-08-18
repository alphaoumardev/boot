/*
  Created by:oumar
  Project:boot
  Name:Repository
  Date: 8/13/2021
  Time: 3:18 PM
*/
package com.alpha.boot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SRepository extends JpaRepository<Student,Long>
{
    Optional<Student> findByEmail(String email);
}
