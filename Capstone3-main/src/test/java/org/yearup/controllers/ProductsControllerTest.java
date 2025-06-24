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
    void testSearchProductFound() {

        //Arrange
        ProductDao productDao = mock(ProductDao.class);
        ProductsController productsController = new ProductsController(productDao);

        Product expectedProduct = new Product(1, "name", BigDecimal.valueOf(50.00), 1, null, "Red", 0, false, null);
        List<Product> expectedProducts = List.of(expectedProduct);
        when(productDao.search(1, null, null, null)).thenReturn(expectedProducts);

        //Act
        List<Product> products = productsController.search(1, null, null, null);

        //Assert
        assertEquals(expectedProducts, products);
        verify(productDao).search(1, null, null, null);

    }

}