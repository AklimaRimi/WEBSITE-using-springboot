package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class service {

    @Autowired

    private  modelrepository repo;

    public List<attributes> listall()
    {
        return repo.findAll();
    }


    public attributes getId(Long id)
    {
        return (attributes) repo.findById(id).get();
    }
    public  void delete(Long id)
    {
        repo.deleteById(id) ;
    }

    public void save(attributes att) {
         repo.save(att);
    }

    public attributes get(Long id) {
        Optional<attributes> optional = repo.findById(id);
        attributes getResponse = null;
        if(optional.isPresent())
        {
            getResponse  = optional.get();
        }
        else
        {
            throw new RuntimeException("INVALID EMAIL ");
        }
        return getResponse;

    }

    public void deleteBy(Long id) {
        repo.deleteById(id);
    }

    public int fin(String email , String password) {
        List<attributes> optional = repo.findBy(email, password);
        attributes getResponse = null;
        if(!optional.isEmpty())
        {
           return 1;
        }
        else
        {
            throw new RuntimeException("INVALID EMAIL ");
        }

    }
}
