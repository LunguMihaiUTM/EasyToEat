package agin.llc1.llc1.builder;

import agin.llc1.llc1.dto.CategoryDTO;
import agin.llc1.llc1.entity.Category;

public class CategoryDirector {

    public static CategoryDTO buildCategoryDTO(Long id, String categoryName) {
        return new CategoryDTOBuilder()
                .id(id)
                .categoryName(categoryName)
                .build();
    }

    public static Category buildCategory(Long id, String categoryName) {
        return new CategoryBuilder()
                .id(id)
                .categoryName(categoryName)
                .build();
    }
}
