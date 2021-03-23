package com.mustafa;

import com.mustafa.entity.Kullanici;
import com.mustafa.repository.KullaniciRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class KullaniciRepositoryTests {

    @Autowired
    private KullaniciRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void CreateKullanici(){
        Kullanici kullanici=new Kullanici();
        kullanici.setAdi("Mustafa");
        kullanici.setSoyadi("Söyler");
        kullanici.setEmail("mstfylrr@gmail.com");
        kullanici.setSifre("12345");

        Kullanici saveKul =repository.save(kullanici);
        Kullanici existKul =entityManager.find(Kullanici.class,saveKul.getId());

        assertThat(existKul.getEmail()).isEqualTo(kullanici.getEmail());
    }

    @Test
    public void EmailBulma(){
        String email="mstfylrr@gmail.com";

        Kullanici kullanici= repository.findByEmail(email);
        assertThat(kullanici).isNotNull();
    }
}
