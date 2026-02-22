package builder;

public class ReportDirector {

    public void constructReport(IReportBuilder builder, ReportStyle style) {
        builder.setHeader("Sales Report");
        builder.setContent("Main report content");
        builder.addSection("Q1", "Sales data Q1");
        builder.addSection("Q2", "Sales data Q2");
        builder.setFooter("End of Report");
        builder.setStyle(style);
    }
}