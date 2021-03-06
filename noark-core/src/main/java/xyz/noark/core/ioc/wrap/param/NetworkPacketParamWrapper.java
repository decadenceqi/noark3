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
package xyz.noark.core.ioc.wrap.param;

import java.io.Serializable;

import xyz.noark.core.exception.UnrealizedException;
import xyz.noark.core.ioc.wrap.ParamWrapper;
import xyz.noark.core.network.NetworkPacket;
import xyz.noark.core.network.Session;

/**
 * NetworkPacket对象.
 *
 * @since 3.3.7
 * @author 小流氓(176543888@qq.com)
 */
public class NetworkPacketParamWrapper implements ParamWrapper {

	@Override
	public Object read(Session session, NetworkPacket packet) {
		return packet;
	}

	@Override
	public Object read(Serializable playerId, Object protocol) {
		throw new UnrealizedException("内部指令是不可以注入封包对象.");
	}
}