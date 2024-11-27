package com.chenxianyu.controller;

import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 允许跨域请求
@CrossOrigin
@RestController
@RequestMapping("/dep") // 定义控制器的基础 URL 路径
public class DepController {

    @Autowired
    private DepService depService; // 注入部门服务类，用于处理业务逻辑

    /**
     * 处理 GET 请求，获取所有部门的信息。
     *
     * @return 返回一个 Reslut 对象，包含所有部门信息的结果。
     */
    @GetMapping("/getDep") // 映射 GET 请求到 "/dep/getDep" 路径
    public Reslut geyDep() {
        // 调用服务层的方法，获取所有部门信息并返回结果
        return depService.getAllDep();
    }

    /**
     * 处理 POST 请求，删除指定部门。
     *
     * @param department 包含要删除的部门信息的 Department 对象。
     * @return 返回一个 Reslut 对象，指示删除操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/deleteDep") // 映射 POST 请求到 "/dep/deleteDep" 路径（注意：修正拼写错误）
    public Reslut deleteDep(@RequestBody Department department) {
        // 调用服务层的方法，删除部门并返回结果
        return depService.delectDep(department);
    }

    /**
     * 处理 POST 请求，以添加新部门。
     *
     * @param department 包含新部门信息的 Department 对象。
     * @return 返回一个 Reslut 对象，指示添加操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/addDep") // 映射 POST 请求到 "/dep/addDep" 路径
    public Reslut addDep(@RequestBody Department department) {
        // 调用服务层的方法，添加新部门并返回结果
        return depService.addDep(department);
    }

    /**
     * 处理 POST 请求，以更新指定部门的信息。
     *
     * @param department 包含更新后的部门信息的 Department 对象。
     * @return 返回一个 Reslut 对象，指示更新操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/updateDep") // 映射 POST 请求到 "/dep/updateDep" 路径
    public Reslut updateDep(@RequestBody Department department) {
        // 调用服务层的方法，更新部门信息并返回结果
        return depService.updateDep(department);
    }

    /**
     * 处理 POST 请求，获取管理员的所有部门信息。
     *
     * @return 返回一个 Reslut 对象，包含所有部门的信息和相关状态。
     */
    @PostMapping("/getAllDep") // 映射 POST 请求到 "/dep/getAllDep" 路径
    public Reslut getAllDep() {
        // 调用服务层的方法，获取所有部门信息并返回结果
        return depService.getAdminAllDep();
    }
}