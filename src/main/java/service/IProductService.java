package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    List<Product> show();
    void edit(int index, Product product);
    void delete(int index);
    int find(int id);
    Product findByName(String name);

    Product getProduct(int index);
}
