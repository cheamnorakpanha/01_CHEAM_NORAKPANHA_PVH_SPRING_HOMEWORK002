package org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Instructor instructor;
}
