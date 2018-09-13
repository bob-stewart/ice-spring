package com.exochain.ice.features.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.net.MediaType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.ByteArrayOutputStream;

import java.util.HashMap;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.exochain.ice.model.Card;
import com.exochain.ice.IDB;

@Controller
@SessionAttributes(names = {"visitor"})
public class RootController {

    @Autowired
    private IDB db;

    @Value("${api.base}")
    private String baseURL;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingPage() {
        return "greeting";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String makeCardPage() {
        return "make-card";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.FOUND)
    public RedirectView makeCardPost(@RequestParam HashMap<String, String> cardData) {
        Card card = new Card(cardData);
        String id = db.addCard(card).toString();
        return new RedirectView("/" + id + "/print"); // ie use this
    }

    // Mostly taken from
    // http://bit.ly/2xgPLhk
    @RequestMapping(value = "/{id}/qr.{ext}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable String id, @PathVariable String ext)
            throws WriterException, IOException {
        final int size = 256;
        String toEncode = baseURL + "/" + id;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix result = qrCodeWriter.encode(toEncode, BarcodeFormat.QR_CODE, size, size);
        ByteArrayOutputStream stream = new ByteArrayOutputStream(); 
        MediaType type = null;
        switch (ext) {
            case "png":
                type = MediaType.PNG;
                break;
            case "gif":
                type = MediaType.GIF;
                break;
            case "jpg":
            case "jpeg":
                type = MediaType.JPEG;
                break;
            // Unfortunately MTImageWriter doesn't seem to support SVG :(
            // TODO?
        }
        if (type != null) {
            // TODO: Configure to have no/small outside edge
            MatrixToImageWriter.writeToStream(result,
                    type.subtype(),
                    stream);
            return ResponseEntity.ok(stream.toByteArray());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/{id}/print", method = RequestMethod.GET)
    public String printCardPage(ModelMap model, @PathVariable String id) {
        Card card = db.getCard(id);
        model.addAttribute("card", card);
        model.addAttribute("baseURL", baseURL);
        return "print-card";
    }

}

