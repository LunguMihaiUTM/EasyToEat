package agin.llc1.llc1.flyweight;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryFactory {
    private static final Map<String, CategoryFlyweight> categories = new HashMap<>();

    public static CategoryFlyweight getCategory(String categoryName) {
        return categories.computeIfAbsent(categoryName, CategoryFlyweight::new);
    }

    public Map<String, CategoryFlyweight> getAllCategories() {
        return categories;
    }
}
