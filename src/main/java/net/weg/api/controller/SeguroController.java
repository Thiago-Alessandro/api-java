package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    public SeguroService seguroService;

    @DeleteMapping
    public void remover (@RequestBody Integer id){
        seguroService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

    @PutMapping
    public  void atualizar(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

    @GetMapping("/{id}")
    public Seguro buscar(@PathVariable Integer id){
        return seguroService.buscar(id);
    }

    @GetMapping
    public List<Seguro> buscar(){
        return seguroService.buscar();
    }

}
