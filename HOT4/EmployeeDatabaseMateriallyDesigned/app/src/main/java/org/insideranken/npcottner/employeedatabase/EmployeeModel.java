package org.insideranken.npcottner.employeedatabase;

import java.util.Comparator;

public class EmployeeModel {
    int employeeId;
    String employeeName;
    String employeeDepartment;
    int employeeImage;

    public EmployeeModel(int employeeId, String employeeName, String employeeDepartment,
                         int employeeImage) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeImage = employeeImage;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getEmployeeDepartment() {
        return employeeDepartment;
    }
    public int getEmployeeImage() {
        return employeeImage;
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

    public static Comparator<EmployeeModel> employeeSearchAscendingComparator =
            new Comparator<EmployeeModel>()
    {
        @Override
        public int compare(EmployeeModel e1, EmployeeModel e2) {
            return e1.getEmployeeName().compareTo((e2.getEmployeeName()));
        }
    };

    public static Comparator<EmployeeModel> employeeSearchDescendingComparator =
            new Comparator<EmployeeModel>()
    {
        @Override
        public int compare(EmployeeModel e1, EmployeeModel e2) {
            return e2.getEmployeeName().compareTo((e1.getEmployeeName()));
        }
    };

    public static Comparator<EmployeeModel> deptSearchAscendingComparator =
            new Comparator<EmployeeModel>()
    {
        @Override
        public int compare(EmployeeModel e1, EmployeeModel e2) {
            return e1.getEmployeeDepartment().compareTo((e2.getEmployeeDepartment()));
        }
    };

    public static Comparator<EmployeeModel> deptSearchDescendingComparator =
            new Comparator<EmployeeModel>()
    {
        @Override
        public int compare(EmployeeModel e1, EmployeeModel e2) {
            return e2.getEmployeeDepartment().compareTo((e1.getEmployeeDepartment()));
        }
    };
}
