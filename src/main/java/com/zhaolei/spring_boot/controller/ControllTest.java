package com.zhaolei.spring_boot.controller;

import com.zhaolei.spring_boot.dao.PersonDao;
import com.zhaolei.spring_boot.entities.Person;
import com.zhaolei.spring_boot.entities.Result;
import com.zhaolei.spring_boot.service.PersonService;
import com.zhaolei.spring_boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@ResponseBody
public class ControllTest {

    private final static Logger log = LoggerFactory.getLogger(ControllTest.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/allPerson",method = RequestMethod.GET)
    public List<Person> findAll(){
        return personDao.findAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person getById(@PathVariable("id") Integer id){
        return personDao.findOne(id);
    }


    @PostMapping(value = "/person")
    public Result postPerson(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtils.error(123,bindingResult.getFieldError().getDefaultMessage());
        }
        person.setName(person.getName());
        person.setAge(person.getAge());
        return ResultUtils.success(personDao.save(person));
    }

    @PutMapping(value = "/person")
    public Person updatePerson(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("age") Integer age){
        Person p = personDao.findOne(id);
        p.setAge(age);
        p.setName(name);
        return personDao.save(p);
    }

    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personDao.delete(id);
    }


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello";
    }

    @GetMapping("/person/getAge/{id}")
    public void getAgeById(@PathVariable("id") Integer id){
        personService.getAge(id);
    }
}
