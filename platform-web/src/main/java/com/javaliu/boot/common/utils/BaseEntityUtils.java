package com.javaliu.boot.common.utils;

import com.javaliu.boot.base.entity.BaseEntity;
import com.javaliu.boot.common.context.ThreadContext;
import com.javaliu.boot.modules.account.entity.AccountEntity;

import java.util.Date;

public class BaseEntityUtils {

	public static void setBaseParam(BaseEntity entity) {
		AccountEntity account = ThreadContext.getThreadInstance().getAccountEntity();
		entity.setCreateBy(account.getId());
		Date date = new Date();
		entity.setCreateDateTime(date);
		entity.setUpdateBy(account.getId());
		entity.setUpdateDateTime(date);
	}

	public static void setUpdateBaseParam(BaseEntity entity) {
		AccountEntity account = ThreadContext.getThreadInstance().getAccountEntity();
		Date date = new Date();
		entity.setUpdateBy(account.getId());
		entity.setUpdateDateTime(date);
	}
}
