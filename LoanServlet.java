import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoanServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    public class Loan {
      private double annualInterestRate;
      private int numberOfYears;
      private double loanAmount;
      private java.util.Date loanDate;
      
      /** Default constructor */
      public Loan() {
        this(2.5, 1, 1000);
      }
          
      /** Construct a loan with specified annual interest rate, number of years, and loan amount */ 
      public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
      }
          
      /** Return annualInterestRate */ 
      public double getAnnualInterestRate() {
        return annualInterestRate;
      }
          
      /** Set a new annualInterestRate */ 
      public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
      }
          
      /** Return numberOfYears */ 
      public int getNumberOfYears() {
        return numberOfYears;
      }

      /** Set a new numberOfYears */ 
      public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
      }

      /** Return loanAmount */ 
      public double getLoanAmount() {
        return loanAmount;
      }

      /** Set a new loanAmount */ 
      public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
      }

      /** Find monthly payment */ 
      public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1-(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment; 
      }

      /** Find total payment */ 
      public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
      }
          
      /** Return loan date */ 
      public java.util.Date getLoanDate() {
        return loanDate;
      }
    }

      // Display results
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Loan Payment</title></head><body>");
    out.println("<h1>Loan Payment</h1>");
    out.println("<p>Loan Amount: $" + loanAmount + "</p>");
    out.println("<p>Interest Rate: " + annualInterestRate + "%</p>");
    out.println("<p>Number of Years: " + numberOfYears + "</p>");
    out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
    out.println("<p>Total Payment: $" + totalPayment + "</p>");
    out.println("</body></html>");
  }
  out.close(); // Close the PrintWriter
}
