package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entities.membre;
import com.example.librarymanagementsystem.service.MembreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("membre")

public class membreController {
    private MembreService membreService;

    @GetMapping("/user/membres")
    public String allAuthors(Model m,
                             @RequestParam(name="mc",defaultValue ="")String mc,
                             @RequestParam(name = "page",defaultValue = "0")int page,
                             @RequestParam(name = "size",defaultValue = "5")int size) {
        Page<membre> list = membreService.getMembreByMC(mc, PageRequest.of(page, size));
        m.addAttribute("membres",list.getContent());
        m.addAttribute("pages",new  int[list.getTotalPages()]);
        m.addAttribute("current",list.getNumber());
        m.addAttribute("mc", mc);
        return "membre/membres";
    }

    @GetMapping("/admin/formajoutMem")
    public String form(Model m){
        membre a= new membre();
        m.addAttribute("membre",a);
        return "membre/addmembre";
    }
    @PostMapping("/admin/submitFormMem")
    public String create(@ModelAttribute("membre") membre user){
        membreService.saveMembre(user);
        return "redirect:/membre/user/membres";
    }
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id){
        membreService.deleteMembre(id);
        return "redirect:/membre/user/membres";
    }

    @GetMapping("/admin/updatemembre/{id}")
    public String updatemembre(@PathVariable Long id,Model m)
    {
        membre a= membreService.getMembreBId(id);
        m.addAttribute("membre",a);
        return "membre/addmembre";
    }
}
