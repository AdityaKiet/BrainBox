package com.brainbox.student.dashboard;

import com.brainbox.student.dto.ClassroomListDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityaagrawal on 18/02/16.
 */
public class ClassroomList {

    public static List<ClassroomListDTO> getClassroomList(){
        List<ClassroomListDTO> classroomListDTOs = new ArrayList<>();

        ClassroomListDTO classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(true);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(true);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);


        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(true);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);


        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);

        classroomListDTO = new ClassroomListDTO();
        classroomListDTO.setIsHeading(false);
        classroomListDTO.setText("Academics");
        classroomListDTOs.add(classroomListDTO);



        return classroomListDTOs;
    }
}
