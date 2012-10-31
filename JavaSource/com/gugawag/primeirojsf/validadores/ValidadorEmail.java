package com.gugawag.primeirojsf.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ValidadorEmail")
public class ValidadorEmail implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor)
			throws ValidatorException {
		
		if (valor == null){
			return;
		}
		
		String email = (String) valor;
		
		if (!email.contains("@") || !email.contains(".")){
			FacesMessage mErro = new FacesMessage("Email não contém @ e/ou .");
			mErro.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mErro);
		}
		
		
	}

}
