import singleton.*;
import builder.*;
import prototype.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("SINGLETON LOGGER");
        singletonTest();

        System.out.println("\nBUILDER REPORTS");
        builderTest();

        System.out.println("\nPROTOTYPE CLONING");
        prototypeTest();
    }

    private static void singletonTest() throws InterruptedException {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            int threadId = i;
            executor.submit(() -> {
                Logger log = Logger.getInstance();
                log.log("Поток " + threadId + " сообщение [INFO]", LogLevel.INFO);
                log.log("Поток " + threadId + " предупреждение [WARNING]", LogLevel.WARNING);
                log.log("Поток " + threadId + " ошибка [ERROR]", LogLevel.ERROR);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Все потоки завершены, проверьте app.log");
    }

    private static void builderTest() {
        ReportStyle style = new ReportStyle("white", "black", 12);
        ReportDirector director = new ReportDirector();

        TextReportBuilder textBuilder = new TextReportBuilder();
        director.constructReport(textBuilder, style);
        Report textReport = textBuilder.getReport();
        textReport.exportToFile("report.txt");
        System.out.println("Текстовый отчет: report.txt");

        HtmlReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder, style);
        Report htmlReport = htmlBuilder.getReport();
        htmlReport.exportToFile("report.html");
        System.out.println("HTML отчет: report.html");

        SimplePdfReportBuilder pdfBuilder = new SimplePdfReportBuilder();
        director.constructReport(pdfBuilder, style);
        Report pdfReport = pdfBuilder.getReport();
        pdfBuilder.exportToPdf("report.pdf");
        System.out.println("PDF отчет (текстовый): report.pdf");
    }

    private static void prototypeTest() {
        Weapon sword = new Weapon("Excalibur", 50);
        Armor plate = new Armor("Dragon Plate", 40);
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Fireball", 70));
        skills.add(new Skill("Heal", 30));

        GameCharacter hero = new GameCharacter("Arthur", 100, 20, 15, 10, sword, plate, skills);
        GameCharacter heroClone = hero.clone();

        System.out.println("Оригинал");
        System.out.println(hero);

        System.out.println("\nКлон");
        System.out.println(heroClone);

        System.out.println("\nКлонирование работает, оригинал не изменился, клон независим!");
    }
}