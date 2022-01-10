package com.project.collegequora.controllers;

import java.util.List;

import com.project.collegequora.Response;
import com.project.collegequora.models.Subject;
import com.project.collegequora.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/addSubject")
    public Response addDepartment(@RequestBody Subject subject)
    {
        if(subjectRepository.count()>0){
            List<Subject> data = subjectRepository.findAll();
            for(Subject sub: data){
                if(sub.getDept_id().equals(subject.getDept_id())){
                    
                    return new Response(400,"Subject Id Already exists",sub);
                }
            }
        }   
        subjectRepository.save(subject);
        return new Response(200,"Subject saved Successfully", "");
    }

    @GetMapping("/findSubjects")
    public Response findUser()
    {
        List<Subject> sub=subjectRepository.findAll();
        return new Response(200,"Fetched successfully", sub);
    }
}
