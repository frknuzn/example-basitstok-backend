package com.frknuzn.basitstok.Service;

import com.frknuzn.basitstok.Dto.ProductDetailByUserDto;
import com.frknuzn.basitstok.Dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save (ProductDto product);

    ProductDto getById(Long id);

    List<ProductDetailByUserDto> getProductsByUserId(Long id);

    Boolean delete(Long productId);

    Boolean update(Long id,ProductDto product);
}
