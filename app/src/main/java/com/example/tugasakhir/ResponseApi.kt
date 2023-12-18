package com.example.tugasakhir

import com.google.gson.annotations.SerializedName

data class ResponseApi(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("id_kategori")
	val idKategori: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("isi")
	val isi: String? = null,

	@field:SerializedName("id_pengguna")
	val idPengguna: Int? = null
)
