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
    public void deletar (@PathVariable Integer seguroId,
                         @PathVariable Integer seguradoraId){
        seguroService.deletar(
                new SeguroId(seguroId, seguradoraId));
    }

    @PostMapping
    public void cadastrar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.cadastrar(seguroCadastroDTO);
    }

    @PutMapping
    public  void editar(@RequestBody SeguroCadastroDTO seguro){
        seguroService.editar(seguro);
    }

    @GetMapping("/{seguroId}/{seguradoraId}")
    public Seguro buscarUm(@PathVariable Integer seguroId,
                         @PathVariable Integer seguradoraId){
        return seguroService.buscarUm(new SeguroId(seguroId, seguradoraId));
    }

    @GetMapping
    public List<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

}
