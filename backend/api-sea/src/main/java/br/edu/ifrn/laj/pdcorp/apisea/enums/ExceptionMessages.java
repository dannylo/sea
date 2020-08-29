package br.edu.ifrn.laj.pdcorp.apisea.enums;

public enum ExceptionMessages {

	USER_EMAIL_EXISTS_DB("E-mail j� registrado no banco de dados, tente outro."),
	USER_DOESNT_EXISTS_DB("Usu�rio n�o encontrado para o e-mail informado."),
	CREDENTIALS_IS_WORNG("E-mail ou senha incorretos."),
	CREDENTIALS_REQUEST_FORBBIDEN("A requisi��o foi negada pela API por n�o ser autenticada."),
	USER_REQUEST_FORBBIDEN("A requisi��o n�o permitida para este usu�rio."),
	EVENT_DOESNT_EXISTS_DB("Evento n�o encontrado."),
	SUBSCRIPTION_DOESNT_EXISTS_DB("Inscri��o n�o encontrada."), 
	SUBSCRIPTION_ALREADY_EXISTS("Inscri��o j� existe.");
	
	private String description;
	
	private ExceptionMessages(String desciption) {
		this.description = desciption;
	}

	public String getDescription() {
		return description;
	}
	
}
