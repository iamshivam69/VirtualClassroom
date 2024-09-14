package service;

import ControllerLayer.Classroom;
import Repositories.ClassRepository;
import entities.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Method to fetch all classes
    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    // Method to fetch class by id
    public Optional<ClassEntity> getClassById(Long id) {
        return classRepository.findById(id);
    }

    // Method to create a class
    public ClassEntity createClass(Classroom classroom) {
        // Convert Classroom to ClassEntity
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(classroom.getClassName());
        classEntity.setDescription(classroom.getDescription());
        // Add any other necessary field mappings

        // Save the entity
        return classRepository.save(classEntity);
    }

    // Method to delete a class by id
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}