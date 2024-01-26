package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Captain;

public interface CaptainRepo extends JpaRepository<Captain, Integer> {

}
