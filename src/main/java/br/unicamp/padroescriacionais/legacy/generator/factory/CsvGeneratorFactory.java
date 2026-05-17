package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class CsvGeneratorFactory implements RelatorioGeneratorFactory{
    @Override
    public RelatorioGenerator criarGenerator() {
        return new CsvRelatorioGenerator();
    }
}
