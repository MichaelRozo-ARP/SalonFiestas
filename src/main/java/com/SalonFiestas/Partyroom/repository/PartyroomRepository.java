package com.SalonFiestas.Partyroom.repository;

import com.SalonFiestas.Partyroom.entities.Partyroom;
import com.SalonFiestas.Partyroom.repository.crudRepository.PartyroomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PartyroomRepository {
    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    public List<Partyroom> getAll(){
        return (List<Partyroom>) partyroomCrudRepository.findAll();
    }

    public Optional<Partyroom> getPartyroom(Integer id){
        return partyroomCrudRepository.findById(id);
    }
    public Partyroom save(Partyroom c){
        return partyroomCrudRepository.save(c);
    }
    public void delete(Partyroom c){
        partyroomCrudRepository.delete(c);
    }

}
