package br.unicamp.padroescriacionais.legacy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.HtmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.XmlRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.factory.RelatorioGeneratorFactory;

class FactoryMethodTest {

    @Test
    void formatosDevemCriarFactoriesEGeradoresCorretos() {
        Map<FormatoRelatorio, Class<? extends RelatorioGenerator>> esperado = new HashMap<>();
        esperado.put(FormatoRelatorio.PDF, PdfRelatorioGenerator.class);
        esperado.put(FormatoRelatorio.CSV, CsvRelatorioGenerator.class);
        esperado.put(FormatoRelatorio.JSON, JsonRelatorioGenerator.class);
        esperado.put(FormatoRelatorio.HTML, HtmlRelatorioGenerator.class);
        esperado.put(FormatoRelatorio.XML, XmlRelatorioGenerator.class);

        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            Class<? extends RelatorioGenerator> classeEsperada = esperado.get(formato);
            assertNotNull(classeEsperada, "Formato nao mapeado no teste: " + formato);

            RelatorioGeneratorFactory factoryEnum = formato.getFactory();
            assertNotNull(factoryEnum, "Factory via enum deve ser nao nula para: " + formato);
            RelatorioGenerator gerador = factoryEnum.criarGenerator();
            assertNotNull(gerador, "Gerador criado pela factory do enum nao deve ser nulo");
            assertEquals(classeEsperada, gerador.getClass(), "Tipo de gerador inesperado para formato: " + formato);
        }
    }
}
