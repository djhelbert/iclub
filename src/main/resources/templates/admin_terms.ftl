<#include "header.ftl">

<div class="container" style="margin-bottom:30px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Terms</li>
  </ul>

  <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <textarea rows="20" name="content">${CONTENT}</textarea>
    <div>&nbsp;</div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

<script type="text/javascript" src="/webjars/tinymce/4.5.6/tinymce.min.js" ></script>
<script>tinymce.init({ selector:'textarea' });</script>

<#include "footer.ftl">