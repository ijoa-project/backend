package com.example.ijoa_refactoring.auth;


import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class FindUserInfo {
    // build test
    private static DolbomiRepository dolbomiRepository;
    private static ParentRepository parentRepository;

    @Autowired
    public FindUserInfo(DolbomiRepository dolbomiRepository,ParentRepository parentRepository){
        this.dolbomiRepository = dolbomiRepository;
        this.parentRepository = parentRepository;
    }

    public static String getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication != null) && (authentication.getPrincipal() instanceof UserDetails)) {
            String userName = authentication.getName();
            if(dolbomiRepository.existsByUserId(userName)){
                String userId = dolbomiRepository.findByUserId(userName).getUserId();
                return userId;

            }else if(parentRepository.existsByUserId(userName)){
                String userId = parentRepository.findByUserId(userName).getUserId();
                return userId;
            }


        }
        return null;
    }
}
