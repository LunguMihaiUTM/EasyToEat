package agin.llc1.llc1.dto;

import agin.llc1.llc1.service.Prototype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Prototype<CategoryDTO> {
    private Long id;
    private String categoryName;

    @Override
    public CategoryDTO clone() {
        return new CategoryDTO(this.id, this.categoryName);
    }

    @Override
    public String toString() {
        return "CategoryDTO{id=" + id + ", categoryName='" + categoryName + "'}";
    }
}