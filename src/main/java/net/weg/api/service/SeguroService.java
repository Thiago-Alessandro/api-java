package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.model.SeguroId;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService implements IService<Seguro, SeguroId>{

    private SeguroRepository seguroRepository;

    public Seguro cadastrar (IDTO dto){
        SeguroCadastroDTO seguroCadastroDTO = (SeguroCadastroDTO) dto;
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        System.out.println(seguro);
        return seguroRepository.save(seguro);}
    public Seguro editar (IDTO dto){
        SeguroCadastroDTO seguroCadastroDTO = (SeguroCadastroDTO) dto;
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        System.out.println(seguro);
        return seguroRepository.save(seguro);}

    public  void deletar(SeguroId id){
        seguroRepository.deleteById(id);
    }

    public Seguro buscarUm (SeguroId id){
        return seguroRepository.findById(id).get();
    }

    public List<Seguro> buscarTodos (){
        return seguroRepository.findAll();
    }

}
