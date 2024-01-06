package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entities.author;
import com.example.librarymanagementsystem.entities.book;
import com.example.librarymanagementsystem.service.AuthorService;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller //api on utilise RestController
@RequestMapping("/author")
public class authorController {
    private AuthorService authorService;

    @GetMapping("/user/authors")
    public String allAuthors(Model m,
                @RequestParam(name="mc",defaultValue ="")String mc,
                @RequestParam(name = "page",defaultValue = "0")int page,
                @RequestParam(name = "size",defaultValue = "5")int size) {
            Page<author>list = authorService.getAuthorByMC(mc, PageRequest.of(page, size));
            m.addAttribute("authors",list.getContent());
            m.addAttribute("pages",new  int[list.getTotalPages()]);
            m.addAttribute("current",list.getNumber());
            m.addAttribute("mc", mc);
            return "author/authors";
    }

    @GetMapping("/admin/formajoutAuth")
    public String form(Model m){
        author a= new author();
        m.addAttribute("author",a);
        return "author/addAuth";
    }
    @PostMapping("/admin/submitFormAuth")
    public String create(@ModelAttribute("author") author auth){
        authorService.saveAuthor(auth);
        return "redirect:/author/user/authors";
    }
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return "redirect:/author/user/authors";
    }

    @GetMapping("/admin/updateauthor/{id}")
    public String updateauth(@PathVariable Long id,Model m)
    {
        author a=authorService.getAuthorBId(id);
        m.addAttribute("author",a);
        return "author/addAuth";
    }


}
