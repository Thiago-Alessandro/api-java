package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CarroService {

   // private UsuarioDAO usuarioDAO;
    private final CarroRepository carroRepository;

    public void salvar(Carro carro){
        carroRepository.save(carro);
    }

    public void cadastrar(CarroCadastroDTO carroCadastroDTO){
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroCadastroDTO, carro);
        carroRepository.save(carro);
    }

    public Carro buscarUm(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

    public void delete(Integer id){
        carroRepository.deleteById(id);
    }

}
