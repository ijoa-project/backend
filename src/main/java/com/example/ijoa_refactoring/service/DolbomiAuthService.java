package com.example.ijoa_refactoring.service;

import com.example.ijoa_refactoring.data.dto.DolbomiExtraDocumentRequestDto;
import com.example.ijoa_refactoring.data.dto.DolbomiHealthCertificationRequestDto;
import com.example.ijoa_refactoring.data.dto.DolbomiLicenseRequestDto;
import com.example.ijoa_refactoring.data.entity.Dolbomi;
import com.example.ijoa_refactoring.data.entity.DolbomiAuth;
import com.example.ijoa_refactoring.data.repository.DolbomiAuthRepository;
import com.example.ijoa_refactoring.data.repository.DolbomiRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@NoArgsConstructor
public class DolbomiAuthService {

    private DolbomiAuthRepository dolbomiAuthRepository;

    private DolbomiRepository dolbomiRepository;

    public int uploadLicenseFile(String userId, DolbomiLicenseRequestDto licenseRequestDto, HttpServletRequest request){

        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);

        DolbomiAuth license = new DolbomiAuth();

        MultipartFile licenseFile = licenseRequestDto.getLicense();

        String orgFileName = licenseFile.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath("/resources/upload");
        String filePath = realPath + File.separator;

        File upload = new File(filePath);
        if(!upload.exists()){
            upload.mkdir();
        }
        String saveFileName =
                System.currentTimeMillis()+orgFileName;
        license.setDolbomi(dolbomi);
        license.setLicense(saveFileName);

        dolbomiAuthRepository.save(license);




        if(license.getAuthId()>0)
            return 1;

        return 0;
    }


    public int uploadHealthCertification(String userId, DolbomiHealthCertificationRequestDto healthCertificationRequestDto,HttpServletRequest request){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);
        DolbomiAuth auth = dolbomiAuthRepository.findByDolbomi(dolbomi);

        MultipartFile healthCertification = healthCertificationRequestDto.getHealthCertification();

        String orgFileName = healthCertification.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath("/resources/upload");
        String filePath = realPath + File.separator;

        File upload = new File(filePath);
        if(!upload.exists()){
            upload.mkdir();
        }
        String saveFileName =
                System.currentTimeMillis()+orgFileName;



        auth.setHealthCertification(saveFileName);
        auth.setExpiredDate(healthCertificationRequestDto.getExpiredDate());

        dolbomiAuthRepository.save(auth);

        if(auth.getHealthCertification()!=null) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public int uploadExtraDocument(String userId, DolbomiExtraDocumentRequestDto extraDocumentRequestDto, HttpServletRequest request){
        Dolbomi dolbomi = dolbomiRepository.findByUserId(userId);

        MultipartFile extraDocument = extraDocumentRequestDto.getExtraDocument();

        String orgFileName = extraDocument.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath("/resources/upload");
        String filePath = realPath + File.separator;

        File upload = new File(filePath);
        if(!upload.exists()){
            upload.mkdir();
        }
        String saveFileName =
                System.currentTimeMillis()+orgFileName;

        dolbomi.setExtraDocument(saveFileName);

        if(extraDocument!=null){
            return 1;
        }else{
            return 0;
        }
    }


}
