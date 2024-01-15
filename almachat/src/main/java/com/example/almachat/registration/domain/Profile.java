package com.example.almachat.registration.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "profiles")
@Data
@Builder
public class Profile {

    @Id
    private String id;

    /** {@link User#getId()} */
    private String userId;
    private int age;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;

    private String provinceId;
    private String districtId;
    private String communeId;
    private String villageId;
    private String houseNumber;
    private String streetName;

    private String primarySchool;
    private String secondarySchool;
    private String highSchool;
    private String university;
    private List<WorkPlace> workPlaces;

    @Data
    @Builder
    static class WorkPlace {
        private String companyName;
        private Date workingFrom;
        private Date workingTo;
    }

}
