package com.example.requestTracking.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;
    private String requesterFirstname;
    private String requesterMiddlename;
    private String requesterLastname;
    private String requesterPersonalAccount;
    private Date requestDate;
    private Date completionDate;
    private String serviceName;
    private String description;
    private String requesterPhone;
    private String requesterAddress;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "journalId")
    private Journal journal;

    public String getRequester(){
        return this.requesterFirstname + " " + this.requesterMiddlename + " " + this.requesterLastname;
    }
}
