/*
 * Welcome to use the TableGo Tools.
 *
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 *
 * Author:bianj
 * Email:edinsker@163.com
 * Version:4.1.2
 */

/*
 * Author:lynk
 * Email:kunloz520@163.com
 * Version:1.0.0
 */


package com.xuxincheng.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author:lynk
 * Email:kunloz520@163.com
 * Version:1.0.0
 */
@Entity
@Table(name = "zykj_test")
public class TestEntity implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1179275499916703464L;

    /**  */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 10)
    private Integer id;

    /**  */
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    /**  */
    @Column(name = "password", unique = true, nullable = false, length = 64)
    private String password;

    /**
     * 获取
     *
     * @return
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}