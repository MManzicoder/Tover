package com.dev.tover.controllers;

import com.dev.tover.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {
    @GetMapping("/")
    public ResponseEntity<ApiResponse> welcome(){
        return ResponseEntity.ok(ApiResponse.success("Hello welcome to event api"));
    }
}
