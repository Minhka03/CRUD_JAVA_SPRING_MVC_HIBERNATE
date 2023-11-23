package com.spring_mvc.admin.validator;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.entities.Category;

public class UniqueElementsValidator implements ConstraintValidator<UniqueElements, String>{

	@Autowired
	private final CategoryDAO categoryDAO;
	
	public UniqueElementsValidator(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
	
	@Override
    public void initialize(UniqueElements constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (value == null || value.trim().isEmpty()) {
            return true; // Bỏ qua kiểm tra nếu chuỗi trống hoặc null
        }
		List<Category> uniqueCharacters = categoryDAO.getAll();
		for (Category category : uniqueCharacters) {
			if(category.getCategoryName().equalsIgnoreCase(value.trim())) {
				return false;
			}
		}
        return true;
    }
}
