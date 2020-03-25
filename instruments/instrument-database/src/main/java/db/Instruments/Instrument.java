package db.Instruments;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 *
 * Represents single instrument in database
 * Columns = id = Identity
 *           name = Instrument name
 *           country = Country of instrument origin
 * @author Patrik Procházka
 */
@Entity
@Table(name = "Instrument")
public class Instrument {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "instrument")
    private Set<CanPlay> played;

    public Instrument(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Instrument() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", played=" + played +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrument)) return false;
        Instrument that = (Instrument) o;
        return Objects.equals(getId(), that.getId()) &&
                getName().equals(that.getName()) &&
                getCountry().equals(that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry());
    }
}
