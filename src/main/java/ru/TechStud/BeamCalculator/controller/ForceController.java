package ru.TechStud.BeamCalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.ForceDTO;
import ru.TechStud.BeamCalculator.service.ForceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/force")
@Slf4j
@Tag(name = "Force", description = "Api for CRUD operations with Force")
public class ForceController {

    private final ForceService forceService;

    @GetMapping
    @Operation(summary = "Get all forces in database")
    public List<ForceDTO> getAllForces() {
        return forceService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create force bulk request")
    public ForceDTO createForce(@Valid @RequestBody ForceDTO dto) {
        return forceService.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update force by id and request")
    public ForceDTO updateForceById(@PathVariable Long id,
                                    @Valid @RequestBody ForceDTO dto) {
        return forceService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete beam by id")
    public void deleteBeamById(@PathVariable Long id) {
        forceService.delete(id);
    }
}
