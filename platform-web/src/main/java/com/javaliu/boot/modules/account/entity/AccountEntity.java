package com.javaliu.boot.modules.account.entity;

import com.javaliu.boot.base.entity.BaseEntity;

public class AccountEntity extends BaseEntity {

      private String code;
      private String email;
      private String nickName;
      private String password;
      private String salt;
      private String headImage;
      private int status;

      public String getCode() {
            return code;
      }

      public void setCode(String code) {
            this.code = code;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public String getNickName() {
            return nickName;
      }

      public void setNickName(String nickName) {
            this.nickName = nickName;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getSalt() {
            return salt;
      }

      public void setSalt(String salt) {
            this.salt = salt;
      }

      public String getHeadImage() {
            return headImage;
      }

      public void setHeadImage(String headImage) {
            this.headImage = headImage;
      }

      public int getStatus() {
            return status;
      }

      public void setStatus(int status) {
            this.status = status;
      }
}
