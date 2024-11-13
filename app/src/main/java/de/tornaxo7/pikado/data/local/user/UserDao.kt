package de.tornaxo7.pikado.data.local.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Query("SELECT * from users WHERE username=:username AND serverUrl=:serverUrl")
    fun getUser(username: String, serverUrl: String): UserEntity

    @Query("SELECT * from users ORDER BY serverUrl ASC, username ASC")
    fun getAllUsers(): Flow<List<UserEntity>>
}