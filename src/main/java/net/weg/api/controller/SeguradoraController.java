package net.weg.api.controller;


import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.dto.IDTO;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @DeleteMapping
    public void remover (@RequestBody Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.cadastrar((IDTO) seguradora);
    }

    @PutMapping
    public  void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.editar((IDTO)seguradora);
    }

    @GetMapping("/{id}")
    public Seguradora buscar(@PathVariable Integer id){
        return seguradoraService.buscarUm(id);
    }

    @GetMapping
    public List<Seguradora> buscar(){
        return seguradoraService.buscarTodos();
    }

}
