package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"pt-BR\">\n");
        sb.append("<head>\n");
        sb.append(" <meta charset=\"UTF-8\">\n");
        sb.append(" <title>").append(relatorio.getTitulo()).append("</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append(" <h1>").append(relatorio.getTitulo()).append("</h1>\n");
        sb.append(" <p><strong>Tipo:</strong> ").append(relatorio.getTipo().name()).append("</p>\n");
        sb.append(" <p><strong>Gerado em:</strong> ").append(relatorio.getDataGeracao()).append("</p>\n");
        sb.append(" <hr>\n");
        sb.append(" <pre>\n").append(relatorio.getConteudo()).append("\n    </pre>\n");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
