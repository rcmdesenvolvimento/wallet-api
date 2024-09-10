package com.rcm.info.wallet.api.controller;

import com.rcm.info.wallet.api.dto.UserDTO;
import com.rcm.info.wallet.api.entity.User;
import com.rcm.info.wallet.api.response.Response;
import com.rcm.info.wallet.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();
        User user = userService.save(this.convertDtoToEntity(dto));
        response.setData(this.convertEntityToDto(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private User convertDtoToEntity(UserDTO dto) {
        User u = new User();
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u.setPassword(dto.getPassword());
        return u;
    }

    private UserDTO convertEntityToDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setEmail(u.getEmail());
        dto.setName(u.getName());
        dto.setPassword(u.getPassword());
        return dto;
    }
}
