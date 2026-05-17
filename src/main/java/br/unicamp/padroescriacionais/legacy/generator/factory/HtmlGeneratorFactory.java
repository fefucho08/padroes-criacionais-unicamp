package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.generator.HtmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class HtmlGeneratorFactory implements RelatorioGeneratorFactory {
    
    @Override
    public RelatorioGenerator criarGenerator() {
        return new HtmlRelatorioGenerator();
    }
}
