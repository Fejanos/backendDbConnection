/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author János
 */
public class Student {
    private int id;
    private String name;
    private Date born;
    //private int teacher_id;
    private Teacher teacher;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getBorn() {
        return this.born;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public Student(int id, String name, Date born, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.teacher = teacher;
    }
    
    
}
