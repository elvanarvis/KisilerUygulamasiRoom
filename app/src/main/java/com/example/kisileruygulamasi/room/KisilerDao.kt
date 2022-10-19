package com.example.kisileruygulamasi.room

import androidx.room.*
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {//Database Access Object
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi:Kisiler)

    @Update
    suspend fun guncelle(kisi:Kisiler)

    @Delete
    suspend fun sil(kisi:Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Kisiler>
}