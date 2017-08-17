<#include "header.ftl">

<#if message??>
<div class="container" style="margin-bottom:5px">
  <div class="alert alert-success">
    ${message}
  </div>
</div>
</#if>

<div class="container" style="margin-bottom:5px">
  <ul class="breadcrumb">
    <li class="active">Logo</li>
  </ul>
</div>

<div class="container" style="margin-bottom:5px">
  <div class="row">
    <div class="col-md-12">
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><img src="/file?id=${logo.id!''}" alt="Logo" class="img-responsive"/></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${logo.name!''}</h3>
                    <p>${logo.mimetype!''}</p>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>

<div class="container" style="margin-bottom:10px">
<h3>Update Logo Image</h3>
<form accept-charset="UTF-8" class="form-horizontal" method="POST" enctype="multipart/form-data" action="/admin/images/logo">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input name="file" type="file" id="logo_file">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default"  onclick="logoButtonSubmitClicked(event)">Submit</button>
    </div>
  </div>
</form>
</div>

<div class="container" style="margin-bottom:10px">
  <ul class="breadcrumb">
    <li class="active">Scroller Images</li>
  </ul>
</div>

<div class="container" style="margin-bottom:10px">
  <div class="row">
    <div class="col-md-12">
        <#list scrollers as scroller>
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><img src="/file?id=${scroller.id!''}" alt="Scroller" class="img-responsive"/></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${scroller.name!''}</h3>
                    <p>${scroller.mimetype!''}</p>
                </div>
                <div><button type="submit" class="btn btn-default" onclick="location.href='/admin/images/delete?id=${scroller.id}'"><i class="fa fa-fw s fa-remove"></i> Delete</button></div>
            </div>
        </div>
        </#list>
    </div>
  </div>
</div>

<div class="container" style="margin-bottom:10px">
<h3>Add Scroller Image</h3>
<form accept-charset="UTF-8" class="form-horizontal" method="POST" enctype="multipart/form-data" action="/admin/images/scroller">
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
            alert("Please choose an image file.");
        }
    }

    function logoButtonSubmitClicked(event) {
        if (!document.getElementById("logo_file").value) {
            event.preventDefault();
            alert("Please choose an image file.");
        }
    }
</script>

<#include "footer.ftl">