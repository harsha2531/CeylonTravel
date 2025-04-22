package org.example.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String check(){
        return "passed~!1";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('TRAVELER')")
    public String checks(){
        return "Traveler access passed~!2";
    }

    @GetMapping("/test3")
    @PreAuthorize("hasAuthority('AGENCY')")
    public String checkss(){
        return "Agency access passed~!3";
    }


}