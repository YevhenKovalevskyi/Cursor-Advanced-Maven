package hw06.task1.mappers.impl;

import hw06.task1.dto.ProductEditDto;
import hw06.task1.dto.ProductDto;
import hw06.task1.entities.Product;
import hw06.task1.mappers.ProductMapper;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YevhenKovalevskyi
 */
@AllArgsConstructor
@Component
public class ProductMapperImpl implements ProductMapper {
    
    private ModelMapper modelMapper;
    
    public ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
    
    public Product toCreateEntity(ProductEditDto productToCreate) {
        Product product = modelMapper.map(productToCreate, Product.class);
        product.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        product.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    
        return product;
    }
    
    public Product toUpdateEntity(Product productCurrent, ProductEditDto productToUpdate) {
        Product product = modelMapper.map(productToUpdate, Product.class);
        product.setId(productCurrent.getId());
        product.setCreatedAt(productCurrent.getCreatedAt());
        product.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    
        return product;
    }
}
