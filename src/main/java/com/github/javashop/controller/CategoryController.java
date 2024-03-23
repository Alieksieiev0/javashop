package com.github.javashop.controller;

import com.github.javashop.dto.CategoryDto;
import com.github.javashop.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto get(@PathVariable UUID id) {
        return categoryService.findById(id);
    }

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        categoryService.deleteById(id);
    }

    @PutMapping("/{id}/products/{productId}")
    public void addProduct(@PathVariable UUID id, @PathVariable UUID productId) {
        categoryService.addProduct(id, productId);
    }

    @DeleteMapping("/{id}/products/{productId}")
    public void removeProduct(@PathVariable UUID id, @PathVariable UUID productId) {
        categoryService.removeProduct(id, productId);
    }
}
