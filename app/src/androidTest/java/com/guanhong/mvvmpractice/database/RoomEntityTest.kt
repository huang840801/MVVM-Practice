package com.guanhong.mvvmpractice.database

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.nullValue

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomEntityTest {

    private lateinit var database: RoomDbHelper
    private lateinit var dao: RoomDao

    @Before
    fun setUp() {

        val context = InstrumentationRegistry.getContext()

        database = Room.inMemoryDatabaseBuilder(context, RoomDbHelper::class.java).build()
        dao = database.getRoomDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun writeUserAndRead() {
        val user = RoomEntity().apply {
            id = 81
            name = "Kobe"
        }

        dao.insert(user)

        val byName = dao.findByName("Kobe")

        assertThat(byName.id, equalTo(81))
    }

    @Test
    fun updateUserAndRead() {
        val user1 = RoomEntity().apply {
            id = 100
            name = "Chamberlain"
        }
        val user2 = RoomEntity().apply {
            id = 100
            name = "Shaq"
        }

        dao.insert(user1)
        dao.update(user2)

        val byId = dao.findById(100)

        assertThat(byId.name, equalTo("Shaq"))
    }

    @Test
    fun deleteUser() {
        val user1 = RoomEntity().apply {
            id = 30
            name = "Curry"
        }

        dao.insert(user1)

        val byId: RoomEntity = dao.findById(30)

        dao.delete(byId)

        val deleteById = dao.findById(30)

        assertThat(deleteById, nullValue())
    }
}