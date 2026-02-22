package builder;

public class TextReportBuilder implements IReportBuilder {

    private Report report = new Report();

    public void setHeader(String header) { report.setHeader(header); }
    public void setContent(String content) { report.setContent(content); }
    public void setFooter(String footer) { report.setFooter(footer); }
    public void addSection(String name, String content) { report.addSection(name, content); }
    public void setStyle(ReportStyle style) { report.setStyle(style); }
    public Report getReport() { return report; }
}