package ru.netology.hibernate.controllers;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.services.PersonsService;

@RestController
@RequiredArgsConstructor
public class SecuredController {

    private final PersonsService personsService;

    @Secured({"ROLE_READ"})
    @GetMapping("/read")
    public ResponseEntity<String> getByAgeLessThan() {
        return ResponseEntity.ok("User with READ role response");
    }

    @RolesAllowed({"WRITE"})
    @GetMapping("/write")
    public ResponseEntity<String> getPersonsByCity() {
        return ResponseEntity.ok("User with WRITE role response");
    }

    @PreAuthorize("hasRole('ROLE_READ') or hasRole('ROLE_WRITE')")
    @GetMapping("/preAuth")
    public ResponseEntity<String> getByNameAndSurname() {
        return ResponseEntity.ok("User with READ or WRITE role response");
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/withParam")
    public ResponseEntity<String> savePerson(@RequestParam String username) {
        return ResponseEntity.ok("User with READ or WRITE role response");
    }
}
