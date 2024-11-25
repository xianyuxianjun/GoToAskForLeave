package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Department;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/dep")
public class DepController {
    @Autowired
    private DepService depService;
    @GetMapping("/getDep")
    public Reslut geyDep(){
        return depService.getAllDep();
    }

    @PostMapping("/delectDep")
    public Reslut delectDep(@RequestBody Department department){
        return depService.delectDep(department);
    }

    @PostMapping("/addDep")
    public Reslut addDep(@RequestBody Department department){
        return depService.addDep(department);
    }

    @PostMapping("/updateDep")
    public Reslut updateDep(@RequestBody Department department){
        return depService.updateDep(department);
    }

    @PostMapping("/getAllDep")
    public Reslut getAllDep(){
        return depService.getAdminAllDep();
    }
}
