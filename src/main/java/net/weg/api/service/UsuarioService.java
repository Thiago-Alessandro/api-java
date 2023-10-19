package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepositoy;

    public void salvar(Usuario usuario){
        usuarioRepositoy.save(usuario);
    }

    public Usuario buscarUm(Integer id){
        return usuarioRepositoy.findById(id).get();
    }

    public Collection<Usuario> buscarTodos(){
        return  usuarioRepositoy.findAll();
    }

    public void delete(Integer id){
        usuarioRepositoy.deleteById(id);
    }

}
