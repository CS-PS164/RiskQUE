package com.bangkit.riskque.utils

import com.bangkit.riskque.model.Answer
import com.bangkit.riskque.model.Quest

object DataDummy {
    fun generateDataQuestion(index: Int): Quest {
        val quests = ArrayList<Quest>()

        quests.add(
            Quest(
                "Seberapa jauh pengetahuan Anda tentang konsep keuangan dan investasi?",
                listOf(
                    Answer("Sama sekali tidah tahu apa-apa", 1),
                    Answer("Memiliki sedikit pengetahuan", 2),
                    Answer("Cukup paham tentang konsep yang ada", 3),
                    Answer("Kompeten dan paham", 4),
                    Answer("Ahli dan memiliki pengetahuan yang luas", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Seberapa banyak pengalaman yang Anda miliki dengan produk investasi?",
                listOf(
                    Answer("Belum punya pengalaman", 1),
                    Answer("Sangat jarang atau sedikit", 2),
                    Answer("Cukup berpengalaman", 3),
                    Answer("Sering melakukan investasi", 4),
                    Answer("Memiliki pengalaman yang sangat luas", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Berapa toleransi risiko atau kesediaan Anda untuk mengambil risiko keuangan?",
                listOf(
                    Answer("Sangat rendah", 1),
                    Answer("Rendah", 2),
                    Answer("Sedang", 3),
                    Answer("Tinggi", 4),
                    Answer("Sangat tinggi", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Apa preferensi Anda ketika memegang aset berisiko?",
                listOf(
                    Answer("Memaksimalkan keamanan", 1),
                    Answer("Sebagian besar main aman", 2),
                    Answer("Campuran sebagian keamanan dan sebagian pengembalian", 3),
                    Answer("Sebagian besar pengembalian", 4),
                    Answer("Maksimalkan pengembalian", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Apa persepsi Anda tentang risiko pasar saham?",
                listOf(
                    Answer("Sangat berisiko", 1),
                    Answer("Agak berisiko", 2),
                    Answer("Netral", 3),
                    Answer("Agak aman", 4),
                    Answer("Sangat aman", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Di masa lalu, ketika mengalami kerugian investasi, tindakan apa yang Anda lakukan?",
                listOf(
                    Answer("Menjual investasi", 1),
                    Answer("Tidak melakukan apa-apa", 3),
                    Answer("Membeli lebih banyak", 5),
                )
            )
        )

        quests.add(
            Quest(
                "Dari seluruh aset Anda, berapa persen yang Anda rencanakan untuk diinvestasikan pada Aset Berkembang (ekuitas dan alternatif)?",
                listOf(
                    Answer("Kurang dari 30%", 0),
                    Answer("30% - 70%", 0),
                    Answer("Lebih dari 70%", 0),
                )
            )
        )

        quests.add(
            Quest(
                "Berapa lama jangka waktu rencana investasi Anda?",
                listOf(
                    Answer("Kurang dari atau sama dengan 5 tahun", 0),
                    Answer("5 - 10 tahun", 0),
                    Answer("Lebih dari atau sama dengan 10 tahun", 0),
                )
            )
        )
        return quests[index]
    }
}