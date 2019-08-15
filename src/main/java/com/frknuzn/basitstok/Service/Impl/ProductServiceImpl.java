package com.frknuzn.basitstok.Service.Impl;

import com.frknuzn.basitstok.Dto.ProductDetailByUserDto;
import com.frknuzn.basitstok.Dto.ProductDto;
import com.frknuzn.basitstok.Entity.Product;
import com.frknuzn.basitstok.Repository.ProductRepository;
import com.frknuzn.basitstok.Repository.UserRepository;
import com.frknuzn.basitstok.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository _productRepository;
    private final UserRepository _userRepository;
    private final ModelMapper _modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, ModelMapper modelMapper) {
        _productRepository = productRepository;
        _userRepository = userRepository;
        _modelMapper = modelMapper;
    }

    /*Dışardan gelen veriyi bizim entitymize dönüştürüyoruz
    Model mapperın görevi; ProductDto tipinden bir örnek alıp içindeki veriyi
    Product tipinden bir classın örneğine ekleyip geri veriyor.
    Bunu da classlarda ki property alanlarını eşleştirerek yapıyor.
    Yani id ile id yi description ile description u
    */
    @Override
    public ProductDto save(ProductDto product) {
        Product productEntity=_modelMapper.map(product,Product.class);
        productEntity.setUser(_userRepository.getOne(product.getUser().getId()));
        productEntity=_productRepository.save(productEntity);
        product.setId(productEntity.getId());
        return product;
    }

    @Override
    public ProductDto getById(Long id) {
        return null;
    }

    @Override
    public List<ProductDetailByUserDto> getProductsByUserId(Long id) {
        List<Product> products=_productRepository.findProductByUserId(id);
        return Arrays.asList(_modelMapper.map(products,ProductDetailByUserDto[].class));
    }

    @Override
    public Boolean delete(Long productId) {
        _productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Boolean update(Long id, ProductDto product) {
        return null;
    }
}
