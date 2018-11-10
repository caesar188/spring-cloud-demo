/**
 * All rights Reserved, Designed By MiGu
 * Copyright: Copyright(C) 2016-2020
 * Company MiGu Co., Ltd.
 */
package com.migu.zuul;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 入口类
 * 项目名称: Rainbow Stone for cartoon
 * 包: com.migu.gateway
 * 类名称: ZuulServerApp.java
 * 类描述: 本类是封装层入口类
 * 创建人: wangxiaowei
 * 创建时间: 2017/10/19 15:46
 */

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApp {
	/**
	 * 入口函数
	 *
	 * @param args 入参.
	 */
	public static void main(final String[] args) {
		new SpringApplicationBuilder(ZuulApp.class).web(true).run(args);
	}

}
