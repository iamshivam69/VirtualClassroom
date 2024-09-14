package ControllerLayer;

import entities.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClassService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Optional<ClassEntity> getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public ClassEntity createClass(@RequestBody Classroom classroom) {
        return classService.createClass(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}