package ru.TechStud.BeamCalculator.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.BeamDTO;
import ru.TechStud.BeamCalculator.entity.Beam;
import ru.TechStud.BeamCalculator.service.BeamService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BeamController {

    private final BeamService beamService;

    @PostMapping
    public ResponseEntity<Beam> create(@RequestBody BeamDTO dto) {
        return new ResponseEntity<>(beamService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Beam>> readAll() {
        return  new ResponseEntity<>(beamService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Beam> update(@RequestBody Beam beam)  {
        return new ResponseEntity<>(beamService.update(beam), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        beamService.delete(id);
        return HttpStatus.OK;
    }
}
