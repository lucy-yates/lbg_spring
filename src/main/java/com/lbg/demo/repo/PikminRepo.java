package com.lbg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Pikmin;

public interface PikminRepo extends JpaRepository<Pikmin, Integer> {

}