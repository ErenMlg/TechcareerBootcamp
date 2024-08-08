package com.softcross.odev1

import androidx.compose.ui.graphics.Color

enum class MedeniHal {
    BEKAR,
    EVLI,
    DUL,
    BOSANMIS
}

fun main() {

    val sehir: String = "İstanbul"
    val ulke = "Türkiye"
    val telefom = "0212 123 45 67"
    val postaKodu = 34000
    val email = "ere@gmail.com"
    val meslek = "Yazılım Mühendisi"
    val stokMiktari = 30
    val musteriAdi = "Ali"
    val bakiye = 3000
    val dogumGunu = "01.01.1990"
    val maas = 30000
    val medeniDurum1 = "Bekar"
    val medeniDurum2 = MedeniHal.EVLI
    val urunYorum = "Ürün çok güzel"
    val odemeTarihi = "01.01.2022"
    val odeme = 3000
    val siparisAdeti = 3
    val arabaModeli = "Mercedes"
    val kitapAdi = "Suç ve Ceza"
    val yayinlanmaTarihi = "01.01.2022"
    val indirimMiktari = 300
    val odaSayisi = 3
    val enlem = 41.0082
    val boylam = 28.9784
    val urunAdi = "Bilgisayar"
    val yemekFiyati = 3000
    val marka = "Apple"
    val muzikAdi = "Believer"
    val videoSuresi = "600".toIntOrNull()
    val urunPuani = 4f
    val resimAdi = "resim.jpg"
    val dosyaFormati = ".jpg"
    val renk = "Mavi"
    val renkKodu1: Color = Color(0xFF0000FF)
    val renkKodu2 = "#0000FF"
    val renkKodu3 = 0xFF0000FF
    val telefonModeli = "Redmi Note 8 Pro"
    val ekranBoyutu = 8.2
    val agirlik = 40
    val ulusalGun = "23 Nisan"
    val tatilGunu = "1 Mayıs"
    val rezervasyonTarihi = "01.01.2022"
    val sokakAdi = "Atatürk"
    val otobusHatti = "34Z"
    val kalanDakika = 30
    val takipKodu = "123456"
    val kuponSuresi = 30
    val kuponKodu = "ABC123"
    val faturaAdresi = "İstanbul - Gaziosmanpaşa"

    println("Şehir: $sehir")
    println("Ülke: $ulke")
    println("Telefon: $telefom")
    println("Posta Kodu: $postaKodu")
    println("E-posta: $email")
    println("Meslek: $meslek")
    println("Stok Miktarı: $stokMiktari")
    println("Müşteri Adı: $musteriAdi")
    println("Bakiye: $bakiye")
    println("Doğum Günü: $dogumGunu")
    println("Maaş: $maas")
    println("Medeni Durum: $medeniDurum1")
    println("Medeni Durum: ${medeniDurum2.name}")
    println("Ürün Yorum: $urunYorum")
    println("Ödeme Tarihi: $odemeTarihi")
    println("Ödeme: $odeme")
    println("Sipariş Adeti: $siparisAdeti")
    println("Araba Modeli: $arabaModeli")
    println("Kitap Adı: $kitapAdi")
    println("Yayınlanma Tarihi: $yayinlanmaTarihi")
    println("İndirim Miktarı: $indirimMiktari")
    println("Oda Sayısı: $odaSayisi")
    println("Enlem: $enlem")
    println("Boylam: $boylam")
    println("Ürün Adı: $urunAdi")
    println("Yemek Fiyatı: $yemekFiyati")
    println("Marka: $marka")
    println("Müzik Adı: $muzikAdi")
    println("Video Süresi: $videoSuresi")
    println("Ürün Puanı: $urunPuani")
    println("Resim Adı: $resimAdi")
    println("Dosya Formatı: $dosyaFormati")
    println("Renk: $renk")
    println("Renk Kodu 1: $renkKodu1")
    println("Renk Kodu 2: $renkKodu2")
    println("Renk Kodu 3: $renkKodu3")
    println("Telefon Modeli: $telefonModeli")
    println("Ekran Boyutu: $ekranBoyutu")
    println("Ağırlık: $agirlik")
    println("Ulusal Gün: $ulusalGun")
    println("Tatil Günü: $tatilGunu")
    println("Rezervasyon Tarihi: $rezervasyonTarihi")
    println("Sokak Adı: $sokakAdi")
    println("Otobüs Hattı: $otobusHatti")
    println("Kalan Dakika: $kalanDakika")
    println("Takip Kodu: $takipKodu")
    println("Kupon Süresi: $kuponSuresi")
    println("Kupon Kodu: $kuponKodu")
    println("Fatura Adresi: $faturaAdresi")

}