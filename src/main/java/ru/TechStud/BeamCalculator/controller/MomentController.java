package ru.TechStud.BeamCalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.MomentDTO;
import ru.TechStud.BeamCalculator.service.MomentService;

import java.util.List;

@RestController
@RequestMapping("/api/moment")
@Tag(name = "Moment", description = "Api for CRUD operations with moment")
@AllArgsConstructor
@Slf4j
public class MomentController {

    private final MomentService momentService;

    @GetMapping
    @Operation(summary = "Return all moments in database")
    public List<MomentDTO> getAllMoments()  {
        return momentService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create moment bulk request")
    public MomentDTO createMoment(@Valid @RequestBody MomentDTO dto)    {
        return momentService.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update moment by id and request")
    public MomentDTO updateMomentById(@PathVariable Long id,
                                      @Valid @RequestBody MomentDTO dto)    {
        return momentService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete moment by id")
    public void deleteMomentById(@PathVariable Long id) {
        momentService.delete(id);
    }
}
