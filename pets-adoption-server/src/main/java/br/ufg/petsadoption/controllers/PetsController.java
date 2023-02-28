package br.ufg.petsadoption.controllers;

import br.ufg.petsadoption.models.Message;
import br.ufg.petsadoption.dtos.PetDto;
import br.ufg.petsadoption.services.PetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsController {

    private final PetsService petsService;

    public PetsController(PetsService petsService) {
        this.petsService = petsService;
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody PetDto dto) {
        petsService.create(dto);
        return ResponseEntity.ok().body(
                new Message(HttpStatus.OK.value(), "created", LocalDateTime.now())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable Long id, @RequestBody PetDto dto) {
        petsService.update(id, dto);
        return ResponseEntity.ok().body(
                new Message(HttpStatus.OK.value(), "updated", LocalDateTime.now())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(petsService.find(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PetDto>> getAll() {
        return ResponseEntity.ok().body(petsService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> delete(@PathVariable Long id) {
        petsService.delete(id);
        return ResponseEntity.ok().body(
                new Message(HttpStatus.OK.value(), "deleted", LocalDateTime.now())
        );
    }
}
