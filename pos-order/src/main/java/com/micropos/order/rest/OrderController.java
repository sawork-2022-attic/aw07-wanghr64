package com.micropos.order.rest;

import com.micropos.carts.api.*;
import com.micropos.carts.dto.*;
import com.micropos.carts.mapper.ItemMapper;
import com.micropos.carts.service.CartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@EnableDiscoveryClient
public class OrderController implements OrderApi {

    private List<ItemDto> getCart() throws Exception {
        String url = "http://localhost:8080/cart";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        List<ItemDto> items = new ArrayList<>();
        return items;
    }

    @Override
    @PostMapping()
    public ResponseEntity<List<ItemDto>> summitOrder() {
        List<ItemDto> items = null;
        try {
            items = getCart();
        } catch (Exception e) {
        }
        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }
}
