<!DOCTYPE html>
<html>
  <head>
    <#assign title = "Make an ICE card">
    <#include "head.ftl">
    <script src='/javascripts/contacts-ajax.js'></script>
  </head>
  <body>
    <#-- <% include body-start %> -->
    <h1>Make an ICE card</h1>
    <p>Fill out as much as you want</p>
    <p>Your data will be safe on the blockchain</p>
    <div class="card">
      <form action="" method="post">
        <#assign names = ["you",
              "primary",
              "alternative",
              "contingency",
              "emergency"
          ]>
        <#include "contact-fields.ftl">
        <h2>Notes</h2>
        <textarea name="notes"></textarea>
        <h2>Options</h2>
        <input type="checkbox" name="deactivate" id="deactivate" checked /><label for="deactivate">Deactivate card on each scan</label>
        <hr />
        <input type="submit" value="Print it" />
      </form>
    </div>
  </body>
</html>

