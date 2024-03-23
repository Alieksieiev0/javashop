package com.github.javashop.service;

import java.util.UUID;

public interface CategoryProductService {
    public void saveByForeignKeys(UUID categoryId, UUID productId);

    public void deleteByForeignKeys(UUID categoryId, UUID productId);
}
