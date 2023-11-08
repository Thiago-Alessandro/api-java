package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.dto.IDTO;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CarroService implements IService<Carro, Integer> {

   // private UsuarioDAO usuarioDAO;
    private final CarroRepository carroRepository;

    @Override
    public Carro cadastrar(IDTO dto) throws Exception {
        CarroCadastroDTO carroDTO = (CarroCadastroDTO) dto;
        if (carroRepository.existsByPlaca(carroDTO.getPlaca())) {
            throw  new Exception("Há um carro com a placa "+carroDTO.getPlaca()+" cadastrado.");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);

        return carroRepository.save(carro);

    }

    public Carro editar(IDTO dto) throws Exception {
        CarroEdicaoDTO carroDTO = (CarroEdicaoDTO) dto;
        if (!carroRepository.existsById(carroDTO.getId())){
            throw new Exception("Não foi encontrado nenhum carro com o id"+carroDTO.getId());
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);
        return carroRepository.save(carro);
    }

    public Carro buscarUm(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

    public void deletar(Integer id){
        carroRepository.deleteById(id);
    }

}
