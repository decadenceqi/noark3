/*
 * Copyright © 2018 www.noark.xyz All Rights Reserved.
 * 
 * 感谢您选择Noark框架，希望我们的努力能为您提供一个简单、易用、稳定的服务器端框架 ！
 * 除非符合Noark许可协议，否则不得使用该文件，您可以下载许可协议文件：
 * 
 * 		http://www.noark.xyz/LICENSE
 *
 * 1.未经许可，任何公司及个人不得以任何方式或理由对本框架进行修改、使用和传播;
 * 2.禁止在本项目或任何子项目的基础上发展任何派生版本、修改版本或第三方版本;
 * 3.无论你对源代码做出任何修改和改进，版权都归Noark研发团队所有，我们保留所有权利;
 * 4.凡侵犯Noark版权等知识产权的，必依法追究其法律责任，特此郑重法律声明！
 */
package xyz.noark.network;

/**
 * 网络相关配置常量类.
 *
 * @since 3.0
 * @author 小流氓(176543888@qq.com)
 */
public class NetworkConstant {
	/** Netty监听端口 */
	public static final String PORT = "network.port";
	/** 心跳功能，默认值为0，则不生效 */
	public static final String HEARTBEAT = "network.heartbeat";
	/** Netty的Work线程数 */
	public static final String WORK_THREADS = "network.work.threads";
	/** 是否为WebSocket */
	public static final String WEBSOCKET_PATH = "network.websocket.path";
	/** 网络封包日志激活 */
	public static final String LOG_ACTIVE = "network.log.active";

	/** 向内部提供HTTP服务的端口 */
	public static final String HTTP_PORT = "network.http.port";
	/** 向内部提供HTTP服务的密钥 */
	public static final String HTTP_SECRET_KEY = "network.http.secret.key";

	private static final int CPU_MIN_COUNT = 4;
	private static final int CPU_MAX_COUNT = 8;
	public static final int DEFAULT_EVENT_LOOP_THREADS;
	static {
		int count = Runtime.getRuntime().availableProcessors();
		if (count <= CPU_MIN_COUNT) {
			DEFAULT_EVENT_LOOP_THREADS = count * 2;
		} else if (count <= CPU_MAX_COUNT) {
			DEFAULT_EVENT_LOOP_THREADS = count + 4;
		} else {
			DEFAULT_EVENT_LOOP_THREADS = 12;
		}
	}
}