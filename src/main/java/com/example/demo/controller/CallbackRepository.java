package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CallbackRepository extends JpaRepository<CallbackTemplate, String> {

    @Query(value = "select EXISTS(select * from verloop v where v.messageid=:messageid)",nativeQuery = true)
    Integer findexists(@Param("messageid")String messageid);

    @Query(value="select status from verloop v where v.messageid=:messageid",nativeQuery = true)
    String findstatus(@Param("messageid")String messageid);
}
