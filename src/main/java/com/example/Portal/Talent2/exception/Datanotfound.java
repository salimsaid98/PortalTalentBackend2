package com.example.Portal.Talent2.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Datanotfound extends RuntimeException{
    public Datanotfound(String msg){
            super(msg);
    }
}