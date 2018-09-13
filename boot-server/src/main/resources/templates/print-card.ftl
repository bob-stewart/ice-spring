HERES THE CARD: ${card}$
HERES THE DIRECT: ${notesDirect}$
HERES THE NOTES: ${card.notes}$
HERES THE CONTACTS: ${card.contacts}$
<#assign contacts = card.contacts>
<#assign you = contacts.you>
<!DOCTYPE html>
<html>
  <head>
    <#assign title = "Print your emergency info">
    <#include "head.ftl">
    <script>
      function init() {
        var printButton = document.getElementById('print-button');
        printButton.onclick = function() {
          window.print();
        };
        document.getElementById("print-button-container").style.display = "inherit";
      }
      window.onload = init;
    </script>
  </head>
  <body>
    <#--<% include body-start %>-->
    <h1>Print your card</h1>
    <p id="print-button-container">
      <a id="print-button" href="javascript:void(0);">Print page</a>
    </p>
    <div class="print-card">
      <div class="front">
        <h2>${you.name}'s emergency info</h2>
        <div class="col-left">
          <p>Scan the QR code or enter the URL:</p>
          <p>${url}</p>
          <p><b>Some</b> info printed on back of card.</p>
        </div>
        <div class="col-right">
          <img src="${cardUrl}/qr.svg" alt="qr-code" />
        </div>
        <div class="clear"></div>
      </div>
      <div class="back">
        <#assign names = ["you",
              "primary",
              "alternative",
              "emergency"
          ]>
        <#list names as contact>
          <#if contact == "you">
            <h2 class="name">${contacts[contact].name}</h2>
            <p>${contacts[contact].address}</p>
          <#else>
            <h2>${contact?capitalize}</h2>
            <p>${contacts[contact].name}</p>
            <p>${contacts[contact].phone}</p>
          </#if>
          <#if contact == "primary">
            <p>${contacts.primary.email}</p>
            <p>${contacts.primary.address}</p>
          </#if>
        </#list>
      </div>
    </div>
    <hr />
    <p>
      Print this page and cut the card out. Fold in half on the dashed line,
      and put it in the front of your wallet, right behind your ID.
    </p>
    <p>
      <a href="/${contacts.you.id}/convert">Convert your card</a> into an
      EXOCHAIN account for more features.
    </p>
  </body>
</html>
