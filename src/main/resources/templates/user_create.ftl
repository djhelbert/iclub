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
  <h2>Register</h2>
  <form role="form" name="form" action="" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email *</label>
      <div class="col-sm-10"><@spring.formInput "form.email" "class='form-control'" "email"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password *</label>
      <div class="col-sm-10"><@spring.formInput "form.password" "class='form-control'" "password"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="passwordConfirm">Confirm Password *</label>
      <div class="col-sm-10"><@spring.formInput "form.passwordConfirm" "class='form-control'" "password"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">First Name *</label>
      <div class="col-sm-10"><@spring.formInput "form.firstName" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="lastName">Last Name *</label>
      <div class="col-sm-10"><@spring.formInput "form.lastName" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="homePhone">Home Phone</label>
      <div class="col-sm-10"><@spring.formInput "form.homePhone" "class='form-control' maxlength='20'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cellPhone">Cell Phone</label>
      <div class="col-sm-10"><@spring.formInput "form.cellPhone" "class='form-control' maxlength='20'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="addressLine1">Address</label>
      <div class="col-sm-10"><@spring.formInput "form.addressLine1" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="addressLine1"></label>
      <div class="col-sm-10"><@spring.formInput "form.addressLine2" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="city">City</label>
      <div class="col-sm-10"><@spring.formInput "form.city" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="state">State</label>
      <div class="col-sm-10"><@spring.formInput "form.state" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="zipCode">Zip Code</label>
      <div class="col-sm-10"><@spring.formInput "form.zipCode" "class='form-control' maxlength='5'" "text"/></div>
    </div>
    
    <div class="checkbox">
      <label><input name="agree" type="checkbox">I agree to the terms of use</label>
    </div>
    
    <div>&nbsp;</div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</div>

<#include "footer.ftl">