package net.finalproject.controller;

import net.finalproject.models.Category;
import net.finalproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "kategoriler/{category}")
    public String getCategoryPage(@PathVariable("category")String categoryUrl, Model model){
        Category category = categoryService.getCategoryByUrlPath(categoryUrl);
        model.addAttribute("category",category);
        return "categoryPage";
    }
}
