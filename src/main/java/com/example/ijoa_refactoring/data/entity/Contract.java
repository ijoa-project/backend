package com.example.ijoa_refactoring.data.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    private int contractId;
    @OneToOne(mappedBy = "contract")
    private CareRequest careRequest;
    @OneToOne(mappedBy = "contract")
    private Dolbomi dolbomi;
    @OneToOne(mappedBy = "contract")
    private Parent parent;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String regularity;
    private String region;
    @ElementCollection
    private List<String> careType;
    private int totalCost;
    private String paymentState;


}
