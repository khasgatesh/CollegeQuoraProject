package com.project.collegequora.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@AllArgsConstructor
@ToString

@Document(collection ="User")
public class User {
    @Id
    private String user_id;
    private String role_type;
    private String user_name;
    private String email;
    private String password;
    private String dept_id;
}
