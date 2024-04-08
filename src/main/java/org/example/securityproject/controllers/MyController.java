package org.example.securityproject.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MyController {

    @GetMapping("/read-data")
    @Secured("ROLE_READ")
    public String readData() {
        return "Data accessible only for users with READ role";
    }

    @GetMapping("/write-data")
    @RolesAllowed("ROLE_WRITE")
    public String writeData() {
        return "Data accessible only for users with WRITE role";
    }

    @GetMapping("/write-delete-data")
    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public String writeDeleteData() {
        return "Data accessible for users with either WRITE or DELETE roles";
    }

    @GetMapping("/user-specific-data")
    public String userSpecificData(@RequestParam String username) {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals(currentUser)) {
            return "Data accessible for the authenticated user: " + currentUser;
        } else {
            return "Access denied. User does not match.";
        }
    }
}