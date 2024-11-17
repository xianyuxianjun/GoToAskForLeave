package com.chenxianyu.controller;

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
    @ResponseBody
    @GetMapping("/getDep")
    public Reslut geyDep(){
        return depService.getAllDep();
    }

}
