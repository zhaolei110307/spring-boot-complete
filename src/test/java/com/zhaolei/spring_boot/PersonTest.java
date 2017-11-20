package com.zhaolei.spring_boot;

import com.zhaolei.spring_boot.entities.Person;
import com.zhaolei.spring_boot.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testPersonGetOne(){
        Person person = personService.getOneAge(3);
        Assert.assertEquals(person.getAge(),new Integer(12));
    }

}
