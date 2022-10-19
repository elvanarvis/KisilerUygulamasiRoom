package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao:KisilerDao) {

    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
        kdao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
        kdao.guncelle(guncellenenKisi)
    }

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            kdao.kisileriYukle()
        }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> =
        withContext(Dispatchers.IO){
            kdao.ara(aramaKelimesi)
        }

    suspend fun sil(kisi_id:Int) {
        val silinenKisi = Kisiler(kisi_id,"","")
        kdao.sil(silinenKisi)
    }
}