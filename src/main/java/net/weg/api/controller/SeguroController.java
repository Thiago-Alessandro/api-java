package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.model.SeguroId;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    public SeguroService seguroService;

    @DeleteMapping("/{seguroId}/{seguradoraId}")
    public void remover (@PathVariable Integer seguroId,
                         @PathVariable Integer seguradoraId){
        seguroService.deletar(seguroId, seguradoraId);
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.cadastrar(seguroCadastroDTO);
    }

    @PutMapping
    public  void atualizar(@RequestBody Seguro seguro){
        seguroService.editar(seguro);
    }

    @GetMapping("/{seguroId}/{seguradoraId}")
    public Seguro buscar(@PathVariable Integer seguroId,
                         @PathVariable Integer seguradoraId){
        return seguroService.buscar(seguroId, seguradoraId);
    }

    @GetMapping
    public List<Seguro> buscar(){
        return seguroService.buscar();
    }

}
