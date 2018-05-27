package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employeess {
    public ArrayList<Employees> getEmployees() {
        return employees;
    }
    @XmlElements({
            @XmlElement(name = "Handlowiec", type = Traders.class),
            @XmlElement(name = "Dyrektor", type = Directors.class)
    })
    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    private ArrayList<Employees> employees;
}
