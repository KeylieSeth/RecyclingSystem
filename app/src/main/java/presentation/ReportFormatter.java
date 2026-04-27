package presentation;

import application.Report;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportFormatter {
    private LocalDate date;

    public String format(Report report){
        int maxWidth = 0;
        
        StringBuilder content = new StringBuilder();

        String header = String.format("%-15s %-10s %-12s %s\n",
        "Name", "Qty", "Impact", "Materials");

        content.append(header);
        maxWidth = header.length();

        for (String row : report.getRows()){
            
            String[] parts = row.split("\t");

            String formattedRow = String.format("%-15s %-11s %-11s %s\n",
            parts[0], parts[1], parts[2], parts[3]);

            content.append(formattedRow);

            if (formattedRow.length() > maxWidth) {
                maxWidth = formattedRow.length();
            }
        }

        StringBuilder sb = new StringBuilder();

        String title = "Recycling Report";

        int padding = (maxWidth - title.length()) / 2;
        sb.append("-".repeat(maxWidth) + "\n");
        sb.append(" ".repeat(Math.max(0, padding)) + title + "\n");
        sb.append("-".repeat(maxWidth) + "\n\n");

        sb.append(content);

       
        sb.append("\nTotal Impact: " + report.getTotalImpact() + "\n");
        sb.append("-".repeat(maxWidth) + "\n");
        
        date = LocalDate.now();
        sb.append("Report Generated: " + date.format(DateTimeFormatter.ISO_DATE) + ".\n");

        return sb.toString();
    }
}
