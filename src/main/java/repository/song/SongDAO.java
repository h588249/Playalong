package repository.song;

import model.song.Song;
import repository.AbstractDAO;

public class SongDAO extends AbstractDAO<Song>
{
    public SongDAO()
    {
        super(Song.class);
    }
}
