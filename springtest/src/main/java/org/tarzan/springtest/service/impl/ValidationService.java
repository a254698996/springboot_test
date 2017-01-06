package org.tarzan.springtest.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.tarzan.springtest.model.ValidationModel;
import org.tarzan.springtest.service.IValidationService;

@Service
public class ValidationService implements IValidationService {

	final static String finalAccessToken = "9995564";

	public ValidationModel verifyAccessToken(String accessToken) {

		if (StringUtils.isBlank(accessToken)) {
			return null;
		}

		String userId = parseToken(accessToken);

		if (StringUtils.isNoneBlank(userId)) {
			return new ValidationModel(userId);
		}
		return null;
	}

	// TODO 从accessToken 里解析出 userId
	private String parseToken(String accessToken) {

		return "151";
	}
}
