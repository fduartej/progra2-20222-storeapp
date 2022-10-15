package com.acme.storeapp.controller.web;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acme.storeapp.integration.sunat.event.FacturacionEvent;
import com.acme.storeapp.model.Factura;

@Controller
public class PagoController {
    private final FacturacionEvent event; 
    
    public PagoController(FacturacionEvent event){
        this.event = event;
    }

    @GetMapping("/pago/procesar")
    public String pagar(Model model) {

        Factura f =  new Factura();
        f.setFechaFactura(new Date());
        f.setTotalFactura(new BigDecimal("1000.50"));
        f.setCodigoCliente("1234");
        event.send(f);
        return "pago/index";
    }
}
