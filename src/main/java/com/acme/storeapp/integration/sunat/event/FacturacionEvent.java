package com.acme.storeapp.integration.sunat.event;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acme.storeapp.integration.sunat.dto.Invoice;
import com.acme.storeapp.model.Factura;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

@Service
public class FacturacionEvent {

    private AmqpTemplate amqpTemplate;
    @Value("${sunat.rabbitmq.exchange.request}")
    private String EXCHANGE_NAME;

    public FacturacionEvent(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    //producer
    public void send(Factura facturaContoso){
        try{
            ObjectMapper mapper = new ObjectMapper();
            //Pongo los datos en el contrato
            Invoice payload = new Invoice();
            payload.setFechaEmision(facturaContoso.getFechaFactura());
            payload.setImporte(facturaContoso.getTotalFactura());
            payload.setRucEmisor("999999999");
            payload.setRucComprador(facturaContoso.getCodigoCliente());   

            String json = mapper.writeValueAsString(payload);
            amqpTemplate.convertSendAndReceive(EXCHANGE_NAME, "", json);
          }catch(JsonProcessingException e){
            e.printStackTrace();
          }
    }

    //consumer
    @RabbitListener(queues = "${sunat.rabbitmq.queue.response}")
    public void receive(Message message) {
        String json = new String(message.getBody(), StandardCharsets.UTF_8);
        try{
            ObjectMapper mapper = new ObjectMapper();
            Invoice invoiceResponse =mapper.readValue(json, Invoice.class);
          }catch(Exception e){
            e.printStackTrace();
          }
    }
}
