package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.model.SeguroId;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService {

    private SeguroRepository seguroRepository;


    public Seguro cadastrar (SeguroCadastroDTO seguroCadastroDTO){
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        System.out.println(seguro);
        return seguroRepository.save(seguro);}
    public void salvar (Seguro seguro){
        seguroRepository.save(seguro);
    }

    public  void deletar(Integer seguroId,
                         Integer seguradoraId){
        seguroRepository.deleteById(new SeguroId(seguroId, seguradoraId));
    }

    public Seguro buscar (Integer seguroId,
                          Integer seguradoraId){
        return seguroRepository.findById(new SeguroId(seguroId,seguradoraId)).get();
    }

    public List<Seguro> buscar (){
        return seguroRepository.findAll();
    }

}
