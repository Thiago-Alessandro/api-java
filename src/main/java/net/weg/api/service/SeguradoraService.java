package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.dto.IDTO;
import net.weg.api.repository.SeguradoraRepository;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguradoraService implements IService<Seguradora, Integer> {

    private SeguradoraRepository seguradoraRepository;

    public Seguradora cadastrar (IDTO dto){
        Seguradora seguradora = (Seguradora) dto;
        return seguradoraRepository.save(seguradora);
    }

    public  void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }

    public Seguradora buscarUm (Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public List<Seguradora> buscarTodos (){
        return seguradoraRepository.findAll();
    }

    public Seguradora editar (IDTO dto){
        Seguradora seguradora = (Seguradora) dto;
        return seguradoraRepository.save(seguradora);
    }

}
