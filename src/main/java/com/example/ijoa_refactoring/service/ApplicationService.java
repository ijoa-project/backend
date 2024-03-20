package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.ApplicationRequestDto;
import com.example.ijoa_refactoring.data.dto.ApplicationResponseDto;
import com.example.ijoa_refactoring.data.entity.Application;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.Location;
import com.example.ijoa_refactoring.data.repository.ApplicationRepository;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import com.example.ijoa_refactoring.data.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private DolbomiRepository dolbomiRepository;

    private LocationRepository locationRepository;


    public ApplicationService(ApplicationRepository applicationRepository, DolbomiRepository dolbomiRepository, LocationRepository locationRepository){
        this.applicationRepository = applicationRepository;
        this.dolbomiRepository = dolbomiRepository;
        this.locationRepository = locationRepository;
    }

    public Application registerApplication(ApplicationRequestDto applicationRequestDto,String userId){

        Dolbomi dolbomi_id = dolbomiRepository.findByUserId(userId);

        Application application = new Application();
        Location location = new Location();

        application.setDay(applicationRequestDto.getDay());
        application.setTime(applicationRequestDto.getTime());
        application.setHopeAge(applicationRequestDto.getHopeAge());
        application.setHopeGender(applicationRequestDto.getHopeGender());
        application.setRegularity(applicationRequestDto.getRegularity());
        application.setCareType(applicationRequestDto.getCareType());
        application.setTitle(applicationRequestDto.getTitle());
        application.setContent(applicationRequestDto.getContent());
        application.setDolbomi(dolbomi_id);
        location.setApplication(application);
        location.setSi(applicationRequestDto.getSi());
        location.setGu(applicationRequestDto.getGu());

        applicationRepository.save(application);
        locationRepository.save(location);

        return application;

    }

    public ApplicationResponseDto getApplication(String userId){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);
        Application application = applicationRepository.findByDolbomi(dolbomi);
        Location location = locationRepository.findByApplication(application);

        ApplicationResponseDto dto = new ApplicationResponseDto();

        dto.setDay(application.getDay());
        dto.setTime(application.getTime());
        dto.setHopeGender(application.getHopeGender());
        dto.setHopeAge(application.getHopeAge());
        dto.setRegularity(application.getRegularity());
        dto.setCareType(application.getCareType());
        dto.setTitle(application.getTitle());
        dto.setContent(application.getContent());
        dto.setSi(location.getSi());
        dto.setGu(location.getGu());


        return dto;
    }

    public Application updateApplication(String userId, ApplicationRequestDto applicationRequestDto){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);
        Application application = applicationRepository.findByDolbomi(dolbomi);
        Location location = locationRepository.findByApplication(application);

        application.setDay(applicationRequestDto.getDay());
        application.setTime(applicationRequestDto.getTime());
        application.setHopeAge(applicationRequestDto.getHopeAge());
        application.setHopeGender(applicationRequestDto.getHopeGender());
        application.setRegularity(applicationRequestDto.getRegularity());
        application.setCareType(applicationRequestDto.getCareType());
        application.setTitle(applicationRequestDto.getTitle());
        application.setContent(applicationRequestDto.getContent());
        application.setDolbomi(dolbomi);
        location.setApplication(application);
        location.setSi(applicationRequestDto.getSi());
        location.setGu(applicationRequestDto.getGu());

        applicationRepository.save(application);
        locationRepository.save(location);

        return application;

    }

    public void deleteApplication(String userId){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);
        Application application = applicationRepository.findByDolbomi(dolbomi);
        Location location = locationRepository.findByApplication(application);
        applicationRepository.delete(application);
        locationRepository.delete(location);
    }


}
