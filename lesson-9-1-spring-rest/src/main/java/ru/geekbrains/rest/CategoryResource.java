package ru.geekbrains.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persist.Category;
import ru.geekbrains.service.CategoryService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("rest/category")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCategoryById(@PathVariable(name = "id") Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<Collection<Category>> getAllFaculties() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestBody Category category) {
        Category updateCategory = categoryService.updateCategory(category);
        if(updateCategory == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
