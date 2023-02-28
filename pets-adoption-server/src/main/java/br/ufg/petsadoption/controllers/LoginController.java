package br.ufg.petsadoption.controllers;

import br.ufg.petsadoption.dtos.UserDto;
import br.ufg.petsadoption.dtos.UserInfoDto;
import br.ufg.petsadoption.models.LoginRequest;
import br.ufg.petsadoption.models.LoginResponse;
import br.ufg.petsadoption.entities.User;
import br.ufg.petsadoption.models.Message;
import br.ufg.petsadoption.services.JWTService;
import br.ufg.petsadoption.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JWTService jwtService;

    public LoginController(AuthenticationManager authenticationManager, UserService userService, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var userDetails = (UserDetails) authentication.getPrincipal();
        var token = jwtService.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/create")
    public ResponseEntity<Message> create(@RequestBody UserDto dto) {
        userService.throwExceptionIfExists(dto.getUsername());
        userService.create(dto);
        return ResponseEntity.ok().body(
                new Message(HttpStatus.OK.value(), "created", LocalDateTime.now())
        );
    }

    @GetMapping("/valid")
    public ResponseEntity<?> valid(@RequestHeader("Authorization") String authorization) {
        var token = StringUtils.substringAfter(authorization, "Bearer ");
        var valid = jwtService.isExpired(token);
        var responseEntity = valid ?
                ResponseEntity.ok() :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED);

        return responseEntity.build();
    }

    @GetMapping("/userinfo")
    public ResponseEntity<UserInfoDto> userInfo(Principal principal) {
        var user = (User) userService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok(
                new UserInfoDto(
                        user.getEmail(),
                        user.getPhone()
                )
        );
    }
}
