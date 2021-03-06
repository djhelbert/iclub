<#include "header.ftl">

<div class="container" style="margin-bottom:10px">
  <div>
    <ul class="breadcrumb">
       <li>Admin</li>
       <li class="active">Sponsors</li>
    </ul>
  </div>
  <div class="row">
    <div class="col-md-12">
        <#list sponsors as sponsor>
        <div class="testiminial-block">
            <div class="row">
                <div class="col-md-2 col-sm-2"><a href="${sponsor.url!'#'}"><img src="/file?id=${sponsor.binaryFile.id!''}" alt="Logo" class="img-responsive"/></a></div>
                <div class="col-md-8 col-sm-8 testimonial-content">
                    <h3>${sponsor.name!''}</h3>
                    <p>${sponsor.description!''}</p>
                </div>
                <div class="col-md-2 col-sm-2"><button type="button" class="btn btn-default" onclick="location.href='/admin/sponsors/delete?id=${sponsor.id}'" class="btn"><i class="fa fa-fw s fa-remove"></i> Delete</button></div>
            </div>
        </div>
        </#list>
    </div>
  </div>
</div>

<div class="container" style="margin-bottom:10px">
<h3>Add Sponsor</h3>
<form accept-charset="UTF-8" class="form-horizontal" method="POST" enctype="multipart/form-data">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Name *</label>
    <div class="col-sm-10">
      <input type="input" class="form-control" maxlength="50" name="name" id="name" placeholder="" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="description">Description *</label>
    <div class="col-sm-10"> 
      <input type="input" class="form-control" maxlength="200" name="description" id="description" placeholder="" required>
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="url">URL *</label>
    <div class="col-sm-10">
      <input type="url" class="form-control" maxlength="50" name="url" id="url" placeholder="" required>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input name="file" id="file" type="file">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" onclick="buttonSubmitClicked(event)" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
</div>

<script>
    function buttonSubmitClicked(event) {
        if (!document.getElementById("file").value) {
            event.preventDefault();
            alert("Please choose an image file.");
        }
    }
</script>

<#include "footer.ftl">