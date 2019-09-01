package DTO;

import java.util.Date;

public class Member {
    private int id;
    private String name;
    private String email;
    private String password;
    private int actived;
    private Date createAt;
    private Date updateAt;

    public Member() {
    }

    public Member(String name, String email, String password, int actived, Date createAt, Date updateAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.actived = actived;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Member(int id, String name, String email, String password, int actived, Date createAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.actived = actived;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActived() {
        return actived;
    }

    public void setActived(int actived) {
        this.actived = actived;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
