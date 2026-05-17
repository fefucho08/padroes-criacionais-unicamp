package br.unicamp.padroescriacionais.legacy.domain;

import br.unicamp.padroescriacionais.legacy.generator.factory.CsvGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.factory.HtmlGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.factory.JsonGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.factory.PdfGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.factory.XmlGeneratorFactory;

public enum FormatoRelatorio {
    PDF(new PdfGeneratorFactory()),
    CSV(new CsvGeneratorFactory()),
    JSON(new JsonGeneratorFactory()),
    HTML(new HtmlGeneratorFactory()),
    XML(new XmlGeneratorFactory());

    private final RelatorioGeneratorFactory generatorFactory;

    private FormatoRelatorio(RelatorioGeneratorFactory generatorFactory) {
        this.generatorFactory = generatorFactory;
    }

    public RelatorioGeneratorFactory getFactory() {
        return generatorFactory;
    }
}
