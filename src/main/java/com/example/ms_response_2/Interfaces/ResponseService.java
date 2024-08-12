package com.example.ms_response_2.Interfaces;


import com.example.ms_response_2.DTO.DtoMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-dockerization" , url="http://ms-dockerization:50500")

public interface ResponseService {
    @GetMapping("/api/message")
    DtoMessage get();

}
