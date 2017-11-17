package com.zhaolei.spring_boot.dao;

import com.zhaolei.spring_boot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer>{

}
