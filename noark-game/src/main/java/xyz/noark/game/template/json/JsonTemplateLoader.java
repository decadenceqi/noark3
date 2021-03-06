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
package xyz.noark.game.template.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.alibaba.fastjson.JSON;

import xyz.noark.core.annotation.tpl.TplFile;
import xyz.noark.core.exception.TplConfigurationException;
import xyz.noark.core.util.CharsetUtils;
import xyz.noark.game.template.AbstractTemplateLoader;

/**
 * JSON格式的模板加载类.
 *
 * @since 3.2
 * @author 小流氓(176543888@qq.com)
 */
public class JsonTemplateLoader extends AbstractTemplateLoader {

	public JsonTemplateLoader(String templatePath) {
		super(templatePath);
	}

	public JsonTemplateLoader(String templatePath, String zone) {
		super(templatePath, zone);
	}

	@Override
	public <T> List<T> loadAll(Class<T> klass) {
		TplFile file = klass.getAnnotation(TplFile.class);
		if (file == null) {
			throw new TplConfigurationException("这不是JSON格式的配置文件类:" + klass.getName());
		}

		try {
			byte[] bytes = Files.readAllBytes(Paths.get(templatePath, zone, file.value()));
			return JSON.parseArray(new String(bytes, CharsetUtils.CHARSET_UTF_8), klass);
		} catch (IOException e) {
			throw new TplConfigurationException("JSON格式的配置文件类:" + klass.getName(), e);
		}
	}

	/**
	 * 加载模板数据.
	 * 
	 * <pre>
	 * ItemTemplate template = templateLoader.load(ItemTemplate.class);<br>
	 * </pre>
	 * 
	 * @param <T> 加载模板类类型
	 * @param klass 模板类.
	 * @return 模板数据
	 */
	public <T> T load(Class<T> klass) {
		TplFile file = klass.getAnnotation(TplFile.class);
		if (file == null) {
			throw new TplConfigurationException("这不是JSON格式的配置文件类:" + klass.getName());
		}

		try {
			return JSON.parseObject(Files.readAllBytes(Paths.get(templatePath, zone, file.value())), klass);
		} catch (IOException e) {
			throw new TplConfigurationException("JSON格式的配置文件类:" + klass.getName(), e);
		}
	}
}