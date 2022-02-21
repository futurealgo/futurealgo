package com.pp.api.test_category.services;

import com.pp.api.test_category.models.TestCategory;
import com.pp.api.test_category.repository.TestCategoryRepository;
import com.pp.models.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TestCategoryServiceImpl implements TestCategoryService{


    @Autowired
    TestCategoryRepository testCategoryRepository;

    @Override
    public TestCategory createTestCategory(TestCategory testCategory) {
        testCategory.setCreatedDate(LocalDateTime.now());
        testCategory.setModifiedDate(LocalDateTime.now());
        testCategory.setTotalTests(0L);
        testCategory.setStatus(StatusEnum.ACTIVE);
        return testCategoryRepository.save(testCategory);
    }

    @Override
    public List<TestCategory> getTestCategories(StatusEnum statusFilter, int page, int size, String field) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, field);
        if (Objects.nonNull(statusFilter))
            return testCategoryRepository.findAllByStatus(statusFilter,pageable);
        return testCategoryRepository.findAllByStatus(StatusEnum.ACTIVE,pageable);
    }

    @Override
    public TestCategory updateTestCategoryStatus(TestCategory testCategory) {
        testCategory.setModifiedDate(LocalDateTime.now());
        return testCategoryRepository.save(testCategory);
    }
}
