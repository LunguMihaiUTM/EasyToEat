package agin.llc1.llc1.builder;

import agin.llc1.llc1.dto.CategoryDTO;

public class CategoryDTOBuilder {

    private Long id;
    private String categoryName;

    public CategoryDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CategoryDTOBuilder categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public CategoryDTO build() {
        return new CategoryDTO(id, categoryName);
    }
}


