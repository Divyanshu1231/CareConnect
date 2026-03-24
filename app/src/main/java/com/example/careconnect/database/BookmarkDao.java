import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.careconnect.model.Bookmark;

import java.util.List;

@Dao
public interface BookmarkDao {

    @Insert
    void insert(Bookmark b);

    @Query("SELECT * FROM Bookmark")
    LiveData<List<Bookmark>> getAll();
}