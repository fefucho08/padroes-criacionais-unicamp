package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class PdfGeneratorFactory implements RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new PdfRelatorioGenerator();
    }
    
}
