package com.pp.api.test_category.services;

import com.pp.api.test_category.models.TestCategory;
import com.pp.models.enums.StatusEnum;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TestCategoryService {

    TestCategory createTestCategory(TestCategory testCategory);

    List<TestCategory> getTestCategories(StatusEnum statusFilter, int page, int size , String field);

    TestCategory updateTestCategoryStatus(TestCategory testCategory);
}
