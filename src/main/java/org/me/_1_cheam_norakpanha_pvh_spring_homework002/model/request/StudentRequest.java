package org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;

    @Schema(example = "example@gmail.com")
    private String email;
    private String phoneNumber;
    private List<Long> courseId;
}
