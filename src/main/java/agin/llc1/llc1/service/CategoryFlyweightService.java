package agin.llc1.llc1.service;

import agin.llc1.llc1.flyweight.CategoryFlyweight;

import java.util.List;

public interface CategoryFlyweightService {

    CategoryFlyweight getCategory(String categoryName);
    List<CategoryFlyweight> getAllCategoriesFlyweight();
}
