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

    public Reslut delectDep(Department department) {
        int i = depMapper.delectDepById(department.getDepId());
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }

    public Reslut addDep(Department department) {
        Department department1 = depMapper.selectDepById(department.getDepId());
        if (department1 != null){
            return Reslut.error("编号已存在");
        }
        int i = depMapper.addDep(department);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("添加失败");
    }

    public Reslut updateDep(Department department) {
        Department department1 = depMapper.selectDepById(department.getDepId());
        if (department1 != null){
            return Reslut.error("编号已存在");
        }
        int i = depMapper.updateDep(department);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("修改失败");
    }

    public Reslut getAdminAllDep() {
        return Reslut.succeed(depMapper.selectAllDep());
    }
}
