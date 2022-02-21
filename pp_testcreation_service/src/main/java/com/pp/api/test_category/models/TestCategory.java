package com.pp.api.test_category.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pp.models.enums.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCategory implements Serializable {

    @ApiModelProperty(notes = "Test Category ID",name="id",value="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(notes = "Test Category Name",name="name",value="name")
    private String name;

    @ApiModelProperty(notes = "Test Category Description",name="description",value="description")
    private String description;

    @ApiModelProperty(notes = "Test Category associated with total number of Tests",name="totalTests",value="totalTests")
    private long totalTests = 0L;

    @ApiModelProperty(notes = "Test Category status",name="status",value="status")
    private StatusEnum status;

    @ApiModelProperty(notes = "Test Category Created Date",name="createdDate",value="createdDate")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;

    @ApiModelProperty(notes = "Test Category Modified Date",name="modifiedDate",value="modifiedDate")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime modifiedDate;
}
