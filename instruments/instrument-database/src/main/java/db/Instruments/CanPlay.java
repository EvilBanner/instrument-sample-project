package db.Instruments;


import db.Band.Musician;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents musician ability to play instrument
 * @author Patrik Procházka
 */
@Entity
@Table(name = "CanPlay")
public class CanPlay {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Musician player;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Instrument instrument;

    public Musician getPlayer() {
        return player;
    }

    public void setPlayer(Musician player) {
        this.player = player;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }



}
