/*
  Created by:oumar
  Project:boot
  Name:Configuration
  Date: 8/13/2021
  Time: 3:40 PM
*/
package com.alpha.boot.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class Configurations
{
    private final SRepository srepository;

    public Configurations(SRepository srepository) {this.srepository = srepository; }

    @Bean
    CommandLineRunner commandLineRunner()
    {
        return args->
        {
           Student alpha= new Student(1L,"AlphaOumar","oumardialo98@gmail.com", LocalDate.now());
           Student oumar= new Student(1L,"Omar","oumardialo98@gmail.com", LocalDate.now());
            srepository.saveAll(List.of(alpha,oumar));
        };
    }

}
