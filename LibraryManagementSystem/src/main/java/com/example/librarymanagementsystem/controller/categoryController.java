package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entities.author;
import com.example.librarymanagementsystem.entities.category;
import com.example.librarymanagementsystem.service.CategorieService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@RequestMapping("category")
public class categoryController {

    private CategorieService serviceCategorie;
    @GetMapping("/user/categories")
    public String allcat(Model m,
        @RequestParam(name="mc",defaultValue ="")String mc,
        @RequestParam(name = "page",defaultValue = "0")int page,
        @RequestParam(name = "size",defaultValue = "5")int size) {
            Page<category> list = serviceCategorie.getCategoryByMC(mc, PageRequest.of(page, size));
            m.addAttribute("categories",list.getContent());
            m.addAttribute("pages",new  int[list.getTotalPages()]);
            m.addAttribute("current",list.getNumber());
            m.addAttribute("mc", mc);
            return "categorie/categories";
    }
    @GetMapping("/admin/formajout")
    public String form(Model m){
        category c = new category();
        m.addAttribute("category",c);
        return "categorie/addCat";
    }
    @PostMapping("/admin/submitForm")
    public String create(@ModelAttribute("category") category c){
        serviceCategorie.saveCategorie(c);
        return "redirect:/category/user/categories";
    }
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id){
        serviceCategorie.deleteCategorie(id);
        return "redirect:/category/user/categories";
    }
    @GetMapping("/admin/updatecategory/{id}")
    public String updatecat(@PathVariable Long id,Model m)
    {
        category c=serviceCategorie.getCategoriesBId(id);
        m.addAttribute("category",c);
        return "categorie/addCat";
    }
}
