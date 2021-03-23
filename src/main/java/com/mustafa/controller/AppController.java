package com.mustafa.controller;

import com.mustafa.entity.Kullanici;
import com.mustafa.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private KullaniciRepository repository;

    @GetMapping
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String KayitGöster(Model model){
        model.addAttribute("kullanici",new Kullanici());
        return "KayitForm";

    }

    @PostMapping("/process_register")
    public String kayitBasarili(Kullanici kullanici){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encodepswd= passwordEncoder.encode(kullanici.getSifre());
        kullanici.setSifre(encodepswd);

        repository.save(kullanici);
        return "kayit_basarili";

    }
    @GetMapping("/list_kullanici")
    public String KullaniciListeGöster(Model model){
        List<Kullanici> kullaniciList=repository.findAll();
        model.addAttribute("listKullanici",kullaniciList);
        return "kullanici";
    }
}
