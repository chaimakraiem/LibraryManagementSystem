package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entities.book;
import com.example.librarymanagementsystem.service.AuthorService;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping("book")

public class bookController {
    private BookService bookService;
    private AuthorService authorService;
    private CategorieService categorieService;
    @GetMapping("/user/books")
    public String allBooks(Model m,
                           @RequestParam(name="mc",defaultValue ="")String mc,
                           @RequestParam(name = "page",defaultValue = "0")int page,
                           @RequestParam(name = "size",defaultValue = "5")int size) {
        //List<Produit>l=serviceProduit.getAllProducts();
        Page<book> l = bookService.getBooksByMc(mc, PageRequest.of(page, size));
        m.addAttribute("books",l.getContent());
        m.addAttribute("pages",new  int[l.getTotalPages()]);
        m.addAttribute("current",l.getNumber());
        m.addAttribute("mc", mc);
        return "book/books";
    }
    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long idbook) {
        bookService.deleteBook(idbook);
        return "redirect:/book/user/books";
    }
    @GetMapping("/admin/formajoutBook")
    public String form(Model m) {
        m.addAttribute("categories", categorieService.getAllCategories());
        m.addAttribute("authors", authorService.getAllAuthors());
        m.addAttribute("book", new book());
        return "book/addBook";
    }

    @PostMapping("/admin/submitBook")
    public String saveBook(@ModelAttribute("book") book book,@RequestParam("file") MultipartFile mf)throws IOException {
        bookService.saveBook(book,mf);
        return "redirect:/book/user/books";
    }

    @GetMapping("/admin/updatebook/{id}")
    public String updatebook(@PathVariable Long id,Model m)
    {
        book b=bookService.getBookById(id);
        m.addAttribute("book",b);
        m.addAttribute("categories",categorieService.getAllCategories());
        m.addAttribute("authors", authorService.getAllAuthors());
        return "book/addBook";
    }


}
