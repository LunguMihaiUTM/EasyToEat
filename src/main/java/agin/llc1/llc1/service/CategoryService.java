package agin.llc1.llc1.service;

import agin.llc1.llc1.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO cloneCategory(CategoryDTO category);
}
