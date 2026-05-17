package br.unicamp.padroescriacionais.legacy;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoGlobal;
import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;

class ConfiguracaoGlobalTest {

    @AfterEach
    void tearDown() {
        ConfiguracaoGlobal.getInstancia().setConfiguracao(null);
    }

    @Test
    void instanciaDeveSerSingleton() {
        ConfiguracaoGlobal a = ConfiguracaoGlobal.getInstancia();
        ConfiguracaoGlobal b = ConfiguracaoGlobal.getInstancia();

        assertSame(a, b, "getInstancia deve retornar a mesma instancia (singleton)");
    }

    @Test
    void setConfiguracaoDeveSerVisivelGlobalmente() {
        ConfiguracaoSistema config = new ConfiguracaoSistema("EmpresaX", "DEV", "/tmp/x", true);
        ConfiguracaoGlobal.getInstancia().setConfiguracao(config);

        ConfiguracaoSistema obtida = ConfiguracaoGlobal.getInstancia().getConfiguracao();
        assertNotNull(obtida);
        assertEquals("EmpresaX", obtida.getNomeEmpresa());
        assertTrue(obtida.isDebugAtivo());
        assertEquals(config, obtida, "Referencia armazenada deve ser a mesma instancia passada");
    }
}
