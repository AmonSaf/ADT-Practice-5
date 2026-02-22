package builder;

public class ReportStyle {

    private String backgroundColor;
    private String fontColor;
    private int fontSize;

    public ReportStyle(String bg, String font, int size) {
        this.backgroundColor = bg;
        this.fontColor = font;
        this.fontSize = size;
    }

    public String getBackgroundColor() { return backgroundColor; }
    public String getFontColor() { return fontColor; }
    public int getFontSize() { return fontSize; }
}