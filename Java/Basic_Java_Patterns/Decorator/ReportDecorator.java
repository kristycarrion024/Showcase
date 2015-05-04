public abstract class ReportDecorator implements Report {
    protected Report report;
    public ReportDecorator(Report report) {
        this.report = report;
    }
    public String getReport() {
        return report.getReport();
    }
}
