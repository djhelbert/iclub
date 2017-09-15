<#include "header.ftl">

<#if message??>
<div class="container" style="margin-bottom:5px">
  <div class="alert alert-success">
    ${message}
  </div>
</div>
</#if>

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li class="active">Resources</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <#list resources as resource>
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><#if resource.isImage()><img src="/file?id=${resource.id!''}" alt="Resource" class="img-responsive"/></#if></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${resource.name!''}</h3>
                    <p><a href="${requestUrl!''}/file?id=${resource.id!''}">${requestUrl!''}/file?id=${resource.id!''}</a></p>
                    <p>Mimetype: ${resource.mimetype!''}</p>
                    <p>Size: ${resource.dataSize!''} kb</p>
                </div>
                <div><button type="submit" class="btn btn-default" onclick="location.href='/admin/resources/delete?id=${resource.id}'"><i class="fa fa-fw s fa-remove"></i> Delete</button></div>
            </div>
        </div>
        </#list>
    </div>
  </div>
</div>

<div class="container" style="margin-bottom:10px">
<h3>Add Resource</h3>
<form accept-charset="UTF-8" class="form-horizontal" method="POST" enctype="multipart/form-data" action="/admin/resources">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input name="file" type="file" id="scroller_file">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" onclick="scrollerButtonSubmitClicked(event)">Submit</button>
    </div>
  </div>
</form>
</div>

<script>
    function scrollerButtonSubmitClicked(event) {
        if (!document.getElementById("scroller_file").value) {
            event.preventDefault();
            alert("Please choose a file.");
        }
    }

    function logoButtonSubmitClicked(event) {
        if (!document.getElementById("logo_file").value) {
            event.preventDefault();
            alert("Please choose a file.");
        }
    }
</script>

<#include "footer.ftl">