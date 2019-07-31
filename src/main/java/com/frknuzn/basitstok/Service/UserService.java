package com.frknuzn.basitstok.Service;

import com.frknuzn.basitstok.Dto.UserDto;
import com.frknuzn.basitstok.Util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUserName(String username);
}
