package com.frknuzn.basitstok.Controller;

import com.frknuzn.basitstok.Dto.LoginRequest;
import com.frknuzn.basitstok.Dto.RegistrationRequest;
import com.frknuzn.basitstok.Dto.TokenResponse;
import com.frknuzn.basitstok.Entity.User;
import com.frknuzn.basitstok.Repository.UserRepository;
import com.frknuzn.basitstok.Security.JwtTokenUtil;
import com.frknuzn.basitstok.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    //Kullanıcı adı ve şifre doğruysa username ve token ver
    //LoginRequest DTO tipinde istek gelecek biz bu isteği doğrulayıp TokenResponse türünden geri döneceğiz
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final User user = userRepository.findByUserName(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        final Date tokenTime=jwtTokenUtil.getExpirationDateFromToken(token);
        return ResponseEntity.ok(new TokenResponse(user.getUserName(), token,tokenTime.getTime()));
    }

    //Kayıt ol
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        Boolean response = userService.register(registrationRequest);
        return ResponseEntity.ok(response);
    }
}
