package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.mapper.ProductMapper;
import org.acme.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductMapper productMapper;

    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> products = new ArrayList<>();

        productRepository.findAll().stream().forEach(item->{
            products.add(productMapper.mapProductEntityToDTO(item));
        });

        return products;
    }

    public void createProduct(ProductDTO product){
        productRepository.persist(productMapper.mapProductDtoToEntity(product));
    }

    public void changeProduct(Long id, ProductDTO product){

        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setPrice(product.getPrice());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategory(product.getCategory());
        productEntity.setModel(product.getModel());

        productRepository.persist(productEntity);
    }

    public void deleteProduct (Long id){
        productRepository.deleteById(id);
    }
}
