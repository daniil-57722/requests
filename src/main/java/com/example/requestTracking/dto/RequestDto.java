package com.example.requestTracking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDto {
    private String serviceName;
    private String requester;
    private String requesterPhone;
    private String requesterPersonalAccount;
    private String requesterAddress;
    private String companyName;
    private Long idJournal;
    private String description;
}
