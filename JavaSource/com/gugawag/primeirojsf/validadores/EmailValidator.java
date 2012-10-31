package com.gugawag.primeirojsf.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ValidEmail")
public class EmailValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		if (value == null){
			return;
		}
		
		String email = (String) value;
		if (!email.contains("@") || !email.contains(".") || email.endsWith(".") || email.endsWith("@")){
			FacesMessage mensagem = new FacesMessage("email inv‡álido. Faltando @ e/ou .");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensagem);
		}
		
	}

}
