package ru.TechStud.BeamCalculator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.LoadDTO;
import ru.TechStud.BeamCalculator.entity.Load;
import ru.TechStud.BeamCalculator.service.LoadService;

import java.util.List;

@RestController
@RequestMapping("/load")
@AllArgsConstructor
public class LoadController {

    private final LoadService loadService;

    @PostMapping
    public ResponseEntity<Load> create(@RequestBody LoadDTO dto) {
        return new ResponseEntity<>(loadService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Load>> readAll() {
        return new ResponseEntity<>(loadService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Load> update(@RequestBody Load load) {
        return new ResponseEntity<>(loadService.update(load), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        loadService.delete(id);
        return HttpStatus.OK;

    }
}
