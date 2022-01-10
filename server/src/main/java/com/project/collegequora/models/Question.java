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

@Document(collection="Question")
public class Question {
 @Id
 private String ques_id;
 private String question;
 private String ques_date;
 private boolean ques_state;
 private Subject sub_id;
 private User user_id;  
}
