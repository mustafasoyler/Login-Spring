package com.mustafa.repository;

import com.mustafa.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {

    @Query("SELECT k from Kullanici k WHERE k.email=?1 ")
    Kullanici findByEmail(String email);



}
