package com.SalonFiestas.Partyroom.repository;


import com.SalonFiestas.Partyroom.entities.Score;
import com.SalonFiestas.Partyroom.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(Integer id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score c){
        return scoreCrudRepository.save(c);
    }
    public void delete(Score c){
        scoreCrudRepository.delete(c);
    }

}
