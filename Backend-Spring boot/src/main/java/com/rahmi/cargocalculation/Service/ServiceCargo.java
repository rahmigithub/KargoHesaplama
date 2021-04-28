package com.rahmi.cargocalculation.Service;

import com.rahmi.cargocalculation.Interface.ICargo;
import com.rahmi.cargocalculation.Model.Cargo;
import org.springframework.stereotype.Service;

// ServiceCargo sınıfı oluşturldu ve ICargo interfacenden implement edildi.

@Service
public class ServiceCargo implements ICargo<Cargo> {

    // İmplement edilen interfaceden gelen methodun gövdesi gerekli kod bloklarıyla tanımlandı.

    @Override
    public int prepareCargoPacket(Cargo cargo) {

        // Kargolanmak istenen toplam kilogramının 7 kilogramlık paketten küçük olup olmadığı hesaplandı.

        if (cargo.getTotalKg() < 7) {

           /* Kargolanmak istenen kilogramının sıfır değerinden büyük veya eşit olup olmadığı
              Kargolanmak istenen kilogramının mod ikisinin sıfıra eşit olup olmadığı
              Elimizdeki iki kilogramlık paket sayısının kargolanmak istenen kilogramının ikiye bölümünden gelen
              sonuctan büyük veya eşit olup olmadığı hesaplandı. */

            if (cargo.getTotalKg() >= 0 && cargo.getTotalKg() % 2 == 0 && cargo.getTwoCount() >= cargo.getTotalKg() / 2)
                return cargo.getTotalKg() / 2;
            else
                return -1;
        }

        /* Elimizde bulunan yedi kilogramlık paketlerden
           hesaplama işlemine katılmasına gerek olan paket sayısının bulunması sağlandı.
           Örnek hesaplama;
           Elimizde
           7 kg ==> 5 adet, 2 kg ==> 4 adet, 25 kglık kargo paketi
           25:7 = 3  ==> elimizde bulunan 5 adet 7 kg paket sayısı yerine
           işlemimize 3 adet 7 kg paket sayısı ile devam ediyoruz */

        if (cargo.getSevenCount() > cargo.getTotalKg() / 7)
            cargo.setSevenCount(cargo.getTotalKg() / 7);

        int usedSevenCount;

        /* Elimizdeki 7 kg paketlerin oluşturmuş olduğu toplam kg miktarı
           kargolanmak istenen toplam kg miktarındaki farkı bulunup çıkan sonucun
           mod 2'sinin 0 değerine eşit olup olmadığı hesaplandı.
           Eğer eşitse kullanılacak 7 kg paket sayısı elimizdeki 7 kg lık paket sayısına eşitlendi.
           Eğer eşit değilse kullanılacak 7 kg paket sayısı elimizdeki 7 kg lık paket sayısının 1 eksiğine eşitlendi. */

        if ((cargo.getTotalKg() - 7 * cargo.getSevenCount()) % 2 == 0)
            usedSevenCount = cargo.getSevenCount();
        else
            usedSevenCount = cargo.getSevenCount() - 1;

        // Kaç adet 2 kglık paketlerden kullanıldığı hesaplandı ve gerekli sonuç return edildi.

        int usedTwoCount = (cargo.getTotalKg() - (usedSevenCount * 7)) / 2;

        return usedTwoCount <= cargo.getTwoCount() ? usedTwoCount : -1;

    }
}
