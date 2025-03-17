package agin.llc1.llc1.controller;

import agin.llc1.llc1.dto.CategoryDTO;
import agin.llc1.llc1.repository.CategoryRepository;
import agin.llc1.llc1.service.CategoryService;
import agin.llc1.llc1.service.serviceImpl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category-manager")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private CategoryService categoryService;

    @PostConstruct
    public void init() {
        categoryService = CategoryServiceImpl.getInstance(categoryRepository);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/clone")
    public ResponseEntity<CategoryDTO> getCloneCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.cloneCategory(categoryDTO));
    }

}
