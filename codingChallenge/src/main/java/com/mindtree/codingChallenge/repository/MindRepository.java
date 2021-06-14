package com.mindtree.codingChallenge.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.codingChallenge.entity.Minds;


public interface MindRepository extends JpaRepository<Minds,Integer> {

}
