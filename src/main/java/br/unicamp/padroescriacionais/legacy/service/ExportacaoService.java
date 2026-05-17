package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoGlobal;
import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.factory.RelatorioGeneratorFactory;

public class ExportacaoService {

    private ConfiguracaoSistema configuracao;
    
    public ExportacaoService() {
    	ConfiguracaoSistema configuracaoLocal = new ConfiguracaoSistema(
    			"Empresa XPTO Ltda.",
    			"PROD",
    			"/var/exports/relatorios",
    			false
    			);
    	
    	ConfiguracaoGlobal.getInstancia().setConfiguracao(configuracaoLocal);
    	this.configuracao = ConfiguracaoGlobal.getInstancia().getConfiguracao();
    }
    
    public void exportar(Relatorio relatorio, FormatoRelatorio formato) {
        RelatorioGeneratorFactory factory = formato.getFactory();
        RelatorioGenerator generator = factory.criarGenerator();
        String conteudoFormatado = generator.gerar(relatorio);

        String nomeArquivo = relatorio.getTitulo()
                .replace(" ", "_")
                .toLowerCase()
                + "." + formato.name().toLowerCase();

        String caminhoCompleto = configuracao.getDiretorioExportacao() + "/" + nomeArquivo;

        System.out.println("[EXPORTACAO] Empresa  : " + configuracao.getNomeEmpresa());
        System.out.println("[EXPORTACAO] Ambiente : " + configuracao.getAmbiente());
        System.out.println("[EXPORTACAO] Arquivo  : " + caminhoCompleto);
        System.out.println("[EXPORTACAO] Conteudo :");
        System.out.println(conteudoFormatado);
    }
}
