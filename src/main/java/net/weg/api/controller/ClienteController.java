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
    public Cliente buscarUm(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void cadastrar(@RequestBody UsuarioCadastroDTO usuario){

        usuarioService.cadastrar(usuario);
    }

    @PutMapping()
    public void eitar(@RequestBody UsuarioCadastroDTO usuario){
        usuarioService.editar(usuario);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Integer id,
                       @RequestBody UsuarioCadastroDTO usuario){
        usuarioService.editar(usuario);
    }

}
