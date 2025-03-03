package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.dto.CategoryDTO;
import agin.llc1.llc1.entity.Category;
import agin.llc1.llc1.repository.CategoryRepository;
import agin.llc1.llc1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> categoriesDTO = categories.stream()
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .categoryName(category.getCategoryName())
                        .build())
                .toList();

        return categoriesDTO;
    }
}
