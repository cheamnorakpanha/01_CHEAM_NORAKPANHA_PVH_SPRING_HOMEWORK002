package org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    @Schema(example = "example@gmail.com")
    private String email;
}
