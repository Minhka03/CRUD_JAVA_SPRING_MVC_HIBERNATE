package com.spring_mvc.admin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileNotNullValidator implements ConstraintValidator<FileNotNull, MultipartFile>{

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value.getOriginalFilename().isEmpty()) {
			return false;
		}
		return true;
	}
}
