package sy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user",schema="sshe",uniqueConstraints=@UniqueConstraint(columnNames="USERNAME"))
public class User {
    private Integer id;

    private String username;

    private String password;

    private Date createdTime;

    private Date updatedTime;

    @Id
    @Column(name="ID",unique=true,nullable=false,length=11)
    @GeneratedValue(strategy=GenerationType.IDENTITY)//自增
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="USERNAME",unique=true,nullable=false,length=45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Column(name="PASSWORD",nullable=false,length=500)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CREATED_TIME",length=7)
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="UPDATED_TIME",length=7)
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}