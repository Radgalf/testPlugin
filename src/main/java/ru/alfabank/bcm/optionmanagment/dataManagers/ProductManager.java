package ru.alfabank.bcm.optionmanagment.dataManagers;


import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.transaction.TransactionCallback;
import net.java.ao.Query;
import ru.alfabank.bcm.optionmanagment.model.Product;

import javax.inject.Inject;
import javax.inject.Named;

import static com.google.common.base.Preconditions.checkNotNull;

@Named
public class ProductManager {
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public ProductManager(ActiveObjects ao) {
        this.ao = checkNotNull(ao);
    }

    public Product getProduct(final int id) {
        return ao.executeInTransaction(new TransactionCallback<Product>() {
            @Override
            public Product doInTransaction() {
                return ao.get(Product.class, id);
            }
        });
    }

    public Product[] getProducts() {
        return ao.executeInTransaction(new TransactionCallback<Product[]>() {
            @Override
            public Product[] doInTransaction() {
                return ao.find(Product.class, Query.select().order("NAME"));
            }
        });
    }

    public Product createProduct(final String name, final long age) {
        return ao.executeInTransaction(new TransactionCallback<Product>() {
            @Override
            public Product doInTransaction() {
                Product product = ao.create(Product.class);
                product.setName(name);
                product.setAge(age);
                product.save();
                return product;
            }
        });
    }

    public Product createProduct(final Product data) {
        return ao.executeInTransaction(new TransactionCallback<Product>() {
            @Override
            public Product doInTransaction() {
                Product product = ao.create(Product.class);
                product.setName(data.getName());
                product.setAge(data.getAge());
                product.save();
                return product;
            }
        });
    }

    public void updateProduct(final int id, final Product product) {
        ao.executeInTransaction(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction() {
                Product dbProduct = ao.get(Product.class, id);
                dbProduct.setName(product.getName());
                dbProduct.setAge(product.getAge());
                dbProduct.save();
                return null;
            }
        });
    }

    public void deleteProduct(final int id) {
        ao.executeInTransaction(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction() {
                Product product = ao.get(Product.class, id);
                ao.delete(product);
                return null;
            }
        });
    }
}
