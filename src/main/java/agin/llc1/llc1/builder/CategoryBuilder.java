package agin.llc1.llc1.builder;

import agin.llc1.llc1.entity.Category;

public class CategoryBuilder {

    private Long id;
    private String categoryName;

    public CategoryBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Category build() {
        return new Category(id, categoryName);
    }
}

