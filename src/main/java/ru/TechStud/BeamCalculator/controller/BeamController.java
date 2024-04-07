package ru.TechStud.BeamCalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.BeamDTO;
import ru.TechStud.BeamCalculator.service.BeamService;

import java.util.List;

@RestController
@RequestMapping("/api/beam")
@Tag(name = "Beam", description = "Api for CRUD operations with beam")
@AllArgsConstructor
@Slf4j
public class BeamController {

    public final BeamService beamService;

    @GetMapping
    @Operation(summary = "Get all beams in database")
    public List<BeamDTO> getAllBeams() {
        return beamService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create beam bulk request")
    public BeamDTO createBeam(@Valid @RequestBody BeamDTO beamDTO) {
        return beamService.create(beamDTO);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update beam by id and request")
    public BeamDTO updateBeamById(@PathVariable Long id,
                                  @Valid @RequestBody BeamDTO beamDTO) {
        return beamService.update(beamDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete beam by id")
    public void deleteBeamById(@PathVariable Long id) {
        beamService.deleteById(id);
    }
}
