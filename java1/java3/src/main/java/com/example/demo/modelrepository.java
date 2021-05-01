package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface modelrepository<list> extends JpaRepository<attributes,String> {
    @Query(value = "SELECT * FROM detail tab WHERE tab.email = ?1 and tab.password = ?2 " , nativeQuery=true)
    List<attributes> findBy(@Param("startAmt") String email, @Param("endAmt") String password);


}
