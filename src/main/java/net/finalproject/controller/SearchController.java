package net.finalproject.controller;

import net.finalproject.models.Page;
import net.finalproject.service.CategoryService;
import net.finalproject.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PageService pageService;

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(@RequestParam("searchKey") String searchKey, Model model, Authentication authentication){
        List<Page> searchResult=new ArrayList<>();
        searchResult.addAll(pageService.search(searchKey));
        model.addAttribute("pageList",searchResult);
        return "searchPage";
    }
}
