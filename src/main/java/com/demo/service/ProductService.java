package com.demo.service;

import com.demo.dto.ProductDto;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<ProductDto> getProductList(ProductDto dto);
}
