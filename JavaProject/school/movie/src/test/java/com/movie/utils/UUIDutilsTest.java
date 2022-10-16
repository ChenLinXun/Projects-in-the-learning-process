package com.movie.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UUIDutilsTest {

    @DisplayName("UUID测试...")
    @Test
    void getId() {
        System.out.println(UUIDutils.getId());
    }
}