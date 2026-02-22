package builder;

public class SimplePdfReportBuilder implements IReportBuilder {

    private Report report = new Report();

    public void setHeader(String header) { report.setHeader(header); }
    public void setContent(String content) { report.setContent(content); }
    public void setFooter(String footer) { report.setFooter(footer); }
    public void addSection(String name, String content) { report.addSection(name, content); }
    public void setStyle(ReportStyle style) { report.setStyle(style); }
    public Report getReport() { return report; }

    // Экспортируем в файл с расширением .pdf (на самом деле обычный текст)
    public void exportToPdf(String filename) {
        if (!filename.endsWith(".pdf")) filename += ".pdf";
        report.exportToFile(filename);
    }
}