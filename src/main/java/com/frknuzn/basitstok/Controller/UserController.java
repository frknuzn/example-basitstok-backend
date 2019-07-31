package com.frknuzn.basitstok.Controller;

import com.frknuzn.basitstok.Dto.UserDto;
import com.frknuzn.basitstok.Service.Impl.UserServiceImpl;
import com.frknuzn.basitstok.Util.ApiPaths;
import com.frknuzn.basitstok.Util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value =ApiPaths.UserCtrl.CTRL,description = "User API's")
@CrossOrigin
public class UserController {

    private final UserServiceImpl _userService;

    public UserController(UserServiceImpl _userService) {
        this._userService = _userService;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation",response = UserDto.class)
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable){
        TPage<UserDto> data=_userService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping()
    @ApiOperation(value = "Get All by operation",response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> data=_userService.getAll();
        return ResponseEntity.ok(data);
    }


    @ApiOperation(value = "Get By id operation",response = UserDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id",required = true) Long id){

        UserDto userDto= _userService.getById(id);
        return ResponseEntity.ok(userDto);
    }
    @ApiOperation(value = "Create operation",response = UserDto.class)
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        return ResponseEntity.ok(_userService.save(user));
    }

}
