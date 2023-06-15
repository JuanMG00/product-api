package com.inditex.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void testProductEntity() {
        // Create a sample Product object
        Product product = Product.builder()
                .id(1)
                .name("Example Product")
                .build();

        // Verify that the entity fields are set correctly
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("Example Product", product.getName());
    }
}
