<#-- PARTIAL
Needs:
 - a list `assign`ed earlier in your document called `names`
   it should include the names of each contact field that this will render
Can use:
 - `existing` which is a map with any existing data to be filled in
Renders:
 - A bunch of <input>s with the right stuff, and headings, but no <form> tag so
   you can add stuff
-->
<#list names as name>
  <h2>${name?capitalize}</h2>
  <#assign fields = [
      "name",
      "email",
      "phone",
      "address",
      "key"
    ]>
  <#list fields as field>
    <input
      <#if field == "key">
        type="hidden"
      <#else>
        type="text"
      </#if>
      <#if existing??>
        <#if existing[name]??>
          <#assign value = existing[name][field]>
        <#else>
          <#assign value = "">
        </#if>
      <#else>
        <#assign value = "">
      </#if>
      placeholder="${field?capitalize}"
      name="${name}:${field}"
      class="field ${name}" <#-- Used for clearGroup and more -->
      value="${value}"
    />
  </#list>
  <a
    href="javascript:void(0);"
    onclick="fillGroup('${name}');"
    class="clear-group ${name}">
    Clear
  </a>
</#list> <#-- names -->

