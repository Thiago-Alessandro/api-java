package net.weg.api.controller;


import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.SeguradoraCadastroDTO;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @DeleteMapping
    public void deletar (@RequestBody Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping
    public void cadastrar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.cadastrar(seguradora);
    }

    @PutMapping
    public  void editar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.editar(seguradora);
    }

    @GetMapping("/{id}")
    public Seguradora buscarUm(@PathVariable Integer id){
        return seguradoraService.buscarUm(id);
    }

    @GetMapping
    public List<Seguradora> buscarTodos(){
        return seguradoraService.buscarTodos();
    }

}
