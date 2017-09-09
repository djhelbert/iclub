<#include "header.ftl">

<div class="container" style="margin-bottom:30px">
  <ul class="breadcrumb">
    <li>Admin</li>
    <li class="active">Privacy Policy</li>
  </ul>

  <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <textarea rows="20" name="content">${CONTENT}</textarea>
    <div>&nbsp;</div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

<script type="text/javascript" src="/webjars/tinymce/4.5.6/tinymce.min.js" ></script>
<script type="text/javascript" src="/webjars/tinymce/4.5.6/tinymce.min.js" ></script>
<script>
tinymce.init({
  selector: "textarea",
  plugins: [
    'advlist autolink lists link image charmap print preview anchor textcolor',
    'searchreplace visualblocks code fullscreen',
    'insertdatetime media table contextmenu paste code'
  ],
  menubar: false,
  toolbar: 'insert | undo redo |  styleselect | bold italic backcolor  | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | removeformat',
  image_caption: true
});
</script>

<#include "footer.ftl">