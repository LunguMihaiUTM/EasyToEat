package agin.llc1.llc1.service.serviceImpl;

import agin.llc1.llc1.flyweight.CategoryFactory;
import agin.llc1.llc1.flyweight.CategoryFlyweight;
import agin.llc1.llc1.service.CategoryFlyweightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryFlyweightServiceImpl implements CategoryFlyweightService {

    private final CategoryFactory categoryFactory;

    @Override
    public CategoryFlyweight getCategory(String categoryName) {
        return CategoryFactory.getCategory(categoryName);
    }

    @Override
    public List<CategoryFlyweight> getAllCategoriesFlyweight() {
        return new ArrayList<>(categoryFactory.getAllCategories()
                .values());
    }
}
