package com.chenxianyu.service;

import com.chenxianyu.mapper.DepMapper;
import com.chenxianyu.model.enity.Department;
import com.chenxianyu.model.vo.DepVo;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepService {
    @Autowired
    private DepMapper depMapper;

    public Reslut getAllDep(){
        List<Department> departmentList = new ArrayList<>();
        List<DepVo> depVoList = new ArrayList<>();
        departmentList = depMapper.selectAllDep();
        for (Department department : departmentList) {
            DepVo depVo = convertToDepVo(department);
            depVoList.add(depVo);
        }
        return Reslut.succeed(depVoList);
    }

    public DepVo convertToDepVo(Department department){
        DepVo depVo = new DepVo();
        depVo.setTitle(department.getDepName());
        depVo.setValue(department.getDepId());
        return depVo;
    }

}
