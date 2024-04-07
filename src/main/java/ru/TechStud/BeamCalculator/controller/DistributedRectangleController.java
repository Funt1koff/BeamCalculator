package ru.TechStud.BeamCalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.DistributedRectangleDTO;
import ru.TechStud.BeamCalculator.service.DistributedRectangleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/distributed_rectangle")
@Slf4j
@Tag(name = "DistributedRectangle", description = "Api for CRUD operations with DistributedRectangle")
public class DistributedRectangleController {

    public final DistributedRectangleService distributedRectangleService;

    @GetMapping
    @Operation(summary = "Get all distributed triangle loads in database")
    public List<DistributedRectangleDTO> getAllBeams() {
        return distributedRectangleService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create distributed triangle load bulk request")
    public DistributedRectangleDTO createBeam(@Valid @RequestBody DistributedRectangleDTO dto) {
        return distributedRectangleService.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update beam by id and request")
    public DistributedRectangleDTO updateBeamById(@PathVariable Long id,
                                                  @Valid @RequestBody DistributedRectangleDTO dto) {
        return distributedRectangleService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete beam by id")
    public void deleteBeamById(@PathVariable Long id) {
        distributedRectangleService.delete(id);
    }
}
