public class Tester {
    public static void main(String[] args) {
        String linebreak = "--------------------";

        System.out.println(linebreak);
        System.out.println(linebreak);
        System.out.println("Testing Employee Class...");
        Employee employee1 = new Employee("John", "Doe");
        System.out.println(employee1.toString());
        System.out.println(linebreak);
        System.out.println("Adding Sales Department...");
        employee1.setDepartment("Sales");
        System.out.println(employee1.toString());
        System.out.println(linebreak);
        System.out.println("Testing Employee Constructor...");
        Employee employee2 = new Employee("Dohn", "Joe", "Marketing");
        System.out.println(employee2.toString());

        System.out.println(linebreak);
        System.out.println(linebreak);

        System.out.println("Testing FulltimeEmployee Class...");
        FulltimeEmployee fullTimeEmployee = new FulltimeEmployee("Albert", "Albertson", "Recruiting");
        System.out.println(fullTimeEmployee.toString());
        System.out.println(linebreak);
        System.out.println("Getting + Setting Salary...");
        fullTimeEmployee.printSalary();
        fullTimeEmployee.setSalary(100000.00);
        fullTimeEmployee.printSalary();
        System.out.println(linebreak);
        System.out.println("Getting + Setting Benefits...");
        fullTimeEmployee.printBenefits();
        fullTimeEmployee.addBenefit("Medical");
        fullTimeEmployee.addBenefit("Dental");
        fullTimeEmployee.addBenefit("Free Lunch");
        fullTimeEmployee.printBenefits();
        fullTimeEmployee.removeBenefit("Free Lunch");
        fullTimeEmployee.printBenefits();

        System.out.println(linebreak);
        System.out.println(linebreak);

        System.out.println("Testing HourlyEmployee Class...");
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Ben", "Benson", "Baking");
        System.out.println(hourlyEmployee.toString());
        System.out.println(linebreak);
        System.out.println("Getting + Setting Hourly Rate...");
        System.out.println(hourlyEmployee.getHourlyRate());
        hourlyEmployee.setHourlyRate(16.50);
        System.out.println(hourlyEmployee.getHourlyRate());
        System.out.println(linebreak);
        System.out.println("Getting + Setting Hours Worked");
        System.out.println(hourlyEmployee.getHours());
        hourlyEmployee.setHours(160);
        System.out.println(hourlyEmployee.getHours());
        System.out.println(linebreak);
        System.out.println("Testing Print Functions...");
        hourlyEmployee.printHours();
        hourlyEmployee.printTotalWages();
        hourlyEmployee.printWeeklyAverage();

        System.out.println(linebreak);
        System.out.println(linebreak);

        System.out.println("Testing Student Class...");
        Student student = new Student("John", "Johnson");
        System.out.println(student.toString());
        System.out.println(linebreak);
        System.out.println("Initializing John's Transcript...");
        student.addClass("Math", "A");
        student.addClass("English", "A");
        student.addClass("Science", "A");
        student.addClass("Social Studies", "A");
        student.addClass("Home Economics", "A");
        student.addClass("Physical Education", "F");
        student.printTranscript();
        System.out.println(linebreak);
        System.out.println("Testing Removing A Class...");
        student.removeClass("Physical Education");
        student.printTranscript();
        System.out.println(linebreak);
        System.out.println("Testing Adding A Class...");
        student.addClass("Computer Science");
        student.printTranscript();
        System.out.println(linebreak);
        System.out.println("Testing Setting A Grade...");
        student.assignGrade("Computer Science", "A+");
        student.printTranscript();
        System.out.println(linebreak);
    }
}

// TEST CASE OUTPUT
// --------------------
// --------------------
// Testing Employee Class...
// John Doe, ID#: 1001, Department: null
// --------------------
// Adding Sales Department...
// John Doe, ID#: 1001, Department: Sales
// --------------------
// Testing Employee Constructor...
// Dohn Joe, ID#: 1002, Department: Marketing
// --------------------
// --------------------
// Testing FulltimeEmployee Class...
// Albert Albertson, ID#: 1003, Department: Recruiting
// --------------------
// Getting + Setting Salary...
// No salary has been set yet
// Salary: $100000.00
// --------------------
// Getting + Setting Benefits...
// Benefits: No current benefits
// Benefits: Medical, Dental, Free Lunch
// Benefits: Medical, Dental
// --------------------
// --------------------
// Testing HourlyEmployee Class...
// Ben Benson, ID#: 1004, Department: Baking
// --------------------
// Getting + Setting Hourly Rate...
// 0.0
// 16.5
// --------------------
// Getting + Setting Hours Worked
// 0
// 160
// --------------------
// Testing Print Functions...
// Total Hours over 4 weeks: 160
// This employee earned $2640.00 for the past 4 weeks.
// Average Hours per week: 40
// --------------------
// --------------------
// Testing Student Class...
// John Johnson, ID#: 1005
// --------------------
// Initializing John's Transcript...
// Math: A
// English: A
// Science: A
// Social Studies: A
// Home Economics: A
// Science: A
// Social Studies: A
// Home Economics: A
// Computer Science: A+
// --------------------