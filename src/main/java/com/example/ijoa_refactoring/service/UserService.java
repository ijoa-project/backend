package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.ParentRepository;

@Service
public class UserService {
    private DolbomiRepository dolbomiRepository;
    private ParentRepository parentRepository;

    @Autowired
    public void registerUser(JoinDto joinDto){
        if(joinDto.equals("dolbomi")){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setName(joinDto.getName());
            dolbomi.setId(joinDto.getId());
            dolbomi.setPw(joinDto.getPw());
            dolbomi.setGender(joinDto.getGender());
            dolbomi.setBirth(joinDto.getBirthDate());
            dolbomi.setPhone(joinDto.getPhone());
            dolbomi.setEmail(joinDto.getEmail());
            dolbomiRepository.save(dolbomi);
        } else if (joinDto.equals("parent")) {
            Parent parent = new Parent();
            parent.setName(joinDto.getName());
            parent.setId(joinDto.getId());
            parent.setPw(joinDto.getPw());
            parent.setGender(joinDto.getGender());
            parent.setBirth(joinDto.getBirthDate());
            parent.setPhone(joinDto.getPhone());
            parent.setEmail(joinDto.getEmail());
            parentRepository.save(parent);

        }
    }
}
