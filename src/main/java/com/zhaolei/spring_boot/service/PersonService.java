package com.zhaolei.spring_boot.service;

import com.zhaolei.spring_boot.ResultEnum;
import com.zhaolei.spring_boot.dao.PersonDao;
import com.zhaolei.spring_boot.entities.Person;
import com.zhaolei.spring_boot.exception.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PersonService {

    @Autowired
    private PersonDao personDao ;

    public void getAge(Integer id){
        Person person = personDao.findOne(id);
        if (person.getAge() < 10){
            throw new PersonException(ResultEnum.XIAO_XUE);
        }if(person.getAge() > 10 && person.getAge() < 16){
            throw new PersonException(ResultEnum.ZHONG_XUE);
        }else{
            throw new PersonException(ResultEnum.OTHER);
        }
    }
}


