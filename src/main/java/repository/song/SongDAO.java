package repository.song;

import model.song.Song;
import repository.AbstractDAO;
import repository.DatabaseRepository;

public class SongDAO extends AbstractDAO<Song>
{
    public SongDAO()
    {
        super(Song.class, new DatabaseRepository<>());
    }
}
