package com.taotao.sso.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="tb_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Length(min=6,max=20,message="用户名的长度必须是6~20.")
	private String username;

    @JsonIgnore//将对象序列号json字符串时忽略该字段
    @Length(min=6,max=20,message="密码的长度必须是6~20.")
    private String password;

    @Length(min=11,max=11,message="手机号长度必须是11.")
    private String phone;
    
    @Email(message="邮箱的格式不符合规则！")
    private String email;
    
    private Date created;
    
    private Date updated;
    
  
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", created=" + created + ", updated=" + updated + "]";
	}


	

}
