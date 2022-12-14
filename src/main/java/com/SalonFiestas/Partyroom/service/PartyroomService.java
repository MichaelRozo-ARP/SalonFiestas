package com.SalonFiestas.Partyroom.service;

import com.SalonFiestas.Partyroom.entities.Partyroom;
import com.SalonFiestas.Partyroom.repository.PartyroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyroomService {

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll(){
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartyroom(Integer id){
        return partyroomRepository.getPartyroom(id);
    }
    public Partyroom save(Partyroom p){
        if(p.getId()==null){
            return partyroomRepository.save(p);
        }else{
            Optional<Partyroom> e = partyroomRepository.getPartyroom(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return partyroomRepository.save(p);
            }
        }
    }
    public Partyroom update(Partyroom p){
        if(p.getId()!=null){
            Optional<Partyroom> q = partyroomRepository.getPartyroom(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getOwner()!=null){
                    q.get().setOwner(p.getOwner());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                if(p.getCapacity()!=null){
                q.get().setCapacity(p.getCapacity());
                }
                /*if(p.getReservations()!=null){
                    q.get().setReservations(p.getReservations());*/

            partyroomRepository.save(q.get());
            return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(Integer id){
        boolean flag=false;
        Optional<Partyroom>p= partyroomRepository.getPartyroom(id);
        if(p.isPresent()){
            partyroomRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
