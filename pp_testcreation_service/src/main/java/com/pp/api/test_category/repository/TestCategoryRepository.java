package com.pp.api.test_category.repository;

import com.pp.api.test_category.models.TestCategory;
import com.pp.models.enums.StatusEnum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCategoryRepository extends JpaRepository<TestCategory, Long> {

    List<TestCategory> findAllByStatus(StatusEnum status, Pageable pageable);
}
