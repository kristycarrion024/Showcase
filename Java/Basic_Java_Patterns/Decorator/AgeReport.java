public class AgeReport extends ReportDecorator {
    protected int age;
    public AgeReport(Report report, int age) {
        super(report);
        this.age = age;
    }
    public String getReport() {
        return report.getReport() + "Age:" + age + " ";
    }
}
