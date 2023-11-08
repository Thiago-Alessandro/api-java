package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarUm(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(carroService.buscarUm(id));
            // return new ResponseEntity<>(carroService.buscarUm(id),HttpStatus.OK);
            // return new ResponseEntity<>(carroService.buscarUm(id),200);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody CarroCadastroDTO carroDTO) {
        try {
            return new ResponseEntity(carroService.cadastrar(carroDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping
    public ResponseEntity<Carro> editar(@RequestBody CarroEdicaoDTO carroDTO) {
        try {
            return new ResponseEntity<>(carroService.editar(carroDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
}
