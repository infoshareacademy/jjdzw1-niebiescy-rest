package niebiescy.rest.domain;

import javax.persistence.*;

@Entity
@Table(name = "searchstring")
public class SearchString {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "string")
    private String string;

    @Column(name = "counter")
    private double counter;



    public SearchString() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }
}
