package br.com.spring.model;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//anotações do lombok
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 120)
    private String name;
    @Column(nullable = false,length = 80,unique = true)
    private String login;
    @Column(nullable = false,length = 120)
    private String password;
    @Column(nullable = false,length = 256,unique = true)
    private String github;
    @Column(nullable = false,length = 120,unique = true)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role admin;


    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedTime;
 
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    
    private Boolean locked = false;
    private Boolean enabled = true;
    private Boolean loggedIn = false;

    public User(String name, String login, String password, String email, String github, Role role){
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;              
        this.github = github;
        this.admin = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(admin.name());
        return Collections.singletonList(authority);
    };

    @Override
    public String getUsername(){
        return  login;
    };

    @Override
    public boolean isAccountNonExpired(){
        return true;
    };

    @Override
    public boolean isAccountNonLocked(){
        return !locked;
    };

    @Override 
    public boolean isCredentialsNonExpired(){
        return true;
    };

    @Override
    public boolean isEnabled(){
        return enabled;
    };
}
