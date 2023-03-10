package com.example.requestTracking.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long journalId;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journal")
    private List<Request> requestList;

    public int getOpenRequestCount(){
        return (int) requestList.stream().filter(item -> item.getStatus().getStatusName().equals("Открыт")).count();
    }

    public int getRequestCount(){
        return requestList.size();
    }



}
