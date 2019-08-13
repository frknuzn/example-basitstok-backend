package com.frknuzn.basitstok.Repository;

import com.frknuzn.basitstok.Entity.Product;
import com.frknuzn.basitstok.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductByUserId(Long userId);
}
