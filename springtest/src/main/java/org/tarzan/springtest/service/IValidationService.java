package org.tarzan.springtest.service;

import org.tarzan.springtest.model.ValidationModel;

public interface IValidationService {
	public ValidationModel verifyAccessToken(String accessToken);
}
