package com.example.easylogin.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*自動生成されたUserクラスを開き、下記2つのアノテーション追加・コンパイルエラーを修正。*/
@Entity
@Table(name="user")
public class User {
/*４つフィールドを追加したが、MySQLで作成したuserテーブルが持つそれぞれのカラムを表す。*/
    
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)/* strategy=GenerationType.IDENTITYは自動的に採番されるAUTO_INCREMENTなIDとして設定。*/
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String fullName;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName){
	    this.userName = userName;
	}
	
	public String getPassword() {
	    return password; 
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
