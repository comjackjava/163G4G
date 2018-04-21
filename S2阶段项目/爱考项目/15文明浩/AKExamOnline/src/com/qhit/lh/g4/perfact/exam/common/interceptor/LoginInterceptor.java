/**
 * 
 */
package com.qhit.lh.g4.perfact.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.g4.perfact.exam.common.bean.Users;
import com.qhit.lh.g4.perfact.exam.common.utils.Constans;

/**
 * @author 万曦晖
 *TODO
 *2018年1月3日下午3:54:57
 */
public class LoginInterceptor extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("登录校验拦截器执行");
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null) {
			return Constans.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
