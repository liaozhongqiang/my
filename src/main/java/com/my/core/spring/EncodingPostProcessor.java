package com.my.core.spring;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;


/**
 * 处理 @Responsebody 的ISO-8859-1
 * 
 * @author liaozq
 * @DATE 2015年11月20日
 */
@Component
public class EncodingPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof RequestMappingHandlerAdapter) {
			List<HttpMessageConverter<?>> convs = ((RequestMappingHandlerAdapter) bean).getMessageConverters();
			for (HttpMessageConverter<?> conv : convs) {
				if (conv instanceof StringHttpMessageConverter) {
					//((StringHttpMessageConverter) conv).setSupportedMediaTypes(
						//	Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8")), MediaType.ALL));
					System.out.println("111");
				}

				if (conv instanceof MappingJackson2HttpMessageConverter) {
					((MappingJackson2HttpMessageConverter) conv).setObjectMapper(
							Jackson2ObjectMapperBuilder.json().simpleDateFormat("yyyy-MM-dd HH:mm:ss").build());
				}
			}
		}

		if (bean instanceof ExceptionHandlerExceptionResolver) {
			List<HttpMessageConverter<?>> convs = ((ExceptionHandlerExceptionResolver) bean).getMessageConverters();
			for (HttpMessageConverter<?> conv : convs) {
				if (conv instanceof StringHttpMessageConverter) {
					((StringHttpMessageConverter) conv).setSupportedMediaTypes(
							Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8")), MediaType.ALL));
				}
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
