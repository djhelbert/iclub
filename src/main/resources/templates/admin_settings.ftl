<#include "header.ftl">

<#import "/spring.ftl" as spring>
<@spring.bind "form" />

<#if message??>
<div class="container" style="margin-bottom:5px">
  <div class="alert alert-success">
    ${message}
  </div>
</div>
</#if>

<#if (spring.status.errors.allErrors?size > 0) >
<div class="container" style="margin-top:10px">
    <div class="alert alert-danger"><a class="close" data-dismiss="alert" href="#">×</a>
       <#list spring.status.errors.allErrors as error>
            <div><@spring.message error.code/></div>
       </#list>
    </div>
</div>
</#if>

<form role="form" name="form" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="container">
  <div class="form-horizontal" style="margin-bottom:10px">
    <ul class="breadcrumb">
       <li>Admin</li>
       <li class="active">Settings</li>
    </ul>
    <form role="form" name="form" action="" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-3" for="title">Title *</label>
      <div class="col-sm-9"><@spring.formInput "form.title" "class='form-control'  maxlength='50' required" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="description">Description *</label>
      <div class="col-sm-9"><@spring.formInput "form.description" "class='form-control' maxlength='250' required" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="facebook">Facebook Group</label>
      <div class="col-sm-9"><@spring.formInput "form.facebook" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="twitter">Twitter Handle @</label>
      <div class="col-sm-9"><@spring.formInput "form.twitter" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="pinterest">Pinterest Board Name</label>
      <div class="col-sm-9"><@spring.formInput "form.pinterest" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="youtube">Youtube Group</label>
      <div class="col-sm-9"><@spring.formInput "form.youtube" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="strava">Strava Embed</label>
      <div class="col-sm-9"><@spring.formInput "form.strava" "class='form-control' maxlength='500'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="banner">Banner</label>
      <div class="col-sm-9"><@spring.formInput "form.banner" "class='form-control' maxlength='500'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactEmail">Contact Email</label>
      <div class="col-sm-9"><@spring.formInput "form.contactEmail" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="rss">RSS Feed URL</label>
      <div class="col-sm-9"><@spring.formInput "form.rss" "class='form-control' maxlength='50'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactPhone">Contact Phone</label>
      <div class="col-sm-9"><@spring.formInput "form.contactPhone" "class='form-control' maxlength='20'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactAddressLine1">Address</label>
      <div class="col-sm-9"><@spring.formInput "form.contactAddressLine1" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactAddressLine2"></label>
      <div class="col-sm-9"><@spring.formInput "form.contactAddressLine2" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactCity">City</label>
      <div class="col-sm-9"><@spring.formInput "form.contactCity" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactState">State</label>
      <div class="col-sm-9"><@spring.formInput "form.contactState" "class='form-control' maxlength='100'" "text"/></div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="contactZipCode">Zip Code</label>
      <div class="col-sm-9"><@spring.formInput "form.contactZipCode" "class='form-control' maxlength='5'" "text"/></div>
    </div>

    <div>&nbsp;</div>

    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  </div>
</div>

<#include "footer.ftl">