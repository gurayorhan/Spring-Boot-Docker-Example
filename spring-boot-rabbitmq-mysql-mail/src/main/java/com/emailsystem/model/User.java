package com.emailsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false)
    private String name;

    @Column(length = 50,nullable = false)
    private String surname;

    @Column(length = 100,nullable = false)
    private String mail;

    @Column(length = 200,nullable = false)
    private String password;

    @OneToMany(mappedBy = "sender")
    private List<Mail> senderMails;

    @OneToMany(mappedBy = "receiver")
    private List<Mail> receiverMails;

}
