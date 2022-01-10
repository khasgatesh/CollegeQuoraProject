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

@Document(collection="Answer")
public class Answer {
 @Id
 private String ans_id;
 private String answer;
 private String ans_date;
 private User user_id;
 
}
