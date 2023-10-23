package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService {

    private SeguroRepository seguroRepository;

    public void salvar (Seguro seguro){
        seguroRepository.save(seguro);
    }

    public  void deletar(Integer id){
        seguroRepository.deleteById(id);
    }

    public Seguro buscar (Integer id){
        return seguroRepository.findById(id).get();
    }

    public List<Seguro> buscar (){
        return seguroRepository.findAll();
    }

}
