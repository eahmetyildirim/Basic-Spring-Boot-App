package net.finalproject.service;

import net.finalproject.models.Category;
import net.finalproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public Category getCategoryByUrlPath(String url){
        return categoryRepository.findCategoryByUrl(url);
    }
}
