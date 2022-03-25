package org.insideranken.npcottner.employeedatabase;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private boolean firstTimeInitiate = true;

    private static ArrayList<EmployeeModel> employeeModelList = new ArrayList<>();

    private static int nextEmployeeId = 26;

    public static List<EmployeeModel> getEmployeeModelList() {
        return employeeModelList;
    }

    public static void setEmployeeModelList(List<EmployeeModel> employeeModelList) {
        MyApplication.employeeModelList = (ArrayList<EmployeeModel>) employeeModelList;
    }

    public static int getNextId() {
        return nextEmployeeId;
    }

    public static void setNextId(int nextEmployeeId) {
        MyApplication.nextEmployeeId = nextEmployeeId;
    }

    public void checkIfFirstTimeInitiate()
    {
        if (firstTimeInitiate)
        {
            createEmployeeModelList();
            firstTimeInitiate = false;
        }
    }

    private void createEmployeeModelList() {
        if(firstTimeInitiate)
        {
            EmployeeModel e0  = new EmployeeModel (3306, "Pat Gliger",
                    "Admissions",R.drawable.a_pat_gliger);
            EmployeeModel e1  = new EmployeeModel (3342, "Tim Polish",
                    "Automotive", R.drawable.b_tim_polish);
            EmployeeModel e2  = new EmployeeModel (3369, "Jameson Clark",
                    "Automotive", R.drawable.c_jameson_clark);
            EmployeeModel e3  = new EmployeeModel (4835, "Jack Ryder",
                    "Automotive",R.drawable.d_jack_ryder);
            EmployeeModel e4  = new EmployeeModel (4830, "LLoyd Pikachu",
                    "Automotive",R.drawable.e_lloyd_pikachu);
            EmployeeModel e5  = new EmployeeModel (3367, "Squirtle Dude",
                    "Automotive",R.drawable.f_squirtle_dude);
            EmployeeModel e6  = new EmployeeModel (3347, "Mark Mattmy",
                    "Automotive",R.drawable.g_mark_mattmy);
            EmployeeModel e7  = new EmployeeModel (3361, "Free Guy",
                    "Automotive",R.drawable.h_free_guy);
            EmployeeModel e8  = new EmployeeModel (3343, "Lou Disease",
                    "Automotive", R.drawable.i_lou_disease);
            EmployeeModel e9  = new EmployeeModel (3392, "Doug Aldren",
                    "Automotive", R.drawable.j_doug_aldren);
            EmployeeModel e10  = new EmployeeModel (3365, "James John",
                    "Automotive",R.drawable.k_james_john);
            EmployeeModel e11  = new EmployeeModel (4850, "John Doe",
                    "Construction", R.drawable.l_john_doe);
            EmployeeModel e12  = new EmployeeModel (4800, "Dan Diggersby",
                    "Construction", R.drawable.m_dan_diggersby);
            EmployeeModel e13  = new EmployeeModel (4873, "Jane Doe",
                    "Counseling",R.drawable.n_jane_doe);
            EmployeeModel e14  = new EmployeeModel (3331, "Boss Lady",
                    "Dean of Academic Affairs", R.drawable.o_boss_lady);
            EmployeeModel e15  = new EmployeeModel (3351, "James Cobbler",
                    "Electrical", R.drawable.p_james_cobbler);
            EmployeeModel e16  = new EmployeeModel (3661, "Ricky Bobby",
                    "Electrical",R.drawable.q_ricky_bobby);
            EmployeeModel e17  = new EmployeeModel (3651, "Dennis Menace",
                    "Electrical", R.drawable.r_dennis_menace);
            EmployeeModel e18  = new EmployeeModel (3339, "Richard Walker",
                    "Electrical",R.drawable.s_richard_walker);
            EmployeeModel e19 = new EmployeeModel (4848, "Charles Cottner",
                    "IT",R.drawable.t_charles_cottner);
            EmployeeModel e20  = new EmployeeModel (3332, "Chad Lucky",
                    "IT", R.drawable.u_chad_lucky);
            EmployeeModel e21  = new EmployeeModel (4817, "Brock Paras",
                    "IT", R.drawable.v_brock_paras);
            EmployeeModel e22  = new EmployeeModel (3675, "Jeff Nichols",
                    "IT",R.drawable.w_jeff_nicholson);
            EmployeeModel e23  = new EmployeeModel (3615, "Brad Jones",
                    "Manufacturing",R.drawable.x_brad_jones);
            EmployeeModel e24  = new EmployeeModel (3311, "Joseph Licorice",
                    "Manufacturing",R.drawable.y_joseph_licorice);
            EmployeeModel e25  = new EmployeeModel (3396, "Justin Just",
                    "Public Safety",R.drawable.z_justin_just);
            EmployeeModel e26  = new EmployeeModel (4395, "Kenneth Blues",
                    "Public Safety",R.drawable.zz_kenneth_blues);


            employeeModelList.addAll(Arrays.asList(
                    e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,
                    e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,
                    e23,e24,e25,e26));
        }

    }
}
