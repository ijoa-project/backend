package com.example.ijoa_refactoring.auth;


import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserInfo {

    public static DolbomiRepository dolbomiRepository;
    public static ParentRepository parentRepository;

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
