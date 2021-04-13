package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Participantsession;

@Repository
public interface Participant_sessionRepository extends JpaRepository<Participantsession,Long>{

}
