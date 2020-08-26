package com.summer.swagger2_demo.web;


import com.summer.swagger2_demo.Model.User;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: swagger2-demo
 * @description: 用户测试类控制层
 * @author: Bacy
 * @create: 2018年04月24日
 *
 * 用到注解说明：
 *    @Api：用在请求的web类上；表示标识这个类是swagger的资源
 *         tags="如果设置这个值、value的值会被覆盖"
 *         value="url的路径值"
 *         description:对api资源的描述
 *         basePath：基本路径
 *         。。。
 *         还有很多注解，可以去官网查看
 *    @ApiOperation："用在请求的方法上，说明方法的作用"
 *          value="说明方法的作用"
 *          notes="方法的备注说明"
 *    @ApiImplicitParam：对单个参数的说明
 *           name：参数名
 *           value：参数的汉字说明、解释
 *           required：参数是否必须传
 *           paramType：参数放在哪个地方
 *               · header --> 请求参数的获取：@RequestHeader
 *               · query --> 请求参数的获取：@RequestParam
 *               · path（用于restful接口）--> 请求参数的获取：@PathVariable
 *               · body（请求体）-->  @RequestBody User user
 *               · form（普通表单提交）
 *           dataType：参数类型，默认String，其它值dataType="Integer"
 *           defaultValue：参数的默认值
 *    @ApiImplicitParams：用在请求的方法上，包含一组参数说明
 *    @ApiParam:用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
 *
 *    常用注解：https://www.cnblogs.com/niudaben/p/11869869.html
 **/

@Controller
@RequestMapping("/user")
@Api(value = "/user", description = "这是user的接口文档")
public class UserController {

    static Map<Long , User> map = new ConcurrentHashMap<>();

    /**
     * @Title: index
     * @Description:测试首页
     * @return
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ApiOperation(value = "测试", notes = "测试首页")
    public String index() {
        return "HelloWorld";
    }

    /**
     * @Title: getList
     * @Description:  获取用户列表
     * @Param: []
     * @return: java.util.List<com.example.swagger2demo.domain.User>
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> list = new ArrayList<>(map.values());
        return  list;
    }
    /**
     * @Title: postUser
     * @Description:  根据user创建用户
     * @Param: [user]
     * @return: java.lang.String
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @ApiOperation(value = "创建用户" , notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详情实体类",required = true,dataType = "User")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        map.put(user.getId(),user);
        return "新用户添加成功~~~";
    }
    /**
     * @Title: getUserById
     * @Description:  根据用户id获取用户基本信息
     * @Param: [id]
     * @return: com.example.swagger2demo.domain.User
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @ApiOperation(value = "获取用户详情",notes = "根据url的id来获取用户基本信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return  map.get(id);
    }

    /**
     * @Title: putUser
     * @Description:  根据用户id来指定更新对象，进行用户的信息更新
     * @Param: [id, user]
     * @return: java.lang.String
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @ApiOperation(value = "更新用户信息",notes = "根据url的id来指定对象，并且根据传过来的user进行用户基本信息更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详情实体类user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@RequestBody User user) {
        User u = map.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        map.put(id,u);

        return "用户基本信息已经更新成功~~~";

    }
    /**
     * @Title: delUser
     * @Description:  根据用户id，删除用户
     * @Param: [id]
     * @return: java.lang.String
     * @Author: Summer-DM
     * @Date: 2020/08/26
     */
    @ApiOperation(value = "删除用户",notes = "根据url的id来指定对象，进行用户信息删除")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delUser(@PathVariable Long id) {
        map.remove(id);
        return "用户ID为："+ id + " 的用户已经被移除系统~~";

    }
}
