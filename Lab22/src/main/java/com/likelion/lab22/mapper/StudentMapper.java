package com.likelion.lab22.mapper;

import com.likelion.lab22.dto.StudentDto;
import com.likelion.lab22.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
}


