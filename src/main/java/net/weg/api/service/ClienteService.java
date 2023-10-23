package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ClienteService {

    private final UsuarioRepository usuarioRepositoy;

    public void salvar(Cliente usuario){
        usuarioRepositoy.save(usuario);
    }

    public Cliente buscarUm(Integer id){
        return usuarioRepositoy.findById(id).get();
    }

    public Collection<Cliente> buscarTodos(){
        return  usuarioRepositoy.findAll();
    }

    public void delete(Integer id){
        usuarioRepositoy.deleteById(id);
    }

}
