package db.Band;

import javax.persistence.*;
import java.util.List;

/**
 * @author Patrik Procházka
 */
@Entity
@Table(name="Band")
public class Band {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "band")
    private List<Musician> bandMates;

    public Long getId() {
        return id;
    }

    public List<Musician> getBandMates() {
        return bandMates;
    }

    public void setBandMates(List<Musician> bandMates) {
        this.bandMates = bandMates;
    }
}
