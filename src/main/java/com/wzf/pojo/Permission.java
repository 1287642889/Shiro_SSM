package com.wzf.pojo;

public class Permission {

    private Integer id;
    private String permissionName; //权限标识 程序中判断使用,如"user:create"
    private String description; //权限描述,UI界面显示使用
    private Boolean available = Boolean.TRUE; //是否可用,如果不可用将不会添加给用户

    public Permission() {
    }

    public Permission(String permissionName, String description, Boolean available) {
        this.permissionName = permissionName;
        this.description = description;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}