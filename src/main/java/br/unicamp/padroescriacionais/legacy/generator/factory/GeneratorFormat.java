package br.unicamp.padroescriacionais.legacy.generator.factory;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;

public class GeneratorFormat{

    public static RelatorioGeneratorFactory getFactory(FormatoRelatorio formato) {
        switch(formato) {
            case PDF -> {
                return new PdfGeneratorFactory();
            }
            case CSV -> {
                return new CsvGeneratorFactory();
            }
            case JSON -> {
                return new JsonGeneratorFactory();
            }
            case HTML -> {
                return new HtmlGeneratorFactory();
            }
            case XML -> {
                return new XmlGeneratorFactory();
            }
            default -> throw new IllegalArgumentException("Formato de relatorio desconhecido: " + formato);
        }
    }
}
