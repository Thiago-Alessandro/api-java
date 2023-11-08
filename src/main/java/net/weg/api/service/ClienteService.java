package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ClienteService implements IService<Cliente, Integer>{

    private final UsuarioRepository usuarioRepositoy;

    public Cliente cadastrar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        return usuarioRepositoy.save(cliente);
    }

    public Cliente buscarUm(Integer id){
        return usuarioRepositoy.findById(id).get();
    }

    public Collection<Cliente> buscarTodos(){
        return  usuarioRepositoy.findAll();
    }

    public void deletar(Integer id){
        usuarioRepositoy.deleteById(id);
    }

    public Cliente editar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        return usuarioRepositoy.save(cliente);
    }

}
