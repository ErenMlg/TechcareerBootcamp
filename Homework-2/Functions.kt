package com.softcross.odev1


fun icAcilarToplami(kenarSayisi: Int): Int = (kenarSayisi - 2) * 180


fun maasHesapla(gunSayisi: Int): Int {
    val calisilanSaat = gunSayisi * 8
    return if (calisilanSaat < 160) {
        calisilanSaat * 10
    } else {
        (calisilanSaat - 160) * 20 + 160 * 10
    }
}

fun internetUcretiHesapla(kullanim: Int): Int {
    return if (kullanim < 50) {
        100
    } else {
        100 + (kullanim - 50) * 4
    }
}

fun fahrenaytHesaplama(santigrat: Int): Float = (santigrat * 1.8f) + 32

fun dikdortgenCevre(uzunKenar: Int, kisaKenar: Int) {
    println("Dikdörtgenin çevresi : " + (2 * (uzunKenar + kisaKenar)))
}

fun faktoriyelHesapla(sayi: Int): Int {
    var sonuc = 1
    for (i in 1..sayi) {
        sonuc *= i
    }
    return sonuc
}

fun kelimeIcindekiHarfSayisi(kelime: String, harf: Char): Int {
    var sayac = 0
    for (i in kelime) {
        if (i == harf) {
            sayac++
        }
    }
    return sayac
}

fun main() {
    /*
    val kenarSayisi = 5
    println("$kenarSayisi kenarlı bir çokgenin iç açılarının toplamı : "+icAcilarToplami(kenarSayisi))
    val calisilanGun = 25
    println("$calisilanGun Gün çalışan birinin maaşı : "+maasHesapla(calisilanGun))
    val internetKullanim = 60
    println("$internetKullanim GB internet kullanan birinin ödeyeceği ücret : "+internetUcretiHesapla(internetKullanim))
    val santigrat = 30
    println("$santigrat Santigrat dereceyi fahrenayta çevirince : "+fahrenaytHesaplama(santigrat))
    val uzunKenar = 5; val kisaKenar = 3
    dikdortgenCevre(uzunKenar, kisaKenar)
    val sayi = 5
    println("$sayi sayısının faktoriyeli : "+faktoriyelHesapla(sayi))
    val kelime = "Techcareer"; val harf = 'a'
    println("$kelime kelimesinde $harf harfi kaç defa geçiyor : "+kelimeIcindekiHarfSayisi(kelime, harf))
    */
    while (true) {
        println(
            """
        Hoşgeldiniz;
        1. İç Açılar Toplamı Hesaplama
        2. Maaş Hesaplama
        3. İnternet Ücreti Hesaplama
        4. Santigratı Fahrenayta Çevirme
        5. Dikdörtgen Çevre Hesaplama
        6. Faktoriyel Hesaplama
        7. Kelime İçindeki Harf Sayısı Hesaplama
    """.trimIndent()
        )

        print("Lütfen yapmak istediğiniz işlemin numarasını giriniz : ")
        val secim = readln().toIntOrNull()

        when (secim) {
            1 -> {
                print("Kenar sayısını giriniz : ")
                val kenarSayisi = readln().toIntOrNull() ?: 3
                println(
                    "$kenarSayisi kenarlı bir çokgenin iç açılarının toplamı : " + icAcilarToplami(
                        kenarSayisi
                    )
                )
            }

            2 -> {
                print("Çalışılan gün sayısını giriniz : ")
                val calisilanGun = readln().toIntOrNull() ?: 25
                println("$calisilanGun Gün çalışan birinin maaşı : " + maasHesapla(calisilanGun))
            }

            3 -> {
                print("İnternet kullanımınızı GB cinsinden giriniz : ")
                val internetKullanim = readln().toIntOrNull() ?: 60
                println(
                    "$internetKullanim GB internet kullanan birinin ödeyeceği ücret : " + internetUcretiHesapla(
                        internetKullanim
                    )
                )
            }

            4 -> {
                print("Santigrat dereceyi giriniz : ")
                val santigrat = readln().toIntOrNull() ?: 60
                println(
                    "$santigrat Santigrat dereceyi fahrenayta çevirince : " + fahrenaytHesaplama(
                        santigrat
                    )
                )
            }

            5 -> {
                print("Uzun kenarı giriniz : ")
                val uzunKenar = readln().toIntOrNull() ?: 5
                print("Kısa kenarı giriniz : ")
                val kisaKenar = readln().toIntOrNull() ?: 3
                dikdortgenCevre(uzunKenar, kisaKenar)
            }

            6 -> {
                print("Faktoriyelini almak istediğiniz sayıyı giriniz : ")
                val sayi = readln().toIntOrNull() ?: 5
                println("$sayi sayısının faktoriyeli : " + faktoriyelHesapla(sayi))
            }

            7 -> {
                print("Kelimeyi giriniz : ")
                val kelime = readln()
                print("Kaç defa geçtiğini öğrenmek istediğiniz harfi giriniz : ")
                val harf = readln().firstOrNull() ?: 'a'
                println(
                    "$kelime kelimesinde $harf harfi kaç defa geçiyor : " + kelimeIcindekiHarfSayisi(
                        kelime,
                        harf
                    )
                )
            }

            else -> println("Hatalı seçim yaptınız.")
        }
        println("Başka bir işlem yapmak ister misiniz? (Evet için E, çıkmak için H ) : ")
        val devamMi = readln().uppercase()
        if (devamMi == "H") {
            println("Çıkış yapılıyor...")
            break
        }
    }
}
