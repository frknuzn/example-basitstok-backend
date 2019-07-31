package com.frknuzn.basitstok.Service.Impl;

import com.frknuzn.basitstok.Dto.RegistrationRequest;
import com.frknuzn.basitstok.Dto.UserDto;
import com.frknuzn.basitstok.Entity.User;
import com.frknuzn.basitstok.Repository.UserRepository;
import com.frknuzn.basitstok.Service.UserService;
import com.frknuzn.basitstok.Util.TPage;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository _userRepository;

    private final ModelMapper _modelMapper;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository _userRepository, ModelMapper _modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this._userRepository = _userRepository;
        this._modelMapper = _modelMapper;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto save(UserDto user) {
       User usr= _modelMapper.map(user,User.class);
       usr=_userRepository.save(usr);
       user.setId(usr.getId());
       return user;
    }

    public List<UserDto> getAll(){
        List<User> data=_userRepository.findAll();
        return Arrays.asList(_modelMapper.map(data,UserDto[].class));
    }


    @Override
    public UserDto getById(Long id) {
        User usr=_userRepository.getOne(id);
        return _modelMapper.map(usr,UserDto.class);
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {

        Page<User> data=_userRepository.findAll(pageable);
        TPage<UserDto> response=new TPage<>();
        response.setStat(data, Arrays.asList(_modelMapper.map(data.getContent(),UserDto[].class)));
        return response;
    }

    @Override
    public UserDto getByUserName(String username) {
        User usr = _userRepository.findByUserName(username);
        return _modelMapper.map(usr,UserDto.class);
    }

    //RegistrationRequest DTO türünden gelen register isteğini kaydediyoruz.Şifremizi bcrypt tipinde encode ediyoruz
    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
           user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUserName(registrationRequest.getUsername());
            _userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
    }
}
