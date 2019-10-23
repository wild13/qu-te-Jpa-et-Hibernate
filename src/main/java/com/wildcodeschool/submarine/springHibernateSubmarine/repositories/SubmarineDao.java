package com.wildcodeschool.submarine.springHibernateSubmarine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.submarine.springHibernateSubmarine.entities.Submarine;

@Repository
public interface SubmarineDao extends JpaRepository<Submarine, Long> {

}
