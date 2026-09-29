package demo;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // File name used for saving and reading employee details
        String fileName = "employee.txt";

        Employee employee = new Employee();
        Attendance attendance = new Attendance();
        Salary salary = new Salary();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("   EMPLOYEE ATTENDANCE & PAYROLL SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Enter Employee Details");
            System.out.println("2. Calculate Attendance");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Display Employee Details");
            System.out.println("5. Save Employee to File");
            System.out.println("6. Read Employee Details from File");
            System.out.println("7. Exit");
            System.out.println("Enter choice:");

            choice = sc.nextInt();

            switch (choice) {

            // ==================================================
            // CASE 1: ENTER EMPLOYEE DETAILS
            // ==================================================
            case 1:

                System.out.println("\n--- ENTER EMPLOYEE DETAILS ---");

                System.out.println("Enter Employee ID:");
                employee.employeeId = sc.nextInt();

                sc.nextLine();

                System.out.println("Enter Employee Name:");
                employee.employeeName = sc.nextLine();

                System.out.println("\nSelect Department:");
                System.out.println("1. IT");
                System.out.println("2. HR");
                System.out.println("3. FINANCE");
                System.out.println("4. MARKETING");
                System.out.println("Enter department choice:");

                employee.departmentChoice = sc.nextInt();

                switch (employee.departmentChoice) {

                case 1:
                    employee.department = "IT";
                    break;

                case 2:
                    employee.department = "HR";
                    break;

                case 3:
                    employee.department = "FINANCE";
                    break;

                case 4:
                    employee.department = "MARKETING";
                    break;

                default:
                    employee.department = "Unknown";
                    System.out.println("Invalid department choice.");
                    break;
                }

                System.out.println("Enter basic salary:");
                employee.basicSalary = sc.nextDouble();

                if (employee.basicSalary > 0) {

                    System.out.println(
                            "Employee details entered successfully."
                    );

                } else {

                    System.out.println(
                            "Invalid salary. Salary must be greater than zero."
                    );
                }

                break;


            // ==================================================
            // CASE 2: CALCULATE ATTENDANCE
            // ==================================================
            case 2:

                System.out.println("\n*** ATTENDANCE CALCULATION ***");

                System.out.println("Enter total working days:");
                attendance.totalWorkingDays = sc.nextInt();

                if (attendance.totalWorkingDays > 0) {

                    attendance.presentDays = 0;
                    attendance.absentDays = 0;

                    for (int day = 1;
                         day <= attendance.totalWorkingDays;
                         day++) {

                        System.out.println(
                                "Day " + day
                                + " - enter 1 for present, 0 for absent:"
                        );

                        attendance.attendance = sc.nextInt();

                        if (attendance.attendance == 1) {

                            attendance.presentDays++;

                        } else if (attendance.attendance == 0) {

                            attendance.absentDays++;

                        } else {

                            System.out.println(
                                    "Invalid input. Please enter only 1 or 0."
                            );

                            day--;
                        }
                    }

                    attendance.attendancePercentage =
                            ((double) attendance.presentDays
                                    / attendance.totalWorkingDays) * 100;

                    System.out.println(
                            "\nPresent days: "
                            + attendance.presentDays
                    );

                    System.out.println(
                            "Absent days: "
                            + attendance.absentDays
                    );

                    System.out.println(
                            "Attendance %: "
                            + attendance.attendancePercentage
                            + "%"
                    );

                    if (attendance.attendancePercentage >= 75) {

                        System.out.println(
                                "Attendance Status: Eligible"
                        );

                    } else {

                        System.out.println(
                                "Attendance Status: Not Eligible"
                        );
                    }

                } else {

                    System.out.println(
                            "Working days must be greater than zero."
                    );
                }

                break;


            // ==================================================
            // CASE 3: CALCULATE SALARY
            // ==================================================
            case 3:

                System.out.println("\n*** SALARY CALCULATION ***");

                if (employee.basicSalary > 0) {

                    if (attendance.totalWorkingDays > 0) {

                        if (attendance.attendancePercentage >= 90) {

                            salary.incentive =
                                    employee.basicSalary * 0.10;

                            salary.deduction = 0;

                            salary.finalSalary =
                                    employee.basicSalary
                                    + salary.incentive;

                            System.out.println(
                                    "Attendance Category: Excellent"
                            );

                            System.out.println(
                                    "Attendance Incentive: 10%"
                            );

                        } else if (
                                attendance.attendancePercentage >= 75) {

                            salary.incentive = 0;
                            salary.deduction = 0;

                            salary.finalSalary =
                                    employee.basicSalary;

                            System.out.println(
                                    "Attendance Category: Good"
                            );

                            System.out.println(
                                    "Attendance Incentive: 0%"
                            );

                        } else {

                            salary.incentive = 0;

                            salary.deduction =
                                    employee.basicSalary * 0.10;

                            salary.finalSalary =
                                    employee.basicSalary
                                    - salary.deduction;

                            System.out.println(
                                    "Attendance Category: Low"
                            );

                            System.out.println(
                                    "Attendance Deduction: 10%"
                            );
                        }

                        System.out.println(
                                "Basic Salary: $"
                                + employee.basicSalary
                        );

                        System.out.println(
                                "Final Salary: $"
                                + salary.finalSalary
                        );

                    } else {

                        System.out.println(
                                "Please calculate attendance first."
                        );
                    }

                } else {

                    System.out.println(
                            "Please enter valid employee details first."
                    );
                }

                break;


            // ==================================================
            // CASE 4: DISPLAY EMPLOYEE DETAILS
            // ==================================================
            case 4:

                System.out.println(
                        "\n**** EMPLOYEE DETAILS ****"
                );

                if (employee.employeeId != 0) {

                    System.out.println(
                            "Employee ID: "
                            + employee.employeeId
                    );

                    System.out.println(
                            "Employee Name: "
                            + employee.employeeName
                    );

                    System.out.println(
                            "Department: "
                            + employee.department
                    );

                    System.out.println(
                            "Basic Salary: "
                            + employee.basicSalary
                    );

                    System.out.println(
                            "Present Days: "
                            + attendance.presentDays
                    );

                    System.out.println(
                            "Absent Days: "
                            + attendance.absentDays
                    );

                    System.out.println(
                            "Attendance %: "
                            + attendance.attendancePercentage
                    );

                    System.out.println(
                            "Final Salary: "
                            + salary.finalSalary
                    );

                } else {

                    System.out.println(
                            "No employee details available."
                    );
                }

                break;


            // ==================================================
            // CASE 5: SAVE EMPLOYEE DETAILS TO FILE
            // ==================================================
            case 5:

                System.out.println(
                        "\n--- SAVE EMPLOYEE TO FILE ---"
                );

                if (employee.employeeId == 0) {

                    System.out.println(
                            "Please enter employee details first."
                    );

                    break;
                }

                try {

                    FileWriter fw = new FileWriter(fileName);

                    PrintWriter pw = new PrintWriter(fw);

                    pw.println("EMPLOYEE PAYROLL DETAILS");
                    pw.println("========================");

                    pw.println(
                            "Employee ID: "
                            + employee.employeeId
                    );

                    pw.println(
                            "Employee Name: "
                            + employee.employeeName
                    );

                    pw.println(
                            "Department: "
                            + employee.department
                    );

                    pw.println(
                            "Basic Salary: "
                            + employee.basicSalary
                    );

                    pw.println(
                            "Total Working Days: "
                            + attendance.totalWorkingDays
                    );

                    pw.println(
                            "Present Days: "
                            + attendance.presentDays
                    );

                    pw.println(
                            "Absent Days: "
                            + attendance.absentDays
                    );

                    pw.println(
                            "Attendance Percentage: "
                            + attendance.attendancePercentage
                    );

                    pw.println(
                            "Final Salary: "
                            + salary.finalSalary
                    );

                    pw.close();

                    System.out.println(
                            "Employee details saved successfully."
                    );

                    System.out.println(
                            "File Name: " + fileName
                    );

                } catch (IOException e) {

                    System.out.println(
                            "Error while writing to file."
                    );

                    System.out.println(
                            e.getMessage()
                    );
                }

                break;


            // ==================================================
            // CASE 6: READ EMPLOYEE DETAILS FROM FILE
            // ==================================================
            case 6:

                System.out.println(
                        "\n--- READ EMPLOYEE DETAILS FROM FILE ---"
                );

                try {

                    FileReader fr =
                            new FileReader(fileName);

                    BufferedReader br =
                            new BufferedReader(fr);

                    String line;

                    while ((line = br.readLine()) != null) {

                        System.out.println(line);
                    }

                    br.close();

                } catch (IOException e) {

                    System.out.println(
                            "Error while reading file."
                    );

                    System.out.println(
                            "Please save employee details first."
                    );
                }

                break;


            // ==================================================
            // CASE 7: EXIT
            // ==================================================
            case 7:

                System.out.println(
                        "\nThank you for using the system."
                );

                break;


            // ==================================================
            // INVALID MENU OPTION
            // ==================================================
            default:

                System.out.println(
                        "Invalid menu choice."
                );

                System.out.println(
                        "Please enter a number from 1 to 7."
                );

                break;
            }

        } while (choice != 7);

        sc.close();
    }
}