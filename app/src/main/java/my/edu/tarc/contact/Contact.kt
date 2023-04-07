package my.edu.tarc.contact

import androidx.room.Entity
import androidx.room.PrimaryKey

//Define a table structure
@Entity(tableName = "contact")
data class Contact (val name: String, @PrimaryKey val phone: String) {  //data class = class for saving data only
    override fun toString(): String {
        return "$name : $phone"
    }
}
