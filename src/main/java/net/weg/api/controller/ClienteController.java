package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService usuarioService;

    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        usuarioService.delete(id);
    }

    @PostMapping()
    public void inserir(@RequestBody UsuarioCadastroDTO usuario){

        usuarioService.salvar(usuario);
    }

    @PutMapping()
    public void update(@RequestBody UsuarioCadastroDTO usuario){
        usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody UsuarioCadastroDTO usuario){
        usuarioService.salvar(usuario);
    }

}
