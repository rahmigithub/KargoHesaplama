package com.rahmi.cargocalculation.Controller;

import com.rahmi.cargocalculation.Model.Cargo;
import com.rahmi.cargocalculation.Service.ServiceCargo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Rest Servicelerinin kullanılması için RestController annotation kullanıldı
// Loglama işlemi için Slf4j annotation kullanıldı

@Slf4j
@RestController
public class ControllerCargo {

    /* ServiceCargo sınıfının türetilecek nesneyi tekrar tekrar oluşturmak yerine bellekte bir kere oluşturulması
       Autowired annotation ile sağlanmış oldu. */

    @Autowired
    ServiceCargo serviceCargo;

    /* Postmapping annotionı ile kullanılacak method için api oluşturuldu.
       Frondend tarafıyla haberleşme sağlandı.
       Json veri formatıyla veri alışverişi sağlandı.
       İşlemden sonra frontende gerekli sonuç return edildi. */

    @CrossOrigin
    @PostMapping("/api/1.0/cargo")
    public int Calculate(@RequestBody Cargo cargo) {

        // Loglama işlemi gerçekleştirildi. Gerekli bilgiler console ve dosyaya aktarıldı.

        log.info("Calculate methodu çalıştırıldı.");
        log.info("Frondend tarafından gelen veriler"+" "
                + cargo.getSevenCount() + " "
                + cargo.getTwoCount() + " "
                + cargo.getTotalKg());

        return serviceCargo.prepareCargoPacket(cargo);
    }

}
