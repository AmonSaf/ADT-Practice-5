package builder;

import java.util.*;

public class Report {

    private String header;
    private String content;
    private String footer;
    private Map<String, String> sections = new LinkedHashMap<>();
    private ReportStyle style;

    public void setHeader(String header) { this.header = header; }
    public void setContent(String content) { this.content = content; }
    public void setFooter(String footer) { this.footer = footer; }
    public void setStyle(ReportStyle style) { this.style = style; }

    public void addSection(String name, String content) {
        sections.put(name, content);
    }

    public String exportText() {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n\n");
        sb.append(content).append("\n");

        for (Map.Entry<String, String> s : sections.entrySet()) {
            sb.append("\n== ").append(s.getKey()).append(" ==\n");
            sb.append(s.getValue()).append("\n");
        }

        sb.append("\n").append(footer);
        return sb.toString();
    }

    public void exportToFile(String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            writer.write(exportText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}