package com.frknuzn.basitstok.Controller;

import com.frknuzn.basitstok.Dto.ProductDto;
import com.frknuzn.basitstok.Service.Impl.ProductServiceImpl;
import com.frknuzn.basitstok.Util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProductCtrl.CTRL)
@Api(value =ApiPaths.ProductCtrl.CTRL,description = "Product API's")
@CrossOrigin(origins = "*", maxAge = 3600 ,allowedHeaders = "*")
public class ProductController {

    private final ProductServiceImpl _productService;


    public ProductController(ProductServiceImpl productService) {
        _productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProductDto.class)

    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto product){

        return ResponseEntity.ok(_productService.save(product));
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get Product By UserId",response = ProductDto.class)
    public ResponseEntity<List<ProductDto>> getProductsByUserId(@PathVariable(value = "id",required = true)Long userId){

        List<ProductDto> productDto=_productService.getProductsByUserId(userId);
        return ResponseEntity.ok(productDto);

    }
}
