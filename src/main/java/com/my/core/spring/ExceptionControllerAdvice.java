package com.my.core.spring;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public String processConversionExcetption(NativeWebRequest request, Exception ex) {
		logger.error("数据验证出错", ex);
		BindException bex = (BindException) ex;
		List<FieldError> errors = bex.getFieldErrors();
		StringBuilder sb = new StringBuilder();
		for (FieldError error : errors) {
			sb.append(error.getDefaultMessage());
		}
		return sb.toString();
	}

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public String processMyException(NativeWebRequest request, Exception ex) {
		return ExceptionUtils.getRootCauseMessage(ex)+"SB";
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String processRuntimeException(NativeWebRequest request, Exception ex) {
		return ExceptionUtils.getRootCauseMessage(ex);
	}

}
