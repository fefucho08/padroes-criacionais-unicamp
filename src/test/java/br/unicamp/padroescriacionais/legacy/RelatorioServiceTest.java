package br.unicamp.padroescriacionais.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.domain.TipoRelatorio;
import br.unicamp.padroescriacionais.legacy.service.RelatorioService;

class RelatorioServiceTest {

    private RelatorioService service;

    @BeforeEach
    void setUp() {
        service = new RelatorioService();
    }

    @Test
    void deveCriarRelatorioDeVendas() {
        Relatorio relatorio = service.criarRelatorio(TipoRelatorio.VENDAS);

        assertNotNull(relatorio);
        assertEquals(TipoRelatorio.VENDAS, relatorio.getTipo());
        assertNotNull(relatorio.getTitulo());
        assertFalse(relatorio.getTitulo().isBlank());
        assertNotNull(relatorio.getConteudo());
        assertFalse(relatorio.getConteudo().isBlank());
        assertNotNull(relatorio.getDataGeracao());
    }

    @Test
    void deveCriarRelatorioDeEstoque() {
        Relatorio relatorio = service.criarRelatorio(TipoRelatorio.ESTOQUE);

        assertNotNull(relatorio);
        assertEquals(TipoRelatorio.ESTOQUE, relatorio.getTipo());
        assertFalse(relatorio.getTitulo().isBlank());
    }

    @Test
    void deveCriarRelatorioDeClientes() {
        Relatorio relatorio = service.criarRelatorio(TipoRelatorio.CLIENTES);

        assertNotNull(relatorio);
        assertEquals(TipoRelatorio.CLIENTES, relatorio.getTipo());
        assertFalse(relatorio.getTitulo().isBlank());
    }

    @Test
    void todosTiposDevemProduizirRelatorioValido() {
        for (TipoRelatorio tipo : TipoRelatorio.values()) {
            Relatorio relatorio = service.criarRelatorio(tipo);
            assertNotNull(relatorio, "Relatorio nulo para tipo: " + tipo);
            assertFalse(relatorio.getTitulo().isBlank(), "Titulo vazio para tipo: " + tipo);
            assertFalse(relatorio.getConteudo().isBlank(), "Conteudo vazio para tipo: " + tipo);
        }
    }

    @Test
    void deveGerarConteudoPdfNaoVazio() {
        String resultado = service.gerarRelatorio(TipoRelatorio.VENDAS, FormatoRelatorio.PDF);

        assertNotNull(resultado);
        assertFalse(resultado.isBlank());
        assertTrue(resultado.contains("PDF"), "Saida PDF deve conter a palavra PDF");
    }

    @Test
    void deveGerarConteudoCsvComVirgulas() {
        String resultado = service.gerarRelatorio(TipoRelatorio.ESTOQUE, FormatoRelatorio.CSV);

        assertNotNull(resultado);
        assertFalse(resultado.isBlank());
        assertTrue(resultado.contains(","), "Saida CSV deve conter virgulas");
    }

    @Test
    void deveGerarConteudoJsonComChaves() {
        String resultado = service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.JSON);

        assertNotNull(resultado);
        assertFalse(resultado.isBlank());
        assertTrue(resultado.contains("{"), "Saida JSON deve conter '{'");
        assertTrue(resultado.contains("}"), "Saida JSON deve conter '}'");
    }

    @Test
    void deveGerarConteudoHtmlComTags() {
        String resultado = service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.HTML);

        assertNotNull(resultado);
        assertFalse(resultado.isBlank());
        assertTrue(resultado.contains("<"), "Saida HTML deve conter '<'");
        assertTrue(resultado.contains(">"), "Saida HTML deve conter '>'");
    }

    @Test
    void deveGerarConteudoXmlComData() {
        String resultado = service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.XML);

        assertNotNull(resultado);
        assertFalse(resultado.isBlank());
        assertTrue(resultado.contains("CDATA"), "Saida XML deve conter 'CDATA'");
    }

    @Test
    void todosFormatosDevemProduizirConteudoValido() {
        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            String resultado = service.gerarRelatorio(TipoRelatorio.VENDAS, formato);
            assertNotNull(resultado, "Resultado nulo para formato: " + formato);
            assertFalse(resultado.isBlank(), "Resultado vazio para formato: " + formato);
        }
    }

    @Test
    void conteudoDeveConterTituloDoRelatorio() {
        String resultado = service.gerarRelatorio(TipoRelatorio.VENDAS, FormatoRelatorio.PDF);
        assertTrue(resultado.contains("Vendas"), "Saida PDF deve mencionar o titulo do relatorio");
    }
}
