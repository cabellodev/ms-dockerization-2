package com.example.ms_response_2.Controller;


import com.example.ms_response_2.DTO.DtoMessage;
import com.example.ms_response_2.Services.ResponseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class ResponseController{

    public final ResponseServiceImp responseServiceImp;

    @Autowired
    public ResponseController (ResponseServiceImp responseServiceImp){
        this.responseServiceImp = responseServiceImp;
    }

    @GetMapping(value="/capture")
    public ResponseEntity<DtoMessage>get(){
        System.out.println("Hola mundo");
        DtoMessage message = this.responseServiceImp.get();
        return ResponseEntity.ok(message);
    }
}

