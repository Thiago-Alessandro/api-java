package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id){
        return carroService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carroService.delete(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro Carro){
        carroService.salvar(Carro);
    }

    @PutMapping()
    public void update(@RequestBody Carro Carro){
        carroService.salvar(Carro);
    }
    
}
