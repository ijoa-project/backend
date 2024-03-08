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
public class PrincipalDetailsService implements UserDetailsService {
    private final DolbomiRepository dolbomiRepository;
    private final  ParentRepository parentRepository;

    public PrincipalDetailsService(DolbomiRepository dolbomiRepository, ParentRepository parentRepository){
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Dolbomi dolbomi = dolbomiRepository.findByUserId(username);
        Parent parent = parentRepository.findByUserId(username);

        if(dolbomi != null){
            return new PrincipalDetails(dolbomi);
        }
        else if(parent!=null){
            return new PrincipalDetails(parent);
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

    }
}
