package model.song;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "dat109_project", name = "song")
public class Song {
    @Id
    @Column(name = "song_name")
    private String name;

    private String artist;

    @Column(name = "instrument") // is "main" necessary?
    private String mainInstrument;

    private int duration;

    @Column(name = "notes_eb")
    private Byte[] notes_Eb;

    @Column(name = "notes_bb")
    private Byte[] notes_Bb;

    private Byte[] sound;

    public Song(String name, String artist, String mainInstrument, int duration) {
        this.name = name;
        this.artist = artist;
        this.mainInstrument = mainInstrument;
        this.duration = duration;
    }

    protected Song() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMainInstrument() {
        return mainInstrument;
    }

    public void setMainInstrument(String mainInstrument) {
        this.mainInstrument = mainInstrument;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
