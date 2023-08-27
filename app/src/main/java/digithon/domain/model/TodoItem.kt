package digithon.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
