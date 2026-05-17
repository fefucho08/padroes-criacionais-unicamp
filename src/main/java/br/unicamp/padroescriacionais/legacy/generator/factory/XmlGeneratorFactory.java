package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.XmlRelatorioGenerator;

public class XmlGeneratorFactory implements RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new XmlRelatorioGenerator();
    }
}

