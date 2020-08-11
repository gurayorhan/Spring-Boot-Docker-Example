package com.emailsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String mail;

    private String password;

    private List<MailDto> senderMails;

    private List<MailDto> receiverMails;

}
