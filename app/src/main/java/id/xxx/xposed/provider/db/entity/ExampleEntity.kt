package id.xxx.xposed.provider.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = ExampleEntity.TABLE_NAME
)
data class ExampleEntity(
    @PrimaryKey
    val id: Short = ID_FIX,
) {
    companion object {
        const val ID_FIX: Short = 1
        const val TABLE_NAME = "table_info"
    }
}