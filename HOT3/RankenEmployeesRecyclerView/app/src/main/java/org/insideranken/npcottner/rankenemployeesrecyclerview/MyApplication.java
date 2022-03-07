package org.insideranken.npcottner.rankenemployeesrecyclerview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static ArrayList<Employee>employeeList = new ArrayList<>();

    private static int nextEmployeeId = 26;

    public MyApplication() {createEmployeeList();}

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        MyApplication.employeeList = (ArrayList<Employee>) employeeList;
    }

    public static int getNextId() {
        return nextEmployeeId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextEmployeeId = nextEmployeeId;
    }

    private void createEmployeeList() {
        Employee e0  = new Employee (3306, "Pat Gliger","Admissions","a_pat_gliger.png");
        Employee e1  = new Employee (3342, "Tim Polish","Automotive","b_tim_polish");
        Employee e2  = new Employee (3369, "Jameson Clark","Automotive","c_jameson_clark.jpg");
        Employee e3  = new Employee (4835, "Jack Ryder","Automotive","d_jack_ryder.png");
        Employee e4  = new Employee (4830, "LLoyd Pikachu","Automotive","e_lloyd_pikachu.png");
        Employee e5  = new Employee (3367, "Squirtle Dude","Automotive","f_squirtle-dude.jpg");
        Employee e6  = new Employee (3347, "Mark Mattmy","Automotive","g_mark_mattmy.png");
        Employee e7  = new Employee (3361, "Free Guy","Automotive","h_free_guy.jpg");
        Employee e8  = new Employee (3343, "Lou Disease","Automotive","i_lou_disease.jpg");
        Employee e9  = new Employee (3392, "Doug Aldren","Automotive","j_doug_aldren.jpg");
        Employee e10  = new Employee (3365, "James John","Automotive","k_james_john.png");
        Employee e11  = new Employee (4850, "John Doe","Construction","l_john_doe.png");
        Employee e12  = new Employee (4800, "Dan Diggersby","Construction","m_dan_diggersby.jpg");
        Employee e13  = new Employee (4873, "Jane Doe","Counseling","n_jane_doe.png");
        Employee e14  = new Employee (3331, "Boss Lady","Dean of Academic Affairs","o_boss_lady.png");
        Employee e15  = new Employee (3351, "James Cobbler","Electrical","p_james_cobbler.png");
        Employee e16  = new Employee (3661, "Ricky Bobby","Electrical","q_ricky_bobby.jpg");
        Employee e17  = new Employee (3651, "Dennis Menace","Electrical","r_dennis_menace.png");
        Employee e18  = new Employee (3339, "Richard Walker","Electrical","s_richard_walker.png");
        Employee e19 = new Employee (4848, "Charles Cottner","IT","t_charles_cottner.jpg");
        Employee e20  = new Employee (3332, "Chad Lucky","IT","u_chad_lucky.jpg");
        Employee e21  = new Employee (4817, "Brock Paras","IT","v_brock_paras.jpg");
        Employee e22  = new Employee (3675, "Jeff Nichols","IT","w_jeff_nichols.jpg");
        Employee e23  = new Employee (3615, "Brad Jones","Manufacturing","x_brad_jones.png");
        Employee e24  = new Employee (3311, "Joseph Licorice","Manufacturing","y_joseph_licorice.png");
        Employee e25  = new Employee (3396, "Justin Just","Public Safety","z_justin_just.jpg");
        Employee e26  = new Employee (4395, "Kenneth Blues","Public Safety","zz_kenneth_blue.jpg");


        employeeList.addAll(Arrays.asList(
                e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,
                e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,
                e23,e24,e25,e26));
    }
}
