package ru.TechStud.BeamCalculator.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.TechStud.BeamCalculator.dto.SubcaseDTO;
import ru.TechStud.BeamCalculator.service.SubcaseService;

import java.util.List;

@RestController
@RequestMapping("/api/subcase")
@Tag(name = "Subcase", description = "Api for CRUD operations with subcase")
@AllArgsConstructor
@Slf4j
public class SubcaseController {

    private final SubcaseService subcaseService;

    @GetMapping
    @Operation(summary = "Return all subcasesd in database")
    public List<SubcaseDTO> getAllSubcases()    {
        return subcaseService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create subcase bulk request")
    public SubcaseDTO createSubcase(@Valid @RequestBody SubcaseDTO dto) {
        return subcaseService.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update subcase by id and request")
    public SubcaseDTO updateSubcaseById(@PathVariable Long id,
                                        @Valid @RequestBody SubcaseDTO dto) {
        return subcaseService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete subcase by id")
    public void deleteSubcaseById(@PathVariable Long id)    {
        subcaseService.delete(id);
    }
}
