package com.bangkit.riskque.utils

import com.bangkit.riskque.R
import com.bangkit.riskque.model.Answer
import com.bangkit.riskque.model.Quest

object DataDummy {
    fun generateDataQuestion(index: Int): Quest {
        val quests = ArrayList<Quest>()

        quests.add(
            Quest(
                R.drawable.quest_1,
                "Seberapa jauh pengetahuan Anda tentang konsep keuangan dan investasi?",
                listOf(
                    Answer("Sama sekali tidah tahu apa-apa"),
                    Answer("Memiliki sedikit pengetahuan"),
                    Answer("Cukup paham tentang konsep yang ada"),
                    Answer("Kompeten dan paham"),
                    Answer("Ahli dan memiliki pengetahuan yang luas"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_2,
                "Seberapa banyak pengalaman yang Anda miliki dengan produk investasi?",
                listOf(
                    Answer("Belum punya pengalaman"),
                    Answer("Sangat jarang atau sedikit"),
                    Answer("Cukup berpengalaman"),
                    Answer("Sering melakukan investasi"),
                    Answer("Memiliki pengalaman yang sangat luas"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_3,
                "Berapa toleransi risiko atau kesediaan Anda untuk mengambil risiko keuangan?",
                listOf(
                    Answer("Sangat rendah"),
                    Answer("Rendah"),
                    Answer("Sedang"),
                    Answer("Tinggi"),
                    Answer("Sangat tinggi"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_4,
                "Apa preferensi Anda ketika memegang aset berisiko?",
                listOf(
                    Answer("Memaksimalkan keamanan"),
                    Answer("Sebagian besar main aman"),
                    Answer("Campuran sebagian keamanan dan sebagian pengembalian"),
                    Answer("Sebagian besar pengembalian"),
                    Answer("Maksimalkan pengembalian"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_5,
                "Apa persepsi Anda tentang risiko pasar saham?",
                listOf(
                    Answer("Sangat berisiko"),
                    Answer("Agak berisiko"),
                    Answer("Netral"),
                    Answer("Agak aman"),
                    Answer("Sangat aman"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_6,
                "Di masa lalu, ketika mengalami kerugian investasi, tindakan apa yang Anda lakukan?",
                listOf(
                    Answer("Menjual investasi"),
                    Answer("Tidak melakukan apa-apa"),
                    Answer("Membeli lebih banyak"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_7,
                "Dari seluruh aset Anda, berapa persen yang Anda rencanakan untuk diinvestasikan pada Aset Berkembang (ekuitas dan alternatif)?",
                listOf(
                    Answer("Kurang dari 30%"),
                    Answer("30% - 70%"),
                    Answer("Lebih dari 70%"),
                )
            )
        )

        quests.add(
            Quest(
                R.drawable.quest_8,
                "Berapa lama jangka waktu rencana investasi Anda?",
                listOf(
                    Answer("Kurang dari atau sama dengan 5 tahun"),
                    Answer("5 - 10 tahun"),
                    Answer("Lebih dari atau sama dengan 10 tahun"),
                )
            )
        )
        return quests[index]
    }
}