package com.example.ms_response_2.Services;

import com.example.ms_response_2.DTO.DtoMessage;
import com.example.ms_response_2.Interfaces.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ResponseServiceImp implements ResponseService {

    public final ResponseService responseService;

    @Autowired
    public ResponseServiceImp(ResponseService responseService){
        this.responseService=responseService;
    }
    @Override // solo se pone para decir que viene de una clase padre que herada , aun siendo interfaz.
    public DtoMessage get() {
        DtoMessage message= this.responseService.get();
        return message;
    }
}