public class NameReport extends ReportDecorator {
    protected String name;
    public NameReport(Report report, String name) {
        super(report);
        this.name = name;
    }
    public String getReport() {
        return report.getReport() + "Name: " + name + " ";
    }
}
