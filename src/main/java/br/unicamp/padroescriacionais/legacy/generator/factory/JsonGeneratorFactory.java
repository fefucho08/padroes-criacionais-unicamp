package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class JsonGeneratorFactory implements RelatorioGeneratorFactory {

    @Override
    public RelatorioGenerator criarGenerator() {
        return new JsonRelatorioGenerator();
    }
}
