package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.builder.CategoryDirector;
import agin.llc1.llc1.dto.CategoryDTO;
import agin.llc1.llc1.entity.Category;
import agin.llc1.llc1.flyweight.CategoryFlyweight;
import agin.llc1.llc1.repository.CategoryRepository;
import agin.llc1.llc1.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private static CategoryServiceImpl instance;

    private CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static CategoryServiceImpl getInstance(CategoryRepository categoryRepository) {
        if (instance == null) {
            instance = new CategoryServiceImpl(categoryRepository);
        }
        return instance;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> categoriesDTO = categories.stream()
                .map(category -> CategoryDirector.buildCategoryDTO
                        (category.getId(), category.getCategoryName())
                )
                .toList();

        return categoriesDTO;
    }

    @Override
    public CategoryDTO cloneCategory(CategoryDTO categoryDTO) {
        return categoryDTO.clone();
    }

}
