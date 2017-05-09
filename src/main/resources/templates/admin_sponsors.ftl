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
				<div class="col-md-2 col-sm-2"><button type="button" onclick="location.href='/admin/sponsors/delete?id=${sponsor.id}'" class="btn">Delete</button></div>
			</div>
		</div>
		</#list>
	</div>
  </div>
</div>

<div class="container" style="margin-top:30px">
  <div class="col-md-4 col-md-offset-4">
    <div class="panel panel-default">
      <div class="panel-heading"><h3 class="panel-title"><strong>Add Sponsor</strong></h3>
        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#"></a></div>
      </div>

      <div class="panel-body">
      <form accept-charset="UTF-8" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div style="margin-bottom: 12px" class="input-group">
          <span class="input-group-addon">Name</span>
          <input name="name" type="inpt" class="form-control">
        </div>

        <div style="margin-bottom: 12px" class="input-group">
          <span class="input-group-addon">Description</span>
          <input name="description" type="input" class="form-control">
        </div>

        <div style="margin-bottom: 12px" class="input-group">
          <span class="input-group-addon">URL</span>
          <input name="url" type="input" class="form-control" size="80">
        </div>

        <input name="file" type="file">

        <hr style="margin-top:10px;margin-bottom:10px;" >

        <button type="submit" class="btn">Submit</button>
      </form>
      </div>
    </div>
  </div>
</div>

<#include "footer.ftl">