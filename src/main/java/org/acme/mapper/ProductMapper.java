package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;

@ApplicationScoped
public class ProductMapper {

    public ProductDTO mapProductEntityToDTO (ProductEntity productEntity){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setCategory(productEntity.getCategory());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setModel(productEntity.getModel());

        return productDTO;
    }

    public ProductEntity mapProductDtoToEntity (ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(productDTO.getId());
        productEntity.setModel(productDTO.getModel());
        productEntity.setCategory(productDTO.getCategory());
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());

        return productEntity;
    }
}
