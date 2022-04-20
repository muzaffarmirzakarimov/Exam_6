package com.example.imtihon_6.controller;



import com.example.imtihon_6.entity.User;
import com.example.imtihon_6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    final UserRepository userRepository;
    final UserService userService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getone(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        return ResponseEntity.status(userOptional.isPresent() ? 404 : 200)
                .body(userOptional.isPresent() ? "User topilmadi" : userOptional.get());
    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
            return  ResponseEntity.status(404).body("User topilmadi!!!");
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("User deleted!!!");
    }

}
