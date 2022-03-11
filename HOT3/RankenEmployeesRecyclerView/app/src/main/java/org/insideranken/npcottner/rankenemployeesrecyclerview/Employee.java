package org.insideranken.npcottner.rankenemployeesrecyclerview;

import java.util.Comparator;

public class Employee {
    int employeeId;
    String employeeName;
    String employeeDepartment;
    String employeeImage;

    public Employee(int employeeId, String employeeName, String employeeDepartment,
                    String employeeImage) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeImage = employeeImage;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    @Override
    public String toString() {
        return "employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeImage=" + employeeImage +
                '}';
    }

    public static Comparator<Employee> employeeSearchAscendingComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getEmployeeName().compareTo((e2.getEmployeeName()));
        }
    };

    public static Comparator<Employee> employeeSearchDescendingComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e2.getEmployeeName().compareTo((e1.getEmployeeName()));
        }
    };

    public static Comparator<Employee> deptSearchAscendingComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getEmployeeDepartment().compareTo((e2.getEmployeeDepartment()));
        }
    };

    public static Comparator<Employee> deptSearchDescendingComparator = new Comparator<Employee>()
    {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e2.getEmployeeDepartment().compareTo((e1.getEmployeeDepartment()));
        }
    };
}
