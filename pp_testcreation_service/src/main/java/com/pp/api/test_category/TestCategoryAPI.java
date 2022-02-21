package com.pp.api.test_category;


import com.pp.api.test_category.dto.TestCategoryDTO;
import com.pp.api.test_category.exceptions.BadRequestException;
import com.pp.api.test_category.models.TestCategory;
import com.pp.api.test_category.services.TestCategoryService;
import com.pp.models.enums.StatusEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class TestCategoryAPI {

    @Autowired
    TestCategoryService testCategoryService;

    @ApiOperation(value = "Create Test Category", response = TestCategory.class, tags = "createTestCategory")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/test_categories")
    public ResponseEntity<TestCategory> createTestCategory(@RequestBody TestCategoryDTO testCategoryDTO){
        if (Objects.nonNull(testCategoryDTO) && (StringUtils.isEmpty(testCategoryDTO.getName()) || StringUtils.isEmpty(testCategoryDTO.getDescription()))){
            throw new BadRequestException();
        }
        return new ResponseEntity<>(testCategoryService.createTestCategory(TestCategory.builder().description(testCategoryDTO.getDescription()).name(testCategoryDTO.getName()).build()),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get list of Test Category", response = List.class, tags = "getTestCategories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Ok")})
    @GetMapping("/test_categories")
    public ResponseEntity<List<TestCategory>> getTestCategories(@RequestParam(value = "statusFilter", required = false) StatusEnum statusFilter, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "10") int size, @RequestParam(value = "field", required = false, defaultValue = "createdDate") String field){
        return new ResponseEntity<>(testCategoryService.getTestCategories(statusFilter, page, size,field), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Test Category", response = TestCategory.class, tags = "updateTestCategories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Ok")})
    @PutMapping("/test_categories")
    public ResponseEntity<TestCategory> updateTestCategories(@RequestBody TestCategory testCategory){
        return new ResponseEntity<>(testCategoryService.updateTestCategoryStatus(testCategory), HttpStatus.OK);
    }


}
