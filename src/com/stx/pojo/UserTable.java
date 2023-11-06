package com.stx.pojo;


import java.io.Serializable;

public class UserTable implements Serializable {

  private int userId;
  private String ukey;
  private String pwd;
  private String realname;
  private int userType;

  @Override
  public String toString() {
    return "UserTable{" +
            "userId=" + userId +
            ", ukey='" + ukey + '\'' +
            ", pwd='" + pwd + '\'' +
            ", realname='" + realname + '\'' +
            ", userType=" + userType +
            '}';
  }

  public UserTable() {
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUkey() {
    return ukey;
  }

  public void setUkey(String ukey) {
    this.ukey = ukey;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public UserTable(int userId, String ukey, String pwd, String realname, int userType) {
    this.userId = userId;
    this.ukey = ukey;
    this.pwd = pwd;
    this.realname = realname;
    this.userType = userType;
  }
}
