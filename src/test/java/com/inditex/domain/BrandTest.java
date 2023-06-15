package com.inditex.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BrandTest {

    @Test
    void testBrandEntity() {
        // Create a sample Brand object
        Brand brand = Brand.builder()
                .id(1)
                .name("Example Brand")
                .build();

        // Verify that the entity fields are set correctly
        Assertions.assertEquals(1, brand.getId());
        Assertions.assertEquals("Example Brand", brand.getName());
    }
}
