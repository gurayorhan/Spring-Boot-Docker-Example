package com.emailsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto implements Serializable {

    private Long id;

    private String title;

    private String content;

    private Long senderId;

    private Long receiverId;

    @JsonIgnore
    private UserDto sender;

    @JsonIgnore
    private UserDto receiver;
}
