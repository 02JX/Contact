package my.tarc.mycontact

import androidx.lifecycle.LiveData
import androidx.room.*
import my.edu.tarc.contact.Contact

//Data Access Object
@Dao
interface ContactDao {
    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAllContact(): LiveData<List<Contact>>

    //Suspend = execute the function in a separate thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)
}