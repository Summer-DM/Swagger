package com.summer.swagger2_demo.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 *@program: swagger2-demo
 *  * @description: 用户测试类
 *  * @author: Summer-DM
 *  * @create: 2020年08月26日
 *
 *  用到注解说明：
 *     @ApiModel：用于类 ；表示对类进行说明，用于参数用实体类接收
 *              value–表示对象名
 *              description–描述
 *              都可省略
 *     @ApiModelProperty：用于方法，字段； 表示对model属性的说明或者数据操作更改
 *              value–字段说明
 *              name–重写属性名字
 *              dataType–重写属性类型
 *              required–是否必填
 *              example–举例说明
 *              hidden–隐藏
 *              都可省略
 */

//@ApiModel("用户信息类")
@ApiModel(value="user对象",description="用户对象user类")
public class User  implements Serializable{
    @ApiModelProperty(value="用户id",name="id",example="100",required=true)
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private String age;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("地址")
    private String addr;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("身份证")
    private String idCard;
    @ApiModelProperty("健康")
    private String health;

    public User() {
    }

    public User(Long id, String name, String age, String sex, String addr) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }
}