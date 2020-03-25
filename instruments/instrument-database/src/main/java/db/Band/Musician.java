package db.Band;

import db.Instruments.CanPlay;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Represents musicician in database
 * @author Patrik Procházka
 */
@Entity
@Table(name = "Musician")
public class Musician {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "player")
    private Set<CanPlay> plays;

    public Band getBand() {
        return band;
    }


    public void setBand(Band band) {
        this.band = band;
    }

    @ManyToOne
    private Band band;

    public Musician(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Musician(Musician musician){
        this.id = musician.getId();
        this.name = musician.getName();
        this.country = musician.getCountry();
        this.band = musician.getBand();
        this.plays = musician.getPlays();
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

    public Set<CanPlay> getPlays() {
        return plays;
    }

    public void setPlays(Set<CanPlay> plays) {
        this.plays = plays;
    }

    public Musician() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musician)) return false;
        Musician musician = (Musician) o;
        return getId().equals(musician.getId()) &&
                Objects.equals(getName(), musician.getName()) &&
                Objects.equals(getCountry(), musician.getCountry()) &&
                Objects.equals(getPlays(), musician.getPlays()) &&
                Objects.equals(getBand(), musician.getBand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getPlays(), getBand());
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", plays=" + plays +
                ", band=" + band +
                '}';
    }
}
