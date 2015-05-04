public class TestReport {
    public static void main(String[] args) {
        Report naReport = 
                  new NameReport(new AgeReport(new SimpleReport(), 34), "Bob");
        System.out.println(naReport.getReport());
    }
}
