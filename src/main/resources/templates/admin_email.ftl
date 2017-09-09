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

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Group Email</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <form role="form" name="form" action="/admin/email" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <div class="form-horizontal">
        <div class="form-group">
          <label class="control-label col-sm-2" for="password">Subject *</label>
          <div class="col-sm-10"><@spring.formInput "form.subject" "class='form-control' required" "subject"/></div>
        </div>
    </div>
    <textarea rows="20" name="body" id="body"></textarea>
    <div>&nbsp;</div>
    <button type="submit" class="btn btn-default">Send</button>
  </form>
</div>

<script type="text/javascript" src="/webjars/tinymce/4.5.6/tinymce.min.js" ></script>
<script>tinymce.init({ selector:'textarea' });</script>

<#include "footer.ftl">