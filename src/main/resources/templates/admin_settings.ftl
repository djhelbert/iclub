<#include "header.ftl">

<#import "/spring.ftl" as spring>
<@spring.bind "form" />

<form role="form" name="form" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<#if (spring.status.errors.allErrors?size > 0) >
<div class="container" style="margin-top:10px">
    <div class="alert alert-danger"><a class="close" data-dismiss="alert" href="#">×</a>
       <#list spring.status.errors.allErrors as error>
            <div><@spring.message error.code/></div>
       </#list>
    </div>
</div>
</#if>

<div class="container" style="margin-top:10px">
<div class="form-horizontal" style="margin-bottom:10px">
  <h2>Club Settings</h2>
  <form role="form" name="form" action="" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Title *</label>
      <div class="col-sm-10"><@spring.formInput "form.title" "class='form-control'  maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">Description *</label>
      <div class="col-sm-10"><@spring.formInput "form.description" "class='form-control' maxlength='250'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastName">Facebook Group</label>
      <div class="col-sm-10"><@spring.formInput "form.facebook" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="homePhone">Twitter Handle</label>
      <div class="col-sm-10"><@spring.formInput "form.twitter" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="homePhone">Pinterest Group</label>
      <div class="col-sm-10"><@spring.formInput "form.pinterest" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="homePhone">Youtube Group</label>
      <div class="col-sm-10"><@spring.formInput "form.youtube" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="homePhone">Strava Group</label>
      <div class="col-sm-10"><@spring.formInput "form.strava" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cellPhone">Contact Phone</label>
      <div class="col-sm-10"><@spring.formInput "form.contactPhone" "class='form-control' maxlength='20'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="addressLine1">Address</label>
      <div class="col-sm-10"><@spring.formInput "form.contactAddressLine1" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="addressLine1"></label>
      <div class="col-sm-10"><@spring.formInput "form.contactAddressLine2" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="city">City</label>
      <div class="col-sm-10"><@spring.formInput "form.contactCity" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="state">State</label>
      <div class="col-sm-10"><@spring.formInput "form.contactState" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="zipCode">Zip Code</label>
      <div class="col-sm-10"><@spring.formInput "form.contactZipCode" "class='form-control' maxlength='5'" "text"/></div>
    </div>

    <div>&nbsp;</div>

    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</div>

<#include "footer.ftl">