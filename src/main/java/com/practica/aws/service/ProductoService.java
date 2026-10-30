package com.practica.aws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.aws.model.Product;
import com.practica.aws.repository.ProductRepository;

@Service 
public class ProductoService {

    @Autowired 
    private ProductRepository productRepository;

    public List<Product> listarTodos(){
        return productRepository.findAll();
    }

    public  Optional<Product> buscarPorId(Long id){
        return  productRepository.findById(id);
    }

    public Product guardar(Product product){
        return productRepository.save(product);
    }

    public Product actualizar(Long id, Product productoDetalles){
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"+ id));
        product.setNombre(productoDetalles.getNombre());
        product.setDescripcion(productoDetalles.getDescripcion());
        product.setPrecio(productoDetalles.getPrecio());
        product.setStock(productoDetalles.getStock());
        product.setActivo(productoDetalles.getActivo());

        return productRepository.save(product);

    }

    public void eliminar(Long id){
        productRepository.deleteById(id);
    }

}
