package builder;

public class HtmlReportBuilder implements IReportBuilder {

    private Report report = new Report();

    public void setHeader(String header) { report.setHeader("<h1>" + header + "</h1>"); }
    public void setContent(String content) { report.setContent("<p>" + content + "</p>"); }
    public void setFooter(String footer) { report.setFooter("<footer>" + footer + "</footer>"); }
    public void addSection(String name, String content) { report.addSection("<h2>" + name + "</h2>", "<p>" + content + "</p>"); }
    public void setStyle(ReportStyle style) { report.setStyle(style); }
    public Report getReport() { return report; }
}