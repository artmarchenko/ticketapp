package com.atmtrans;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long routeid;
    private int seat;
    private String passangername;
    private String passangersecondname;

    public Ticket() {
    }

    public Ticket(Long routeid, int seat, String passangername, String passangersecondname) {
        this.routeid = routeid;
        this.seat = seat;
        this.passangername = passangername;
        this.passangersecondname = passangersecondname;
    }

    public String getPassangername() {
        return passangername;
    }

    public void setPassangername(String passangername) {
        this.passangername = passangername;
    }

    public String getPassangersecondname() {
        return passangersecondname;
    }

    public void setPassangersecondname(String passangersecondname) {
        this.passangersecondname = passangersecondname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Long getRouteid() {
        return routeid;
    }

    public void setRouteid(Long routeid) {
        this.routeid = routeid;
    }
}
