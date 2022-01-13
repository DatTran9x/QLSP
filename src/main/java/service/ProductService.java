package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> list = new ArrayList<>();

    {
        list.add(new Product(1,"A",1));
        list.add(new Product(2,"B",2));
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public List<Product> show() {
        return list;
    }

    @Override
    public void edit(int index, Product product) {
        list.set(index,product);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public int find(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id)
                return i;
        }
        return -1;
    }

    @Override
    public Product findByName(String name) {
        for (Product p:list) {
            if(p.getName().contains(name))
                return p;
        }
        return null;
    }

    @Override
    public Product getProduct(int index) {
        return list.get(index);
    }

}
