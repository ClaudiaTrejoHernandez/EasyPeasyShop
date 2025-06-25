package org.yearup.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;
import org.yearup.data.ProductDao;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductsControllerTest {

    @Test
    void testSearchProductByCategoryIdOnly() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product expectedProduct = new Product(1, "name", BigDecimal.valueOf(50.00), 1, null, null, 0, false, null);
        List<Product> expectedProducts = List.of(expectedProduct);
        when(productDao.search(1, null, null, null)).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(1, null, null, null);

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(1, null, null, null);

    }

    @Test
    void testSearchProductByColorOnly() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product expectedProduct = new Product(1, "name", BigDecimal.valueOf(40.00), 1, null, "blue", 0, false, null);
        List<Product> expectedProducts = List.of(expectedProduct);
        when(productDao.search(null, null, null, "blue")).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(null, null, null, "blue");

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, null, null, "blue");

    }

    @Test
    void testSearchProductByPriceOnly() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product expectedProduct = new Product(1, "name", BigDecimal.valueOf(30.00), 1, null, null, 0, false, null);
        List<Product> expectedProducts = List.of(expectedProduct);
        when(productDao.search(null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99), null)).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99), null);

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99), null);

    }

    @Test
    void testSearchProductByMultipleFilters() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product expectedProduct = new Product(1, "name", BigDecimal.valueOf(30.00), 1, null, "Black", 0, false, null);
        List<Product> expectedProducts = List.of(expectedProduct);
        when(productDao.search(1, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99),"Black")).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(1, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99),"Black");

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(1, BigDecimal.valueOf(20.00), BigDecimal.valueOf(45.99),"Black");
    }

    @Test
    void testSearchProductByNoFilters() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product p1 = new Product(1, "name1", BigDecimal.valueOf(50.00), 1, null, null, 0, false, null);
        Product p2 = new Product(3,"name2", BigDecimal.valueOf(199.99), 2, null, "Red", 5, false, null);
        List<Product> expectedProducts = List.of(p1, p2);
        when(productDao.search(null, null, null, null)).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(null, null, null, null);

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(null, null, null, null);

    }

}