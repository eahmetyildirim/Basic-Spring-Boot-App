package net.finalproject.controller;

import net.finalproject.models.Category;
import net.finalproject.models.CustomOAuth2User;
import net.finalproject.models.Page;
import net.finalproject.models.User;
import net.finalproject.service.CategoryService;
import net.finalproject.service.PageService;
import net.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class PageController {
    @Autowired
    private PageService pageService;

    @Autowired
    UserService userService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/add-page", method = RequestMethod.GET)
    public String addPage(Model model, Authentication authentication){
        Page page=new Page();
        model.addAttribute("page",page);
        List<Category> categoryList =categoryService.getAllCategory(); // Database'den tüm kategoriler çekildi
        Map<Long,String> categoryMap=new HashMap<>();
        for(Category category:categoryList){
            categoryMap.put(category.getId(),category.getName()); // Kategoriler kategori id ve name ile maplenerek map datasına eklendi.
        }
        model.addAttribute("categoryMapList",categoryMap); // Maplediğimiz datayı modele ekledik.

        return "addPage";
    }

    @RequestMapping(value = {"/sayfa/{categoryUrl}/{pageUrl}"})
    public String getPage(@PathVariable("categoryUrl") String categoryUrl, @PathVariable("pageUrl") String pageUrl, Model model){
        Page page=pageService.getPageByUrlAndCategoryUrl(pageUrl,categoryUrl);
        model.addAttribute("page",page);
        Map<String,String> breadcrumb=new HashMap<>();
        Category category=page.getCategory();
        breadcrumb.put(category.getName(),"kategoriler/"+category.getUrl());
        breadcrumb.put(page.getTitle(),"sayfa/"+category.getUrl()+"/"+page.getUrl());
        model.addAttribute("breadcrumb",breadcrumb);
        return "page";
    }

    @RequestMapping(value = "/save-page", method = RequestMethod.POST)
    public String savePage(@ModelAttribute("page") Page page, Authentication authentication){
        if(Objects.nonNull(authentication) && authentication.isAuthenticated()) {
            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
            User user = userService.getUserForEmail(oauthUser.getEmail());
            page.setUser(user);
        }
        Date createdDate=new Date();
        page.setCreatedDate(createdDate);
        pageService.save(page);
        return "redirect:/";
    }
}
