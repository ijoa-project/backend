package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.Repository.DolbomiRepository;
import com.example.ijoa_refactoring.Repository.ParentRepository;
import com.example.ijoa_refactoring.data.dto.JoinDto;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{
    private ParentRepository parentRepository;
    private DolbomiRepository dolbomiRepository;

    @Autowired
    public UserServiceImple(ParentRepository parentRepository, DolbomiRepository dolbomiRepository){
        this.parentRepository = parentRepository;
        this.dolbomiRepository = dolbomiRepository;
    }

    @Override
    public void registerUser(JoinDto joinDto){
        if(joinDto.getPosition().equals("dolbomi")){
            Dolbomi dolbomi = new Dolbomi();
            dolbomi.setName(joinDto.getName());
            dolbomi.setId(joinDto.getId());
            dolbomi.setPw(joinDto.getPw());
            dolbomi.setBirth(joinDto.getBirthDate());
            dolbomi.setEmail(joinDto.getEmail());
            dolbomi.setPhone(joinDto.getPhone());
            dolbomi.setGender(joinDto.getGender());
            dolbomiRepository.save(dolbomi);
        }else if(joinDto.getPosition().equals("parent")){
            Parent parent = new Parent();
            parent.setName(joinDto.getName());
            parent.setId(joinDto.getId());
            parent.setPw(joinDto.getPw());
            parent.setBirth(joinDto.getBirthDate());
            parent.setEmail(joinDto.getEmail());
            parent.setPhone(joinDto.getPhone());
            parent.setGender(joinDto.getGender());
            parentRepository.save(parent);
        }

    }
}
