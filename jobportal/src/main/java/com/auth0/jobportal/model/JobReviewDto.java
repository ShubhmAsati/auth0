package com.auth0.jobportal.model;

import com.auth0.jobportal.entity.jsonMapper.Reviews;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class JobReviewDto {

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private long jobId;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    @Type(type = "jsonb")
    private List<Reviews> reviews;  //Clear this out
}
