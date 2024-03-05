package com.example.ijoa_refactoring.auth;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {
    private Dolbomi dolbomi;
    private Parent parent;

    public PrincipalDetails(Dolbomi dolbomi) {
        this.dolbomi = dolbomi;

    }
    public PrincipalDetails(Parent parent) {
        this.parent = parent;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                if(dolbomi!=null) {
                    return dolbomi.getRole().toString();
                }
                else if(parent!=null){
                    return parent.getRole().toString();
                }
                return "없는 사용자입니다.";
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        if(dolbomi!=null) {
            return dolbomi.getPw();
        }
        else if(parent!=null){
            return parent.getPw();
        }
        return null;
    }

    @Override
    public String getUsername() {
        if(dolbomi!=null) {
            return dolbomi.getId();
        }
        else if(parent!=null){
            return parent.getId();
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
