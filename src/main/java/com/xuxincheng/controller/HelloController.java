package com.xuxincheng.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuxincheng.bean.Student;
import com.xuxincheng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value = "ApiController",tags = "api测试入口入口")
@RestController
public class HelloController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/index", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(){
        return "gssdgsd";
    }

    @RequestMapping(value = "/getcount", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public String getcount(){
        return studentService.getAllStudent()+"";
    }

    @RequestMapping(value = "/setredis", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public Student setredis(){
        Student student = new Student();
        student.setAddress("地址");
        student.setName("徐新城");
        student.setUuid("01");
        //set操作
        redisTemplate.opsForValue().set("student01",JSON.toJSONString(student));
        return JSON.parseObject(redisTemplate.opsForValue().get("student01"),Student.class);
    }

    @ApiOperation(value = "获取列表方法",tags = "api列表入口")
    @RequestMapping(value = "/getlist", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> getlist(){
        Map<String, Object> responseMap = new HashMap<>();
        //设置分页  得到page实体
        Page page = PageHelper.startPage(1,10);
        //执行分页后数据
        List<Student> students =  studentService.getAllStudentList();
        //获取总条数
        String count = page.getTotal()+"";
        responseMap.put("rows", students);
        responseMap.put("total", count);
        return  responseMap;
    }

    @RequestMapping(value = "/addStudent", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public String addStudent(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "sex") String sex,
            @RequestParam(name = "phone") String phone
    ){
        Student student = new Student();
        student.setSex(Integer.valueOf(sex));
        student.setName(name);
        student.setPhone(phone);
        student.setMeetphone("");
        student.setStatus(0);
        int seconds = (int)(System.currentTimeMillis() / 1000);
        student.setCreatetime(seconds);
        student.setIstrainexp(0);
        student.setUuid(UUID.randomUUID().toString());
        return studentService.addStudent(student)+"";
    }
}
