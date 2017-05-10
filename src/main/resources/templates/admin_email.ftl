<#include "header.ftl">

<div class="container" style="margin-bottom:30px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Group Email</li>
  </ul>

  <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <textarea rows="20" name="content"></textarea>
    <div>&nbsp;</div>
    <button type="submit" class="btn btn-default">Send</button>
  </form>
</div>

<script type="text/javascript" src="/webjars/tinymce/4.2.1/tinymce.min.js" ></script>
<script>tinymce.init({ selector:'textarea' });</script>

<#include "footer.ftl">