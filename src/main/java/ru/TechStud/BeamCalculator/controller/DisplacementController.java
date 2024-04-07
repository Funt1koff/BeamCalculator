package ru.TechStud.BeamCalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.DisplacementDTO;
import ru.TechStud.BeamCalculator.service.DisplacementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/displacement")
@Slf4j
@Tag(name = "Displacement", description = "Api for CRUD operations with Displacement")
public class DisplacementController {

    public final DisplacementService displacementService;

    @GetMapping
    @Operation(summary = "Get all displacements in database")
    public List<DisplacementDTO> getAllDisplacements() {
        return displacementService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create displacement bulk request")
    public DisplacementDTO createDisplacement(@Valid @RequestBody DisplacementDTO dto) {
        return displacementService.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update displacement by Id, and request")
    public DisplacementDTO updateDisplacementById(@PathVariable Long id,
                                                  @Valid @RequestBody DisplacementDTO dto) {
        return displacementService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete displacement by Id")
    public void deleteDisplacement(@PathVariable Long id) {
        displacementService.delete(id);
    }
}
