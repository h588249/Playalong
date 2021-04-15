package repository.song;

import model.song.Song;
import repository.AbstractDAO;
import repository.Pair;
import repository.Repository;

import java.util.List;

public class SongDAO extends AbstractDAO<Song> {
    /**
     * Constructs a new data access object with a given repository
     *
     * @param repository
     */
    public SongDAO(Repository<Song> repository) {
        super(Song.class, repository);
    }

    /**
     * Inserts a song into the database
     *
     * @param song
     */
    public void insert(Song song) {
        repository.create(song);
    }

    /**
     * Attempts to get a song with the given name
     *
     * @param songName The name of the song
     * @return A song which has "songName" as name or null if no song was found
     */
    public Song findSongWithName(String songName) {
        return repository.getById(songName);

    }

    /**
     * Attempts to get a list of all the songs of a given artist
     *
     * @param artistName The name of the artist
     * @return List of songs by the artist if the artist exists
     */
    public List<Song> findSongsFromArtist(String artistName) {
        return repository.getList(
                "select s from Song s where s.artist = :artist",
                new Pair<>("artist", artistName)
        );
    }

    /**
     * Fetches all the songs in the database
     * <p>
     * Should make it so that it only fetches the song name, but the repo doesnt allow that
     *
     * @return All the songs in the database
     */
    public List<Song> getAllSongs() {
        return repository.getList("select s from Song s");
    }

    /**
     * Removes the song from the database if it exists
     *
     * @param song Song to be removed
     */
    public void removeSong(Song song) {
        repository.delete(song);
    }
}
