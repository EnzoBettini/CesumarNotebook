package com.spring.security.models;

import com.spring.security.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String login;
   private String password;
   private UserRole role;



   public User(String login, String  password, UserRole role){
      this.login = login;
      this.password = password;
      this.role = role;
   }

   public User() {

   }


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      if(this.role == UserRole.ADMIN) return
              List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER"));
      else return  List.of(new SimpleGrantedAuthority("USER"));
   }

   @Override
   public String getUsername() {
      return login;
   }

   @Override
   public boolean isAccountNonExpired() {
      return UserDetails.super.isAccountNonExpired();
   }

   @Override
   public boolean isAccountNonLocked() {
      return UserDetails.super.isAccountNonLocked();
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return UserDetails.super.isCredentialsNonExpired();
   }

   @Override
   public boolean isEnabled() {
      return UserDetails.super.isEnabled();
   }
}
