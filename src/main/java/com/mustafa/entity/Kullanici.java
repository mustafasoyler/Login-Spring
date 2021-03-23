package com.mustafa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Kullanicilar")
@Getter
@Setter
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,unique = true,length = 50)
    private  Long id;

    @Column(nullable = false,length = 30)
    private String email;

    @Column(nullable = false,length = 120)
    private String sifre;

    @Column(nullable = false,length = 25)
    private String adi;

    @Column(nullable = false,length = 25)
    private String soyadi;

}
