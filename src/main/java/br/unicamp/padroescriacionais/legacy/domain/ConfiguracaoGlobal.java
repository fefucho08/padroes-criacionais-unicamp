package br.unicamp.padroescriacionais.legacy.domain;

public class ConfiguracaoGlobal {
	
	private static ConfiguracaoGlobal instancia = new ConfiguracaoGlobal();
	
	private ConfiguracaoSistema configuracao;
	
	private ConfiguracaoGlobal() {
		
	}
	
	public static ConfiguracaoGlobal getInstancia() {
		return instancia;
	}
	
	public ConfiguracaoSistema getConfiguracao() {
		return configuracao;
	}
	
	public void setConfiguracao(ConfiguracaoSistema configuracao) {
		this.configuracao = configuracao;
	}
}
