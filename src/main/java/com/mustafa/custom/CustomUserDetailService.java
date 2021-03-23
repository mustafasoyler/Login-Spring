package com.mustafa.custom;

import com.mustafa.entity.Kullanici;
import com.mustafa.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private KullaniciRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Kullanici kullanici = repository.findByEmail(email);
        if (kullanici==null){
            throw new UsernameNotFoundException("Kullanıcı Bulunamadı");

        }
        return new CustomUserDetails(kullanici);
    }
}
