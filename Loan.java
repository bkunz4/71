import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoanServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Get form data
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        int numYears = Integer.parseInt(request.getParameter("numYears"));

        // Compute loan payments
        Loan loan = new Loan(interestRate, numYears, loanAmount);
          double getMonthlyPayment() {
            double interestRate = interestRate / 1200;
            double monthlyPayment = loanAmount * interestRate / (1-(1 / Math.pow(1 + interestRate, numYears * 12)));
            return monthlyPayment; 
          }
        
          /** Find total payment */ 
          double getTotalPayment() {
            double totalPayment = getMonthlyPayment() * numYears * 12;
            return totalPayment;
          }

        // Display results
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Payment</title></head><body>");
        out.println("<h1>Loan Payment</h1>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Interest Rate: " + interestRate + "%</p>");
        out.println("<p>Number of Years: " + numYears + "</p>");
        out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
        out.println("<p>Total Payment: $" + totalPayment + "</p>");
        out.println("</body></html>");
    }
}
