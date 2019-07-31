package com.frknuzn.basitstok.Repository;

import com.frknuzn.basitstok.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);
}
