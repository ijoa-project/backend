package com.example.ijoa_refactoring.auth;

import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private DolbomiRepository dolbomiRepository;
    private ParentRepository parentRepository;

    public PrincipalDetailsService(DolbomiRepository dolbomiRepository, ParentRepository parentRepository){
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Dolbomi dolbomi = dolbomiRepository.findById(username);
        Parent parent = parentRepository.findById(username);

        if(dolbomi != null){
            return new PrincipalDetails(dolbomi);
        }
        else if(parent!=null){
            return new PrincipalDetails(parent);
        }

        return null;
    }
}
