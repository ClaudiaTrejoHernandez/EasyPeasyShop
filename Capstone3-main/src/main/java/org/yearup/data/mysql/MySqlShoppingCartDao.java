package org.yearup.data.mysql;


import org.springframework.stereotype.Component;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    private final ProductDao productDao;

    public MySqlShoppingCartDao(DataSource dataSource, ProductDao productDao) {
        super(dataSource);
        this.productDao = productDao;

    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        ShoppingCart cart = new ShoppingCart();

        String sql = "SELECT * " +
                "FROM shopping_cart " +
                "WHERE user_id = ? ";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");

                // Call the ProductDao to get full product information:
                Product product = productDao.getById(productId);

                if (product != null)
                {
                    ShoppingCartItem item = new ShoppingCartItem();
                    item.setProduct(product);
                    item.setQuantity(quantity);

                    cart.add(item);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error loading shopping cart for user: " + userId, e);
        }

        return cart;

    }

    @Override
    public ShoppingCart addProductToCart(int userId, int productId) {
        String sql = "INSERT INTO shopping_cart (user_id, product_id, quantity) " +
                "VALUES(?, ?, 1)" +
                "ON DUPLICATE KEY UPDATE quantity = quantity + 1";      //increment if item already exists

        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error adding item to cart", e);
        }

        //Return the updated cart:
        return getByUserId(userId);
    }

    @Override
    public ShoppingCart removeProductFromCart(int userId, int productId) {
        return null;
    }

    @Override
    public ShoppingCart updateQuantity(int userId, int productId, int quantity) {
        return null;
    }
}
