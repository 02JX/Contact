package my.edu.tarc.contact

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.tarc.mycontact.ContactDao

//@Database (entities = arrayOf(Contact::class, Table2::class), version = 1, exportSchema = false)
//                                             ^do this if got more table
@Database (entities = arrayOf(Contact::class), version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object{
        //Singleton prevents multiple instances of database opening at the same time
        @Volatile   //Volatile memory
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context) : ContactDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            //Run at the same time with application
            //App will not continue until it's done
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}